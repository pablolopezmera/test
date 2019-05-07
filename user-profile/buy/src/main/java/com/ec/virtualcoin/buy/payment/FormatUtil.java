package com.ec.virtualcoin.buy.payment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtil {

    public int formatDate(Date birthday) {
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        return Integer.valueOf(format.format(birthday));
    }

    public String maxLength(String string, int maxLength) {
        if (string !=null && string.length() > maxLength) {
            return string.substring(0, maxLength);
        }
        return string;
    }

    
}
