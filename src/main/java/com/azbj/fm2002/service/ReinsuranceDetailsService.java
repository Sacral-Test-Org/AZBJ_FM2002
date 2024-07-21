package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.ReinsuranceDetailsRepository;
import com.azbj.fm2002.model.ReinsuranceDetails;
import com.azbj.fm2002.model.ReinsurerDetails;
import com.azbj.fm2002.dto.ReinsuranceCoverDetailsDTO;
import com.azbj.fm2002.dto.ReinsuranceDetailsDTO;
import com.azbj.fm2002.util.CalculationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReinsuranceDetailsService {

    @Autowired
    private ReinsuranceDetailsRepository reinsuranceDetailsRepository;

    @Autowired
    private CalculationUtil calculationUtil;

    public List<ReinsuranceDetails> fetchReinsuranceDetails() {
        return reinsuranceDetailsRepository.findAll();
    }

    public void validateOccPercField() {
        // Assuming we have a method to get the product definition and OCC Perc value
        String productDefinition = getProductDefinition();
        double occPercValue = getOccPercValue();

        if ("CAPITAL_SHIELD".equals(productDefinition) && occPercValue > 0) {
            throw new IllegalArgumentException("Product not allowed on extra premium");
        }
    }

    public void validateSpecialRiskPercentage(ReinsuranceCoverDetailsDTO dto) {
        if ("CAPITAL_SHIELD".equals(dto.getProductDefinition()) && dto.getSpecialRiskPercentage() > 0) {
            throw new IllegalArgumentException("Product not allowed on extra Premium");
        }
    }

    public Map<String, Object> calculateValues() {
        List<Object> data = reinsuranceDetailsRepository.fetchData();
        // Assuming we have methods to get the required dates
        Date insuredDob = getInsuredDob();
        Date policyholderDob = getPolicyholderDob();
        Date inceptionDate = getInceptionDate();

        int entryAge = calculationUtil.calculateEntryAge(insuredDob, inceptionDate);
        // Perform other calculations and return the results
        return Map.of("entryAge", entryAge);
    }

    public List<ReinsurerDetails> getReinsurerDetails() {
        return reinsuranceDetailsRepository.findAll();
    }

    public ReinsurerDetails referToReinsurer(ReinsurerDetails reinsurerDetails) {
        return reinsuranceDetailsRepository.save(reinsurerDetails);
    }

    public ReinsuranceDetailsDTO saveReinsuranceDetails(ReinsuranceDetailsDTO dto) {
        // Validate the reinsurance details
        validateReinsuranceDetails(dto);
        return reinsuranceDetailsRepository.save(dto);
    }

    public void deleteRecord(Long recordId) {
        reinsuranceDetailsRepository.deleteById(recordId);
    }

    public List<String> getReinsurerCodes(String reinsuranceType, String productId) {
        return reinsuranceDetailsRepository.findReinsurerCodes(reinsuranceType, productId);
    }

    public void validateReinsuranceDetails(ReinsuranceDetailsDTO dto) {
        if (dto.isReferToReinsurer()) {
            if (dto.getReinsurerCode() == null) {
                throw new IllegalArgumentException("Please select Reinsurer");
            }
            if (dto.getReinsuranceReason() == null) {
                throw new IllegalArgumentException("Please select Reinsurance Reason");
            }
            if (dto.getUnderwritersRecommendation() == null) {
                throw new IllegalArgumentException("Please select Underwriters recommendation");
            }
            if (dto.getUnderwritersMedicalComments() == null || dto.getUnderwritersFinancialComments() == null || dto.getUnderwritersFinalComments() == null) {
                throw new IllegalArgumentException("Please enter Underwriters comments");
            }
            if ("COUNTER OFFER".equals(dto.getUnderwritersRecommendation()) && dto.getCounterOfferDetails() == null) {
                throw new IllegalArgumentException("Please enter the counter offer details");
            }
        }
    }

    public void navigateToMedicalUnderwriting() {
        // Logic to navigate to the Medical Underwriting screen and hide the Reinsurer Selection screen
    }

    // Placeholder methods for missing dependencies
    private String getProductDefinition() {
        return "CAPITAL_SHIELD";
    }

    private double getOccPercValue() {
        return 1.0;
    }

    private Date getInsuredDob() {
        return new Date();
    }

    private Date getPolicyholderDob() {
        return new Date();
    }

    private Date getInceptionDate() {
        return new Date();
    }
}