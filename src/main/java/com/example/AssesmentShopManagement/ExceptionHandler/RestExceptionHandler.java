package com.example.AssesmentShopManagement.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    //not found exception
    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorResponse> exceptionProductHandler(Exception e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrrorcode(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(e.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
    }

    //Id not found
    @ExceptionHandler(IdException.class)
    public ResponseEntity<ErrorResponse> exceptionIdnotfound(Exception e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrrorcode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(e.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    //bad request exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionBadrequest(Exception e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrrorcode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage("Request cannot be handled due to incorrect request");
        return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);

    }
}
