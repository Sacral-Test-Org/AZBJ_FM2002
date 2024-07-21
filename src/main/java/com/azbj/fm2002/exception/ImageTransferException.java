package com.azbj.fm2002.exception;

public class ImageTransferException extends RuntimeException {
    private String message;

    public ImageTransferException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}