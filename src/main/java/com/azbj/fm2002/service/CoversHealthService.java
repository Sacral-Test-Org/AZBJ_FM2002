package com.azbj.fm2002.service;

import com.azbj.fm2002.util.CalculationUtil;
import com.azbj.fm2002.repository.CoversHealthRepository;
import com.azbj.fm2002.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoversHealthService {

    @Autowired
    private CalculationUtil calculationUtil;

    @Autowired
    private CoversHealthRepository coversHealthRepository;

    private int globalEntryAge;
    private double globalSumInsured;

    public EntryAgeValidationResponse validateEntryAge(EntryAgeValidationRequest request) {
        EntryAgeValidationResponse response = calculationUtil.validateEntryAge(request);
        if (response.isValid()) {
            globalEntryAge = request.getEntryAge();
            // Update main cover entry age logic here
        }
        return response;
    }

    public TermsCalculationResponse calculateTerms(TermsCalculationRequest request) {
        TermsCalculationResponse response = calculationUtil.calculateTerms(request);
        if (request.isChildCareProduct()) {
            int benefitTerm = request.getPackageMaturityDate() - globalEntryAge;
            int premiumTerm = 18 - globalEntryAge;
            response.setBenefitTerm(benefitTerm);
            response.setPremiumTerm(premiumTerm);
        }
        return response;
    }

    public CoversHealthValidationResponse validateSumInsured(CoversHealthValidationRequest request) {
        Cover cover = coversHealthRepository.findCoverById(request.getCoverId());
        if (cover != null) {
            globalSumInsured = cover.getSumInsured();
            // Update main cover sum insured logic here
            // Disable commit and exit buttons logic here
        }
        return new CoversHealthValidationResponse(globalSumInsured);
    }

    public void navigateToNextItem(Long currentCoverId) {
        Cover currentCover = coversHealthRepository.findCoverById(currentCoverId);
        if (currentCover != null && "R014A01".equals(currentCover.getCoverCode())) {
            double storedValue = currentCover.getSumInsured();
            Cover nextCover = coversHealthRepository.findNextCover(currentCoverId);
            if (nextCover != null && "R015A01".equals(nextCover.getCoverCode())) {
                double calculatedSumInsured = (storedValue / 30000) * 1250;
                nextCover.setSumInsured(calculatedSumInsured);
                coversHealthRepository.save(nextCover);
                // Move back to previous record logic here
            }
        }
    }
}