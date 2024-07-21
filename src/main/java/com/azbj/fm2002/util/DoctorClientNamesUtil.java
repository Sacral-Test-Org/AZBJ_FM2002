package com.azbj.fm2002.util;

public class DoctorClientNamesUtil {

    public static boolean validateDoctorCode(String doctorCode) {
        // Assuming a valid doctor code is alphanumeric and between 5 to 10 characters
        if (doctorCode == null || doctorCode.isEmpty()) {
            return false;
        }
        return doctorCode.matches("^[a-zA-Z0-9]{5,10}$");
    }
}
