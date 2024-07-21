package com.azbj.fm2002.dto;

public class SeniorUnderwriterDTO {
    private String sysDesc;
    private String charValue;

    public SeniorUnderwriterDTO() {}

    public SeniorUnderwriterDTO(String sysDesc, String charValue) {
        this.sysDesc = sysDesc;
        this.charValue = charValue;
    }

    public String getSysDesc() {
        return sysDesc;
    }

    public void setSysDesc(String sysDesc) {
        this.sysDesc = sysDesc;
    }

    public String getCharValue() {
        return charValue;
    }

    public void setCharValue(String charValue) {
        this.charValue = charValue;
    }
}