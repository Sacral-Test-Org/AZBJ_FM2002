package com.azbj.fm2002.exception;

public class SearchCpException extends RuntimeException {
    private String message;

    public SearchCpException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}