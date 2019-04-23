package com.ec.virtualcoin.common;

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
        if (getUserProfile(renderRequest) == null) {
            UserProfile UserProfile = UserProfileLocalServiceUtil.fetchUserProfile(user.getScreenName());
            if (UserProfile == null) {
                UserProfile = UserProfileLocalServiceUtil.createUserProfile(user.getScreenName());
                getSession(renderRequest).setAttribute("UserProfileIsNew", true);
            }
            getSession(renderRequest).setAttribute("UserProfile", UserProfile);
            _logger.info("puestooooo");
        }


    }

    public UserProfile getUserProfile(RenderRequest renderRequest) {
        return (UserProfile) getSession(renderRequest).getAttribute("UserProfile");
    }

    public void setDocumentFilePath(String filePath, ImageType imageType, ActionRequest request) {
        UserProfile UserProfile  = getUserProfile(request);
        _logger.info(imageType + " actualizado a: " + filePath);
        switch (imageType) {
        case ANVERSO:
           UserProfile.setAnversoId(filePath);
            break;
        case REVERSO:
            UserProfile.setReversoId(filePath);
            break;
        case SELFIE:
            UserProfile.setSelfie(filePath);
            break;
        case RESIDENCIA:
            UserProfile.setProofAddress(filePath);
            break;
        default:
            break;
        }
    }

    public String getDocumentFilePath(ImageType imageType, ActionRequest request) {
        UserProfile UserProfile  = getUserProfile(request);
        return getDocumentFilePath(UserProfile, imageType);
    }

    public String getDocumentFilePath(ImageType imageType, HttpServletRequest request) {
        UserProfile UserProfile  = getUserProfile(request);
        return getDocumentFilePath(UserProfile, imageType);
    }
    
    public String getDocumentFilePath(UserProfile UserProfile, ImageType imageType) {
        switch (imageType) {
        case ANVERSO:
           return UserProfile.getAnversoId();
        case REVERSO:
            return UserProfile.getReversoId();
        case SELFIE:
            return UserProfile.getSelfie();
        case RESIDENCIA:
            return UserProfile.getProofAddress();
        default:
            return null;
        }
    }

    public UserProfile getUserProfile(ActionRequest request) {
        return (UserProfile) getSession(request).getAttribute("UserProfile");
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
        Object UserProfileIsNew = getSession(request).getAttribute("UserProfileIsNew");
        return UserProfileIsNew != null && (boolean) getSession(request).getAttribute("UserProfileIsNew");
    }

    public UserProfile getUserProfile(HttpServletRequest request) {
        return (UserProfile) getSession(request).getAttribute("UserProfile");
    }

    private HttpSession getSession(HttpServletRequest request) {
        return PortalUtil.getOriginalServletRequest(request).getSession();
    }

}
