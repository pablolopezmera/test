<%@ include file="/init.jsp" %>

<%
    boolean success = (boolean) renderRequest.getAttribute("success");
    String errorMessage = (String) renderRequest.getAttribute("errorMessage");
%>

<div class="container" style="width:70%; margin-top: 50px;">

<c:if test="${ success == true }">
    <div class="row" class="col-md-12"><liferay-ui:message key="buy.payment.success"/></div>
</c:if>

<c:if test="${ success == false }">
    <div class="row" class="col-md-12"><liferay-ui:message key="buy.payment.fail"/></div>
    <div class="row" class="col-md-12"><%=errorMessage%></div>
</c:if>

</div>