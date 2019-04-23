package com.ec.virtualcoin.buy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ec.virtualcoin.buy.payment.FormatUtil;
import com.ec.virtualcoin.buy.payment.client.AuthorizeCaptureRequest;
import com.ec.virtualcoin.buy.payment.client.AuthorizeCaptureTransactionRequest;
import com.ec.virtualcoin.buy.payment.client.EcorePayClient;
import com.ec.virtualcoin.buy.payment.client.RequestType;
import com.ec.virtualcoin.buy.payment.jaxb.Response;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import user.profile.model.Purchase;
import user.profile.model.UserProfile;
import user.profile.service.PurchaseLocalServiceUtil;
import user.profile.service.UserProfileLocalServiceUtil;
import user.profile.service.persistence.PurchasePK;

@Component(immediate = true, property = { 
        "com.liferay.portlet.add-default-resource=true",
        "com.liferay.portlet.css-class-wrapper=portlet-controlpanel",
        "com.liferay.portlet.display-category=category.hidden",
        "com.liferay.portlet.preferences-owned-by-group=true",
        "com.liferay.portlet.render-weight=100",
        "javax.portlet.expiration-cache=0",
        "javax.portlet.init-param.view-template=/start_purchase.jsp",
        "javax.portlet.name=buy",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.init-param.add-process-action-success-action=false"
}, service = Portlet.class)
public class BuyPortlet extends MVCPortlet {

    private static Logger _logger = LoggerFactory.getLogger(BuyPortlet.class.getName());

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        
        User user = (User) renderRequest.getAttribute(WebKeys.USER);

        try {

            UserProfile userProfile = UserProfileLocalServiceUtil.getUserProfile(user.getScreenName());
            _logger.info("aprobado: " + userProfile.getApproved());
            HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
            HttpServletRequest osr = PortalUtil.getOriginalServletRequest(request);
            String value = osr.getParameter("value");
            _logger.info("quiere comprar: " + value);
            String pid = osr.getParameter("pid");
            _logger.info("pid: " + pid);

            renderRequest.setAttribute("usdValue", value);

            if (!isCountryAllowed(userProfile.getCountry())) {
                _logger.info("el pais: " + userProfile.getCountry());
                renderRequest.setAttribute("country", userProfile.getCountryDescription());
                renderRequest.setAttribute("status", "COUNTRY_NOT_ALLOWED");
            } else if (!userProfile.getApproved()) {
                renderRequest.setAttribute("status", "PROFILE_NOT_APPROVED");
            } else {
                renderRequest.setAttribute("status", "START_PURCHASE");
            }

        } catch (PortalException e) {
            _logger.error(e.getMessage());
        }

        super.doView(renderRequest, renderResponse);
    }

    private void loadPurchaseOrderData(String pid, RenderRequest renderRequest) {
        User user = (User) renderRequest.getAttribute(WebKeys.USER);
        PurchasePK purchasePK = new PurchasePK();
        purchasePK.setScreenname(user.getScreenName());
        purchasePK.setHash(pid);
        Purchase purchase = PurchaseLocalServiceUtil.fetchPurchase(purchasePK);
        renderRequest.setAttribute("usdValue", purchase.getValue_from());
        renderRequest.setAttribute("btcValue", purchase.getValue_to());
        renderRequest.setAttribute("ewallet", purchase.getEwallet());
        renderRequest.setAttribute("pid", pid);
    }

    private boolean isValidPid(String pid) {
        return true;
    }

    public void sendOrder(ActionRequest actionRequest, ActionResponse response) throws Exception {
        _logger.info("Buy request:");
        _logger.info(actionRequest.getParameter("usdValue"));
        _logger.info(actionRequest.getParameter("btcValue"));
        _logger.info(actionRequest.getParameter("ewallet"));
        Purchase purchase = registerPurchaseOrder(actionRequest);
        actionRequest.setAttribute("usdValue", purchase.getValue_from());
        actionRequest.setAttribute("btcValue", purchase.getValue_to());
        actionRequest.setAttribute("ewallet", purchase.getEwallet());
        actionRequest.setAttribute("pid", purchase.getPrimaryKey().hash);
//        sendMailConfirmationRequest(actionRequest, purchase);
        response.setRenderParameter("jspPage","/confirmation.jsp"); 
    }

    public void confirmOrder(ActionRequest actionRequest, ActionResponse response) throws Exception {
        _logger.info("Confirm order:");
        _logger.info(actionRequest.getParameter("pid"));
        Purchase purchase = loadPurchase(actionRequest);
        if (purchase.getStatus().equals(Status.ORDERED.name()) || purchase.getStatus().equals(Status.CONFIRMED.name())) {
            purchase.setStatus(Status.CONFIRMED.name());
            PurchaseLocalServiceUtil.updatePurchase(purchase);
            _logger.info("orden confirmada");
            actionRequest.setAttribute("pid", actionRequest.getParameter("pid"));
            response.setRenderParameter("jspPage","/payment.jsp"); 
        }
    }

    private Purchase loadPurchase(ActionRequest actionRequest) {
        User user = (User) actionRequest.getAttribute(WebKeys.USER);
        String processId = actionRequest.getParameter("pid");
        PurchasePK purchasePK = new PurchasePK();
        purchasePK.setScreenname(user.getScreenName());
        purchasePK.setHash(processId);
        Purchase purchase = PurchaseLocalServiceUtil.fetchPurchase(purchasePK );
        return purchase;
    }

    public void makePayment(ActionRequest actionRequest, ActionResponse response) throws Exception {
        _logger.info("Va a realizar el pago:");
        _logger.info(actionRequest.getParameter("pid"));
        _logger.info(actionRequest.getParameter("yearExpiration"));
        String yearExpiration = actionRequest.getParameter("yearExpiration");
        String monthExpiration = actionRequest.getParameter("monthExpiration");
        String cvv = actionRequest.getParameter("cvv");
        String cardNumber = actionRequest.getParameter("cardNumber");
        cardNumber = cardNumber.replaceAll(" ", "");
        Purchase purchase = loadPurchase(actionRequest);
        User user = (User) actionRequest.getAttribute(WebKeys.USER);
        UserProfile uProfile = UserProfileLocalServiceUtil.fetchUserProfile(user.getScreenName());
        EcorePayClient cpc = new EcorePayClient();

        _logger.info(user.getFirstName());
        _logger.info(user.getLastName());
        _logger.info(uProfile.getPostalCode());
        _logger.info("valor: " + purchase.getValue_from());
        AuthorizeCaptureTransactionRequest transaction = new AuthorizeCaptureTransactionRequest.Builder()
                .Reference(purchase.getScreenname().concat(purchase.getPrimaryKey().getHash()))
                .Amount(Float.valueOf(purchase.getValue_from()))
                .Currency(purchase.getCurr_from())
                .Email(user.getEmailAddress())
                .IPAddress(getRemoteAddress(actionRequest))
                .Phone(uProfile.getPhoneNumber())
                .FirstName(user.getFirstName())
                .LastName(user.getLastName())
                .Address(uProfile.getStreet1().concat(" - ").concat(uProfile.getStreet2()))
                .City(uProfile.getCity())
                .State(uProfile.getProv())
                .PostCode(uProfile.getPostalCode())
                .Country(uProfile.getCountry())
                .CardNumber(Long.valueOf(cardNumber))
                .CardExpMonth(Byte.valueOf(monthExpiration))
                .CardExpYear(Short.valueOf(yearExpiration))
                .CardCVV(Byte.valueOf(cvv))
                .build();
        
        if (user.getBirthday() != null) {
            FormatUtil formatUtil = new FormatUtil();
            transaction.setDOB(formatUtil.formatDate(user.getBirthday()));
        }

        // TODO: Poner los datos de accountId y accountAuth
        AuthorizeCaptureRequest acr = new AuthorizeCaptureRequest(RequestType.AuthorizeCapture, 97709852, "TyawONMkSoidmMBV", transaction);
        
        Response authorizeResponse = cpc.authorizeCapture(acr);
        
        _logger.info(String.valueOf(authorizeResponse.getResponseCode()));
        if (authorizeResponse.getResponseCode() == 100) {
            markOrderAsPaid(actionRequest);
            actionRequest.setAttribute("success", true);
            _logger.info("pago exitoso, manda true");
        } else {
            SessionErrors.add(actionRequest, "error-key");
            actionRequest.setAttribute("success", false);
            actionRequest.setAttribute("errorMessage", authorizeResponse.getDescription());
            _logger.info("pago errado, manda false");
        }

        response.setRenderParameter("jspPage","/payment_result.jsp"); 
    }

    private void markOrderAsPaid(ActionRequest actionRequest) {
        _logger.info("Mark order as paid:");
        _logger.info(actionRequest.getParameter("pid"));
        Purchase purchase = loadPurchase(actionRequest);
        purchase.setStatus(Status.PAID.name());
        PurchaseLocalServiceUtil.updatePurchase(purchase);
    }

    private String getRemoteAddress(ActionRequest actionRequest) {
        return PortalUtil.getHttpServletRequest(actionRequest).getRemoteAddr();
    }

    private Purchase registerPurchaseOrder(ActionRequest actionRequest) {
        User user = (User) actionRequest.getAttribute(WebKeys.USER);

        PurchasePK pk = new PurchasePK();
        Purchase purchase = PurchaseLocalServiceUtil.createPurchase(pk);

        Calendar dateTime = Calendar.getInstance();
        String usd = actionRequest.getParameter("usdValue");
        String btc = actionRequest.getParameter("btcValue");
        String ewallet = actionRequest.getParameter("ewallet");
        purchase.setDate_time(dateTime.getTime());
        purchase.setCurr_from(MoneyCurrency.USD.name());
        purchase.setValue_from(usd);
        purchase.setCurr_to(CryptoCurrency.BTC.name());
        purchase.setValue_to(btc);
        purchase.setEwallet(ewallet);
        purchase.setStatus(Status.ORDERED.name());
        purchase.setScreenname(user.getScreenName());
        purchase.setHash(buildHash(purchase));

        purchase.getPrimaryKey().setScreenname(user.getScreenName());
        purchase.getPrimaryKey().setHash(buildHash(purchase));
        PurchaseLocalServiceUtil.addPurchase(purchase);
        return purchase;
    }

    private String buildHash(Purchase purchase) {
        // TODO Auto-generated method stub
        StringBuilder toHash = new StringBuilder(200);
        toHash.append(purchase.getScreenname());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        toHash.append(sdf.format(purchase.getDate_time()));

        toHash.append(purchase.getEwallet());

        _logger.info(toHash.toString());
        _logger.info(Hash.sha1(toHash.toString()));

        return Hash.sha1(toHash.toString());
    }

    private boolean isCountryAllowed(String country) {
        return "EC".equals(country);
    }

    private void sendMailConfirmationRequest(ActionRequest actionRequest, Purchase purchase) {
        User user = (User) actionRequest.getAttribute(WebKeys.USER);
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Group siteGroup = themeDisplay.getSiteGroup();
        String mailFrom = (String) siteGroup.getExpandoBridge().getAttribute("notification.address.from");
        String subject = (String) siteGroup.getExpandoBridge().getAttribute("notification.confirmation.request");

        String name = user.getFirstName().concat(" ").concat(user.getLastName());
        String link = buildLink(actionRequest, purchase);
        String body = StringUtil.replace(getBodyTemplate().toString(),
                new String[] { "[$NAME$]", "[$USD$]", "[$BTC$]", "[$EWALLET$]", "[$LINK$]" },
                new String[] { name, purchase.getValue_from(), purchase.getValue_to(), purchase.getEwallet(), link });

        try {
            InternetAddress fromAddress = new InternetAddress(mailFrom);
            InternetAddress  toAddress = new InternetAddress(user.getEmailAddress());
            MailMessage mailMessage = new MailMessage();
            mailMessage.setTo(toAddress);
            mailMessage.setFrom(fromAddress);
            mailMessage.setSubject(subject);
            mailMessage.setBody(body);
            mailMessage.setHTMLFormat(true);
            MailServiceUtil.sendEmail(mailMessage);
            _logger.debug("Sent mail by Using Template");
        } catch (AddressException e) {
            e.printStackTrace();
        }

    }

    private String buildLink(ActionRequest actionRequest, Purchase purchase) {
        StringBuilder url = new StringBuilder(200);
        String completeURL = PortalUtil.getCurrentCompleteURL(
                PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest)));
        url.append(completeURL.substring(0, completeURL.indexOf("?") + 1));
        url.append("p_p_id=buy&");
        url.append("pid=");
        url.append(purchase.getHash());
        _logger.info(url.toString());
        return url.toString();
    }

    private StringBuilder getBodyTemplate() {
        InputStream resourceAsStream = this.getClass().getClassLoader()
                .getResourceAsStream("/content/confirmation-request.tmpl");
        StringBuilder textBuilder = new StringBuilder();
        try (Reader reader = new BufferedReader(
                new InputStreamReader(resourceAsStream, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c = 0;
            while ((c = reader.read()) != -1) {
                textBuilder.append((char) c);
            }
            _logger.debug("el body");
            _logger.debug(textBuilder.toString());
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return textBuilder;
    }

}
