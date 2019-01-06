package com.ec.virtualcoin.commmon;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.ec.virtualcoin.common.Quote;

public class QuoteTest {
    
    @Test
    public void noTransactionFee() {
        Quote q = new Quote();
        q.setTransactionFee(0d);
        q.setUsdPrice(100D);
        
        Double fp = q.getFinalPrice();
        
        assertThat(fp, equalTo(100d));
        
    }

    @Test
    public void shouldCalcFee() {
        Quote q = new Quote();
        q.setUsdPrice(100D);
        q.setTransactionFee(8.55d);
        
        Double fp = q.getFinalPrice();
        
        assertThat(fp, equalTo(108.55d));
        
    }

}