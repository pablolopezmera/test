<%@ include file="/init.jsp"%>

<%@ page import="user.profile.model.UserProfile"%>

<%
    UserProfile userProfile = (UserProfile) renderRequest.getAttribute("userProfile");
%>


<portlet:defineObjects />

<portlet:actionURL name="approve" var="approveURL" >
      <portlet:param name="screenname" value="${userProfile.userId}" />
</portlet:actionURL>
<portlet:actionURL name="deny" var="denyURL" >
      <portlet:param name="screenname" value="${userProfile.userId}" />
</portlet:actionURL>
<portlet:actionURL name="cancel" var="cancelURL" >
      <portlet:param name="screenname" value="${userProfile.userId}" />
</portlet:actionURL>

<aui:form method="post">

<div class="table-responsive"> 
<table class="table">
  <caption><b><liferay-ui:message key="identification" /></b></caption>
  <tbody>
    <tr><td class="control-label" colspan="3"><%=userProfile.getIdType()%> <%=userProfile.getIdNumber()%></td>
    <tr>
      <td class="control-label"><liferay-ui:message key="anverso" /><br /><img name="anversoImg" id="ANVERSOImg"
                        src="/o/profile/image?isAdmin=true&imageLocation=<%=userProfile.getAnversoId()%>"
                        width="250" height="150" /></td>
      <td class="control-label"><liferay-ui:message key="reverso" /><br /><img name="anversoImg" id="ANVERSOImg"
                        src="/o/profile/image?isAdmin=true&imageLocation=<%=userProfile.getReversoId()%>"
                        width="250" height="150" /></td>
      <td class="control-label"><liferay-ui:message key="selfie" /><br /><img name="anversoImg" id="ANVERSOImg"
                        src="/o/profile/image?isAdmin=true&imageLocation=<%=userProfile.getSelfie()%>"
                        width="250" height="150" /></td>
    </tr>
  </tbody>
</table>
</div>

<div class="table-responsive"> 
<table class="table">
  <caption><b><liferay-ui:message key="residence" /></b></caption>
  <tbody>
    <tr>
      <td><img name="anversoImg" id="ANVERSOImg"
                        src="/o/profile/image?isAdmin=true&imageLocation=<%=userProfile.getProofAddress()%>"
                        width="350" /></td>
      <td width="100%">
        <table class="table">
            <tr><td class="control-label"><liferay-ui:message key="user.country" /></td><td><%=userProfile.getCountry()%></td></tr>
            <tr><td class="control-label"><liferay-ui:message key="user.prov" /></td><td><%=userProfile.getProv()%></td></tr>
            <tr><td class="control-label"><liferay-ui:message key="user.city" /></td><td><%=userProfile.getCity()%></td></tr>
            <tr><td class="control-label"><liferay-ui:message key="user.street1" /></td><td><%=userProfile.getStreet1()%></td></tr>
            <tr><td class="control-label"><liferay-ui:message key="user.street2" /></td><td><%=userProfile.getStreet2()%></td></tr>
            <tr><td class="control-label"><liferay-ui:message key="user.homeNumber" /></td><td><%=userProfile.getHomeNumber()%></td></tr>
            <tr><td class="control-label"><liferay-ui:message key="user.postalCode" /></td><td><%=userProfile.getPostalCode()%></td></tr>
        </table>
      </td>
    </tr>
  </tbody>
</table>
</div>

<aui:button name="btnApprove" value="button.approve" onClick="<%=approveURL.toString()%>" />
<aui:button name="btnDeny" value="button.deny" onClick="<%=denyURL.toString()%>" />
<aui:button name="btnSave" value="button.back" onClick="<%=cancelURL.toString()%>" />

</aui:form>