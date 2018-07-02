package com.ec.virtualcoin.fixedquotation;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.log.LogService;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(immediate = true, 
        configurationPid = "com.ec.virtualcoin.fixedquotation.FixedQuotationConfiguration",
        configurationPolicy = ConfigurationPolicy.OPTIONAL,
        property = {"javax.portlet.name=fixed.quotation" }, 
        service = ConfigurationAction.class
        )
public class FixedQuotationConfigurationAction extends DefaultConfigurationAction {

    @Reference
    private LogService _log;
    private volatile FixedQuotationConfiguration fixedQuotationConfiguration;

    @Override
    public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws Exception {
        
        _log.log(LogService.LOG_INFO, "default configurationnnnnnnnnnnnnnnnnnnnnnnn");

        httpServletRequest.setAttribute(FixedQuotationConfiguration.class.getName(), fixedQuotationConfiguration);

        super.include(portletConfig, httpServletRequest, httpServletResponse);
    }

    @Override
    public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        _log.log(LogService.LOG_INFO, "process action..............");

        String favoriteColor = ParamUtil.getString(actionRequest, "favoriteColor");
        setPreference(actionRequest, "favoriteColor", favoriteColor);

        super.processAction(portletConfig, actionRequest, actionResponse);
    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        fixedQuotationConfiguration = ConfigurableUtil.createConfigurable(FixedQuotationConfiguration.class,
                properties);
    }

}