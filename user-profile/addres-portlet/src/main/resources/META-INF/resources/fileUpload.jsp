<%@ include file="/init.jsp" %>

<portlet:defineObjects />

<portlet:actionURL name="upload" var="uploadFileURL"></portlet:actionURL>

<aui:form name="myForm" enctype="multipart/form-data">

    <aui:input type="file" name="fileupload" id="fileupload" accept="image/x-png,image/gif,image/jpeg" />
    
    <aui:button name="Save" value="upload.file" type="submit" />
    
    <aui:button name="closeDialog" type="button" value="close" />

    <aui:script use="aui-base">
           A.one('#<portlet:namespace/>closeDialog').on('click', function(event) {
    
                 Liferay.Util.getOpener().closePopup();

                 });
    </aui:script>
 
	<aui:script use="aui-base,aui-io-request">
	    A.one('#<portlet:namespace/>Save').on('click', function(event) {
	       event.preventDefault();
	       console.log('va a subir');
	        var A = AUI();
	        var url = '<%=uploadFileURL%>';
	        var myForm = A.one("#<portlet:namespace/>myForm");
	        var ajaxURL = "<portlet:resourceURL id='upload'></portlet:resourceURL>";
	        A.io.request(
	            url,
	            {
	                method: 'POST',
	                form: {id: myForm, upload: true},
	                on: {
	                    complete: function() {
	                       console.log('refrescar y cerrar');
                            Liferay.Util.getOpener().refeshImage();
	                        Liferay.Util.getOpener().closePopup();
	                    }
	                }
	            }
	       );
	    });
	</aui:script>
</aui:form>