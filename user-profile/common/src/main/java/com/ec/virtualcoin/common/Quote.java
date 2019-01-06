package com.ec.virtualcoin.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = QuoteDeserializer.class)
public class Quote {

    private String name;
    private String symbol;
    private Double usdPrice = 0d;
    private Double transactionFee = 0d;
    private Double finalPrice = 0d;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public Double getUsdPrice() {
        return usdPrice;
    }
    public void setUsdPrice(Double price) {
        this.usdPrice = price;
        calcFinalPrice();
    }
    public Double getTransactionFee() {
        return transactionFee;
    }
    public void setTransactionFee(Double transactionFee) {
        this.transactionFee = transactionFee;
        calcFinalPrice();
    }
    private void calcFinalPrice() {
        finalPrice = usdPrice + usdPrice * transactionFee / 100;
    }
    public Double getFinalPrice() {
        return finalPrice;
    }
    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }
}
