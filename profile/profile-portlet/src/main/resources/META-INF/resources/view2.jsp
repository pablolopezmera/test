<%@ include file="/init.jsp"%>

<%
    String anversoFile = (String) renderRequest.getAttribute("anversoUrl");
    String reversoFile = (String) renderRequest.getAttribute("reversoUrl");
    String selfieFile = (String) renderRequest.getAttribute("selfieUrl");
    String residenciaFile = (String) renderRequest.getAttribute("residenciaUrl");
%>

<aui:script use="liferay-util-window">


Liferay.provide(
     window,
     'closePopup',
     function(dialogId) {
        console.log('debe cerrar');
        console.log(dialogId);
             var dialog = Liferay.Util.getWindow(dialogId);
             console.log(dialog);

          Liferay.fire('closeWindow', {
                    id:'<portlet:namespace/>dialog'
                           });
                 },['aui-base','liferay-util-window'] );

</aui:script>

<portlet:defineObjects />

<portlet:actionURL name="saveProfile" var="saveProfile" />

<aui:form action="<%=saveProfile%>" enctype="multipart/form-data"
	method="post">

    <portlet:renderURL var="uploadAnverso" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
        <portlet:param name="mvcPath" value="/fileUpload.jsp" />
        <portlet:param name="img" value="ANVERSO" />
    </portlet:renderURL>

    <portlet:renderURL var="uploadReverso" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
        <portlet:param name="mvcPath" value="/fileUpload.jsp" />
        <portlet:param name="img" value="REVERSO" />
    </portlet:renderURL>

    <portlet:renderURL var="uploadSelfie" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
        <portlet:param name="mvcPath" value="/fileUpload.jsp" />
        <portlet:param name="img" value="SELFIE" />
    </portlet:renderURL>

    <portlet:renderURL var="uploadResidencia" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
        <portlet:param name="mvcPath" value="/fileUpload.jsp" />
        <portlet:param name="img" value="RESIDENCIA" />
    </portlet:renderURL>

	<table>
		<tr>
			<td><img
				src="/o/profile/image?imageType=ANVERSO&file=${anversoFile}"
				width="100" height="111" /><br /><aui:button href="${uploadAnverso}"
					useDialog="true" value="Anverso" /></td>
			<td><img
				src="/o/profile/image?imageType=REVERSO&file=${reversoFile}"
				width="100" height="111" /><br /><aui:button href="${uploadReverso}"
					useDialog="true" value="Reverso" /></td>
		</tr>
		<tr>
			<td><img
				src="/o/profile/image?imageType=SELFIE&file=${selfieFile}"
				width="100" height="111" /><br /><aui:button href="${uploadSelfie}"
					useDialog="true" value="Selfie" /></td>
			<td><img
				src="/o/profile/image?imageType=RESIDENCIA&file=${residenciaFile}"
				width="100" height="111" /><br /><aui:button href="${uploadResidencia}"
					useDialog="true" value="Prueba residencia" /></td>
		</tr>
				
	</table>
	
</aui:form>