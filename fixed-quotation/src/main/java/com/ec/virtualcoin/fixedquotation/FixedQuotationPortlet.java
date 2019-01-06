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

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ec.virtualcoin.fixedquotation.constants.FixedQuotationPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

/**
 * @author Liferay
 */
@Component(
    configurationPid = "com.ec.virtualcoin.fixedquotation.FixedQuotationConfiguration",
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Fixed Quotation Portlet",
		"javax.portlet.init-param.config-template=/configuration.jsp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + FixedQuotationPortletKeys.FIXED_QUOTATION_PORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FixedQuotationPortlet extends MVCPortlet {

    private static Logger _logger = LoggerFactory.getLogger(FixedQuotationPortlet.class.getName());

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

	    _logger.info(renderRequest.getParameter("usdAmount"));
	    
        String usdAmount = renderRequest.getParameter("usdAmount") == null ? "200": renderRequest.getParameter("usdAmount");
        
        _logger.info("usdAmount: " + usdAmount);
	    
        renderRequest.setAttribute("usdAmount", usdAmount);

		super.doView(renderRequest, renderResponse);
	}

}