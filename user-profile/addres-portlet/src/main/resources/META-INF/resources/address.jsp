<%@ include file="/init.jsp"%>

<%@ page import="com.liferay.portal.kernel.model.Country"%>
<%@ page import="user.profile.model.UserProfile"%>
<%@ page import="java.util.List"%>

<%
    List<Country> countries = (List<Country>) renderRequest.getAttribute("countries");
	String city = (String) renderRequest.getAttribute("city");
	String country = (String) renderRequest.getAttribute("country");
	String homeNumber = (String) renderRequest.getAttribute("homeNumber");
	String postalCode = (String) renderRequest.getAttribute("postalCode");
	String prov = (String) renderRequest.getAttribute("prov");
	String street1 = (String) renderRequest.getAttribute("street1");
	String street2 = (String) renderRequest.getAttribute("street1");
	String phoneNumber = (String) renderRequest.getAttribute("phoneNumber");
%>

<portlet:renderURL var="uploadResidencia" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
    <portlet:param name="mvcPath" value="/fileUpload.jsp" />
    <portlet:param name="img" value="RESIDENCIA" />
</portlet:renderURL>

<portlet:defineObjects />

<portlet:actionURL name="delete" var="deleteResidencia">
    <portlet:param name="imgType" value="RESIDENCIA" />
</portlet:actionURL>

<portlet:actionURL name="saveProfile" var="saveProfile" />

<aui:form action="<%= saveProfile %>" method="post" name="addresForm">

<div class="container">
    <div class="row">
        <div id="no-more-tables">
            <table class="col-md-12 table-bordered table-striped table-condensed cf">
                <tbody>
                    <tr>
                      <td>
				          <aui:select name="country" label="user.country">
				                <%for(int i = 0; i < countries.size(); i++){ 
				                    Country c = countries.get(i);
				                    boolean selected = false;
				                    if(country.equals(c.getA2())){
				                        selected = true;
				                    } %>
				                    <aui:option label="<%=c.getNameCurrentValue() %>" value="<%=c.getA2() %>" selected="<%=selected %>" />
				                <%} %>
				            </aui:select>
				            <aui:input label="user.prov" name="prov" value="${prov}" type="String">
                                <aui:validator name="required" />
				            </aui:input>
				            <aui:input label="user.city" name="city" value="${city}" type="String" >
                                <aui:validator name="required" />
                            </aui:input>
				            <aui:input label="user.homeNumber" name="homeNumber" value="${homeNumber}" type="String" >
                                <aui:validator name="required" />
                            </aui:input>
				            <aui:input label="user.street1" name="street1" value="${street1}" type="String" >
                                <aui:validator name="required" />
                            </aui:input>
				            <aui:input label="user.street2" name="street2" value="${street2}" type="String" >
                                <aui:validator name="required" />
                            </aui:input>
                            <aui:input label="user.postalCode" name="postalCode" value="${postalCode}" type="String" >
                                <aui:validator name="required" />
                            </aui:input>
                            <aui:input label="user.phoneNumber" name="phoneNumber" value="${phoneNumber}" type="String" >
                                <aui:validator name="required" />
                                <aui:validator name="number" />
                            </aui:input>
                      </td>
                      <td valign="top">
			            <table>
			                <tr>
			                    <td colspan="2"><img id="RESIDENCIAImg"
			                        src="/o/address/image?imageType=RESIDENCIA" width="250"
			                        height="150" /></td>
			                </tr>
			                <tr>
			                    <td align="center"><aui:button name="btnResidencia"
			                            type="button" value="change" /></td>
			                    <td align="center"><aui:button name="delResidencia"
			                            type="button" value="borrar" /></td>
			                </tr>
			            </table>
                      </td>
                    </tr>
                    <tr>
                      <td>
                      </td>
                      <td>
                      </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>


<br />
<aui:button name="Save" value="Save" />
	
</aui:form>

<aui:script use="aui-base,liferay-util-window,aui-io-request">

    var actualDialog = 'RESIDENCIA';
    
    A.one('#<portlet:namespace/>btnResidencia').on('click', function(event) {
        actualDialog = 'RESIDENCIA';
        openDialog(actualDialog, '<liferay-ui:message key="RESIDENCIA" />', '<%=uploadResidencia %>');
    });

    A.one('#<portlet:namespace/>delResidencia').on('click', function(event) {
        deleteImg('<%=deleteResidencia%>', 'RESIDENCIAImg');
    });
    
    function deleteImg(url , imageName){
        var A = AUI();
        var url = url;
        A.io.request(
            url,
            {
                method: 'POST',
                form: {id: '<portlet:namespace/>addresForm'},
                on: { success: function() { refeshImage(imageName);}
                }
            }
       );
    }

    A.one('#<portlet:namespace/>Save').on('click', function(event) {
        var A = AUI();
        var url = '<%=saveProfile%>';
        A.io.request(
            url,
            {
                method: 'POST',
                form: {id: '<portlet:namespace/>addresForm'},
                on: { success: function() { refreshPortlet();}}
            }
       );

    });
    
    function openDialog(dialogType, title, uri){
          Liferay.Util.openWindow({
               dialog: {centered: true, height: 300, modal: true, width: 400},
             id: '<portlet:namespace/>' +  dialogType,
             title: title,
             uri: uri
           });
    }

	Liferay.provide(
	     window,
	     'closePopup',
	     function(dialogId) {
	         console.log('cerrar: <portlet:namespace/>' + actualDialog);
	         Liferay.fire('closeWindow', {id:'<portlet:namespace/>' + actualDialog});
                 },['aui-base','liferay-util-window'] );

    Liferay.provide(window, 'refreshPortlet', function() {
        var curPortlet = '#p_p_id<portlet:namespace/>';
        console.log(curPortlet);
        Liferay.Portlet.refresh(curPortlet);
        setTimeout(function(){ 
            refeshImage('RESIDENCIAImg'); 
            }, 500);
        
    },
    ['aui-dialog','aui-dialog-iframe']
    );
    
    function refeshImage(imageName){
        console.log('refrescar...');
        console.log(imageName);
        img = document.getElementById(imageName);
        console.log(img);
        var d=new Date();
        img.src = img.src + '&a=' +d.getTime();
    }

</aui:script>