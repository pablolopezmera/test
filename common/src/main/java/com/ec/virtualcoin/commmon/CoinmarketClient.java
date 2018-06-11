package com.ec.virtualcoin.commmon;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CoinmarketClient {

    private static Logger _logger = LoggerFactory.getLogger(CoinmarketClient.class.getName());
    
    public Quote getBtcQuotation() throws ClientProtocolException, IOException {
        String url = "https://api.coinmarketcap.com/v2/ticker/1/";
//        String url = "https://blockchain.info/es/ticker";

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = httpClient.execute(request);

        _logger.info("Response Code : " + response.getStatusLine().getStatusCode());
        
        String result = EntityUtils.toString(response.getEntity());

        return processResponse(result);
    }

    private Quote processResponse(String resp) throws JsonParseException, JsonMappingException, IOException {
        return new ObjectMapper().readValue(resp, Quote.class);
    }

}
