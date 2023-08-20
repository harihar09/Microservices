package com.microService.ProductService.Exception;

import lombok.Data;

@Data
public class ProductNotFound extends RuntimeException {
    // this will help to invoke the parent class constructor and print
    // on console
    private String errorCode;

    public ProductNotFound(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
