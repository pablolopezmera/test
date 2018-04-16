package com.ec.virtualcoin.admin.users;

import org.junit.Assert;
import org.junit.Test;

public class EscapeTest {
    
    @Test
    public void testEscape() {
        String expected = "[{'firstName':'','screenName':'20120'},{'firstName':'','screenName':'20120'}]";
        Escaper escaper = new Escaper("[\"{\\\"firstName\\\":\\\"\\\",\\\"screenName\\\":\\\"20120\\\"}\"," + 
                "\"{\\\"firstName\\\":\\\"\\\",\\\"screenName\\\":\\\"20120\\\"}\"]");
        String unescaped = escaper.unescape();
        Assert.assertEquals(expected, unescaped);
    }

}
