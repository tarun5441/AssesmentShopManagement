package com.example.AssesmentShopManagement.ExceptionHandler;

public class ProductException extends Exception{
    private static final int id = 1;
    private String errormessage;

    public ProductException(String message, String errormessage) {
        super(message);
        this.errormessage = errormessage;
    }

    public String getErrormessage() {
        return errormessage;
    }
}
