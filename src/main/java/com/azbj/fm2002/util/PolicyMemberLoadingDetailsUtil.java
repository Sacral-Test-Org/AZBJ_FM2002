package com.azbj.fm2002.util;

public class PolicyMemberLoadingDetailsUtil {

    /**
     * Checks if the member's relation is valid (i.e., not 'Son', 'Daughter', or 'Child').
     *
     * @param relation the relation of the member
     * @return true if the relation is valid, false otherwise
     */
    public static boolean isMemberRelationValid(String relation) {
        return !("Son".equalsIgnoreCase(relation) || "Daughter".equalsIgnoreCase(relation) || "Child".equalsIgnoreCase(relation));
    }
}
