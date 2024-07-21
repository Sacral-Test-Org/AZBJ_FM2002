package com.azbj.fm2002.util;

public class ManualCasePushUtil {

    /**
     * Formats the rule message based on specific criteria.
     *
     * @param ruleMessage the original rule message
     * @return the formatted rule message
     */
    public static String formatRuleMessage(String ruleMessage) {
        if (ruleMessage == null || ruleMessage.isEmpty()) {
            return "";
        }

        // Example formatting logic based on the user story
        if (ruleMessage.contains("QC Requirements raised.")) {
            return ruleMessage;
        } else if (ruleMessage.contains("QC Failed for question")) {
            return "Question No " + ruleMessage.substring(36) + " failed at DEQC";
        } else if (ruleMessage.contains("Rule No")) {
            return "Rule Configurator: " + ruleMessage;
        } else {
            return "Other: " + ruleMessage;
        }
    }
}
