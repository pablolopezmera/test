package com.ec.virtualcoin.buy.payment;

import org.junit.Assert;
import org.junit.Test;

import com.ec.virtualcoin.buy.BTCAddrValidator;

public class BTCAddrValidatorTest {

    @Test
    public void test() {

        Assert.assertTrue(BTCAddrValidator.validate("1AGNa15ZQXAZUgFiqJ2i7Z2DPU2J6hW62i"));
        Assert.assertFalse(BTCAddrValidator.validate("1AGNa15ZQXAZUgFiqJ2i7Z2DPU2J6hW62j"));
        Assert.assertTrue(BTCAddrValidator.validate("1Q1pE5vPGEEMqRcVRMbtBK842Y6Pzo6nK9"));
        Assert.assertFalse(BTCAddrValidator.validate("1AGNa15ZQXAZUgFiqJ2i7Z2DPU2J6hW62X"));
        Assert.assertFalse(BTCAddrValidator.validate("1ANNa15ZQXAZUgFiqJ2i7Z2DPU2J6hW62i"));
        Assert.assertFalse(BTCAddrValidator.validate("1A Na15ZQXAZUgFiqJ2i7Z2DPU2J6hW62i"));
        Assert.assertFalse(BTCAddrValidator.validate("BZbvjr"));
        Assert.assertFalse(BTCAddrValidator.validate("i55j"));
        Assert.assertFalse(BTCAddrValidator.validate("1AGNa15ZQXAZUgFiqJ2i7Z2DPU2J6hW62!"));
        Assert.assertFalse(BTCAddrValidator.validate("1AGNa15ZQXAZUgFiqJ2i7Z2DPU2J6hW62iz"));
        Assert.assertFalse(BTCAddrValidator.validate("1AGNa15ZQXAZUgFiqJ2i7Z2DPU2J6hW62izz"));
        Assert.assertFalse(BTCAddrValidator.validate("1Q1pE5vPGEEMqRcVRMbtBK842Y6Pzo6nJ9"));
        Assert.assertFalse(BTCAddrValidator.validate("1AGNa15ZQXAZUgFiqJ2i7Z2DPU2J6hW62I"));
        Assert.assertTrue(BTCAddrValidator.validate("3R2MPpTNQLCNs13qnHz89Rm82jQ27bAwft"));
        Assert.assertTrue(BTCAddrValidator.validate("34QjytsE8GVRbUBvYNheftqJ5CHfDHvQRD"));
        Assert.assertTrue(BTCAddrValidator.validate("3GsAUrD4dnCqtaTTUzzsQWoymHNkEFrgGF"));
        Assert.assertTrue(BTCAddrValidator.validate("3NagLCvw8fLwtoUrK7s2mJPy9k6hoyWvTU"));

    }

}