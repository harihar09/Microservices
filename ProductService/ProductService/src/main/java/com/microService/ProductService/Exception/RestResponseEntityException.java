package com.microService.ProductService.Exception;

import com.microService.ProductService.DTO.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class RestResponseEntityException extends ResponseEntityExceptionHandler {

    // add exception handler methods here
    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<ErrorResponse> productNotFoundException(ProductNotFound exception) {
        // prepare error response
        ErrorResponse response = ErrorResponse.builder()
                .message(exception.getMessage())
                .timeStamp(Instant.now())
                .statusCode(exception.getErrorCode())
                .build();
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }
}
