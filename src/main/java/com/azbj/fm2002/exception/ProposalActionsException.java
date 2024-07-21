package com.azbj.fm2002.exception;

public class ProposalActionsException extends RuntimeException {
    public ProposalActionsException(String message) {
        super(message);
    }

    public ProposalActionsException(String message, Throwable cause) {
        super(message, cause);
    }
}