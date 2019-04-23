package com.ec.virtualcoin.buy.payment;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.ec.virtualcoin.buy.payment.client.AuthorizeCaptureRequest;
import com.ec.virtualcoin.buy.payment.client.AuthorizeCaptureTransactionRequest;
import com.ec.virtualcoin.buy.payment.client.EcorePayClient;
import com.ec.virtualcoin.buy.payment.client.PaymantInvocationException;
import com.ec.virtualcoin.buy.payment.client.RequestType;
import com.ec.virtualcoin.buy.payment.client.ShipTo;
import com.ec.virtualcoin.buy.payment.jaxb.Response;

public class RequestTest {

    @Test
    @Ignore
    public void shouldMakeSuccessPayment() throws JAXBException, IOException, PaymantInvocationException {
        EcorePayClient cpc = new EcorePayClient();
        ShipTo shipTo = new ShipTo.Builder()
            .FirstName("Jane")
            .LastName("Doe")
            .Address("345 Boring Road")
            .City("Dullsville")
            .State("CA")
            .PostCode((short) 12345)
            .Country("US").build();

        AuthorizeCaptureTransactionRequest transaction = new AuthorizeCaptureTransactionRequest.Builder()
                .Reference("X53222389-20")
                .Amount(2.40f)
                .Currency("USD")
                .Email("john_doe@example.com")
                .IPAddress("192.168.1.1")
                .Phone("+1 206 555 1212")
                .FirstName("John")
                .LastName("Doe")
                .DOB(19810530)
                .SSN((short) 3231)
                .Address("123 Boring Road")
                .City("Dullsville")
                .State("CA")
                .PostCode((short) 12345)
                .Country("US")
                .CardNumber(4111111111111111l)
                .CardExpMonth((byte) 06)
                .CardExpYear((short) 2020)
                .CardCVV((byte) 123)
                .ShipTo(shipTo).build();

        AuthorizeCaptureRequest acr = new AuthorizeCaptureRequest(RequestType.AuthorizeCapture, 97709852, "TyawONMkSoidmMBV", transaction);
        
        Response authorizeCapture = cpc.authorizeCapture(acr);
        
        Assert.assertEquals(100, authorizeCapture.getResponseCode());
        
    }

    @Test
    @Ignore
    public void shouldMakeSuccessPaymentStringPostCode() throws JAXBException, IOException, PaymantInvocationException {
      EcorePayClient cpc = new EcorePayClient();
      ShipTo shipTo = new ShipTo.Builder()
          .FirstName("Jane")
          .LastName("Doe")
          .Address("345 Boring Road")
          .City("Dullsville")
          .State("CA")
          .PostCode((short) 12345)
          .Country("US").build();

      AuthorizeCaptureTransactionRequest transaction = new AuthorizeCaptureTransactionRequest.Builder()
              .Reference("X53222389-20")
              .Amount(2.40f)
              .Currency("USD")
              .Email("john_doe@example.com")
              .IPAddress("192.168.1.1")
              .Phone("+1 206 555 1212")
              .FirstName("John")
              .LastName("Doe")
              .DOB(19810530)
              .SSN((short) 3231)
              .Address("123 Boring Road")
              .City("Dullsville")
              .State("CA")
              .PostCode("12345")
              .Country("US")
              .CardNumber(4111111111111111l)
              .CardExpMonth((byte) 06)
              .CardExpYear((short) 2020)
              .CardCVV((byte) 123)
              .ShipTo(shipTo).build();

      AuthorizeCaptureRequest acr = new AuthorizeCaptureRequest(RequestType.AuthorizeCapture, 97709852, "TyawONMkSoidmMBV", transaction);
      
      Response authorizeCapture = cpc.authorizeCapture(acr);
      
      System.out.println(authorizeCapture.getAVSResult());
      System.out.println(authorizeCapture.getAuthCode());
      System.out.println(authorizeCapture.getResponseCode());
      Assert.assertEquals(100, authorizeCapture.getResponseCode());
  }


    @Test
//    @Ignore
    public void shouldMakeSuccessPaymentNoShip() throws JAXBException, IOException, PaymantInvocationException {
        EcorePayClient cpc = new EcorePayClient();

        AuthorizeCaptureTransactionRequest transaction = new AuthorizeCaptureTransactionRequest.Builder()
                .Reference("pablof2a1a088783cee007cf3081b3e58e143051e7698")
                // For a successful transaction the amount must be even (eg. 2.40)
                // For a failed transaction the amount must be odd (eg 2.75)
                .Amount(2.40f)
                .Currency("USD")
                .Email("john_doe@example.com")
                .IPAddress("192.168.1.1")
                .Phone("+1 206 555 1212")
                .FirstName("John")
                .LastName("Doe")
//                .DOB(19810530)
//                .SSN((short) 3231)
                .Address("123 Boring Road")
                .City("Dullsville")
                .State("CA")
                .PostCode((short) 12345)
                .Country("US")
                .CardNumber(4111111111111111l)
                .CardExpMonth((byte) 06)
                .CardExpYear((short) 2020)
                .CardCVV((byte) 123)
                .build();

//        AuthorizeCaptureTransactionRequest transaction = new AuthorizeCaptureTransactionRequest.Builder()
//                .Reference(purchase.getScreenname().concat(purchase.getPrimaryKey().getHash()))
//                .Amount(Float.valueOf(purchase.getValue_from()))
//                .Currency(purchase.getCurr_from())
//                .Email(user.getEmailAddress())
//                .IPAddress(getRemoteAddress(actionRequest))
//                .Phone(uProfile.getPhoneNumber())
//                .FirstName(user.getFirstName())
//                .LastName(user.getLastName())
//                .Address(uProfile.getStreet1().concat(" - ").concat(uProfile.getStreet2()))
//                .City(uProfile.getCity())
//                .State(uProfile.getProv())
//                .PostCode(uProfile.getPostalCode())
//                .Country(uProfile.getCountry())
//                .CardNumber(Long.valueOf(cardNumber))
//                .CardExpMonth(Byte.valueOf(monthExpiration))
//                .CardExpYear(Short.valueOf(yearExpiration))
//                .CardCVV(Byte.valueOf(cvv))
//                .build();
//
        
        AuthorizeCaptureRequest acr = new AuthorizeCaptureRequest(RequestType.AuthorizeCapture, 97709852, "TyawONMkSoidmMBV", transaction);
        
        Response authorizeCapture = cpc.authorizeCapture(acr);
        
        System.out.println(authorizeCapture.getAVSResult());
        System.out.println(authorizeCapture.getAuthCode());
        System.out.println(authorizeCapture.getResponseCode());
        Assert.assertEquals(100, authorizeCapture.getResponseCode());
    }

}
