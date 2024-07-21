package com.azbj.fm2002.dto;

import java.math.BigDecimal;
import java.util.List;

public class PremiumCalculationResponse {
    private BigDecimal totalPremium;
    private BigDecimal serviceTax;
    private BigDecimal educationCess;
    private BigDecimal higherEducationCess;
    private List<String> warningMessages;
    private List<String> errorMessages;

    // Getters and Setters
    public BigDecimal getTotalPremium() {
        return totalPremium;
    }

    public void setTotalPremium(BigDecimal totalPremium) {
        this.totalPremium = totalPremium;
    }

    public BigDecimal getServiceTax() {
        return serviceTax;
    }

    public void setServiceTax(BigDecimal serviceTax) {
        this.serviceTax = serviceTax;
    }

    public BigDecimal getEducationCess() {
        return educationCess;
    }

    public void setEducationCess(BigDecimal educationCess) {
        this.educationCess = educationCess;
    }

    public BigDecimal getHigherEducationCess() {
        return higherEducationCess;
    }

    public void setHigherEducationCess(BigDecimal higherEducationCess) {
        this.higherEducationCess = higherEducationCess;
    }

    public List<String> getWarningMessages() {
        return warningMessages;
    }

    public void setWarningMessages(List<String> warningMessages) {
        this.warningMessages = warningMessages;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
