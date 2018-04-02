<%@ include file="/init.jsp" %>

<%
	boolean isCountryAllowed = (boolean) renderRequest.getAttribute("isCountryAllowed");
%>


<p>
<b><liferay-ui:message key="buy.caption"/></b>
<br />
<c:if test="${ isCountryAllowed}">
	<p>Cuanto quiere</p>
</c:if>
	
<c:if test="${ !isCountryAllowed}">
	<b><liferay-ui:message key="buy.country.not.allowed"/></b>
</c:if>

</p>