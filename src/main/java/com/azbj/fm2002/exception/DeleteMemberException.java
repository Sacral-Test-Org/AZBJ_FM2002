package com.azbj.fm2002.exception;

public class DeleteMemberException extends RuntimeException {
    private String message;

    public DeleteMemberException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}