<%@ include file="/init.jsp" %>

<%
    boolean success = (boolean) renderRequest.getAttribute("success");
    String errorMessage = (String) renderRequest.getAttribute("errorMessage");
%>

<br /><br />

<c:if test="${ success == true }">
    <p><liferay-ui:message key="buy.payment.success"/></p>
</c:if>

<c:if test="${ success == false }">
    <p><liferay-ui:message key="buy.payment.fail"/></p>
    <%=errorMessage%>
</c:if>

