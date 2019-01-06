package com.ec.virtualcoin.commmon;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.ec.virtualcoin.common.CoinmarketClient;
import com.ec.virtualcoin.common.Quote;

public class CoinmarketClientTest {

    @Test
    @Ignore
    public void shouldQueyQuotation() throws ClientProtocolException, IOException {
        CoinmarketClient client = new CoinmarketClient(5D);
        Quote quote = client.getBtcQuotation();
        System.out.println(quote.getName());
        System.out.println(quote.getSymbol());
        System.out.println(quote.getUsdPrice());
        System.out.println(quote.getTransactionFee());
        System.out.println(quote.getFinalPrice());
        Assert.assertTrue(quote.getUsdPrice() > 0);
    }

}