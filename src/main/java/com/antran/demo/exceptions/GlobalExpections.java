package com.antran.demo.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExpections {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExpections.class);
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException exception){
        logger.warn("An illegal argument was passed: {}",exception.getMessage(),exception);
        return ResponseEntity.badRequest().body("An illegal argument was passed");
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException(ArithmeticException exception){
        logger.warn("An ArithmeticException was passed: {}",exception.getMessage(),exception);
        return ResponseEntity.badRequest().body("An ArithmeticException was passed");
    }
}
