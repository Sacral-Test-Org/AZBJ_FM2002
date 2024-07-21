package com.azbj.fm2002.dto;

import java.math.BigDecimal;
import java.util.Date;

public class GstCalculationRequest {
    private String productId;
    private String coverCode;
    private BigDecimal premium;
    private Date effectiveDate;
    private int policyYear;
    private String mailingAddressPinCode;
    private String serviceAddressPinCode;
    private BigDecimal sumAssured;
    private String eventCode;

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCoverCode() {
        return coverCode;
    }

    public void setCoverCode(String coverCode) {
        this.coverCode = coverCode;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public int getPolicyYear() {
        return policyYear;
    }

    public void setPolicyYear(int policyYear) {
        this.policyYear = policyYear;
    }

    public String getMailingAddressPinCode() {
        return mailingAddressPinCode;
    }

    public void setMailingAddressPinCode(String mailingAddressPinCode) {
        this.mailingAddressPinCode = mailingAddressPinCode;
    }

    public String getServiceAddressPinCode() {
        return serviceAddressPinCode;
    }

    public void setServiceAddressPinCode(String serviceAddressPinCode) {
        this.serviceAddressPinCode = serviceAddressPinCode;
    }

    public BigDecimal getSumAssured() {
        return sumAssured;
    }

    public void setSumAssured(BigDecimal sumAssured) {
        this.sumAssured = sumAssured;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }
}