package com.ec.virtualcoin;

public class AttributeNotFoundException extends Exception {

    private static final long serialVersionUID = 6072419678415504715L;

    public AttributeNotFoundException() {
        super();
    }

    public AttributeNotFoundException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public AttributeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AttributeNotFoundException(String message) {
        super(message);
    }

    public AttributeNotFoundException(Throwable cause) {
        super(cause);
    }

}
