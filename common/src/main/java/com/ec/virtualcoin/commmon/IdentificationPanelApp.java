package com.ec.virtualcoin.commmon;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;

@Component(
        immediate = true,
        property = {
            "panel.app.order:Integer=1",
            "panel.category.key=" + PanelCategoryKeys.USER_MY_ACCOUNT,
        },
        service = PanelApp.class
    )
public class IdentificationPanelApp extends BasePanelApp {

    @Override
    public String getPortletId() {
        return "identification-portlet";
    }

    @Override
    @Reference(
        target = "(javax.portlet.name=identification-portlet)",
        unbind = "-"
    )
    public void setPortlet(Portlet portlet) {
        super.setPortlet(portlet);
    }

    @Override
    public String getLabel(Locale locale) {
        return "Identification";
    }


}
