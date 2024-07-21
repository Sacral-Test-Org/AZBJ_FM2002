package com.azbj.fm2002.dto;

import java.math.BigDecimal;

public class GstCalculationResponse {
    private BigDecimal totalGstAmount;
    private BigDecimal stateGst;
    private BigDecimal centralGst;
    private BigDecimal utGst;
    private BigDecimal integratedGst;
    private String errorMessage;

    // Getters and Setters
    public BigDecimal getTotalGstAmount() {
        return totalGstAmount;
    }

    public void setTotalGstAmount(BigDecimal totalGstAmount) {
        this.totalGstAmount = totalGstAmount;
    }

    public BigDecimal getStateGst() {
        return stateGst;
    }

    public void setStateGst(BigDecimal stateGst) {
        this.stateGst = stateGst;
    }

    public BigDecimal getCentralGst() {
        return centralGst;
    }

    public void setCentralGst(BigDecimal centralGst) {
        this.centralGst = centralGst;
    }

    public BigDecimal getUtGst() {
        return utGst;
    }

    public void setUtGst(BigDecimal utGst) {
        this.utGst = utGst;
    }

    public BigDecimal getIntegratedGst() {
        return integratedGst;
    }

    public void setIntegratedGst(BigDecimal integratedGst) {
        this.integratedGst = integratedGst;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
