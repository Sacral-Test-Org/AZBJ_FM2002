package com.azbj.fm2002.exception;

public class CounterOfferException extends RuntimeException {
    private String errorCode;

    public CounterOfferException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}