<%@ include file="/init.jsp"%>

<%
    String idType = (String) renderRequest.getAttribute("idType");
    String idNumber = (String) renderRequest.getAttribute("idNumber");
%>

<portlet:renderURL var="uploadAnverso" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
    <portlet:param name="mvcPath" value="/fileUpload.jsp" />
    <portlet:param name="img" value="ANVERSO" />
</portlet:renderURL>
<portlet:renderURL var="uploadReverso" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
    <portlet:param name="mvcPath" value="/fileUpload.jsp" />
    <portlet:param name="img" value="REVERSO" />
</portlet:renderURL>
<portlet:renderURL var="uploadSelfie" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
    <portlet:param name="mvcPath" value="/fileUpload.jsp" />
    <portlet:param name="img" value="SELFIE" />
</portlet:renderURL>

<portlet:defineObjects />

<portlet:actionURL name="delete" var="deleteAnverso">
    <portlet:param name="imgType" value="ANVERSO" />
</portlet:actionURL>
<portlet:actionURL name="delete" var="deleteReverso">
    <portlet:param name="imgType" value="REVERSO" />
</portlet:actionURL>
<portlet:actionURL name="delete" var="deleteSelfie">
    <portlet:param name="imgType" value="SELFIE" />
</portlet:actionURL>

<portlet:actionURL name="saveProfile" var="saveProfile" />

<aui:form action="<%= saveProfile %>" method="post">
	<table>
        <tr>
          <td>
              <table>
                  <tr><td colspan="2" class="control-label" align="center"><liferay-ui:message key="anverso"/></td></tr>
                  <tr><td colspan="2"><img name="anversoImg" id="ANVERSOImg"
                src="/o/profile/image?imageType=ANVERSO"
                width="250" height="150" /></td></tr>
                  <tr><td>&nbsp;</td></tr>
                  <tr><td align="center"><aui:button name="btnAnverso" type="button" value="cambiar" /></td>
                      <td align="center"><aui:button name="delAnverso" type="button" value="borrar" /></td></tr>
              </table>
          </td>
          <td>&nbsp;</td>
          <td>
              <table>
                  <tr><td colspan="2" class="control-label" align="center"><liferay-ui:message key="reverso"/></td></tr>
                  <tr><td colspan="2"><img id="REVERSOImg"
                src="/o/profile/image?imageType=REVERSO"
                width="250" height="150" /></td></tr>
                  <tr><td>&nbsp;</td></tr>
                  <tr><td align="center"><aui:button name="btnReverso" type="button" value="cambiar" /></td>
                    <td align="center"><aui:button name="delReverso" type="button" value="borrar" /></td></tr>
              </table>
          </td>
         </tr>
         <tr><td> &nbsp;</td></tr>
        <tr>
          <td>
              <table>
                  <tr><td colspan="2" class="control-label" align="center"><liferay-ui:message key="selfie"/></td></tr>
                  <tr><td colspan="2"><img id="SELFIEImg"
                src="/o/profile/image?imageType=SELFIE"
                width="250" height="150" /></td></tr>
                  <tr><td>&nbsp;</td></tr>
                  <tr><td align="center"><aui:button name="btnSelfie" type="button" value="change" /></td>
                    <td align="center"><aui:button name="delSelfie" type="button" value="borrar" /></td></tr>
              </table>
          </td>
          <td>&nbsp;</td>
          <td>
	         <aui:select name="idType" label="id.type">
               <aui:option label="select..." value="" />
               <aui:option label="id.type.passport" value="Passport" selected="<%=idType.equals("Passport") %>" />
               <aui:option label="id.type.id" value="Id" selected="<%=idType.equals("Id") %>" />
               <aui:option label="id.type.driverlicense" value="License" selected="<%=idType.equals("License") %>" />
	         </aui:select>
             <aui:input label="id.number" name="idNumber" value="${idNumber}" type="String" />
          
          </td>
        </tr>
	</table>
	
<br /><br />
<aui:button name="Save" value="Save" type="submit" />
	
</aui:form>
<aui:script use="aui-base,liferay-util-window,aui-io-request">

    var actualDialog = 'ANVERSO';
    
    A.one('#<portlet:namespace/>btnAnverso').on('click', function(event) {
        actualDialog = 'ANVERSO';
        console.log('<%=uploadAnverso %>');
        openDialog(actualDialog, '<liferay-ui:message key="ANVERSO" />', '<%=uploadAnverso %>');
    });

    A.one('#<portlet:namespace/>btnReverso').on('click', function(event) {
        actualDialog = 'REVERSO';
        openDialog(actualDialog, '<liferay-ui:message key="REVERSO" />', '<%=uploadReverso %>');
    });

    A.one('#<portlet:namespace/>btnSelfie').on('click', function(event) {
        actualDialog = 'SELFIE';
        openDialog(actualDialog, '<liferay-ui:message key="SELFIE" />', '<%=uploadSelfie %>');
    });

    A.one('#<portlet:namespace/>delAnverso').on('click', function(event) {
        deleteImg('<%=deleteAnverso%>', 'ANVERSOImg');
    });
    
    A.one('#<portlet:namespace/>delReverso').on('click', function(event) {
        deleteImg('<%=deleteReverso%>', 'REVERSOImg');
    });
    
    A.one('#<portlet:namespace/>delSelfie').on('click', function(event) {
        deleteImg('<%=deleteSelfie%>', 'SELFIEImg');
    });
    
    function deleteImg(url , imageName){
        var A = AUI();
        var url = url;
        A.io.request(
            url,
            {
                method: 'POST',
                form: {id: '<portlet:namespace/>uploadFile'},
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
                form: {id: '<portlet:namespace/>uploadFile'},
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
        // Liferay.Portlet.refresh(curPortlet);
        // setTimeout(function(){ 
            refeshImage(actualDialog + 'Img'); 
            refeshImage('ANVERSOImg'); 
            refeshImage('REVERSOImg'); 
            refeshImage('SELFIEImg'); 
        //    }, 500);
        
    },
    ['aui-dialog','aui-dialog-iframe']
    );
    
    function refeshImage(imageName){
        console.log('refrescar...');
        console.log(imageName);
        img = document.getElementById(imageName);
        var d=new Date();
        img.src = img.src + '&a=' +d.getTime();
    }

</aui:script>