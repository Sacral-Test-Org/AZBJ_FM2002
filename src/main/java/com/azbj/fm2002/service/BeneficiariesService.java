package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.BeneficiariesRepository;
import com.azbj.fm2002.model.BeneficialOwner;
import com.azbj.fm2002.model.NomineeDetails;
import com.azbj.fm2002.model.ValidationResponse;
import com.azbj.fm2002.exception.BeneficialOwnerValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BeneficiariesService {

    @Autowired
    private BeneficiariesRepository beneficiariesRepository;

    public void saveGender(String gender) {
        beneficiariesRepository.save(gender);
    }

    public String getGender() {
        return beneficiariesRepository.findGender();
    }

    public void deleteNominee(Long nomineeId) {
        beneficiariesRepository.deleteNominee(nomineeId);
    }

    public List<String> fetchNomineeDetails() {
        return beneficiariesRepository.findNomineeDetails();
    }

    public int calculateEntryAge(Date beneficiaryDOB, Date policyInceptionDate) {
        long ageInMillis = policyInceptionDate.getTime() - beneficiaryDOB.getTime();
        return (int) (ageInMillis / (1000L * 60 * 60 * 24 * 365));
    }

    public boolean validateProductType(int productId) {
        int[] validProductIds = {14, 31, 32, 33, 34, 49, 50};
        for (int id : validProductIds) {
            if (id == productId) {
                return true;
            }
        }
        return false;
    }

    public boolean validateDOB(Date dateOfBirth) {
        long ageInMillis = new Date().getTime() - dateOfBirth.getTime();
        int age = (int) (ageInMillis / (1000L * 60 * 60 * 24 * 365));
        return age >= 18;
    }

    public void disableFormActions(String premiumFrequency) {
        if (premiumFrequency != null) {
            // Logic to disable commit and exit actions on the form
        }
    }

    public List<NomineeDetails> fetchNomineeDetails(String applicationNo, String proposalNo) {
        return beneficiariesRepository.findNomineeDetails(applicationNo, proposalNo);
    }

    public void saveNomineeDetails(List<NomineeDetails> nomineeDetails) {
        beneficiariesRepository.saveAll(nomineeDetails);
    }

    public boolean validateAppointeeName(String appointeeName) {
        return beneficiariesRepository.findAppointeeByName(appointeeName) != null;
    }

    public List<BeneficiaryTrusteeDTO> retrieveBeneficiaryTrusteeRecords(String contractId) {
        return beneficiariesRepository.findByContractId(contractId);
    }

    public ValidationResponse validateBeneficialOwnerRecord(BeneficialOwner beneficialOwner) {
        if (beneficialOwner.getName() == null || beneficialOwner.getShares() == null || beneficialOwner.getIdentificationProof() == null ||
            beneficialOwner.getIdentificationDocument() == null || beneficialOwner.getIdentificationDate() == null ||
            beneficialOwner.getAddressProof() == null || beneficialOwner.getAddressId() == null ||
            beneficialOwner.getAddressDate() == null || beneficialOwner.getAddress() == null ||
            beneficialOwner.getDateOfBirth() == null) {
            throw new BeneficialOwnerValidationException("Please enter all details.");
        }
        return new ValidationResponse(true, "Validation successful");
    }
}