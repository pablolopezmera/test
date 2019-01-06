package com.ec.virtualcoin.common;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class QuoteDeserializer extends StdDeserializer<Quote> { 
 
    private static final long serialVersionUID = 3601596697620915924L;

    public QuoteDeserializer() { 
        this(null); 
    } 
 
    public QuoteDeserializer(Class<?> vc) { 
        super(vc); 
    }
 
    @Override
    public Quote deserialize(JsonParser jp, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        String name = node.get("data").get("name").asText();
        String symbol = node.get("data").get("symbol").asText();
        double price = node.get("data").get("quotes").get("USD").get("price").asDouble();
        
        Quote data = new Quote();
        data.setName(name);
        data.setUsdPrice(price);
        data.setSymbol(symbol);
        
        return data;
    }
}