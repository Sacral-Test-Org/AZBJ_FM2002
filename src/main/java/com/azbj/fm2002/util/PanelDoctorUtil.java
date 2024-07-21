package com.azbj.fm2002.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PanelDoctorUtil {

    private static final String DATE_FORMAT = "dd/MM/yyyy";

    /**
     * Compares the entered date with the predefined date (opus date) and returns the validation result.
     *
     * @param dateReceived the date received as a string
     * @param opusDate the predefined opus date as a string
     * @return true if the dates are equal, false otherwise
     */
    public static boolean isDateEqual(String dateReceived, String opusDate) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        try {
            Date receivedDate = sdf.parse(dateReceived);
            Date predefinedDate = sdf.parse(opusDate);
            return receivedDate.equals(predefinedDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
}
