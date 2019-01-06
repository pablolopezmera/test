<%@ include file="/init.jsp" %>


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
    <td><div class="btc-quotation" id="<portlet:namespace/>btcAmount" /></td>
  </tr>
  <tr>
    <td><a class="buy-button" href="http://localhost:8080/group/control_panel/manage?p_p_id=buy&p_p_lifecycle=0&p_p_state=maximized&p_p_auth=fqnvTYbt&value=${usdAmount}">Buy now</a></td>
  </tr>
</table>

<script>

    var <portlet:namespace/>fixed_usd = ${usdAmount};
    
    function <portlet:namespace/>convertToBtc(usdPrice){
        usd = <portlet:namespace/>fixed_usd / usdPrice;
        return usd.toFixed(4);
    }

    var xhr = new XMLHttpRequest();
    xhr.open("POST", '/o/rest/quotation/btc', true);
    xhr.setRequestHeader("Content-Type", "application/json");
    
    xhr.onreadystatechange = function() {//Call a function when the state changes.
        if(this.readyState == XMLHttpRequest.DONE && this.status == 200) {
            // Request finished. Do processing here.
            <portlet:namespace/>updateCotization(JSON.parse(this.response));
        }
    }
    xhr.send();
    
    function <portlet:namespace/>updateCotization(data) {
        usdPrice = data.finalPrice;
        btc = <portlet:namespace/>convertToBtc(usdPrice);
        btcDiv = document.getElementById('<portlet:namespace/>btcAmount');
        btcDiv.innerHTML = btc;
    }

</script>