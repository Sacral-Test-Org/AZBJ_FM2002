package com.azbj.fm2002.exception;

public class ProductIdException extends RuntimeException {
    private String message;

    public ProductIdException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}