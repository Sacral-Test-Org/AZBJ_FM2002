package com.azbj.fm2002.exception;

public class MailingAddressException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MailingAddressException(String message) {
        super(message);
    }
}