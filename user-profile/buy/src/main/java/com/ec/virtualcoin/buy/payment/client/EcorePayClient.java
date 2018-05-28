package com.ec.virtualcoin.buy.payment.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ec.virtualcoin.buy.payment.jaxb.Request;
import com.ec.virtualcoin.buy.payment.jaxb.Request.Transaction;
import com.ec.virtualcoin.buy.payment.jaxb.Response;

public class EcorePayClient {
    
    private static Logger _logger = LoggerFactory.getLogger(EcorePayClient.class.getName());
    private static final String USER_AGENT = "Mozilla/5.0";

    public Response authorizeCapture(AuthorizeCaptureRequest acr) throws JAXBException, IOException, PaymantInvocationException {
        Request request = createRequest(acr);
        ByteArrayOutputStream soapMessage = generateSoapMessage(request);
//        _logger.info(soapMessage.toString());
        System.out.println(soapMessage.toString());
        InputStream response = sendMessage(soapMessage);
        return parseResponse(response);
    }

    private Response parseResponse(InputStream response) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Response.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Response responseObject = (Response) unmarshaller.unmarshal(response);
        System.out.println("parse response");
        System.out.println(responseObject.getResponseCode());
        System.out.println(responseObject.getDescription());
//        _logger.info("parse response");
//        _logger.info(responseObject.getAuthCode());
//        _logger.info(responseObject.getDescription());
        return responseObject;
    }

    private InputStream sendMessage(ByteArrayOutputStream soapMessage) throws IOException, PaymantInvocationException {
        String POST_URL = "https://gateway.ecorepay.cc/";
        URL obj = new URL(POST_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);

        // For POST only - START
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(soapMessage.toByteArray());
        os.flush();
        os.close();
        
        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
//            BufferedReader in = new BufferedReader(new InputStreamReader(
//                    con.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();

            // print result
            return con.getInputStream();
        } else {
            throw new PaymantInvocationException();
        }
    }

    private ByteArrayOutputStream generateSoapMessage(Request request) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Request.class);
        Marshaller marshaller = context.createMarshaller();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        marshaller.marshal(request, output);
        return output;
    }

    private Request createRequest(AuthorizeCaptureRequest acr) {
        Request request = new Request();
        request.setAccountAuth(acr.getAccountAuth());
        request.setAccountID(acr.getAccountID());
        request.setType(acr.getRequest().name());
        
        AuthorizeCaptureTransactionRequest transactionRequest = acr.getTransactionRequest();
        Transaction transaction = new Transaction();
        transaction.setAddress(transactionRequest.getAddress());
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setCardCVV(transactionRequest.getCardCVV());
        transaction.setCardExpMonth(transactionRequest.getCardExpMonth());
        transaction.setCardExpYear(transactionRequest.getCardExpYear());
        transaction.setCardNumber(transactionRequest.getCardNumber());
        transaction.setCity(transactionRequest.getCity());
        transaction.setCountry(transactionRequest.getCountry());
        transaction.setCurrency(transactionRequest.getCurrency());
        transaction.setDOB(transactionRequest.getDOB());
        transaction.setEmail(transactionRequest.getEmail());
//        transaction.setField1(transactionRequest.getFirstName());
        transaction.setFirstName(transactionRequest.getFirstName());
        transaction.setIPAddress(transactionRequest.getIPAddress());
        transaction.setLastName(transactionRequest.getLastName());
        transaction.setPhone(transactionRequest.getPhone());
        transaction.setPostCode(transactionRequest.getPostCode());
        transaction.setReference(transactionRequest.getReference());
        
        ShipTo shipTo = transactionRequest.getShipTo();
        
        com.ec.virtualcoin.buy.payment.jaxb.Request.Transaction.ShipTo st = new com.ec.virtualcoin.buy.payment.jaxb.Request.Transaction.ShipTo();
                st.setAddress(shipTo.getAddress());
                st.setCity(shipTo.getCity());
                st.setCountry(shipTo.getCountry());
                st.setFirstName(shipTo.getFirstName());
                st.setLastName(shipTo.getLastName());
                st.setPostCode(shipTo.getPostCode());
                st.setState(shipTo.getState());
        
        transaction.setShipTo(st);
        transaction.setSSN(transactionRequest.getSSN());
        transaction.setState(transactionRequest.getState());
        
        request.setTransaction(transaction);
        
        return request;
    }

}
