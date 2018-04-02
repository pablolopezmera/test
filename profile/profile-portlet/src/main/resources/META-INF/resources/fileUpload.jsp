<%@ include file="/init.jsp" %>

<portlet:defineObjects />

<%
    Object uploaded = request.getAttribute("fileUploaded");
    boolean fileUploaded = false;
    if (uploaded != null){
        fileUploaded = (Boolean) uploaded; 
    }
%>
 
<portlet:actionURL name="uploadFile" var="uploadFile"></portlet:actionURL>
 
<aui:form action="<%= uploadFile %>" enctype="multipart/form-data" method="post" name="uploadFile">

    ${fileUploaded }
 
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
	        var url = '<%=uploadFile.toString()%>';
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