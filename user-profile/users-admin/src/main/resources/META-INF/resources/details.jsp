<%@ include file="/init.jsp"%>

<%@ page import="user.profile.model.UserProfile"%>

<%
	UserProfile userProfile = (UserProfile) renderRequest.getAttribute("userProfile");
    String email = (String) renderRequest.getAttribute("email");
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


<div class="container-fluid">
    <div class="row"><div class="column"><b><liferay-ui:message key="identification" /></b></div></div>
    <div class="row">
        <div class="col-md-12"><liferay-ui:message key="<%=userProfile.getIdType()%>" />: <%=userProfile.getIdNumber()%></div>
    </div>
    <div class="row"><div class="column">&nbsp;</div></div>
    <div class="row">
        <div class="col-md-4"><liferay-ui:message key="anverso" /></div>
        <div class="col-md-4"><liferay-ui:message key="reverso" /></div>
        <div class="col-md-4"><liferay-ui:message key="selfie" /></div>
    </div>
    <div class="row">
        <div class="col-md-4"><img name="anversoImg" id="ANVERSOImg"
                                        src="/o/profile/image?imageType=ANVERSO&isAdmin=true&imageLocation=<%=userProfile.getAnversoId()%>"
                                        width="250" height="150" /></div>
        <div class="col-md-4"><img name="reversoImg" id="ANVERSOImg"
                                        src="/o/profile/image?imageType=REVERSO&isAdmin=true&imageLocation=<%=userProfile.getReversoId()%>"
                                        width="250" height="150" /></div>
        <div class="col-md-4"><img name="selfieImg" id="ANVERSOImg"
                                        src="/o/profile/image?imageType=SELFIE&isAdmin=true&imageLocation=<%=userProfile.getSelfie()%>"
                                        width="250" height="150" /></div>
    </div>
    <div class="row"><div class="column">&nbsp;</div></div>
    <div class="row"><b><div class="column"><liferay-ui:message key="user.address" /></b></div></div>
    <div class="row">
        <div class="col-md-6">
	        <b><liferay-ui:message key="user.country"/>:</b>&nbsp;<%=userProfile.getCountryDescription()%><br />
	        <b><liferay-ui:message key="user.prov"/>:</b>&nbsp;<%=userProfile.getProv()%><br />
	        <b><liferay-ui:message key="user.city"/>:</b>&nbsp;<%=userProfile.getCity()%><br />
	        <b><liferay-ui:message key="user.street1"/>:</b>&nbsp;<%=userProfile.getStreet1()%><br />
	        <b><liferay-ui:message key="user.homeNumber"/>:</b>&nbsp;<%=userProfile.getHomeNumber()%><br />
	        <b><liferay-ui:message key="user.street2"/>:</b>&nbsp;<%=userProfile.getStreet2()%><br />
	        <b><liferay-ui:message key="user.postalCode"/>:</b>&nbsp;<%=userProfile.getPostalCode()%><br />
            <b><liferay-ui:message key="user.phoneNumber"/>:</b>&nbsp;<%=userProfile.getPhoneNumber()%><br />
            <b><liferay-ui:message key="user.email"/>:</b>&nbsp;<%=email%><br />
        </div>
        <div class="col-md-6"><img id="RESIDENCIAImg"
                               src="/o/profile/image?imageType=RESIDENCIA&isAdmin=true&imageLocation=<%=userProfile.getProofAddress()%>" width="250"
                               height="150" /></div>
    </div>
    <div class="row"><div class="column">&nbsp;</div></div>
    <div class="row" align="center">
        <div class="col-md-12">
	        <aui:button name="btnApprove" value="button.approve" onClick="change('${approveURL}')" />
	        <aui:button name="btnDeny" value="button.deny" onClick="change('${denyURL}')" />
	        <aui:button name="btnSave" value="button.back" onClick="change('${cancelURL}')" />
        </div>
    </div>
</div>

<script type="text/javascript">
  
  function change(url){
    document.location.href = url;
  }

</script>

</aui:form>