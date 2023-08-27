package com.microService.OrderService.exception;

public class CustomException extends RuntimeException {

    private String errorCode;
    private String status;

    public CustomException(String message, String errorCode, String status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;

    }

}
