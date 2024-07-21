package com.azbj.fm2002.exception;

public class IncompleteProposalDetailsException extends RuntimeException {
    public IncompleteProposalDetailsException(String message) {
        super(message);
    }

    public IncompleteProposalDetailsException(String message, Throwable cause) {
        super(message, cause);
    }
}