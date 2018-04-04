package com.liferay.users.admin.web.servlet.taglib.ui.ext;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.servlet.taglib.ui.FormNavigatorEntry;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.users.admin.web.servlet.taglib.ui.UserAddressesFormNavigatorEntry;

/**
 * Created by dnebinger on 12/29/16.
 */
@Component(
	property = {"form.navigator.entry.order:Integer=80"},
	service = FormNavigatorEntry.class
)
public class UserAddressesFormNavigatorEntryExt extends UserAddressesFormNavigatorEntry {

    private static Logger _logger = LoggerFactory.getLogger(UserAddressesFormNavigatorEntryExt.class.getName());
    
    private boolean visible = GetterUtil.getBoolean(PropsUtil.get(Constants.MY_ACCOUNT_ADDRESSES_VISIBLE), true);

	@Override
	public String getFormNavigatorId() {
		return Constants.MY_ACCOUNT_PREFIX + super.getFormNavigatorId();
	}

	@Override
	public boolean isVisible(User user, User selUser) {
	    _logger.info("Es visible:::::::::::::" + visible);
	    _logger.info(PropsUtil.get(Constants.MY_ACCOUNT_ADDRESSES_VISIBLE));
		return visible && super.isVisible(user, selUser);
	}
}
