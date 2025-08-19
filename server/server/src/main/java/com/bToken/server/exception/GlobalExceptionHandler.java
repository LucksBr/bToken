package com.bToken.server.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bToken.server.service.validation.ServiceException;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(ServiceException exception){
        return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(Map.of(
            "message", exception.getMessage(),
            "errors", exception.getErrorsMessage()
        ));
    }

}
