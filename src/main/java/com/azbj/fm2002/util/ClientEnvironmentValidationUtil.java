package com.azbj.fm2002.util;

public class ClientEnvironmentValidationUtil {

    public static boolean validatePartnerReferences(Object insuredPersonPartnerRef, Object policyHolderPartnerRef) {
        if (insuredPersonPartnerRef == null) {
            System.out.println("Cannot Skip Policy As Partner Is Not Created. Kindly Create Partner And Proceed.");
            return false;
        }
        if (policyHolderPartnerRef == null) {
            System.out.println("Cannot Skip Policy As Partner Is Not Created. Kindly Create Partner And Proceed.");
            return false;
        }
        // Both partner references are present
        System.out.println("Action set to 'SE'. Proceeding to the next step.");
        return true;
    }
}
