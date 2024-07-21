package com.azbj.fm2002.exception;

public class DrivingLicenseDetailsException extends RuntimeException {
    private String errorMessage;

    public DrivingLicenseDetailsException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}