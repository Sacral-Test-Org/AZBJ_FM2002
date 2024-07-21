package com.azbj.fm2002.util;

public class SecFrarReqUtil {

    public boolean validateSupervisorCredentials(String supervisorId, String password) {
        // Validate Supervisor ID
        if (supervisorId == null || supervisorId.isEmpty()) {
            System.out.println("Please enter Supervisor ID");
            return false;
        }

        // Validate Password
        if (password == null || password.isEmpty()) {
            System.out.println("Please enter Password");
            return false;
        }

        // If both fields are filled, return true
        return true;
    }
}