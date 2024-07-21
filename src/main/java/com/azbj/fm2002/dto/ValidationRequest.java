package com.azbj.fm2002.dto;

import java.util.Date;

public class ValidationRequest {
    private Date dateOfBirth;
    private String mailingDistrict;
    private String mailingState;
    private double totalPremium;
    private double annualIncome;
    private String panCard;

    // Getters and Setters
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMailingDistrict() {
        return mailingDistrict;
    }

    public void setMailingDistrict(String mailingDistrict) {
        this.mailingDistrict = mailingDistrict;
    }

    public String getMailingState() {
        return mailingState;
    }

    public void setMailingState(String mailingState) {
        this.mailingState = mailingState;
    }

    public double getTotalPremium() {
        return totalPremium;
    }

    public void setTotalPremium(double totalPremium) {
        this.totalPremium = totalPremium;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }
}