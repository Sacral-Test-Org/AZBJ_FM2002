package com.azbj.fm2002.dto;

import java.util.List;

public class DoctorClientNamesResponse {
    private List<String> clientNames;

    public DoctorClientNamesResponse(List<String> clientNames) {
        this.clientNames = clientNames;
    }

    public List<String> getClientNames() {
        return clientNames;
    }

    public void setClientNames(List<String> clientNames) {
        this.clientNames = clientNames;
    }
}