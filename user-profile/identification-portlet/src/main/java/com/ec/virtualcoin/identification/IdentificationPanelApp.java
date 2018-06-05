package com.ec.virtualcoin.identification;

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
public class IdentificationPanelApp extends BasePanelApp {

    @Override
    public String getPortletId() {
        return "identification_portlet";
    }

    @Override
    @Reference(
        target = "(javax.portlet.name=identification_portlet)",
        unbind = "-"
    )
    public void setPortlet(Portlet portlet) {
        super.setPortlet(portlet);
    }

}
