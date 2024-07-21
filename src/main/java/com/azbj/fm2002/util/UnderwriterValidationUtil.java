package com.azbj.fm2002.util;

public class UnderwriterValidationUtil {

    // Method to check if the underwriterId is exactly 8 characters long
    public static boolean isValidUnderwriterId(String underwriterId) {
        return underwriterId != null && underwriterId.length() == 8;
    }

    // Method to check if the underwriterId is not the same as the current user
    public static boolean isNotCurrentUser(String underwriterId, String currentUserId) {
        return underwriterId != null && !underwriterId.equals(currentUserId);
    }
}
