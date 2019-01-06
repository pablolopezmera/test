package com.ec.virtualcoin.config;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.ec.virtualcoin.config.CoinaturalConfiguration")
public interface CoinaturalConfiguration {

    @Meta.AD(
        deflt = "Coinatural",
        required = false
    )
    public String siteName();

    @Meta.AD(
            deflt = "10",
            required = false
        )
    public Double transactionFee();

}