package com.ec.virtualcoin.admin.users;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

@Component(immediate = true, service = ModelListener.class)
public class UserCreationListener extends BaseModelListener<User> {

    private static Logger _logger = LoggerFactory.getLogger(UserCreationListener.class.getName());

    @Override
    public void onAfterCreate(User user) throws ModelListenerException {
        _logger.info("Se creo el usuario: " + user.getScreenName());
        List<Group> groupList = GroupLocalServiceUtil.getGroups(0, GroupLocalServiceUtil.getGroupsCount());
        long siteId = 0;
        for (Group group : groupList) {
            if (group.getGroupKey().equalsIgnoreCase("Virtualcoin")) {
                siteId = group.getGroupId();
            }
        }
        UserLocalServiceUtil.addGroupUser(siteId, user.getUserId());
        _logger.info("Usuario agregado al sitio");
        super.onAfterCreate(user);
    }

}
