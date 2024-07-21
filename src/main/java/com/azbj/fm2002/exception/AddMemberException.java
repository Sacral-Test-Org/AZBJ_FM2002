package com.azbj.fm2002.exception;

public class AddMemberException extends RuntimeException {
    public AddMemberException(String message) {
        super(message);
    }

    public AddMemberException(String message, Throwable cause) {
        super(message, cause);
    }
}