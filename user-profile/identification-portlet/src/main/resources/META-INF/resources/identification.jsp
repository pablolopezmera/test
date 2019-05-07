<%@ include file="/init.jsp"%>

<%
    String idType = (String) renderRequest.getAttribute("idType");
    String idNumber = (String) renderRequest.getAttribute("idNumber");
    String dateTimeSecond = (String) renderRequest.getAttribute("dateTimeSecond");
    
%>

<portlet:defineObjects />

<liferay-ui:error key="message.anverso.not.uploaded" message="message.anverso.not.uploaded" />
<liferay-ui:error key="message.reverso.not.uploaded" message="message.reverso.not.uploaded" />
<liferay-ui:error key="message.selfie.not.uploaded" message="message.selfie.not.uploaded" />

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

<portlet:actionURL name="delete" var="deleteAnverso">
    <portlet:param name="imgType" value="ANVERSO" />
</portlet:actionURL>
<portlet:actionURL name="delete" var="deleteReverso">
    <portlet:param name="imgType" value="REVERSO" />
</portlet:actionURL>
<portlet:actionURL name="delete" var="deleteSelfie">
    <portlet:param name="imgType" value="SELFIE" />
</portlet:actionURL>

<portlet:actionURL name="setChangingImage" var="setAnverso">
    <portlet:param name="imgType" value="ANVERSO" />
</portlet:actionURL>
<portlet:actionURL name="setChangingImage" var="setReverso">
    <portlet:param name="imgType" value="REVERSO" />
</portlet:actionURL>
<portlet:actionURL name="setChangingImage" var="setSelfie">
    <portlet:param name="imgType" value="SELFIE" />
</portlet:actionURL>

<portlet:actionURL name="saveProfile" var="saveProfile" />

<aui:form action="<%= saveProfile %>" method="post" name="identificationForm">
<div class="container">
    <div class="row" class="col-md-12">&nbsp;</div>
    <div class="row" class="col-md-12" align="center"><liferay-ui:message key="mensaje.carga.identificacion"/></div>
    <div class="row">
        <div id="no-more-tables">
            <table class="col-md-12 table-bordered table-striped table-condensed cf">
                <tbody>
                    <tr>
                      <td align="center">
			             <aui:select name="idType" label="id.type" required="true">
			               <aui:option label="select..." value="" />
			               <aui:option label="id.type.passport" value="Passport" selected="<%=idType.equals("Passport") %>" />
			               <aui:option label="id.type.id" value="Id" selected="<%=idType.equals("Id") %>" />
			               <aui:option label="id.type.driverlicense" value="License" selected="<%=idType.equals("License") %>" />
			             </aui:select>
			             <aui:input label="id.number" name="idNumber" value="${idNumber}" type="String" required="true" />
                      </td>
                      <td align="center">
			              <table>
			                  <tr><td colspan="2" align="center"><liferay-ui:message key="selfie"/></td></tr>
			                  <tr><td colspan="2"><img id="SELFIEImg"
			                src="/o/profile/image?imageType=SELFIE&a=<%=dateTimeSecond%>"
			                width="250" height="150" /></td></tr>
			                  <tr><td>&nbsp;</td></tr>
			                  <tr><td align="center"><aui:button name="btnSelfie" type="button" value="cambiar" /></td>
			                    <td align="center"><aui:button name="delSelfie" type="button" value="borrar" /></td></tr>
			              </table>
                      </td>
                    </tr>
                    <tr>
                      <td align="center">
			              <table>
			                  <tr><td colspan="2" align="center"><liferay-ui:message key="anverso"/></td></tr>
			                  <tr><td colspan="2"><img name="anversoImg" id="ANVERSOImg"
			                src="/o/profile/image?imageType=ANVERSO&a=<%=dateTimeSecond%>"
			                width="250" height="150" /></td></tr>
			                  <tr><td>&nbsp;</td></tr>
			                  <tr><td align="center"><aui:button name="btnAnverso" type="button" value="cambiar" /></td>
			                      <td align="center"><aui:button name="delAnverso" type="button" value="borrar" /></td></tr>
			              </table>
                      </td>
                      <td align="center">
			              <table>
			                  <tr><td colspan="2" align="center"><liferay-ui:message key="reverso"/></td></tr>
			                  <tr><td colspan="2"><img id="REVERSOImg"
			                src="/o/profile/image?imageType=REVERSO&a=<%=dateTimeSecond%>"
			                width="250" height="150" /></td></tr>
			                  <tr><td>&nbsp;</td></tr>
			                  <tr><td align="center"><aui:button name="btnReverso" type="button" value="cambiar" /></td>
			                    <td align="center"><aui:button name="delReverso" type="button" value="borrar" /></td></tr>
			              </table>
                      </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
<br /><br />
    <div class="row" class="col-md-12" align="center"><aui:button type="submit" /></div>
</div>
	
	
</aui:form>
<aui:script use="aui-base,liferay-util-window,aui-io-request">

    var actualDialog = 'ANVERSO';
    
    A.one('#<portlet:namespace/>btnAnverso').on('click', function(event) {
        actualDialog = 'ANVERSO';
        openDialog(actualDialog, '<liferay-ui:message key="ANVERSO" />', '<%=uploadAnverso %>', '<%=setAnverso %>');
    });

    A.one('#<portlet:namespace/>btnReverso').on('click', function(event) {
        actualDialog = 'REVERSO';
        openDialog(actualDialog, '<liferay-ui:message key="REVERSO" />', '<%=uploadReverso %>', '<%=setReverso %>');
    });

    A.one('#<portlet:namespace/>btnSelfie').on('click', function(event) {
        actualDialog = 'SELFIE';
        openDialog(actualDialog, '<liferay-ui:message key="SELFIE" />', '<%=uploadSelfie %>', '<%=setSelfie %>');
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
                form: {id: '<portlet:namespace/>identificationForm'},
                on: { success: function() { refeshImage(imageName);}
                }
            }
       );
    }

    function setImageTypeInSession(url){
        var A = AUI();
        var url = url;
        A.io.request(
            url,
            {
                method: 'POST',
                form: {id: '<portlet:namespace/>identificationForm'},
                on: { success: function() { console.log('aplicado...');}
                }
            }
       );
    }

    function openDialog(actualDialog, title, uri, uriSet){
        setImageTypeInSession(uriSet);
          Liferay.Util.openWindow({
               dialog: {centered: true, height: 300, modal: true, width: 400},
             id: '<portlet:namespace/>' +  actualDialog,
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
    },
    ['aui-dialog','aui-dialog-iframe']
    );
    
    Liferay.provide(window, 'refeshImage', function(imageName) {
        if (!imageName) imageName = actualDialog + 'Img';
        console.log('refrescar...');
        console.log(imageName);
        img = document.getElementById(imageName);
        var d=new Date();
        img.src = img.src + '&a=' +d.getTime();
    });

</aui:script>