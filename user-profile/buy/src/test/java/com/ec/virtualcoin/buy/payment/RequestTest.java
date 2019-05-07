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
            .PostCode("FL12345DS")
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
                .PostCode("FL12345")
                .Country("US")
                .CardNumber(4111111111111111l)
                .CardExpMonth((byte) 06)
                .CardExpYear((short) 2020)
                .CardCVV((short) 999)
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
          .PostCode("FL123458")
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
              .CardCVV((short) 999)
              .ShipTo(shipTo).build();

      AuthorizeCaptureRequest acr = new AuthorizeCaptureRequest(RequestType.AuthorizeCapture, 97709852, "TyawONMkSoidmMBV", transaction);
      
      Response authorizeCapture = cpc.authorizeCapture(acr);
      
      System.out.println(authorizeCapture.getAVSResult());
      System.out.println(authorizeCapture.getAuthCode());
      System.out.println(authorizeCapture.getResponseCode());
      Assert.assertEquals(100, authorizeCapture.getResponseCode());
  }


    @Test
    @Ignore
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
                .PostCode("FL12345")
                .Country("US")
                .CardNumber(4111111111111111l)
                .CardExpMonth((byte) 06)
                .CardExpYear((short) 2020)
                .CardCVV((short) 999)
                .build();

        AuthorizeCaptureRequest acr = new AuthorizeCaptureRequest(RequestType.AuthorizeCapture, 97709852, "TyawONMkSoidmMBV", transaction);
        
        Response authorizeCapture = cpc.authorizeCapture(acr);
        
        System.out.println(authorizeCapture.getAVSResult());
        System.out.println(authorizeCapture.getAuthCode());
        System.out.println(authorizeCapture.getResponseCode());
        Assert.assertEquals(100, authorizeCapture.getResponseCode());
    }

    @Test
  @Ignore
  public void shouldMakeSuccessPaymentOswaldo() throws JAXBException, IOException, PaymantInvocationException {
      EcorePayClient cpc = new EcorePayClient();

      AuthorizeCaptureTransactionRequest transaction = new AuthorizeCaptureTransactionRequest.Builder()
              .Reference("1234567890123456789012345678901234567890123456789012345678901234")
              .Amount(1234.0f)
              .Currency("USD")
              .Email("oswaldo.maldonado.orrego@gmail.com")
              .IPAddress("191.99.138.4")
              .Phone("0999811567")
              .FirstName("Oswaldo")
              .LastName("Maldonado")
              .Address("CIPRESES - HELECHOS")
              .City("QUITO")
              .State("PICHINCHA")
              .PostCode("170513")
              .Country("EC")
              .CardNumber(5555555555554444l)
              .CardExpMonth(Byte.valueOf("1"))
              .CardExpYear(Short.valueOf("2021"))
              .CardCVV(Short.valueOf("1234"))
              .build();

//      FormatUtil formatUtil = new FormatUtil();
//      transaction.setDOB(formatUtil.formatDate(new GregorianCalendar(1966, 7, 12).getTime()));
      
      AuthorizeCaptureRequest acr = new AuthorizeCaptureRequest(RequestType.AuthorizeCapture, 97709852, "TyawONMkSoidmMBV", transaction);
      
      Response authorizeCapture = cpc.authorizeCapture(acr);
      
      Assert.assertEquals(100, authorizeCapture.getResponseCode());
  }
    

}
