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
    var columns = [
      {key:'date_time', label:'<liferay-ui:message key="date_time"/>'},
      {key:'curr_from', label:'<liferay-ui:message key="curr_from"/>'},
      {key:'value_from', label:'<liferay-ui:message key="value_from"/>'},
      {key:'curr_to', label:'<liferay-ui:message key="curr_to"/>'},
      {key:'value_to', label:'<liferay-ui:message key="value_to"/>'},
      {key:'ewallet', label:'<liferay-ui:message key="ewallet"/>'}
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
