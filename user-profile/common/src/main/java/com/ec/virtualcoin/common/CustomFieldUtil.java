package com.ec.virtualcoin.common;

import javax.management.AttributeNotFoundException;
import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

public class CustomFieldUtil {
    
    public <T> T getSiteAttribute(ActionRequest actionRequest, String attributeName) throws AttributeNotFoundException {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Group siteGroup = themeDisplay.getSiteGroup();
        @SuppressWarnings("unchecked")
        T attribute = (T) siteGroup.getExpandoBridge().getAttribute(attributeName);
        if (attribute == null) {
            throw new AttributeNotFoundException(String.format("Attribute %s nof found, create the attribute as SITE CUSTOM FIELD and give read permissions to USER role", attributeName));
        }
        return attribute;
    }

}
