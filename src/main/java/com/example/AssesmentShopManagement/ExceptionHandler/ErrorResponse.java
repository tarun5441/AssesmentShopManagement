package com.example.AssesmentShopManagement.ExceptionHandler;

public class ErrorResponse {
    private int errrorcode;
    private String message;

    public int getErrrorcode() {
        return errrorcode;
    }

    public void setErrrorcode(int errrorcode) {
        this.errrorcode = errrorcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
