package com.ec.virtualcoin.commmon;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = QuoteDeserializer.class)
public class Quote {

    private String name;
    private String symbol;
    private Double usdPrice;
    
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
    }
}
