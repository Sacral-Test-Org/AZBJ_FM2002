package com.project.azbj_fm2002.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.apache.log4j.Logger;

@ControllerAdvice
public class CustomExceptionHandler {

    private static final Logger logger = Logger.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        logger.error("Unexpected error occurred: ", ex);
        return new ResponseEntity<>("An unexpected error occurred. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SaveInsuredPersonException.class)
    public ResponseEntity<String> handleSaveInsuredPersonException(SaveInsuredPersonException ex) {
        logger.error("Error occurred while saving insured person details: ", ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
