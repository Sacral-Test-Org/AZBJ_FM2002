package com.azbj.fm2002.dto;

public class SumAssuredCalculationResponse {
    private double sumAssuredOnDeath;

    public SumAssuredCalculationResponse(double sumAssuredOnDeath) {
        this.sumAssuredOnDeath = sumAssuredOnDeath;
    }

    public double getSumAssuredOnDeath() {
        return sumAssuredOnDeath;
    }

    public void setSumAssuredOnDeath(double sumAssuredOnDeath) {
        this.sumAssuredOnDeath = sumAssuredOnDeath;
    }
}
