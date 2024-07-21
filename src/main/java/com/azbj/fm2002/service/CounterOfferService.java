package com.azbj.fm2002.service;

import com.azbj.fm2002.dto.CounterOfferDTO;
import com.azbj.fm2002.dto.CounterOfferRequest;
import com.azbj.fm2002.dto.CounterOfferResponse;
import com.azbj.fm2002.dto.CounterOfferValidationRequest;
import com.azbj.fm2002.dto.CounterOfferValidationResponse;
import com.azbj.fm2002.repository.CounterOfferRepository;
import com.azbj.fm2002.util.CounterOfferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterOfferService {

    @Autowired
    private CounterOfferRepository counterOfferRepository;

    @Autowired
    private CounterOfferUtil counterOfferUtil;

    public String processCounterOffer(CounterOfferDTO counterOfferDetails) {
        // Validate the counter offer details
        validateCounterOfferDetails(counterOfferDetails);

        // Save the counter offer details to the database
        counterOfferRepository.saveCounterOfferDetails(counterOfferDetails);

        // Create a JSON object for PDF generation
        String jsonObject = createJsonObject(counterOfferDetails);

        // Call external API to generate the PDF
        boolean isPdfGenerated = counterOfferUtil.createPDF(jsonObject);

        // Enable the 'Submit' button if PDF generation is successful
        if (isPdfGenerated) {
            return "Counter offer letter generated successfully.";
        } else {
            throw new RuntimeException("Failed to generate counter offer letter.");
        }
    }

    private void validateCounterOfferDetails(CounterOfferDTO counterOfferDetails) {
        // Implement validation logic here
    }

    private String createJsonObject(CounterOfferDTO counterOfferDetails) {
        // Implement JSON object creation logic here
        return "{}";
    }

    public Object checkProductAndGroupStatus(String productId, String groupId) {
        return counterOfferRepository.findProductAndGroupStatus(productId, groupId);
    }

    public CounterOfferResponse submitCounterOffer(CounterOfferRequest request) {
        // Check for existing offers
        int existingOffersCount = counterOfferRepository.checkExistingOffers(request.getPolicyRef());

        // Update existing offers if they exist
        if (existingOffersCount > 0) {
            counterOfferRepository.updateExistingOffers(request.getPolicyRef());
        }

        // Insert new offer
        counterOfferRepository.insertNewOffer(request);

        // Commit the transaction and return response
        return new CounterOfferResponse("Counter offer modified successfully.");
    }

    public CounterOfferValidationResponse validateCounterOffer(CounterOfferValidationRequest request) {
        return counterOfferRepository.findCounterOfferDetails(request);
    }

    public CounterOfferValidationResponse modifyCounterOfferType(String selectedOfferType) {
        // Check if the product is of type 'ULIP' or 'GROUP'
        if ("ULIP".equals(selectedOfferType) || "GROUP".equals(selectedOfferType)) {
            throw new CounterOfferValidationException("Cannot modify counter offer for ULIP/GROUP cases.");
        }

        // Check if the selected counter offer type is 'CO_IP'
        if ("CO_IP".equals(selectedOfferType)) {
            throw new CounterOfferValidationException("Please select a different counter offer type.");
        }

        // Check for duplicate counter offers
        boolean isDuplicate = counterOfferRepository.findDuplicateCounterOffer(selectedOfferType);
        if (isDuplicate) {
            throw new CounterOfferValidationException("Duplicate counter offer type found.");
        }

        // Return predefined values for valid counter offer type
        return new CounterOfferValidationResponse("Valid counter offer type.");
    }
}
