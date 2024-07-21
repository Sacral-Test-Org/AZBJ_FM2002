package com.azbj.fm2002.exception;

public class FakeDocumentException extends RuntimeException {
    public FakeDocumentException(String message) {
        super(message);
    }

    public FakeDocumentException(String message, Throwable cause) {
        super(message, cause);
    }
}