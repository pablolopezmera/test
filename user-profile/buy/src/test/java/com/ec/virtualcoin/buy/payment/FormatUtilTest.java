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

}
