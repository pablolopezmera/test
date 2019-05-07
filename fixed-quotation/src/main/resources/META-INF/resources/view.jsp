<%@ include file="/init.jsp" %>

    <div class="divTable">
        <div class="divTableBody">
            <div class="firstRow" align="center">
                <div class="divTableRow">
                    <p id="firstRowParagraph">
                        Buy<br />
                        <b>$${usdAmountFormatted}</b>
                    </p>
                </div>
            </div>
            <div class="secondRow" align="center">
                <div class="divTableRow">
                    <p id="secondRowParagraph"></p>
                </div>
            </div>
            <div class="thirdRow" align="center">
                <div class="divTableRow">
                    <p id="thirdRowParagraph"></p>
                </div>
            </div>
            <div class="fourthRow" align="center">
                <div class="divTableRow">
                    <div id="fourthRowParagraph">
                       <table width="100%">
                           <tr><td colspan="2" align="center">You Get</td></tr>
                           <tr><td align="center" height="30" id="<portlet:namespace/>btcAmount"></td><td style="color: red">BTC</td></tr>
                           <tr><td align="center" colspan="2" height="40">
                            <a class="buy-button" href="/group/control_panel/manage?p_p_id=buy&p_p_lifecycle=0&p_p_state=maximized&p_p_auth=fqnvTYbt&value=${usdAmount}">Buy now</a>
                           </td></tr>
                       </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

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