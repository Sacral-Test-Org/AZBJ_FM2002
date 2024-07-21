package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.CounterOfferValidationRequest;
import com.azbj.fm2002.dto.CounterOfferValidationResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

public class CounterOfferValidationUtil {
    private static final Logger logger = LogManager.getLogger(CounterOfferValidationUtil.class);

    public static CounterOfferValidationResponse validateCounterOffer(CounterOfferValidationRequest request) {
        CounterOfferValidationResponse response = new CounterOfferValidationResponse();

        // Validate counter offer reasons
        List<String> reasons = request.getCounterOfferReasons();
        if (reasons == null || reasons.isEmpty() || reasons.size() > 3) {
            response.setValid(false);
            response.setMessage("Invalid number of counter offer reasons. Must select between 1 and 3 reasons.");
            logger.error("Invalid number of counter offer reasons.");
            return response;
        }
        String concatenatedReasons = String.join(", ", reasons);
        response.setConcatenatedReasons(concatenatedReasons);

        // Validate beneficiary details
        if (request.getBeneficiaryDetails() == null || request.getBeneficiaryDetails().isEmpty()) {
            response.setValid(false);
            response.setMessage("Beneficiary details are missing.");
            logger.error("Beneficiary details are missing.");
            return response;
        }

        // Validate product ID and counter offer types
        String productId = request.getProductId();
        if (productId == null || productId.isEmpty()) {
            response.setValid(false);
            response.setMessage("Product ID is missing.");
            logger.error("Product ID is missing.");
            return response;
        }

        // Calculate insured person's age and joint life flag
        LocalDate dob = request.getDateOfBirth();
        if (dob == null) {
            response.setValid(false);
            response.setMessage("Date of birth is missing.");
            logger.error("Date of birth is missing.");
            return response;
        }
        int age = Period.between(dob, LocalDate.now()).getYears();
        response.setAge(age);
        response.setJointLifeFlag(request.isJointLifeFlag());

        // Calculate telephone numbers
        String insuredPhoneNumber = request.getInsuredPhoneNumber();
        String policyholderPhoneNumber = request.getPolicyholderPhoneNumber();
        if (insuredPhoneNumber == null || insuredPhoneNumber.isEmpty() || policyholderPhoneNumber == null || policyholderPhoneNumber.isEmpty()) {
            response.setValid(false);
            response.setMessage("Telephone numbers are missing.");
            logger.error("Telephone numbers are missing.");
            return response;
        }
        response.setInsuredPhoneNumber(insuredPhoneNumber);
        response.setPolicyholderPhoneNumber(policyholderPhoneNumber);

        // Validate counter offer details for different types
        if (!validateCounterOfferTypes(request)) {
            response.setValid(false);
            response.setMessage("Counter offer type validation failed.");
            logger.error("Counter offer type validation failed.");
            return response;
        }

        // Perform product-specific validations
        if (!validateProductSpecificConditions(request)) {
            response.setValid(false);
            response.setMessage("Product-specific validation failed.");
            logger.error("Product-specific validation failed.");
            return response;
        }

        response.setValid(true);
        response.setMessage("Counter offer validation successful.");
        logger.info("Counter offer validation successful.");
        return response;
    }

    private static boolean validateCounterOfferTypes(CounterOfferValidationRequest request) {
        // Implement the logic to validate counter offer types such as CO_IP, CO_SA, CO_BTPT1, and CO_BTPT2
        // Ensure all necessary fields are populated and conditions are met
        // This is a placeholder for the actual implementation
        return true;
    }

    private static boolean validateProductSpecificConditions(CounterOfferValidationRequest request) {
        // Implement the logic to perform product-specific validations
        // Check cover codes, sum assured, benefit term, premium term, and other relevant parameters
        // This is a placeholder for the actual implementation
        return true;
    }
}
