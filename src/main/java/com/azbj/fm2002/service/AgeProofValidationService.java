package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.AgeProofValidationRepository;
import com.azbj.fm2002.model.ValidationResponse;
import com.azbj.fm2002.model.AgeProofDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class AgeProofValidationService {

    private static final Logger logger = LogManager.getLogger(AgeProofValidationService.class);

    @Autowired
    private AgeProofValidationRepository ageProofValidationRepository;

    public boolean validateAgeProofID(String ageProofType, String ageProofID) {
        try {
            if (("AC".equals(ageProofType) || "ACS".equals(ageProofType)) && ageProofID.length() == 12) {
                // Extract names and format DOB
                // Assume insuredPersonName and insuredPersonDOB are available
                String insuredPersonName = "John A. Doe"; // Placeholder
                String insuredPersonDOB = "01/JAN/1980"; // Placeholder
                String[] nameParts = insuredPersonName.split(" ");
                String firstName = nameParts[0];
                String middleName = nameParts.length > 2 ? nameParts[1] : "";
                String lastName = nameParts.length > 2 ? nameParts[2] : nameParts[1];

                // Validate Aadhaar data
                boolean isValidAadhaar = ageProofValidationRepository.validateAadhaarData(ageProofID, firstName, middleName, lastName, insuredPersonDOB);
                if (isValidAadhaar) {
                    // Update age proof ID
                    logger.info("Aadhaar data validated successfully for ID: " + ageProofID);
                    return true;
                } else {
                    logger.error("Aadhaar data validation failed for ID: " + ageProofID);
                    return false;
                }
            } else if ("Pan Card".equals(ageProofType) && ageProofID != null) {
                // Assign age proof ID to agent's PAN card
                // Assume agentCode is available
                String agentCode = "123456"; // Placeholder
                ageProofValidationRepository.updateAgentPanCard(ageProofID, agentCode);
                logger.info("PAN card updated successfully for agent: " + agentCode);
                return true;
            }
        } catch (Exception e) {
            logger.error("Error validating age proof ID: " + e.getMessage());
        }
        return false;
    }

    public String validateAgeProof(String ageProof) {
        try {
            String ageUid = ageProofValidationRepository.findAgeUidByAgeProof(ageProof);
            return ageUid;
        } catch (NoDataFoundException e) {
            return "NA1";
        } catch (Exception e) {
            return "NA2";
        }
    }

    public String determineAgeProofType(Object ageProofDetails) {
        try {
            String ageProofType = ageProofValidationRepository.findAgeProofType(ageProofDetails);
            return ageProofType.equals("Y") ? "Standard Age Proof" : "Non-standard Age Proof";
        } catch (Exception e) {
            logger.error("Error determining age proof type: " + e.getMessage());
            return "Error determining age proof type";
        }
    }

    public ValidationResponse validate(String ageProofType, String ageProofID, String agentCode) {
        try {
            ValidationResponse response = ageProofValidationRepository.validate(ageProofType, ageProofID, agentCode);
            return response;
        } catch (Exception e) {
            logger.error("Error validating age proof: " + e.getMessage());
            return new ValidationResponse(false, "Error validating age proof");
        }
    }

    public AgeProofDetails getAgeProofDetails(String proofType) {
        try {
            AgeProofDetails details = ageProofValidationRepository.findAgeProofDetails(proofType);
            return details;
        } catch (Exception e) {
            logger.error("Error fetching age proof details: " + e.getMessage());
            return null;
        }
    }
}
