<%@ include file="/init.jsp" %>

<script type="text/javascript">
<!--
var portletNamespace = '<portlet:namespace/>';
//-->
</script>

<%
    String pid = (String) renderRequest.getAttribute("pid");
%>

<portlet:actionURL name="makePayment" var="makePayment" />

<aui:form name="confirmForm" id="confirmForm" action="<%= makePayment %>" method="post">

    <aui:input type="hidden" name="pid" value="${pid}" />

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/styles.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/demo.css">

    <div class="container-fluid">
        <div class="creditCardForm">
            <div class="heading">
                <h1>Confirm Purchase</h1>
            </div>
            <div class="payment">

                    <div class="form-group owner">
                        <aui:input type="text" class="form-control" id="owner" name="owner">
                            <aui:validator name="required" />
                            <aui:validator name="minLength">5</aui:validator>
                        </aui:input>
                    </div>
                    <div class="form-group CVV">
                        <aui:input type="text" class="form-control" name="cvv" id="cvv">
                            <aui:validator name="required" />
                            <aui:validator name="number" />
                            <aui:validator name="minLength">3</aui:validator>
                            <aui:validator name="maxLength">4</aui:validator>
                        </aui:input>
                    </div>
                    <div class="form-group" id="card-number-field">
                        <aui:input type="text" class="form-control" name="cardNumber" id="cardNumber">
                            <aui:validator name="required" />
                        </aui:input>
                    </div>
                    <div class="form-group" id="expiration-date">
                         <aui:select name="monthExpiration" label="expiration.date">
                            <aui:option value="01">January</aui:option>
                            <aui:option value="02">February </aui:option>
                            <aui:option value="03">March</aui:option>
                            <aui:option value="04">April</aui:option>
                            <aui:option value="05">May</aui:option>
                            <aui:option value="06">June</aui:option>
                            <aui:option value="07">July</aui:option>
                            <aui:option value="08">August</aui:option>
                            <aui:option value="09">September</aui:option>
                            <aui:option value="10">October</aui:option>
                            <aui:option value="11">November</aui:option>
                            <aui:option value="12">December</aui:option>
                        </aui:select>
                         <aui:select name="yearExpiration" label="expiration.date">
                            <aui:option value="2018">2018</aui:option>
                            <aui:option value="2019">2019</aui:option>
                            <aui:option value="2020">2020</aui:option>
                            <aui:option value="2021">2021</aui:option>
                        </aui:select>
                    </div>
                    <div class="form-group" id="credit_cards">
                        <img src="<%=request.getContextPath()%>/assets/images/visa.jpg" id="visa">
                        <img src="<%=request.getContextPath()%>/assets/images/mastercard.jpg" id="mastercard">
                        <img src="<%=request.getContextPath()%>/assets/images/amex.jpg" id="amex">
                    </div>
                      <aui:button name="Buy" value="buy.confirm" type="submit" />
<!-- 
                    <div class="form-group" id="pay-now">
                        <button type="submit" class="btn btn-default" id="confirm-purchase">Confirm</button>
                    </div>
 -->

            </div>
        </div>

    </div>
    <script src="<%=request.getContextPath()%>/assets/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/jquery.payform.min.js" charset="utf-8"></script>
    <script src="<%=request.getContextPath()%>/assets/js/script.js"></script>
</aui:form>
