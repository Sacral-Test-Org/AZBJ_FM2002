package com.azbj.fm2002.exception;

public class CounterOfferValidationException extends RuntimeException {
    private String message;

    public CounterOfferValidationException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}