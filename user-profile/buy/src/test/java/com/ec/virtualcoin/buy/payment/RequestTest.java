package com.ec.virtualcoin.buy.payment;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import com.ec.virtualcoin.buy.payment.client.AuthorizeCaptureRequest;
import com.ec.virtualcoin.buy.payment.client.AuthorizeCaptureTransactionRequest;
import com.ec.virtualcoin.buy.payment.client.EcorePayClient;
import com.ec.virtualcoin.buy.payment.client.PaymantInvocationException;
import com.ec.virtualcoin.buy.payment.client.RequestType;
import com.ec.virtualcoin.buy.payment.client.ShipTo;

public class RequestTest {

    @Test
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
                .Amount(2.75f)
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
                .CardExpYear((short) 2018)
                .CardCVV((byte) 123)
                .ShipTo(shipTo).build();

        AuthorizeCaptureRequest acr = new AuthorizeCaptureRequest(RequestType.AuthorizeCapture, 97709852, "TyawONMkSoidmMBV", transaction);
        
        cpc.authorizeCapture(acr);
        
    }
}
