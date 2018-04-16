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

import user.profile.model.UserProfile;
import user.profile.service.UserProfileLocalServiceUtil;

public class SessionManager {
    
    private static Logger _logger = LoggerFactory.getLogger(SessionManager.class.getName());

    public void initProfileInSession(RenderRequest renderRequest) throws PortalException {

        _logger.info("Inicia profile in session");
        User user = PortalUtil.getUser(renderRequest);
        _logger.info(user.getScreenName());
        if (getUserProfile(renderRequest) == null) {
            UserProfile userProfile = UserProfileLocalServiceUtil.fetchUserProfile(user.getScreenName());
            if (userProfile == null) {
                _logger.info("El usuario no existe, se pone como nuevo");
                userProfile = UserProfileLocalServiceUtil.createUserProfile(user.getScreenName());
                getSession(renderRequest).setAttribute("documentsProfileIsNew", true);
            }
            getSession(renderRequest).setAttribute("documentsProfile", userProfile);
            _logger.info("puestooooo");
        }


    }

    public UserProfile getUserProfile(RenderRequest renderRequest) {
        return (UserProfile) getSession(renderRequest).getAttribute("documentsProfile");
    }

    public void setDocumentFilePath(String filePath, ImageType imageType, ActionRequest request) {
        UserProfile documentsProfile  = getUserProfile(request);
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

    public String getDocumentFilePath(ImageType imageType, ActionRequest request) {
        UserProfile documentsProfile  = getUserProfile(request);
        return getDocumentFilePath(documentsProfile, imageType);
    }

    public String getDocumentFilePath(ImageType imageType, HttpServletRequest request) {
        UserProfile documentsProfile  = getDocumentsProfile(request);
        return getDocumentFilePath(documentsProfile, imageType);
    }
    
    public String getDocumentFilePath(UserProfile documentsProfile, ImageType imageType) {
        switch (imageType) {
        case ANVERSO:
           return documentsProfile.getAnversoId();
        case REVERSO:
            return documentsProfile.getReversoId();
        case SELFIE:
            return documentsProfile.getSelfie();
        case RESIDENCIA:
            return documentsProfile.getProofAddress();
        default:
            return null;
        }
    }

    public UserProfile getUserProfile(ActionRequest request) {
        return (UserProfile) getSession(request).getAttribute("documentsProfile");
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

    public UserProfile getDocumentsProfile(HttpServletRequest request) {
        return (UserProfile) getSession(request).getAttribute("documentsProfile");
    }

    private HttpSession getSession(HttpServletRequest request) {
        return PortalUtil.getOriginalServletRequest(request).getSession();
    }

}
