package com.azbj.fm2002.util;

public class UpdateTermsUtil {

    public static boolean validateTerms(String premiumTerm, String packageCode) {
        if (premiumTerm == null || premiumTerm.isEmpty()) {
            return false;
        }
        if (packageCode == null || packageCode.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean validateUpdateTermsRequest(UpdateTermsRequest request) {
        if (request == null) {
            return false;
        }
        if (request.getBenefitTerm() == null || request.getBenefitTerm().isEmpty()) {
            return false;
        }
        if (request.getPackageCode() == null || request.getPackageCode().isEmpty()) {
            return false;
        }
        return true;
    }
}

class UpdateTermsRequest {
    private String benefitTerm;
    private String packageCode;

    public String getBenefitTerm() {
        return benefitTerm;
    }

    public void setBenefitTerm(String benefitTerm) {
        this.benefitTerm = benefitTerm;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }
}