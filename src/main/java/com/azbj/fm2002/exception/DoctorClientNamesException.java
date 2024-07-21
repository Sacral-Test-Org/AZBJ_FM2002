package com.azbj.fm2002.exception;

public class DoctorClientNamesException extends RuntimeException {
    private String message;

    public DoctorClientNamesException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}