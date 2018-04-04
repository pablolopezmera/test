package com.ec.virtualcoin;

import java.io.File;
import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import profile.model.DocumentsProfile;
import profile.service.DocumentsProfileLocalServiceUtil;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=profile-portlet Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProfilePortlet extends MVCPortlet {

    private static Logger _logger = LoggerFactory.getLogger(ProfilePortlet.class.getName());

    private final static int ONE_GB = 1073741824;
    
    private final static String baseDir = "/tmp/uploaded/";
    
    private final static String fileInputName = "fileupload";
    
    private ImageType imageType;
    
    private String anversoUrl;
    
    private String reversoUrl;
    
    private String selfieUrl;
    
    private String residenciaUrl;
    
    private SessionManager sessionManager = new SessionManager();
    
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        _logger.info("Do viewwwwwwwwwwwwwwwwwwwww");
        super.doView(renderRequest, renderResponse);
    }
    
    @Override
    public void render(RenderRequest renderRequest, RenderResponse arg1) throws IOException, PortletException {
        _logger.info("Entra a render");
        try {
            sessionManager.initProfileInSession(renderRequest);
        } catch (PortalException e) {
            e.printStackTrace();
        }
        setRequestAttributes(renderRequest);
        if (renderRequest.getParameter("img") != null) {
            imageType = ImageType.valueOf(renderRequest.getParameter("img"));
        }
        super.render(renderRequest, arg1);
    }

    private void setRequestAttributes(RenderRequest renderRequest) {
        DocumentsProfile documentsProfile = sessionManager.getDocumentsProfile(renderRequest);
        if (documentsProfile != null) {
            _logger.info("Si tiene datos");
            renderRequest.setAttribute("anversoFile", documentsProfile.getAnversoId());
            renderRequest.setAttribute("reversoFile", documentsProfile.getReversoId());
            renderRequest.setAttribute("selfieFile", documentsProfile.getSelfie());
            renderRequest.setAttribute("residenciaFile", documentsProfile.getProofAddress());
            
            _logger.info("anversoFile" + documentsProfile.getAnversoId());
            _logger.info("reversoFile" + documentsProfile.getReversoId());
            _logger.info("selfieFile" + documentsProfile.getSelfie());
            _logger.info("residenciaFile" + documentsProfile.getProofAddress());
        }
    }

    public void saveProfile(ActionRequest request, ActionResponse response)
            throws Exception {
        _logger.info("Guardar perfil con las imagenes:");
        createOrUpdate(request);
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
        
        String dafultFolder = PropsUtil.get(Constants.PROFILE_FOLDER_LOCATION.getPropertyName());
        String screenName = PortalUtil.getUser(request).getScreenName();
        String extension = fileUtil.getFileExtension(uploadedFile.getName());
        String targetFilePath = fileUtil.generateRoute(screenName, imageType, dafultFolder, extension);
        fileUtil.createPendingFolders(targetFilePath);
        fileUtil.copyFile(uploadedFile.getAbsolutePath(), targetFilePath);
        sessionManager.setDocumentFilePath(imageType.name().concat(extension), imageType, request);
        
        response.setRenderParameter("jspPage", "/fileUpload.jsp");
    }

    private void createOrUpdate(ActionRequest request) {
        if (sessionManager.userHasProfile(request)) {
            _logger.info("El cliente no existe, se va a crear uno");
            createDocumentProfile(request);
        } else {
            _logger.info("El cliente ya existe, se debe modificar");
            updateDocumentProfile(request);
        }
    }

    private void updateDocumentProfile(ActionRequest request) {
        DocumentsProfile documentsProfile = sessionManager.getDocumentsProfile(request);
        DocumentsProfileLocalServiceUtil.updateDocumentsProfile(documentsProfile);
        _logger.info("Datos a guardar");
        _logger.info(documentsProfile.getAnversoId());
        _logger.info(documentsProfile.getReversoId());
        _logger.info(documentsProfile.getSelfie());
        _logger.info(documentsProfile.getProofAddress());
    }

    private void createDocumentProfile(ActionRequest request) {
        DocumentsProfileLocalServiceUtil.addDocumentsProfile(sessionManager.getDocumentsProfile(request));
        _logger.info("Creado no se donde");
    }

}