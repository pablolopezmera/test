package com.ec.virtualcoin.fixedquotation.config;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ec.virtualcoin.fixedquotation.constants.FixedQuotationPortletKeys;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(
        configurationPid = "com.ec.virtualcoin.fixedquotation.config.FixedConfiguration",
        configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
        property = {
            "javax.portlet.name=" + FixedQuotationPortletKeys.FIXED_QUOTATION_PORTLET
        },
        service = ConfigurationAction.class
    )
public class FixedConfigurationAction extends DefaultConfigurationAction {

    private volatile FixedConfiguration _fixedConfiguration;

    private static Logger _logger = LoggerFactory.getLogger(FixedConfigurationAction.class.getName());

    @Override
    public void include(
            PortletConfig portletConfig, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws Exception {
        
        httpServletRequest.setAttribute(
                FixedConfiguration.class.getName(), _fixedConfiguration);
        
        super.include(portletConfig, httpServletRequest, httpServletResponse);
    }
    
    @Override
    public void processAction(
            PortletConfig portletConfig, ActionRequest actionRequest,
            ActionResponse actionResponse)
        throws Exception {

        String usdAmount = ParamUtil.getString(actionRequest, "usdAmount");
        _logger.info("Grabar: " + usdAmount);
        
        setPreference(actionRequest, "usdAmount", usdAmount);

        super.processAction(portletConfig, actionRequest, actionResponse);
    }

    
    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _logger.info(properties.toString());
        _fixedConfiguration = ConfigurableUtil.createConfigurable(FixedConfiguration.class, properties);
    }

}
