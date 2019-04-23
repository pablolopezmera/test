package com.ec.virtualcoin.admin.users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
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

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONSerializer;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.CountryServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import user.profile.model.UserProfile;
import user.profile.service.UserProfileLocalServiceUtil;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=Coinatural",
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
            renderRequest.setAttribute("countryName", findCountryName(userProfile.getCountry()));
        }
        super.render(renderRequest, renderResponse);
    }
    
    private String findCountryName(String countryA2) {
        String countryName = "";
        if (countryA2!=null && !countryA2.isEmpty()) {
            Country country = CountryServiceUtil.fetchCountryByA2(countryA2);
            countryName = country.getName();
        }
        return countryName;
    }


    @ProcessAction(name="approve")
    public void approve(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
        String screename = ParamUtil.get(actionRequest, "screenname", "");
        _logger.debug("approveeeeeeeeeeeeeeeeee");
        _logger.debug(screename);
        UserProfile userProfile = UserProfileLocalServiceUtil.fetchUserProfile(screename);
        userProfile.setApproved(Boolean.TRUE);
        UserProfileLocalServiceUtil.updateUserProfile(userProfile);
        sendApprovedMailConfirmation(actionRequest, userProfile);
    }

    private void sendApprovedMailConfirmation(ActionRequest actionRequest, UserProfile userProfile) {
        User user = (User) actionRequest.getAttribute(WebKeys.USER);
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Group siteGroup = themeDisplay.getSiteGroup();
        String mailFrom = (String) siteGroup.getExpandoBridge().getAttribute("notification.address.from");
        String subject = (String) siteGroup.getExpandoBridge().getAttribute("notification.approved.subject");

        String link = buildLink(actionRequest);
        String name = user.getFirstName().concat(" ").concat(user.getLastName());
        String body = StringUtil.replace(getBodyTemplate().toString(),
                new String[] { "[$NAME$]", "[$LINK$]" },
                new String[] { name, link });

        try {
            InternetAddress fromAddress = new InternetAddress(mailFrom);
            _logger.debug(String.format("company: %s userid: %s",  user.getCompanyId(), userProfile.getUserId()));
            User destinationUser = UserLocalServiceUtil.fetchUserByScreenName(user.getCompanyId(), userProfile.getUserId());
            InternetAddress  toAddress = new InternetAddress(destinationUser.getEmailAddress());
            MailMessage mailMessage = new MailMessage();
            mailMessage.setTo(toAddress);
            mailMessage.setFrom(fromAddress);
            mailMessage.setSubject(subject);
            mailMessage.setBody(body);
            mailMessage.setHTMLFormat(true);
            MailServiceUtil.sendEmail(mailMessage);
            _logger.debug("Sent mail by Using Template to: ".concat(destinationUser.getEmailAddress()));
        } catch (AddressException e) {
            SessionErrors.add(actionRequest, "error");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            SessionErrors.add(actionRequest, "error");
            e.printStackTrace();
        }

    }
    
    @ProcessAction(name="approve")
    public void deny(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
        String screename = ParamUtil.get(actionRequest, "screenname", "");
        _logger.debug("denyyyyyyyyyyyyyyyyy");
        _logger.debug(screename);
        UserProfile userProfile = UserProfileLocalServiceUtil.fetchUserProfile(screename);
        userProfile.setApproved(Boolean.FALSE);
        UserProfileLocalServiceUtil.updateUserProfile(userProfile);
    }
    
    @ProcessAction(name="approve")
    public void cancel(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
        String screename = ParamUtil.get(actionRequest, "screenname", "");
        _logger.debug("cancellllllllllllll");
        _logger.debug(screename);
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
                _logger.error(e.getMessage());
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

    private StringBuilder getBodyTemplate() {
        InputStream resourceAsStream = this.getClass().getClassLoader()
                .getResourceAsStream("/content/profile-approved.tmpl");
        StringBuilder textBuilder = new StringBuilder();
        try (Reader reader = new BufferedReader(
                new InputStreamReader(resourceAsStream, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c = 0;
            while ((c = reader.read()) != -1) {
                textBuilder.append((char) c);
            }
            _logger.debug("el body");
            _logger.debug(textBuilder.toString());
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return textBuilder;
    }    

    private String buildLink(ActionRequest actionRequest) {
        StringBuilder url = new StringBuilder(200);
        String completeURL = PortalUtil.getCurrentCompleteURL(
                PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest)));
        url.append(completeURL.substring(0, completeURL.indexOf("group") + 5));
        url.append("/control_panel/manage?p_p_id=buy");
        _logger.info(url.toString());
        return url.toString();
    }


}