package com.azbj.fm2002.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class KycDetailsUtil {

    /**
     * Formats the date of birth in 'DD-MM-YYYY' format.
     * 
     * @param dateOfBirth the date of birth to format
     * @return the formatted date of birth as a String
     */
    public static String formatDateOfBirth(Date dateOfBirth) {
        if (dateOfBirth == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(dateOfBirth);
    }
}
