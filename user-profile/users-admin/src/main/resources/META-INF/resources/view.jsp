<%@ include file="/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>

<%
    String users = (String) renderRequest.getAttribute("users");
%>
<p>
    <div id="usersDataTable"></div>
</p>
<portlet:renderURL var="showjspURL">
    <portlet:param name="jspPage" value="/residencia.jsp" />
</portlet:renderURL>
<portlet:renderURL var="showIdURL">
    <portlet:param name="jspPage" value="/identification.jsp" />
</portlet:renderURL>
<aui:script use="aui-base"> 
YUI().use(
  'aui-datatable','datatable-sort','liferay-portlet-url',   
  function(Y) {
    var columns = [
      {key:'idType', label:'<liferay-ui:message key="id.type"/>'},
      {key:'idNumber', label:'<liferay-ui:message key="id.number"/>'},
      {key:'firstName', label:'<liferay-ui:message key="user.first.name"/>'},
      {key:'lastName', label:'<liferay-ui:message key="user.last.name"/>'},
      {key:'approved', label:'<liferay-ui:message key="user.approved"/>'},
      {
        key: 'details', label: '<liferay-ui:message key="view.details"/>',
        nodeFormatter: function (o) {
            // console.log(o.data);
            var url = Liferay.PortletURL.createRenderURL();
            url.setWindowState("<%=LiferayWindowState.NORMAL.toString() %>")
            url.setParameter("screenname", o.data.screenname);
            url.setPortletMode("<%=LiferayPortletMode.VIEW %>")
            url.setParameter('mvcPath', '/details.jsp');
            url.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>")

            o.cell.set('innerHTML', '<a href="'+ url.toString() + '"><liferay-ui:message key="view.details"/></a>');
            return false;
            },
        allowHTML: true
      }
    ];

    var data = <%=HtmlUtil.unescape(users)%> ;
    
    var sortable = ['idType','idNumber','firstName','lastName']
        
    new Y.DataTable(
      {
        columns: columns,
        data: data,
        sortable: sortable
      }
    ).render("#usersDataTable");
  }
);
</aui:script>
