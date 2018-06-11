package com.ec.virtualcoin.admin.users;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.ec.virtualcoin.admin.users.CoinaturalConfiguration")
public interface CoinaturalConfiguration {

    @Meta.AD(
        deflt = "Coinatural",
        required = false
    )
    public String siteName();

}