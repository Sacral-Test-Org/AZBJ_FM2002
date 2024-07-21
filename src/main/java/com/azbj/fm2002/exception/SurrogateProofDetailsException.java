package com.azbj.fm2002.exception;

public class SurrogateProofDetailsException extends RuntimeException {
    public SurrogateProofDetailsException(String message) {
        super(message);
    }

    public SurrogateProofDetailsException(String message, Throwable cause) {
        super(message, cause);
    }
}