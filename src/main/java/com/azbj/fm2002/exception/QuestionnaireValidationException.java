package com.azbj.fm2002.exception;

public class QuestionnaireValidationException extends RuntimeException {
    private String errorMessage;

    public QuestionnaireValidationException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}