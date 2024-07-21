package com.azbj.fm2002.exception;

public class PivcLinkException extends RuntimeException {
    public PivcLinkException(String message) {
        super(message);
    }

    public PivcLinkException(String message, Throwable cause) {
        super(message, cause);
    }
}