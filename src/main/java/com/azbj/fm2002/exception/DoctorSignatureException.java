package com.azbj.fm2002.exception;

public class DoctorSignatureException extends RuntimeException {
    public DoctorSignatureException(String message) {
        super(message);
    }

    public DoctorSignatureException(String message, Throwable cause) {
        super(message, cause);
    }
}