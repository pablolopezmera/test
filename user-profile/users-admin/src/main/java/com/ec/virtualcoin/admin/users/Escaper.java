package com.ec.virtualcoin.admin.users;

public class Escaper {

    private String string;
    
    public Escaper(String string) {
        this.string = string;
    }

    public String unescape() {
        string = string.replace("\\\"", "'");
        string = string.replace("\"", "");
        string = "[".concat(string.substring(1, string.length()-1).concat("]"));
        return string;
    }

}
