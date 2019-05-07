package com.ec.virtualcoin.buy.payment;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class FormatUtilTest {

    @Test
    public void shouldTransformToyyyyDDmm() {
        Date time = Calendar.getInstance().getTime();
        time.setTime(1506142800000l);
        FormatUtil formatUtil = new FormatUtil();
        int formatDate = formatUtil.formatDate(time);
        Assert.assertEquals(20170923, formatDate);
    }

    @Test
    public void shouldReturnMax64() {
        FormatUtil formatUtil = new FormatUtil();
        String reference = formatUtil.maxLength("12345678901234567890123456789012345678901234567890123456789012345", 64);
        Assert.assertEquals("1234567890123456789012345678901234567890123456789012345678901234", reference);
    }

    @Test
    public void shouldReturnSameString() {
        FormatUtil formatUtil = new FormatUtil();
        String reference = formatUtil.maxLength("123456789012345678901234567890", 64);
        Assert.assertEquals("123456789012345678901234567890", reference);
    }

    @Test
    public void shouldReturnNull() {
        FormatUtil formatUtil = new FormatUtil();
        String reference = formatUtil.maxLength(null, 64);
        Assert.assertNull(reference);
    }

}
