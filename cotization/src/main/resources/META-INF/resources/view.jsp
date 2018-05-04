<%@ include file="/init.jsp" %>

<div id="divWidgetAreaConversion" style="min-width:280px !important; height:220px !important;"><script>var typeChart='conversion';
var w_baseCurrency = new Array(); var w_targetCurrency = new Array(); w_baseCurrency[0]="BTC"; w_targetCurrency[0]="USD"; var widgetStyle={};
widgetStyle["bgColor"]="#FFFFFF";
widgetStyle["backgroundColor"]="#FFFFFF";
widgetStyle["bgTransparent"]="solid";
widgetStyle["fontSize"]="16px";
widgetStyle["fontFamily"]="arial";
widgetStyle["fontColor"]="#000000";
widgetStyle["borderWidth"]="1";
widgetStyle["borderColor"]="#CCCCCC";
widgetStyle["cornerStyle"]="round";
widgetStyle["lastUpdateTime"]="block";
widgetStyle["chartStyle"]="none";
</script><meta charset="UTF"><script src="https://bitcoinaverage.com/vendor/jquery/dist/jquery.min.js"></script><script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script><script src="https://bitcoinaverage.com/js/widgetGenerator/widgetUserScript.js"></script></div>
<script>
function placeOrder() {
	ic = document.getElementById('inputCurrency');
	console.log(ic.value);
	location.href = '/group/virtualcoin/buy?value=' + ic.value;
}
</script>
<p>

    <button value="Buy" onclick="placeOrder()">Buy</button>
	<b><liferay-ui:message key="cotization.caption"/></b>
</p>