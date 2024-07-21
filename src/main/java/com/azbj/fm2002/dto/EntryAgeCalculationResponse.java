package com.azbj.fm2002.dto;

public class EntryAgeCalculationResponse {
    private int entryAge;
    private int benefitTerm;
    private int premiumTerm;

    public int getEntryAge() {
        return entryAge;
    }

    public void setEntryAge(int entryAge) {
        this.entryAge = entryAge;
    }

    public int getBenefitTerm() {
        return benefitTerm;
    }

    public void setBenefitTerm(int benefitTerm) {
        this.benefitTerm = benefitTerm;
    }

    public int getPremiumTerm() {
        return premiumTerm;
    }

    public void setPremiumTerm(int premiumTerm) {
        this.premiumTerm = premiumTerm;
    }
}