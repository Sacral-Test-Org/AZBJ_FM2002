package com.azbj.fm2002.util;

import java.util.Date;
import java.util.Calendar;

public class AgeCalculationUtil {

    public static int calculateAge(Date dateOfBirth, Date inceptionDate) {
        if (dateOfBirth == null || inceptionDate == null) {
            throw new IllegalArgumentException("Date of birth and inception date must not be null");
        }

        Calendar birthCal = Calendar.getInstance();
        birthCal.setTime(dateOfBirth);
        Calendar inceptionCal = Calendar.getInstance();
        inceptionCal.setTime(inceptionDate);

        int age = inceptionCal.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR);

        if (inceptionCal.get(Calendar.DAY_OF_YEAR) < birthCal.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        return age;
    }

    public static int determineFinalAge(int insuredPersonAge, int policyholderAge) {
        if (insuredPersonAge < 18) {
            return policyholderAge;
        } else {
            return insuredPersonAge;
        }
    }
}
