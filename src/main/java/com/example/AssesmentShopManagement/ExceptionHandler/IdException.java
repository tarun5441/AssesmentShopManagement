package com.example.AssesmentShopManagement.ExceptionHandler;

public class IdException extends Exception{
    private String errormessage;

    public IdException() {
    }

    public IdException(String message, String errormessage) {
        super(message);
        this.errormessage = errormessage;
    }

    public String getErrormessage() {
        return errormessage;
    }
}
