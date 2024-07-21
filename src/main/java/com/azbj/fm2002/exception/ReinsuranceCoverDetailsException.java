package com.azbj.fm2002.exception;

public class ReinsuranceCoverDetailsException extends RuntimeException {
    private String errorMessage;

    public ReinsuranceCoverDetailsException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
