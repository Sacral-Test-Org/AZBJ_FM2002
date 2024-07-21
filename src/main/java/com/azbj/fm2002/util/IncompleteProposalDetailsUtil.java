package com.azbj.fm2002.util;

import java.util.List;
import java.util.stream.Collectors;

public class IncompleteProposalDetailsUtil {

    // Utility method to filter proposal form fields from a list of values
    public static List<String> filterProposalFormFields(List<String> values) {
        return values.stream()
                .filter(value -> value != null && !value.trim().isEmpty())
                .collect(Collectors.toList());
    }

    // Utility method to validate comments length
    public static boolean validateCommentsLength(String comments) {
        return comments != null && comments.length() <= 1000;
    }

    // Utility method to check if details received value is valid
    public static boolean isValidDetailsReceivedValue(String value, List<String> validValues) {
        return validValues.contains(value);
    }

    // Utility method to create a new blank proposal detail row
    public static ProposalDetail createNewProposalDetail() {
        return new ProposalDetail();
    }

    // Utility method to delete a proposal detail row by index
    public static List<ProposalDetail> deleteProposalDetailByIndex(List<ProposalDetail> details, int index) {
        if (index >= 0 && index < details.size()) {
            details.remove(index);
        }
        return details;
    }

    // Utility method to navigate back to the previous screen
    public static void navigateBack() {
        // Implementation for navigation logic
    }
}

class ProposalDetail {
    private String field;
    private String comments;
    private String detailsReceived;

    // Getters and Setters
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDetailsReceived() {
        return detailsReceived;
    }

    public void setDetailsReceived(String detailsReceived) {
        this.detailsReceived = detailsReceived;
    }
}
