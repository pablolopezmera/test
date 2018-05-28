package com.ec.virtualcoin.buy.payment.client;

public class AuthorizeCaptureRequest {
    private RequestType request;
    private Integer AccountID;
    private String AccountAuth;
    private AuthorizeCaptureTransactionRequest transactionRequest;
    
    public AuthorizeCaptureRequest(RequestType request, Integer accountID, String accountAuth,
            AuthorizeCaptureTransactionRequest transactionRequest) {
        super();
        this.request = request;
        AccountID = accountID;
        AccountAuth = accountAuth;
        this.transactionRequest = transactionRequest;
    }
    public RequestType getRequest() {
        return request;
    }
    public void setRequest(RequestType request) {
        this.request = request;
    }
    public Integer getAccountID() {
        return AccountID;
    }
    public void setAccountID(Integer accountID) {
        AccountID = accountID;
    }
    public String getAccountAuth() {
        return AccountAuth;
    }
    public void setAccountAuth(String accountAuth) {
        AccountAuth = accountAuth;
    }
    public AuthorizeCaptureTransactionRequest getTransactionRequest() {
        return transactionRequest;
    }
    public void setTransactionRequest(AuthorizeCaptureTransactionRequest transactionRequest) {
        this.transactionRequest = transactionRequest;
    }

}
