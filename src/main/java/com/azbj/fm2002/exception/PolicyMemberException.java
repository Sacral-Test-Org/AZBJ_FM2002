package com.azbj.fm2002.exception;

public class PolicyMemberException extends RuntimeException {
    private String errorMessage;

    public PolicyMemberException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}