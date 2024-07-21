package com.azbj.fm2002.exception;

public class DeleteCoverException extends RuntimeException {
    private String errorMessage;

    public DeleteCoverException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}