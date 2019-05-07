<%@ include file="/init.jsp" %>

<%
	String usdValue = (String) renderRequest.getAttribute("usdValue");
	String btcValue = (String) renderRequest.getAttribute("btcValue");
    String ewallet = (String) renderRequest.getAttribute("ewallet");
    String pid = (String) renderRequest.getAttribute("pid");
    String status = (String) renderRequest.getAttribute("status");
    String country = (String) renderRequest.getAttribute("country");
%>

<liferay-ui:error key="not.valid.wallet.addres" message="not.valid.wallet.addres" />
<portlet:actionURL name="sendOrder" var="sendOrder" />
<portlet:actionURL name="confirmOrder" var="confirmOrder" />

<div class="container" style="width:70%; margin-top: 50px;">
	<c:if test="${ status == 'COUNTRY_NOT_ALLOWED'}">
	    <div class="row" class="col-md-12"><liferay-ui:message key="buy.country.not.allowed" arguments="<%=country %>"/></div>
	    <div class="row" class="col-md-12"><a href="/group/control_panel/manage?p_p_id=address"><liferay-ui:message key="buy.update.address"/></a></div>
	</c:if>
	
	<c:if test="${ status == 'PROFILE_NOT_APPROVED'}">
	    <div class="row" class="col-md-12"><liferay-ui:message key="buy.profile.not.approved"/></div>
	    <div class="row" class="col-md-12"><a href="/group/control_panel/manage?p_p_id=identification"><liferay-ui:message key="buy.update.identification"/></a></div>
	    <div class="row" class="col-md-12"><a href="/group/control_panel/manage?p_p_id=address"><liferay-ui:message key="buy.update.address"/></a></div>
	</c:if>
	
	<c:if test="${ status == 'MAIL_CONFIRMATION_SENT'}">
	    <liferay-ui:message key="buy.mail.confirmation.sent"/>
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
	         <aui:input id="ewallet" label="buy.ewallet" name="ewallet" maxlength="35" >
	               <aui:validator name="required" />
	               <aui:validator errorMessage="not.valid.wallet.addres" name="custom">
			                function(value, fieldNode, ruleValue) {
			                     return (value.match(/^[13][a-km-zA-HJ-NP-Z1-9]{25,34}$/));
			                }
			        </aui:validator>
	           </aui:input>
	           <aui:button name="Buy" value="buy.send.order" type="submit" />
	    </aui:form>
	</c:if>
</div>
	
<aui:script use="aui-base">

    var usdToBtcCot;
    var calcFrom = 'USD';
    
    var usdField = A.one('#<portlet:namespace/>usdValue');
    if (usdField != undefined) {
	    A.one('#<portlet:namespace/>usdValue').on('keyup', function(event) {
            calcFrom = 'USD';
	        btc = convertToBtc(A.one('#<portlet:namespace/>usdValue').get('value'));
	        A.one('#<portlet:namespace/>btcValue').set('value', btc);
	    });

	    A.one('#<portlet:namespace/>btcValue').on('keyup', function(event) {
            calcFrom = 'BTC';
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
        usd = btc * usdToBtcCot;
        return usd.toFixed(4);
    }
    
        
    function updateCotization(data) {
        usdToBtcCot = data.usdPrice;
        if (calcFrom == 'USD'){
            usdField = A.one('#<portlet:namespace/>usdValue');
            btc = convertToBtc(usdField.get('value'));
            A.one('#<portlet:namespace />btcValue').set('value', btc);
        }
        if (calcFrom == 'BTC'){
            btcField = A.one('#<portlet:namespace/>btcValue');
            usd = convertToUsd(btcField.get('value'));
            A.one('#<portlet:namespace />usdValue').set('value', usd);
        }
    }
    
    var btcCotizationRequest = A.io.request('/o/rest/quotation/btc', {
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
    
