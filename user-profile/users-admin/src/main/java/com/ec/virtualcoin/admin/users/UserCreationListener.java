package com.ec.virtualcoin.admin.users;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ec.virtualcoin.config.CoinaturalConfiguration;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import user.profile.model.UserProfile;
import user.profile.service.UserProfileLocalServiceUtil;

@Component(immediate = true, service = ModelListener.class, configurationPid = "com.ec.virtualcoin.config.CoinaturalConfiguration")
public class UserCreationListener extends BaseModelListener<User> {

    private volatile CoinaturalConfiguration _configuration;
    
    private static Logger _logger = LoggerFactory.getLogger(UserCreationListener.class.getName());

    @Override
    public void onAfterCreate(User user) throws ModelListenerException {
        _logger.info("Se creo el usuario: " + user.getScreenName());
        _logger.info("Unir al sitio: " + _configuration.siteName());
        List<Group> groupList = GroupLocalServiceUtil.getGroups(0, GroupLocalServiceUtil.getGroupsCount());
        long siteId = 0;
        for (Group group : groupList) {
            if (group.getGroupKey().equalsIgnoreCase(_configuration.siteName())) {
                siteId = group.getGroupId();
            }
        }
        UserLocalServiceUtil.addGroupUser(siteId, user.getUserId());
        UserProfile userProfile = UserProfileLocalServiceUtil.createUserProfile(user.getScreenName());
        userProfile.setApproved(Boolean.FALSE);
        UserProfileLocalServiceUtil.addUserProfile(userProfile);
        _logger.info("Usuario agregado al sitio");
        super.onAfterCreate(user);
    }
    
    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        _logger.info("Se activa o modifica la configuracion..." + properties);
        _configuration = ConfigurableUtil.createConfigurable(CoinaturalConfiguration.class, properties);
    }

}
