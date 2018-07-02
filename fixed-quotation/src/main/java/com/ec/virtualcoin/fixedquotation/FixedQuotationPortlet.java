package com.ec.virtualcoin.fixedquotation;

import java.io.IOException;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.log.LogService;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

@Component(
	immediate = true,
	configurationPid =
	        "com.ec.virtualcoin.fixedquotation.FixedQuotationConfiguration",
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=fixed-quotation Portlet",
		"javax.portlet.init-param.config-template=/configuration.jsp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=fixed.quotation",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FixedQuotationPortlet extends MVCPortlet {

    @Reference
    private LogService _log;

    private volatile FixedQuotationConfiguration fixedQuotationConfiguration;
    
    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
            fixedQuotationConfiguration = ConfigurableUtil.createConfigurable(
                    FixedQuotationConfiguration.class, properties);
    }

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        // TODO Auto-generated method stub
        _log.log(LogService.LOG_INFO, "La concha de la loraaaaaaaaaaaa");
        super.doView(renderRequest, renderResponse);
    }
    
}