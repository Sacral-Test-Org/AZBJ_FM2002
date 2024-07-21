package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.CoversRepository;
import com.azbj.fm2002.dto.CoversHealthDTO;
import com.azbj.fm2002.dto.EntryAgeCalculationRequest;
import com.azbj.fm2002.dto.EntryAgeCalculationResponse;
import com.azbj.fm2002.dto.PremiumCalculationRequest;
import com.azbj.fm2002.dto.PremiumCalculationResponse;
import com.azbj.fm2002.util.CalculationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CoversService {

    @Autowired
    private CoversRepository coversRepository;

    public void manageInsuranceCoverDetails() {
        try {
            coversRepository.deleteRecordGroup("THL_COVER_RG");
            coversRepository.createRecordGroup("THL_COVER_RG", "SELECT COVER_DESCRIPTION, COVER_CODE FROM CFG_V_PROD_COVERS_API WHERE PRODUCT_ID = :CONTROL.CN_PRODUCT_ID AND PROD_VERSION = :CONTROL.CN_PRODUCT_VERSION");
            coversRepository.populateRecordGroup("THL_COVER_RG");
            coversRepository.setLovProperty("THL_COVER_RG");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateFormStatusControl(String globalLoadingFlag) {
        if ("F".equals(globalLoadingFlag)) {
            coversRepository.updateFormStatusControl("Y");
        }
    }

    public boolean validateAndTrackChanges(double frequencyOfOccurrenceAmount) {
        boolean isValid = coversRepository.validateFrequencyOfOccurrenceAmount(frequencyOfOccurrenceAmount);
        if (isValid) {
            coversRepository.setControlStatusFlag("Y");
        }
        return isValid;
    }

    public boolean validateProductID(int productID) {
        return coversRepository.isProductIDValid(productID);
    }

    public void storePremiumTerm(int premiumTerm) {
        coversRepository.storePremiumTermInGlobalVariable(premiumTerm);
    }

    public void updateFormStatus() {
        coversRepository.updateFormStatus("Y");
    }

    public void setPremiumTerm(int benefitTerm) {
        coversRepository.setPremiumTermToBenefitTerm(benefitTerm);
    }

    public boolean validateEntryAge(int entryAge) {
        return coversRepository.findEntryAge(entryAge);
    }

    public Map<String, Integer> calculateTerms(int entryAge, String packageCode) {
        return coversRepository.findPackageCode(packageCode, entryAge);
    }

    public List<String> fetchReasonsForCounterOffers() {
        return coversRepository.findReasonsForCounterOffers();
    }

    public Object fetchPackageDetails(String productId, java.util.Date receiptDate) {
        return coversRepository.findPackageDetails(productId, receiptDate);
    }

    public Object submitPolicyDetails(Object policyDetails) {
        return coversRepository.savePolicyDetails(policyDetails);
    }

    public boolean validateBenefitTerm(int benefitTerm) {
        return coversRepository.isBenefitTermValid(benefitTerm);
    }

    public int adjustPremiumTerm(int benefitTerm) {
        return (int) Math.floor(benefitTerm * 2 / 3.0);
    }

    public EntryAgeCalculationResponse calculateEntryAge(EntryAgeCalculationRequest request) {
        int calculatedAge = CalculationUtil.calculateAge(request.getDateOfBirth(), request.getInceptionDate(), request.getEffectiveDate());
        return new EntryAgeCalculationResponse(calculatedAge);
    }

    public boolean validateBookingFrequency(String bookingFrequency) {
        return coversRepository.findBookingFrequency(bookingFrequency);
    }

    public PremiumCalculationResponse calculatePremium(PremiumCalculationRequest request) {
        return CalculationUtil.calculatePremium(request);
    }

    public void deleteCover(String coverId) {
        coversRepository.deleteCover(coverId);
    }

    public void savePayoutFrequency(String frequency) {
        coversRepository.save(frequency);
    }

    public void updateLoanDisbursedDate(String loanDisbursedDate) {
        coversRepository.save(loanDisbursedDate);
    }

    public List<CoversHealthDTO> getCoverDetails(Long productId) {
        return coversRepository.findByProductId(productId);
    }

    public CoversHealthDTO saveCoverDetails(CoversHealthDTO coversHealthDTO) {
        return coversRepository.save(coversHealthDTO);
    }
}