/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ec.virtualcoin.fixedquotation;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ec.virtualcoin.fixedquotation.config.FixedConfiguration;
import com.ec.virtualcoin.fixedquotation.constants.FixedQuotationPortletKeys;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

/**
 * @author Liferay
 */
@Component(
    configurationPid = "com.ec.virtualcoin.fixedquotation.config.FixedConfiguration",
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Coinatural",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Fixed Quotation Portlet",
		"javax.portlet.init-param.config-template=/configuration.jsp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + FixedQuotationPortletKeys.FIXED_QUOTATION_PORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.header-portlet-css=/style.css"
	},
	service = Portlet.class
)
public class FixedQuotationPortlet extends MVCPortlet {

    private static Logger _logger = LoggerFactory.getLogger(FixedQuotationPortlet.class.getName());

    private volatile FixedConfiguration _fixedConfiguration;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
	    
        PortletPreferences preferences = renderRequest.getPreferences();
        
        String usdAmount = preferences.getValue("usdAmount", _fixedConfiguration.usdAmount());
        
        renderRequest.setAttribute("usdAmount", usdAmount);
        renderRequest.setAttribute("usdAmountFormatted", format(usdAmount));

		super.doView(renderRequest, renderResponse);
	}
	
	private String format(String usdAmount) {
	    NumberFormat formatter;
         
        formatter = new DecimalFormat("00.00");
        return formatter.format(Float.valueOf(usdAmount));
    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _fixedConfiguration = ConfigurableUtil.createConfigurable(FixedConfiguration.class, properties);
    }

}