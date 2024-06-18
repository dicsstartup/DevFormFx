package com.dicsstartup.devformfx;

public class DevException extends Exception {

    public DevException() {
        super();
    }

    // Constructor con mensaje personalizado
    public DevException(String message) {
        super(message);
    }

    // Constructor con mensaje y causa
    public DevException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor con causa
    public DevException(Throwable cause) {
        super(cause);
    }

}
