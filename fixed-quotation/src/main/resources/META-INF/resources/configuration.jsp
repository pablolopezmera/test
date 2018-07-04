<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<%
    String usdAmount = (String) renderRequest.getAttribute("usdAmount");
%>

<liferay-portlet:actionURL portletConfiguration="<%= true %>"
    var="configurationActionURL"
/>

<liferay-portlet:renderURL portletConfiguration="<%= true %>"
    var="configurationRenderURL"
/>

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">

    <aui:input name="<%= Constants.CMD %>" type="hidden"
        value="<%= Constants.UPDATE %>" />

    <aui:input name="redirect" type="hidden"
        value="<%= configurationRenderURL %>" />

    <aui:fieldset>
        <aui:input label="usdAmount" name="usdAmount" value="<%=usdAmount %>" type="String" />
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
    </aui:button-row>
</aui:form>