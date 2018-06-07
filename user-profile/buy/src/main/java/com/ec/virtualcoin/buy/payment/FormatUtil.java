package com.ec.virtualcoin.buy.payment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtil {

    public int formatDate(Date birthday) {
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        return Integer.valueOf(format.format(birthday));
    }

    
}
