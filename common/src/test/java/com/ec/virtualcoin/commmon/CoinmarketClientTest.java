package com.ec.virtualcoin.commmon;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class CoinmarketClientTest {

    @Test
    @Ignore
    public void shouldQueyQuotation() throws ClientProtocolException, IOException {
        CoinmarketClient client = new CoinmarketClient();
        Quote quote = client.getBtcQuotation();
        System.out.println(quote.getName());
        System.out.println(quote.getSymbol());
        System.out.println(quote.getUsdPrice());
        Assert.assertTrue(quote.getUsdPrice() > 0);
    }
}
