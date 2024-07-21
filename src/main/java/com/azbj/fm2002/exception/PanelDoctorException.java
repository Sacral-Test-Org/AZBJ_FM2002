package com.azbj.fm2002.exception;

public class PanelDoctorException extends RuntimeException {
    public PanelDoctorException(String message) {
        super(message);
    }

    public PanelDoctorException(String message, Throwable cause) {
        super(message, cause);
    }
}