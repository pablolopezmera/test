package com.ec.virtualcoin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.CountryServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import user.profile.model.UserProfile;
import user.profile.service.UserProfileLocalServiceUtil;

@Component(
	immediate = true,
	property = {
//		"com.liferay.portlet.display-category=category.sample",
//		"com.liferay.portlet.instanceable=true",
//		"javax.portlet.display-name=address-portlet Portlet",
//		"javax.portlet.init-param.template-path=/",
//		"javax.portlet.init-param.view-template=/address.jsp",
//		"javax.portlet.resource-bundle=content.Language",
//		"javax.portlet.security-role-ref=power-user,user",
//		"mvc.command.name=upload"

        "com.liferay.portlet.add-default-resource=true",
        "com.liferay.portlet.css-class-wrapper=portlet-controlpanel",
        "com.liferay.portlet.display-category=category.hidden",
        "com.liferay.portlet.preferences-owned-by-group=true",
        "com.liferay.portlet.render-weight=100",
        "javax.portlet.display-name=My Address",
        "javax.portlet.expiration-cache=0",
        "javax.portlet.init-param.view-template=/address.jsp",
        "javax.portlet.name=address",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=administrator",
        "javax.portlet.supports.mime-type=text/html",
        "mvc.command.name=upload"
	
	},
	service = Portlet.class
)
public class AddressPortlet extends MVCPortlet {

    private static Logger _logger = LoggerFactory.getLogger(AddressPortlet.class.getName());

    private final static int ONE_GB = 1073741824;
    
    private final static String baseDir = "/tmp/uploaded/";
    
    private final static String fileInputName = "fileupload";
    
    private ImageType imageType;
    
    private SessionManager sessionManager = new SessionManager();

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        _logger.info("Do viewwwwwwwwwwwwwwwwwwwww");
        super.doView(renderRequest, renderResponse);
    }
    
    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        _logger.info("Entra a render");
        try {
            List<Country> countries = CountryServiceUtil.getCountries();
            sessionManager.initProfileInSession(renderRequest);
            UserProfile up = sessionManager.getUserProfile(renderRequest);
            renderRequest.setAttribute("countries", countries);
            renderRequest.setAttribute("city", up.getCity());
            renderRequest.setAttribute("country", up.getCountry());
            renderRequest.setAttribute("homeNumber", up.getHomeNumber());
            renderRequest.setAttribute("postalCode", up.getPostalCode());
            renderRequest.setAttribute("prov", up.getProv());
            renderRequest.setAttribute("street1", up.getStreet1());
            renderRequest.setAttribute("street2", up.getStreet2());
            renderRequest.setAttribute("phoneNumber", up.getPhoneNumber());
        } catch (PortalException e) {
            e.printStackTrace();
        }
        if (renderRequest.getParameter("img") != null) {
            imageType = ImageType.valueOf(renderRequest.getParameter("img"));
        }
        super.render(renderRequest, renderResponse);
    }

    public void saveProfile(ActionRequest request, ActionResponse response)
            throws Exception {
        _logger.info("Guardar la direccion:");
        UserProfile up = sessionManager.getUserProfile(request);
        up.setCity(request.getParameter("city"));
        up.setCountry(request.getParameter("country"));
        up.setHomeNumber(request.getParameter("homeNumber"));
        up.setPostalCode(request.getParameter("postalCode"));
        up.setProv(request.getParameter("prov"));
        up.setStreet1(request.getParameter("street1"));
        up.setStreet2(request.getParameter("street2"));
        up.setPhoneNumber(request.getParameter("phoneNumber"));
        up.setApproved(Boolean.FALSE);
        createOrUpdate(request);
        sendNotification(request);
    }

    public void display(ActionRequest req, ActionResponse res) {
        String fName = req.getParameter("fName");
        String lName = req.getParameter("lName");
        String password = req.getParameter("password");
        _logger.info(fName);
        _logger.info(lName);
        _logger.info(password);
        String successMsg = "form submitted Successfully!";
        SessionMessages.add(req, "request_processed", successMsg);
    }

    public void upload(ActionRequest request, ActionResponse response)
            throws Exception {
        
        _logger.info("Subir archivo para: " + imageType);
 
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
        
        long sizeInBytes = uploadRequest.getSize(fileInputName);
        _logger.info("File size: " + sizeInBytes);
        _logger.info("File name: " + uploadRequest.getFileName(fileInputName));
 
        if (uploadRequest.getSize(fileInputName) == 0) {
            throw new Exception("Received file is 0 bytes!");
        }
 
        // Get the uploaded file as a file.
        File uploadedFile = uploadRequest.getFile(fileInputName);
        
        _logger.info(uploadedFile.getAbsolutePath());
 
        FileUtil fileUtil = new FileUtil();
        
//        String dafultFolder = PropsUtil.get(Constants.PROFILE_FOLDER_LOCATION.getPropertyName());
        String defultFolder = fileUtil.getImageAbsolutePath();
        _logger.info("default folder:" + defultFolder);
        String screenName = PortalUtil.getUser(request).getScreenName();
        String extension = fileUtil.getFileExtension(uploadedFile.getName());
        String targetFilePath = fileUtil.generateRoute(screenName, imageType, defultFolder, extension);
        fileUtil.createPendingFolders(targetFilePath);
        fileUtil.copyFile(uploadedFile.getAbsolutePath(), targetFilePath);
        sessionManager.setDocumentFilePath(targetFilePath, imageType, request);
        
        _logger.info("Se pone en request:" + targetFilePath);
        request.setAttribute("anversoFile",targetFilePath);
        
        response.setRenderParameter("jspPage", "/fileUpload.jsp");
    }

    public void delete(ActionRequest request, ActionResponse response)
            throws Exception {
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
        UserProfile userProfile = sessionManager.getUserProfile(request);
        UserProfileLocalServiceUtil.updateUserProfile(userProfile);
        _logger.info("Datos a guardar");
        _logger.info(userProfile.getAnversoId());
        _logger.info(userProfile.getReversoId());
        _logger.info(userProfile.getSelfie());
        _logger.info(userProfile.getProofAddress());
    }

    private void createDocumentProfile(ActionRequest request) {
        UserProfile documentsProfile = sessionManager.getUserProfile(request);
        documentsProfile.setApproved(Boolean.FALSE);
        UserProfileLocalServiceUtil.addUserProfile(documentsProfile);
        _logger.info("Creado no se donde");
    }

    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws IOException, PortletException {
        // TODO Auto-generated method stub
        super.serveResource(resourceRequest, resourceResponse);
    }
    
    public void sendNotification(ActionRequest actionRequest) {
        String mailFrom = null;
        String mailTo = null;
        try {
            mailFrom = getSiteAttribute(actionRequest, "notification.address.from");
            mailTo = getSiteAttribute(actionRequest, "notification.address.to");
            _logger.info("mailFrom: " + mailFrom);
            _logger.info("mailTo: " + mailTo);
        } catch (AttributeNotFoundException e) {
            _logger.error(e.getMessage());
            return;
        }

        try {
            InternetAddress from = new InternetAddress(mailFrom);
            InternetAddress to = new InternetAddress(mailTo);
            MailMessage mailMessage = new MailMessage(from, to, "Usuario actualizado", "El usuario ha cambiado sus datos",
                    false);
            MailServiceUtil.sendEmail(mailMessage);
        } catch (AddressException e) {
            _logger.error(e.getMessage());
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private String getSiteAttribute(ActionRequest actionRequest, String attributeName) throws AttributeNotFoundException {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Group siteGroup = themeDisplay.getSiteGroup();
        String attribute = (String) siteGroup.getExpandoBridge().getAttribute(attributeName);
        if (attribute == null) {
            throw new AttributeNotFoundException("Please verify attribute notification.address.from and permissions.");
        }
        return attribute;
    }
    
}
