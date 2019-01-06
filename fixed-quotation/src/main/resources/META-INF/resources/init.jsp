<%@ page import="com.ec.virtualcoin.fixedquotation.config.FixedConfiguration" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
    FixedConfiguration fixedConfiguration =
        (FixedConfiguration)
        renderRequest.getAttribute(FixedConfiguration.class.getName());

    String usdAmount = StringPool.BLANK;

    if (Validator.isNotNull(fixedConfiguration)) {
        usdAmount =
            portletPreferences.getValue(
                "usdAmount", fixedConfiguration.usdAmount().toString());
    }
%>