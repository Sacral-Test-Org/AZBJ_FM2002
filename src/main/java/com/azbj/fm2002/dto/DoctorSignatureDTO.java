package com.azbj.fm2002.dto;

public class DoctorSignatureDTO {
    private String doctorCode;
    private String signature;

    public DoctorSignatureDTO() {}

    public DoctorSignatureDTO(String doctorCode, String signature) {
        this.doctorCode = doctorCode;
        this.signature = signature;
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}