package com.azbj.fm2002.exception;

public class LanguageException extends RuntimeException {
    private String message;

    public LanguageException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}