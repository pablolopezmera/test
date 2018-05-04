<%@ include file="/init.jsp" %>

<%
	String usdValue = (String) renderRequest.getAttribute("usdValue");
	String btcValue = (String) renderRequest.getAttribute("btcValue");
    String ewallet = (String) renderRequest.getAttribute("ewallet");
    String pid = (String) renderRequest.getAttribute("pid");
    String status = (String) renderRequest.getAttribute("status");
%>

<portlet:actionURL name="sendOrder" var="sendOrder" />
<portlet:actionURL name="confirmOrder" var="confirmOrder" />

<p>

<c:if test="${ status == 'COUNTRY_NOT_ALLOWED'}">
    <b><liferay-ui:message key="buy.country.not.allowed"/></b>
</c:if>

<c:if test="${ status == 'PROFILE_NOT_APPROVED'}">
    <p><liferay-ui:message key="buy.profile.not.approved"/></p>
</c:if>

<c:if test="${ status == 'MAIL_CONFIRMATION_SENT'}">
    <liferay-ui:message key="buy.mail.confirmation.sent"/>
</c:if>

<c:if test="${ status == 'CONFIRMATION'}">
  <aui:form name="confirmForm" id="confirmForm" action="<%= confirmOrder %>" method="post">
      <aui:input type="hidden" name="pid" value="${pid}" />
	    <liferay-ui:message key="confirm.your.order"/><br />
	    <liferay-ui:message key="buy.usd"/>:${usdValue}<br />
	    <liferay-ui:message key="buy.btc"/>:${btcValue}<br />
	    <liferay-ui:message key="buy.ewallet"/>:${ewallet}<br />
      <aui:button name="Buy" value="buy.confirm" type="submit" />
    </aui:form>
</c:if>

<c:if test="${ status == 'START_PURCHASE'}">
  <aui:form name="buyForm" id="buyForm" action="<%= sendOrder %>" method="post">
      <aui:input id="usdValue" label="buy.usd" name="usdValue" value="${usdValue}" >
             <aui:validator name="required" />
       <aui:validator errorMessage="Only numeric value is allowed."  name="custom">
               function(value, fieldNode, ruleValue) {
                  return (value.match(/^-?\d*(\.\d+)?$/));
               }
       </aui:validator>
      </aui:input>
         <aui:input id="btcValue" label="buy.btc" name="btcValue" value="${btcValue}" >
             <aui:validator name="required" />
             <aui:validator errorMessage="Only numeric value is allowed."  name="custom">
                     function(value, fieldNode, ruleValue) {
                        return (value.match(/^-?\d*(\.\d+)?$/));
                     }
             </aui:validator>
         </aui:input>
         <aui:input id="ewallet" label="buy.ewallet" name="ewallet" >
               <aui:validator name="required" />
           </aui:input>
           <aui:button name="Buy" value="buy.send.order" type="submit" />
    </aui:form>
</c:if>
	
</p>

<aui:script use="aui-base">

    var usdToBtcCot;
    
    var usdField = A.one('#<portlet:namespace/>usdValue');
    if (usdField != undefined) {
	    A.one('#<portlet:namespace/>usdValue').on('keyup', function(event) {
	        btc = convertToBtc(A.one('#<portlet:namespace/>usdValue').get('value'));
	        A.one('#<portlet:namespace/>btcValue').set('value', btc);
	    });

	    A.one('#<portlet:namespace/>btcValue').on('keyup', function(event) {
	        usd = convertToUsd(A.one('#<portlet:namespace/>btcValue').get('value'));
	        A.one('#<portlet:namespace/>usdValue').set('value', usd);
	    });

	    setInterval(function(){
	            getBtcCotization("Hello"); 
	        }, 20000);
    }
    
    function convertToBtc(usd){
       return usd / usdToBtcCot;
    }

    
    function convertToUsd(btc){
       return btc * usdToBtcCot;
    }
    
        
    function updateCotization(data) {
        usdToBtcCot = data.USD.last;
        usdField = A.one('#<portlet:namespace/>usdValue');
        if (usdField != undefined){
	        btc = convertToBtc(usdField.get('value'));
	        A.one('#<portlet:namespace/>btcValue').set('value', btc);
        }
    }
    
	var btcCotizationRequest = A.io.request('https://blockchain.info/es/ticker', {
	    dataType: 'json',
		on: {
		    success: function() {
		          updateCotization(this.get('responseData'));
		   }
		}
	
	});

    function getBtcCotization(){
        btcCotizationRequest.start();
    }
    
    btcCotizationRequest.start();

</aui:script>
    
