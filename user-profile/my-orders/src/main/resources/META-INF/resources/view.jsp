<%@ include file="/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>

<%
    String orders = (String) renderRequest.getAttribute("orders");
%>
<p>
    <div id="ordersDataTable"></div>
</p>
<aui:script use="aui-base"> 
YUI().use(
  'aui-datatable','datatable-sort','liferay-portlet-url',   
  function(Y) {
  
    function toDateTime(o) {
        d = new Date(o.data.date_time);
        return d.toLocaleString(); 
    }
    
    var columns = [
      {key:'date_time', formatter: toDateTime, label:'<liferay-ui:message key="label.date.time"/>'},
      {key:'curr_from', label:'<liferay-ui:message key="label.currency.from"/>'},
      {key:'value_from', label:'<liferay-ui:message key="label.value.from"/>'},
      {key:'curr_to', label:'<liferay-ui:message key="label.currency.to"/>'},
      {key:'value_to', label:'<liferay-ui:message key="label.value.to"/>'},
      {key:'ewallet', label:'<liferay-ui:message key="label.ewallet"/>'},
      {key:'status', label:'<liferay-ui:message key="label.status"/>'}
      ];

    var data = <%=HtmlUtil.unescape(orders)%> ;
    
    var sortable = ['curr_from','curr_to', 'date_time']
        
    new Y.DataTable(
      {
        columns: columns,
        data: data,
        sortable: sortable
      }
    ).render("#ordersDataTable");
  }
);
</aui:script>
