package com.azbj.fm2002.dto;

public class ManualCasePushDTO {
    private String ruleMessage;
    private String paramValue;

    public ManualCasePushDTO() {}

    public ManualCasePushDTO(String ruleMessage, String paramValue) {
        this.ruleMessage = ruleMessage;
        this.paramValue = paramValue;
    }

    public String getRuleMessage() {
        return ruleMessage;
    }

    public void setRuleMessage(String ruleMessage) {
        this.ruleMessage = ruleMessage;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }
}
