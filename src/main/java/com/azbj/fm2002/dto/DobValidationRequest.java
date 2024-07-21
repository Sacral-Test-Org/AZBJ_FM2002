package com.azbj.fm2002.dto;

import java.util.Date;

public class DobValidationRequest {
    private Date dob;

    public DobValidationRequest() {}

    public DobValidationRequest(Date dob) {
        this.dob = dob;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
