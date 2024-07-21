package com.azbj.fm2002.util;

import java.util.Date;

public class DobValidationUtil {

    /**
     * Validates the Date of Birth (DOB) against the Opus Date.
     * 
     * @param dob the date of birth to be validated
     * @param opusDate the opus date to validate against
     * @return true if DOB is valid (i.e., less than opus date), false otherwise
     */
    public static boolean validateDOB(Date dob, Date opusDate) {
        if (dob == null || opusDate == null) {
            throw new IllegalArgumentException("Date of Birth and Opus Date must not be null");
        }
        return dob.before(opusDate);
    }
}
