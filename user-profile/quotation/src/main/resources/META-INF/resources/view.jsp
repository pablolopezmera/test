<%@ include file="/init.jsp"%>

<p>
	<aui:form name="buyForm" id="buyForm">
		<aui:input id="usdValue" label="quotation.usd" name="usdValue"
			value="500">
			<aui:validator name="required" />
			<aui:validator errorMessage="Only numeric value is allowed."
				name="custom">
	               function(value, fieldNode, ruleValue) {
	                  return (value.match(/^-?\d*(\.\d+)?$/));
	               }
	       </aui:validator>
		</aui:input>
		<aui:input id="btcValue" label="quotation.btc" name="btcValue"
			value="">
			<aui:validator name="required" />
			<aui:validator errorMessage="Only numeric value is allowed."
				name="custom">
	                     function(value, fieldNode, ruleValue) {
	                        return (value.match(/^-?\d*(\.\d+)?$/));
	                     }
	             </aui:validator>
		</aui:input>
		<aui:button name="Buy" value="quotation.buy" id="placeOrder" />
	</aui:form>

</p>

<aui:script use="aui-base">

    var usdToBtcCot = 0;
    var calcFrom = 'USD';
    
    var usdField = A.one('#<portlet:namespace />usdValue');
    if (usdField != undefined) {
        A.one('#<portlet:namespace />usdValue').on('keyup', function(event) {
            calcFrom = 'USD';
            btc = convertToBtc(A.one('#<portlet:namespace />usdValue').get('value'));
            A.one('#<portlet:namespace />btcValue').set('value', btc);
        });

        A.one('#<portlet:namespace />btcValue').on('keyup', function(event) {
            calcFrom = 'BTC';
            usd = convertToUsd(A.one('#<portlet:namespace />btcValue').get('value'));
            A.one('#<portlet:namespace />usdValue').set('value', usd);
        });

        setInterval(function(){
                getBtcCotization(); 
            }, 30000);
    }
    
    function convertToBtc(usd){
       return usd / usdToBtcCot;
    }

    function convertToUsd(btc){
        usd = btc * usdToBtcCot;
        return usd.toFixed(4);
    }

    function updateCotization(data) {
        usdToBtcCot = data.finalPrice;
        usdField = A.one('#<portlet:namespace />usdValue');
        if (calcFrom == 'USD'){
            btc = convertToBtc(usdField.get('value'));
            A.one('#<portlet:namespace />btcValue').set('value', btc);
        }
        if (calcFrom == 'BTC'){
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
    
    A.one('#<portlet:namespace />placeOrder').on('click', function(event) {
        usd = document.getElementById('<portlet:namespace />usdValue');
        console.log(usd.value);
        // location.href = '/group/virtualcoin/buy?value=' + usd.value;
        location.href = '/group/control_panel/manage?p_p_id=buy&p_p_lifecycle=0&p_p_state=maximized&p_p_auth=fqnvTYbt&value=' + usd.value;
    });

</aui:script>
