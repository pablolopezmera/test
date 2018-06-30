<%@ include file="/init.jsp"%>

<%@ page import="user.profile.model.UserProfile"%>

<%
    UserProfile userProfile = (UserProfile) renderRequest.getAttribute("userProfile");
%>


<portlet:defineObjects />

<portlet:actionURL name="approve" var="approveURL" >
      <portlet:param name="screenname" value="<%=userProfile.getUserId()%>" />
</portlet:actionURL>
<portlet:actionURL name="deny" var="denyURL" >
      <portlet:param name="screenname" value="<%=userProfile.getUserId()%>" />
</portlet:actionURL>
<portlet:actionURL name="cancel" var="cancelURL" >
      <portlet:param name="screenname" value="<%=userProfile.getUserId()%>" />
</portlet:actionURL>

<aui:form method="post">

<div class="container">
    <div class="row">
        <div id="no-more-tables">
            <table class="col-md-12 table-bordered table-striped table-condensed cf">
                <tbody>
				    <tr><td class="control-label" colspan="3"><%=userProfile.getIdType()%> <%=userProfile.getIdNumber()%></td>
                    <tr>
                      <td class="control-label"><liferay-ui:message key="anverso" /></td>
                      <td class="control-label"><liferay-ui:message key="reverso" /></td>
                      <td class="control-label"><liferay-ui:message key="selfie" /></td>
                    </tr>
                    <tr>
                      <td><img name="anversoImg" id="ANVERSOImg"
                                        src="/o/profile/image?isAdmin=true&imageLocation=<%=userProfile.getAnversoId()%>"
                                        width="250" height="150" /></td>
                      <td><img name="anversoImg" id="ANVERSOImg"
                                        src="/o/profile/image?isAdmin=true&imageLocation=<%=userProfile.getReversoId()%>"
                                        width="250" height="150" /></td>
                      <td><img name="anversoImg" id="ANVERSOImg"
                                        src="/o/profile/image?isAdmin=true&imageLocation=<%=userProfile.getSelfie()%>"
                                        width="250" height="150" /></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<aui:button name="btnApprove" value="button.approve" onClick="change('${approveURL}')" />
<aui:button name="btnDeny" value="button.deny" onClick="change('${denyURL}')" />
<aui:button name="btnSave" value="button.back" onClick="change('${cancelURL}')" />

<script type="text/javascript">
  
  function change(url){
    document.location.href = url;
  }

</script>

</aui:form>