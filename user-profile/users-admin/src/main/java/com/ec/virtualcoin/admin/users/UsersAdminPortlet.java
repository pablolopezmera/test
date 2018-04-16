package com.ec.virtualcoin.admin.users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONSerializer;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import user.profile.model.UserProfile;
import user.profile.service.UserProfileLocalServiceUtil;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
        "com.liferay.portlet.instanceable=true", "javax.portlet.display-name=users-admin Portlet",
        "javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class UsersAdminPortlet extends MVCPortlet {

    private static Logger _logger = LoggerFactory.getLogger(UsersAdminPortlet.class.getName());

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        List<UserProfileDto> users = loadUserProfiles();
        _logger.info("Users: " + users.size());
        Escaper escaper = new Escaper(usersToJsonString(users).toJSONString());
        String unescaped = escaper.unescape();
        _logger.info(unescaped);

        renderRequest.setAttribute("users", unescaped);
        super.doView(renderRequest, renderResponse);
    }

    
    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        String screename = renderRequest.getParameter("screenname");
        _logger.info("renderrrrrrrrrr");
        _logger.info(screename);
        if (screename != null && !screename.isEmpty()) {
            UserProfile userProfile = UserProfileLocalServiceUtil.fetchUserProfile(screename);
            renderRequest.setAttribute("userProfile", userProfile);
        }
//        renderResponse.setRenderParameter("jspPage", "/identification.jsp");
        super.render(renderRequest, renderResponse);
    }
    
    @ProcessAction(name="approve")
    public void approve(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
        String screename = ParamUtil.get(actionRequest, "screenname", "");
        _logger.info("approveeeeeeeeeeeeeeeeee");
        _logger.info(screename);
        UserProfile userProfile = UserProfileLocalServiceUtil.fetchUserProfile(screename);
        userProfile.setApproved(Boolean.TRUE);
        UserProfileLocalServiceUtil.updateUserProfile(userProfile);
//        actionRequest.setAttribute("userProfile", userProfile);
//        actionResponse.setRenderParameter("jspPage", "/identification.jsp");
    }
    
    @ProcessAction(name="approve")
    public void deny(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
        String screename = ParamUtil.get(actionRequest, "screenname", "");
        _logger.info("denyyyyyyyyyyyyyyyyy");
        _logger.info(screename);
        UserProfile userProfile = UserProfileLocalServiceUtil.fetchUserProfile(screename);
        userProfile.setApproved(Boolean.FALSE);
        UserProfileLocalServiceUtil.updateUserProfile(userProfile);
//        actionRequest.setAttribute("userProfile", userProfile);
//        actionResponse.setRenderParameter("jspPage", "/identification.jsp");
    }
    
    @ProcessAction(name="approve")
    public void cancel(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
        String screename = ParamUtil.get(actionRequest, "screenname", "");
        _logger.info("cancellllllllllllll");
        _logger.info(screename);
    }
    
    private List<UserProfileDto> loadUserProfiles() {
        List<UserProfileDto> userList = new ArrayList<>();
        int countUser = UserLocalServiceUtil.getUsersCount();
        List<User> users = UserLocalServiceUtil.getUsers(0, countUser);
        for (User user : users) {
            try {
                UserProfile up = UserProfileLocalServiceUtil.getUserProfile(user.getScreenName());
                userList.add(new UserProfileDto(user.getFirstName(), user.getLastName(), up.getIdType(), up.getIdNumber(), user.getScreenName(), up.getApproved()));
            } catch (PortalException e) {
                e.printStackTrace();
            }
        }
        _logger.info("Users: " + users.size());
        return userList;
    }

    public JSONArray usersToJsonString(List<UserProfileDto> users) {

        JSONArray resultsArray = JSONFactoryUtil.createJSONArray();

        if (users != null) {

            for (UserProfileDto user : users) {
                JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
                resultsArray.put(serializer.serialize(user));
            }
        }
        return resultsArray;
    }

    private void initProfileInSession(RenderRequest renderRequest) throws PortalException {
        _logger.info("Inicia profile in session");
        User user = PortalUtil.getUser(renderRequest);
        _logger.info(user.getScreenName());
        UserProfile userProfile = UserProfileLocalServiceUtil.fetchUserProfile(user.getScreenName());
        renderRequest.setAttribute("userProfile", userProfile);
    }

}