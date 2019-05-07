package com.ec.virtualcoin.identification;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.management.AttributeNotFoundException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ec.virtualcoin.common.CustomFieldUtil;
import com.ec.virtualcoin.common.ImageType;
import com.ec.virtualcoin.common.SessionManager;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;

import user.profile.model.UserProfile;
import user.profile.service.UserProfileLocalServiceUtil;

@Component(immediate = true, property = { "com.liferay.portlet.add-default-resource=true",
        "com.liferay.portlet.css-class-wrapper=portlet-controlpanel",
        "com.liferay.portlet.display-category=category.hidden", "com.liferay.portlet.preferences-owned-by-group=true",
        "com.liferay.portlet.render-weight=100", "javax.portlet.expiration-cache=0",
        "javax.portlet.init-param.view-template=/identification.jsp", "javax.portlet.name=identification",
        "javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=administrator",
        "javax.portlet.supports.mime-type=text/html"
        // "javax.portlet.init-param.add-process-action-success-action=false"
}, service = Portlet.class)
public class IdentificationPortlet extends MVCPortlet {

    private static Logger _logger = LoggerFactory.getLogger(IdentificationPortlet.class.getName());

    private final static int ONE_GB = 1073741824;

    private final static String fileInputName = "fileupload";

    private ImageType imageType;

    private SessionManager sessionManager = new SessionManager();

    private boolean anversoUploaded;

    private boolean reversoUploaded;

    private boolean selfieUploaded;

    @Override
    public void render(RenderRequest renderRequest, RenderResponse arg1) throws IOException, PortletException {
        try {
            sessionManager.initProfileInSession(renderRequest);
            UserProfile up = sessionManager.getUserProfile(renderRequest);
            _logger.info("Idtype: " + up.getIdType());
            _logger.info("Idnumber: " + up.getIdNumber());
            renderRequest.setAttribute("idType", up.getIdType());
            renderRequest.setAttribute("idNumber", up.getIdNumber());
            renderRequest.setAttribute("dateTimeSecond", new Date().toString());
        } catch (PortalException e) {
            e.printStackTrace();
        }
        super.render(renderRequest, arg1);
    }

    public void setChangingImage(ActionRequest actionRequest, ActionResponse actionResponse) {
        if (actionRequest.getParameter("imgType") != null) {
            _logger.info("setChangingImage imgType: " + actionRequest.getParameter("imgType"));
            imageType = ImageType.valueOf(actionRequest.getParameter("imgType"));
            SessionMessages.clear(actionRequest);
        }
    }

    public void saveProfile(ActionRequest request, ActionResponse response) throws Exception {
        _logger.info("Guardar perfil con las imagenes:");
        UserProfile up = sessionManager.getUserProfile(request);
        _logger.info(request.getParameter("idType"));
        _logger.info(request.getParameter("idNumber"));
        up.setIdType(request.getParameter("idType"));
        up.setIdNumber(request.getParameter("idNumber"));
        up.setApproved(Boolean.FALSE);

        verifyImagesUploaded(request);

        if (!anversoUploaded) {
            _logger.info("Se va por error y pongo varios errores");
            SessionErrors.add(request, "message.anverso.not.uploaded");
        }
        if (!reversoUploaded) {
            _logger.info("Se va por error y pongo varios errores");
            SessionErrors.add(request, "message.reverso.not.uploaded");
        }
        if (!selfieUploaded) {
            _logger.info("Se va por error y pongo varios errores");
            SessionErrors.add(request, "message.selfie.not.uploaded");
        }

        if (anversoUploaded && reversoUploaded && selfieUploaded) {
            createOrUpdate(request);
            sendNotification(request);
        }

    }

    private void verifyImagesUploaded(ActionRequest request) {
        String anverso = sessionManager.getDocumentFilePath(ImageType.ANVERSO, request);
        String reverso = sessionManager.getDocumentFilePath(ImageType.REVERSO, request);
        String selfie = sessionManager.getDocumentFilePath(ImageType.SELFIE, request);
        anversoUploaded = anverso != null && !anverso.isEmpty();
        reversoUploaded = reverso != null && !reverso.isEmpty();
        selfieUploaded = selfie != null && !selfie.isEmpty();
    }

    public void upload(ActionRequest request, ActionResponse response) throws Exception {

        _logger.debug("Subir archivo para: " + imageType);
        _logger.debug("parametro actualDialog: " + request.getParameter("actualDialog"));

        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);

        long sizeInBytes = uploadRequest.getSize(fileInputName);
        _logger.debug("File size: " + sizeInBytes);
        _logger.debug("File name: " + uploadRequest.getFileName(fileInputName));

        if (sizeInBytes == 0) {
            throw new Exception("Received file is 0 bytes!");
        }

        // Get the uploaded file as a file.
        File uploadedFile = uploadRequest.getFile(fileInputName);

        _logger.debug(uploadedFile.getAbsolutePath());

        FileUtil fileUtil = new FileUtil();

        // String dafultFolder =
        // PropsUtil.get(Constants.PROFILE_FOLDER_LOCATION.getPropertyName());
        String defultFolder = fileUtil.getImageAbsolutePath();
        _logger.info("default folder:" + defultFolder);
        String screenName = PortalUtil.getUser(request).getScreenName();
        String extension = fileUtil.getFileExtension(uploadedFile.getName());
        String targetFilePath = fileUtil.generateRoute(screenName, imageType, defultFolder, extension);
        fileUtil.createPendingFolders(targetFilePath);
        fileUtil.copyFile(uploadedFile.getAbsolutePath(), targetFilePath);
        sessionManager.setDocumentFilePath(targetFilePath, imageType, request);

        _logger.info("Se pone en request:" + targetFilePath);
        // request.setAttribute("anversoFile",targetFilePath);

        response.setRenderParameter("jspPage", "/fileUpload.jsp");
    }

    public void delete(ActionRequest request, ActionResponse response) throws Exception {
        _logger.info("Deletea");
        _logger.info(request.getParameter("imgType"));
        imageType = ImageType.valueOf(request.getParameter("imgType"));
        sessionManager.setDocumentFilePath("", imageType, request);
    }

    private void createOrUpdate(ActionRequest actionRequest) throws PortalException {
        User user = PortalUtil.getUser(actionRequest);
        UserProfile existingProfile = UserProfileLocalServiceUtil.fetchUserProfile(user.getScreenName());
        if (existingProfile == null) {
            _logger.info("El cliente no existe, se va a crear uno");
            createDocumentProfile(actionRequest);
        } else {
            _logger.info("El cliente ya existe, se debe modificar");
            updateDocumentProfile(actionRequest);
        }
    }

    private void updateDocumentProfile(ActionRequest request) {
        UserProfile UserProfile = sessionManager.getUserProfile(request);
        UserProfileLocalServiceUtil.updateUserProfile(UserProfile);
        _logger.debug("Datos a guardar");
        _logger.debug(UserProfile.getAnversoId());
        _logger.debug(UserProfile.getReversoId());
        _logger.debug(UserProfile.getSelfie());
        _logger.debug(UserProfile.getProofAddress());
    }

    private void createDocumentProfile(ActionRequest request) {
        UserProfile userProfile = sessionManager.getUserProfile(request);
        UserProfileLocalServiceUtil.addUserProfile(userProfile);
    }

    public void sendNotification(ActionRequest actionRequest) {
        CustomFieldUtil cfu = new CustomFieldUtil();

        try {
            String mailFrom = cfu.getSiteAttribute(actionRequest, "notification.address.from");
            String mailTo = cfu.getSiteAttribute(actionRequest, "notification.address.to");
            _logger.debug("mailFrom: " + mailFrom);
            _logger.debug("mailTo: " + mailTo);
            InternetAddress from = new InternetAddress(mailFrom);
            InternetAddress to = new InternetAddress(mailTo);

            MailMessage mailMessage = new MailMessage(from, to, "Usuario actualizado",
                    "El usuario ha cambiado sus datos", false);
            MailServiceUtil.sendEmail(mailMessage);
        } catch (AddressException | AttributeNotFoundException e) {
            _logger.error(e.getMessage());
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
