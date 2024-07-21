package com.azbj.fm2002.exception;

public class DiscountTypeException extends RuntimeException {
    public DiscountTypeException(String message) {
        super(message);
    }

    public DiscountTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}