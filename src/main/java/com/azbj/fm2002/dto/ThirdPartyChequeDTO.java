package com.azbj.fm2002.dto;

public class ThirdPartyChequeDTO {
    private String paymentMode;
    private String question;
    private int confidencePercentage;

    public ThirdPartyChequeDTO() {}

    public ThirdPartyChequeDTO(String paymentMode, String question, int confidencePercentage) {
        this.paymentMode = paymentMode;
        this.question = question;
        this.confidencePercentage = confidencePercentage;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getConfidencePercentage() {
        return confidencePercentage;
    }

    public void setConfidencePercentage(int confidencePercentage) {
        this.confidencePercentage = confidencePercentage;
    }
}
