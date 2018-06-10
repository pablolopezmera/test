package com.ec.virtualcoin;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;

@Component(
        immediate = true,
        property = {
            "panel.category.key=" + PanelCategoryKeys.USER_MY_ACCOUNT,
            "service.ranking:Integer=100"
        },
        service = PanelApp.class
    )
public class MyOrdersPanelApp extends BasePanelApp {

    @Override
    public String getPortletId() {
        return "my_orders";
    }

    @Override
    @Reference(
        target = "(javax.portlet.name=my_orders)",
        unbind = "-"
    )
    public void setPortlet(Portlet portlet) {
        super.setPortlet(portlet);
    }

}
