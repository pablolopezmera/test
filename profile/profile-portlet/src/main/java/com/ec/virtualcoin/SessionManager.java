package com.ec.virtualcoin;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;

import profile.model.DocumentsProfile;
import profile.service.DocumentsProfileLocalServiceUtil;

public class SessionManager {
    
    private static Logger _logger = LoggerFactory.getLogger(SessionManager.class.getName());

    public void initProfileInSession(RenderRequest renderRequest) throws PortalException {

        User user = PortalUtil.getUser(renderRequest);
        if (getDocumentsProfile(renderRequest) == null) {
            DocumentsProfile documentsProfile = DocumentsProfileLocalServiceUtil.fetchDocumentsProfile(user.getScreenName());
            if (documentsProfile == null) {
                documentsProfile = DocumentsProfileLocalServiceUtil.createDocumentsProfile(user.getScreenName());
                getSession(renderRequest).setAttribute("documentsProfileIsNew", true);
            }
            getSession(renderRequest).setAttribute("documentsProfile", documentsProfile);
        }


    }

    public DocumentsProfile getDocumentsProfile(RenderRequest renderRequest) {
        return (DocumentsProfile) getSession(renderRequest).getAttribute("documentsProfile");
    }

    public void setDocumentFilePath(String filePath, ImageType imageType, ActionRequest request) {
        DocumentsProfile documentsProfile  = getDocumentsProfile(request);
        _logger.info(imageType + " actualizado a: " + filePath);
        switch (imageType) {
        case ANVERSO:
           documentsProfile.setAnversoId(filePath);
            break;
        case REVERSO:
            documentsProfile.setReversoId(filePath);
            break;
        case SELFIE:
            documentsProfile.setSelfie(filePath);
            break;
        case RESIDENCIA:
            documentsProfile.setProofAddress(filePath);
            break;
        default:
            break;
        }
    }

    public DocumentsProfile getDocumentsProfile(ActionRequest request) {
        return (DocumentsProfile) getSession(request).getAttribute("documentsProfile");
    }

    private HttpSession getSession(ActionRequest actionRequest) {
        HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(actionRequest);
        HttpServletRequest originalServletRequest = PortalUtil.getOriginalServletRequest(httpServletRequest);
        HttpSession session = originalServletRequest.getSession();
        return session;
    }

    private HttpSession getSession(RenderRequest renderRequest) {
        HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
        HttpServletRequest originalServletRequest = PortalUtil.getOriginalServletRequest(httpServletRequest);
        HttpSession session = originalServletRequest.getSession();
        return session;
    }

    public boolean userHasProfile(ActionRequest request) {
        _logger.info("Holaaaaaaaaaa");
        _logger.info(getSession(request).toString());
        Object documentsProfileIsNew = getSession(request).getAttribute("documentsProfileIsNew");
        return documentsProfileIsNew != null && (boolean) getSession(request).getAttribute("documentsProfileIsNew");
    }
    
}
