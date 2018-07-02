package com.ec.virtualcoin.fixedquotation;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.ec.virtualcoin.fixedquotation.FixedQuotationConfiguration")
public interface FixedQuotationConfiguration {

    @Meta.AD(deflt = "100", required = false)
    public Integer usdAmount();

}
