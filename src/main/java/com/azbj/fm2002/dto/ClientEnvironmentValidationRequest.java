package com.azbj.fm2002.dto;

public class ClientEnvironmentValidationRequest {
    private String insuredPersonPartnerReference;
    private String policyHolderPartnerReference;

    public ClientEnvironmentValidationRequest() {}

    public ClientEnvironmentValidationRequest(String insuredPersonPartnerReference, String policyHolderPartnerReference) {
        this.insuredPersonPartnerReference = insuredPersonPartnerReference;
        this.policyHolderPartnerReference = policyHolderPartnerReference;
    }

    public String getInsuredPersonPartnerReference() {
        return insuredPersonPartnerReference;
    }

    public void setInsuredPersonPartnerReference(String insuredPersonPartnerReference) {
        this.insuredPersonPartnerReference = insuredPersonPartnerReference;
    }

    public String getPolicyHolderPartnerReference() {
        return policyHolderPartnerReference;
    }

    public void setPolicyHolderPartnerReference(String policyHolderPartnerReference) {
        this.policyHolderPartnerReference = policyHolderPartnerReference;
    }
}