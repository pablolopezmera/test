<%@ include file="/init.jsp" %>

<portlet:defineObjects />

<portlet:actionURL name="upload" var="uploadFileURL"></portlet:actionURL>
 
<aui:form action="<%= uploadFileURL %>" enctype="multipart/form-data" method="post">

    <aui:input type="file" name="fileupload" />
    
    <aui:button name="Save" value="Save" type="submit" />
    
    <aui:button name="closeDialog" type="button" value="close" />

    <aui:script use="aui-base">
           A.one('#<portlet:namespace/>closeDialog').on('click', function(event) {
    
                 Liferay.Util.getOpener().closePopup();

                 });
    </aui:script>
 
	<aui:script use="aui-base,aui-io-request">
	    A.one('#<portlet:namespace/>Save').on('click', function(event) {
	        var A = AUI();
	        var url = '<%=uploadFileURL.toString()%>';
	        A.io.request(
	            url,
	            {
	                method: 'POST',
	                form: {id: '<portlet:namespace/>uploadFile'},
	                on: {
	                    success: function() {
	                        Liferay.Util.getOpener().refreshPortlet();
	                        Liferay.Util.getOpener().closePopup();
	                    }
	                }
	            }
	       );
	    });
	</aui:script>
</aui:form>