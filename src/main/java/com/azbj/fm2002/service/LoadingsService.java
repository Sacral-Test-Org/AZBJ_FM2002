package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.LoadingsRepository;
import com.azbj.fm2002.dto.MedicalLoadingValidationRequest;
import com.azbj.fm2002.dto.OccupationLoadingValidationRequest;
import com.azbj.fm2002.dto.OccupationLoadingValidationResponse;
import com.azbj.fm2002.exception.MedicalLoadingValidationException;
import com.azbj.fm2002.util.MedicalLoadingValidationUtil;
import com.azbj.fm2002.util.OccupationLoadingValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoadingsService {

    @Autowired
    private LoadingsRepository loadingsRepository;

    public boolean validateLoadingType(String productId, String loadingType) {
        String currentLoadingType = loadingsRepository.findLoadingType(productId);
        if (("277".equals(productId) || "271".equals(productId)) && !"PER_THOUSAND_SA".equals(loadingType)) {
            return false;
        }
        return true;
    }

    public void applyLoadingType(String loadingType, String coverCode) {
        loadingsRepository.updateLoadingType(loadingType, coverCode);
    }

    public void validateLoading(String productDefinition, String coverCode, double loadingPercentage) {
        if (("SWAYAM_SHAKTI_SURAKSHA".equals(productDefinition) || "SARVE_SHAKTI_SURAKSHA".equals(productDefinition) ||
                "GROUP_SEVA_PLAN".equals(productDefinition) || "GROUP_LEAVE_ENCASHMENT".equals(productDefinition) ||
                "GROUP_CREDIT_PROTECT".equals(productDefinition) || "GROUP_CREDIT_PROTECTION_PLUS".equals(productDefinition) ||
                "NIYAMIT_SANCHAY_SURAKSHA".equals(productDefinition) || "NIYAMIT_SANCHAY_SURKSHA_SINGLE".equals(productDefinition)) &&
                !coverCode.startsWith("L") && loadingPercentage > 0) {
            throw new IllegalArgumentException("Please load Main cover");
        }
        // Update form status to 'Y'
        // Assuming there's a method to update form status
        // updateFormStatus("Y");
    }

    public void validateOccupationLoading(String productDefinition, double occupationLoadingPercentage, String coverCode) {
        if ("CAPITAL_SHIELD".equals(productDefinition) && occupationLoadingPercentage > 0) {
            throw new IllegalArgumentException("Product not allowed on extra Premium");
        }
        if (("GROUP_CREDIT_PROTECT".equals(productDefinition) || "GROUP_SURAKSHA".equals(productDefinition) ||
                "SWAYAM_SHAKTI_SURAKSHA".equals(productDefinition) || "SARVE_SHAKTI_SURAKSHA".equals(productDefinition) ||
                "GROUP_SEVA_PLAN".equals(productDefinition) || "GROUP_LOAN_PROTECTOR".equals(productDefinition) ||
                "GROUP_LEAVE_ENCASHMENT".equals(productDefinition) || "GROUP_CREDIT_PROTECTION_PLUS".equals(productDefinition) ||
                "NIYAMIT_SANCHAY_SURAKSHA".equals(productDefinition) || "NIYAMIT_SANCHAY_SURKSHA_SINGLE".equals(productDefinition)) &&
                !coverCode.startsWith("L") && occupationLoadingPercentage > 0) {
            throw new IllegalArgumentException("Please load Main cover");
        }
        if ("SARAL_JEEVAN_BIMA".equals(productDefinition) && occupationLoadingPercentage > 4) {
            throw new IllegalArgumentException("Occupation Loading Cannot be greater than 4!");
        }
        // Update form status to 'Y'
        // Assuming there's a method to update form status
        // updateFormStatus("Y");
    }

    public void validateMLP(MedicalLoadingValidationRequest request) {
        try {
            MedicalLoadingValidationUtil.validate(request);
        } catch (MedicalLoadingValidationException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public OccupationLoadingValidationResponse validateOccupationLoadingClass(OccupationLoadingValidationRequest request) {
        return OccupationLoadingValidationUtil.validate(request);
    }
}
