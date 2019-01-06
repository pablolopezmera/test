package com.ec.virtualcoin.fixedquotation.config;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.ec.virtualcoin.fixedquotation.config.FixedConfiguration")
public interface FixedConfiguration {

    @Meta.AD(
        deflt = "345",
        required = false
    )
    public String usdAmount();

}