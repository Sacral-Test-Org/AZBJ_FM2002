package com.azbj.fm2002.exception;

public class SumAssuredCalculationException extends RuntimeException {
    private String errorCode;

    public SumAssuredCalculationException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
