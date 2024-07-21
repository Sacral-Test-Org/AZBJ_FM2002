package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.MedicalLoadingValidationRequest;
import com.azbj.fm2002.dto.MedicalLoadingValidationResponse;
import com.azbj.fm2002.exception.MedicalLoadingValidationException;

public class MedicalLoadingValidationUtil {

    public static MedicalLoadingValidationResponse validate(MedicalLoadingValidationRequest request) throws MedicalLoadingValidationException {
        String coverCode = request.getCoverCode();
        String productDefinition = request.getProductDefinition();
        int mlp = request.getMlp();

        if ("R003A01".equals(coverCode) || "R003B01".equals(coverCode)) {
            if (mlp != 0 && mlp != 25 && mlp != 50 && mlp != 75 && mlp != 100 && mlp != 150) {
                throw new MedicalLoadingValidationException("The Medical Loading Percentage can be 0, 25, 50, 75, 100, 150 for this Rider.");
            }
        } else if (coverCode.startsWith("L") || "R002A01".equals(coverCode)) {
            if (mlp < 0 || mlp > 500) {
                throw new MedicalLoadingValidationException("The Medical Loading Percentage can be between 0 and 500.");
            }
        } else if ("R018A01".equals(coverCode)) {
            if (mlp < 0 || mlp > 100) {
                throw new MedicalLoadingValidationException("The Medical Loading Percentage can be between 0 and 100.");
            }
        } else if ("L066A01".equals(coverCode)) {
            if (mlp < 0 || mlp > 125) {
                throw new MedicalLoadingValidationException("The Medical Loading Percentage can be between 0 and 125.");
            }
        }

        if ("SARAL_JEEVAN_BIMA".equals(productDefinition) && mlp > 200) {
            throw new MedicalLoadingValidationException("Medical Loading is not allowed greater than 200!");
        }

        if ("CAPITAL_SHIELD".equals(productDefinition) && mlp > 0) {
            throw new MedicalLoadingValidationException("Product not allowed on extra Premium.");
        }

        if (isGroupProduct(productDefinition) && !coverCode.startsWith("L") && mlp > 0) {
            throw new MedicalLoadingValidationException("Please load Main cover.");
        }

        return new MedicalLoadingValidationResponse(true);
    }

    private static boolean isGroupProduct(String productDefinition) {
        return "GROUP_CREDIT_PROTECT".equals(productDefinition) ||
               "GROUP_SURAKSHA".equals(productDefinition) ||
               "SWAYAM_SHAKTI_SURAKSHA".equals(productDefinition) ||
               "SARVE_SHAKTI_SURAKSHA".equals(productDefinition) ||
               "GROUP_SEVA_PLAN".equals(productDefinition) ||
               "GROUP_LOAN_PROTECTOR".equals(productDefinition) ||
               "GROUP_LEAVE_ENCASHMENT".equals(productDefinition) ||
               "GROUP_CREDIT_PROTECTION_PLUS".equals(productDefinition) ||
               "NIYAMIT_SANCHAY_SURAKSHA".equals(productDefinition) ||
               "NIYAMIT_SANCHAY_SURKSHA_SINGLE".equals(productDefinition);
    }
}