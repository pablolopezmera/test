package com.ec.virtualcoin;

import java.util.Date;

public class PurchaseDto {

    private String curr_from, curr_to, ewallet, value_from, value_to, status;
    private Date date_time;

    public PurchaseDto(String curr_from, String curr_to, Date date_time, String ewallet, String value_from,
            String value_to, String status) {
        super();
        this.curr_from = curr_from;
        this.curr_to = curr_to;
        this.date_time = date_time;
        this.ewallet = ewallet;
        this.value_from = value_from;
        this.value_to = value_to;
        this.status = status;
    }

    public String getCurr_from() {
        return curr_from;
    }

    public void setCurr_from(String curr_from) {
        this.curr_from = curr_from;
    }

    public String getCurr_to() {
        return curr_to;
    }

    public void setCurr_to(String curr_to) {
        this.curr_to = curr_to;
    }

    public String getEwallet() {
        return ewallet;
    }

    public void setEwallet(String ewallet) {
        this.ewallet = ewallet;
    }

    public String getValue_from() {
        return value_from;
    }

    public void setValue_from(String value_from) {
        this.value_from = value_from;
    }

    public String getValue_to() {
        return value_to;
    }

    public void setValue_to(String value_to) {
        this.value_to = value_to;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public String getStatus() {
        return status;
    }

}
