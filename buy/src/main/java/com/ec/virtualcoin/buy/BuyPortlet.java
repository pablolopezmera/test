package com.ec.virtualcoin.buy;

import java.io.IOException;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=buy Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BuyPortlet extends MVCPortlet {

    private static Logger _logger = LoggerFactory.getLogger(BuyPortlet.class.getName());
    
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        
        @SuppressWarnings("unchecked")
        Map<String, String> userInfo = (Map<String, String>) renderRequest.getAttribute(PortletRequest.USER_INFO);
        
        String country = userInfo.get("user.business-info.postal.country");
        _logger.info(country);
        
        if ("Ecuador".equals(country)) {
            renderRequest.setAttribute("isCountryAllowed", true);
        } else {
            renderRequest.setAttribute("isCountryAllowed", false);
        }
        
        
        super.doView(renderRequest, renderResponse);
    }
    
    
}