package com.azbj.fm2002.service;

import com.azbj.fm2002.dto.BeneficiaryTrusteeInfo;
import com.azbj.fm2002.dto.DobValidationRequest;
import com.azbj.fm2002.dto.DobValidationResponse;
import com.azbj.fm2002.exception.DobValidationException;
import com.azbj.fm2002.repository.MwpActRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MwpActService {

    @Autowired
    private MwpActRepository mwpActRepository;

    public void saveBeneficiaryTrusteeInfo(BeneficiaryTrusteeInfo info) {
        // Validate mandatory fields
        if (info.getBeneficiaryName() == null) {
            throw new IllegalArgumentException("At least one beneficiary is mandatory");
        }
        if (info.getTrusteeName() == null) {
            throw new IllegalArgumentException("At least one Trustee is mandatory");
        }
        if (info.getWitnessName() == null) {
            throw new IllegalArgumentException("Witness name cannot be null");
        }

        // Delete existing records for the given contract ID
        mwpActRepository.deleteByContractId(info.getContractId());

        // Insert new records
        mwpActRepository.save(info);

        // Display success message and clear form fields
        System.out.println("Saved Successfully");
    }

    public DobValidationResponse validateDOB(DobValidationRequest request) {
        // Fetch the opus date from the repository
        Date opusDate = mwpActRepository.getOpusDate();

        // Compare the DOB from the request with the opus date
        if (!request.getDob().before(opusDate)) {
            throw new DobValidationException("The Date of birth cannot be same as or greater than opus date");
        }

        // Return a successful response
        return new DobValidationResponse(true);
    }
}
