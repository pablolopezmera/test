<%@ include file="/init.jsp" %>

<%
    String usdAmount = (String) renderRequest.getAttribute("usdAmount");
%>

<style>
<!--
.usd-quotation {
    font-size: 150%;
}
.btc-quotation {
    font-size: 200%;
}
.buy-button {
    font-size: 300%;
}
-->
</style>

<table>
  <tr>
    <th class="usd-quotation">$${usdAmount}</th>
  </tr>
  <tr>
    <td><div class="btc-quotation" id="btcAmount" /></td>
  </tr>
  <tr>
    <td><a class="buy-button" href="/group/virtualcoin/buy?value=${usdAmount}">Buy now</a></td>
  </tr>
</table>

<aui:script use="aui-base">

    var usd = ${usdAmount};
    
    function convertToBtc(){
        return usd / usdToBtcCot;
     }

    var btcCotizationRequest = A.io.request('/o/rest/quotation/btc', {
        dataType: 'json',
        on: {
            success: function() {
                updateCotization(this.get('responseData'));
           }
        }
    
    });

    function updateCotization(data) {
        console.log(data);
        usdToBtcCot = data.usdPrice;
        btc = convertToBtc();
        btcDiv = document.getElementById('btcAmount');
        btcDiv.innerHTML = btc;
    }

</aui:script>