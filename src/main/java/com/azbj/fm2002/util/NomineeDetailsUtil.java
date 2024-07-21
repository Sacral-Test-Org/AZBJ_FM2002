package com.azbj.fm2002.util;

import java.util.Date;
import java.util.Calendar;

public class NomineeDetailsUtil {

    /**
     * Calculate the age based on the date of birth and the current date.
     * 
     * @param dob Date of birth
     * @param currentDate Current date
     * @return int Age
     */
    public static int calculateAge(Date dob, Date currentDate) {
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(dob);
        Calendar current = Calendar.getInstance();
        current.setTime(currentDate);

        int age = current.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

        if (current.get(Calendar.DAY_OF_YEAR) < birthDate.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        return age;
    }

    /**
     * Check if the age is less than 18.
     * 
     * @param age Age to check
     * @return boolean True if age is less than 18, otherwise false
     */
    public static boolean isMinor(int age) {
        return age < 18;
    }
}
