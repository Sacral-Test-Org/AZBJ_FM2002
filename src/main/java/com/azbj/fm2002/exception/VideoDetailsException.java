package com.azbj.fm2002.exception;

public class VideoDetailsException extends RuntimeException {
    public VideoDetailsException(String message) {
        super(message);
    }

    public VideoDetailsException(String message, Throwable cause) {
        super(message, cause);
    }
}