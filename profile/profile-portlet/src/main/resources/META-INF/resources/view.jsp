<%@ include file="/init.jsp"%>

<%
    String anversoFile = (String) renderRequest.getAttribute("anversoUrl");
    String reversoFile = (String) renderRequest.getAttribute("reversoUrl");
    String selfieFile = (String) renderRequest.getAttribute("selfieUrl");
    String residenciaFile = (String) renderRequest.getAttribute("residenciaUrl");
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
<portlet:renderURL var="uploadResidencia" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
    <portlet:param name="mvcPath" value="/fileUpload.jsp" />
    <portlet:param name="img" value="RESIDENCIA" />
</portlet:renderURL>

<portlet:defineObjects />

<portlet:actionURL name="saveProfile" var="saveProfile" />

<aui:form action="<%=saveProfile%>" enctype="multipart/form-data"
	method="post">

	<table>
		<tr>
			<td><img name="anversoImg" id="ANVERSOImg"
				src="/o/profile/image?imageType=ANVERSO&file=${anversoFile}"
				width="250" height="150" /><br />
					<aui:button name="btnAnverso" type="button" value="Anverso" />
					</td>
					<td>&nbsp;</td>
			<td><img id="REVERSOImg"
				src="/o/profile/image?imageType=REVERSO&file=${reversoFile}"
				width="250" height="150" /><br />
				    <aui:button name="btnReverso" type="button" value="Reverso" />
				    </td>
		</tr>
		<tr>
			<td><img id="SELFIEImg"
				src="/o/profile/image?imageType=SELFIE&file=${selfieFile}"
				width="250" height="150" /><br />
				<aui:button name="btnSelfie" type="button" value="Selfie" /></td>
				<td>&nbsp;</td>
			<td><img id="RESIDENCIAImg"
				src="/o/profile/image?imageType=RESIDENCIA&file=${residenciaFile}"
				width="250" height="150" /><br />
				<aui:button name="btnResidencia" type="button" value="Residencia" />
				</td>
		</tr>
				
	</table>
	
</aui:form>
<aui:script use="aui-base,liferay-util-window,aui-io-request">

    var actualDialog = 'ANVERSO';
    
    A.one('#<portlet:namespace/>btnAnverso').on('click', function(event) {
        actualDialog = 'ANVERSO';
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

    A.one('#<portlet:namespace/>btnResidencia').on('click', function(event) {
        actualDialog = 'RESIDENCIA';
        openDialog(actualDialog, '<liferay-ui:message key="RESIDENCIA" />', '<%=uploadResidencia %>');
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
            refeshImage(actualDialog + 'Img'); 
            refeshImage('ANVERSOImg'); 
            refeshImage('REVERSOImg'); 
            refeshImage('SELFIEImg'); 
            refeshImage('RESIDENCIAImg'); 
            }, 500);
        
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