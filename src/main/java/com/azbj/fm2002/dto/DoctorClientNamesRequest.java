package com.azbj.fm2002.dto;

public class DoctorClientNamesRequest {
    private String doctorCode;

    public DoctorClientNamesRequest() {}

    public DoctorClientNamesRequest(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }
}
