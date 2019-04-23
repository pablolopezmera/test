<%@ include file="/init.jsp" %>

<%
	String usdValue = (String) renderRequest.getAttribute("usdValue");
	String btcValue = (String) renderRequest.getAttribute("btcValue");
    String ewallet = (String) renderRequest.getAttribute("ewallet");
    String pid = (String) renderRequest.getAttribute("pid");
%>

<portlet:actionURL name="sendOrder" var="sendOrder" />
<portlet:actionURL name="confirmOrder" var="confirmOrder" />

<p>

  <aui:form name="confirmForm" id="confirmForm" action="<%= confirmOrder %>" method="post">
      <aui:input type="hidden" name="pid" value="${pid}" />
	    <liferay-ui:message key="confirm.your.order"/><br />
	    <liferay-ui:message key="buy.usd"/>:${usdValue}<br />
	    <liferay-ui:message key="buy.btc"/>:${btcValue}<br />
	    <liferay-ui:message key="buy.ewallet"/>:${ewallet}<br />
      <aui:button name="Buy" value="buy.confirm" type="submit" />
    </aui:form>
	
</p>
