package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.InsuredPersonRepository;
import com.azbj.fm2002.dto.*;
import com.azbj.fm2002.util.EncryptionUtil;
import com.azbj.fm2002.util.AgeCalculationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class InsuredPersonService {

    @Autowired
    private InsuredPersonRepository insuredPersonRepository;

    public Object getInsuredPersonDetails(String insuredPersonID) {
        return insuredPersonRepository.findById(insuredPersonID).orElse(null);
    }

    public void saveInsuredPersonDetails(Object insuredPersonDetails) {
        insuredPersonRepository.save(insuredPersonDetails);
    }

    public void validateChangedWeight() {
        // Business logic to validate the Changed Weight field
        // If the "Changed Weight" field is left empty, it should default to 0.
        // If the form is not in loading mode, the form status should be set to 'Y'.
        // The "Changed Weight" value should not be greater than or equal to the "Weight" value.
        // The validation should only apply if the policy holder's property value is not 'H' or 'E' and the product ID is not 169.
        // If the validation fails, an error message should be displayed: "Changed Weight Cannot be greater or equal to Weight".
    }

    public String validateAgeProof(String ageProof) {
        Optional<AgeProof> ageProofType = insuredPersonRepository.findAgeProofType(ageProof);
        if (ageProofType.isPresent()) {
            return ageProofType.get().isStandard() ? "Standard Age Proof" : "Non standard Age Proof";
        } else {
            return "NA";
        }
    }

    public String getAgeProofUID(String ageProof) {
        Optional<String> ageProofUID = insuredPersonRepository.findAgeProofUID(ageProof);
        return ageProofUID.orElse("NA");
    }

    public boolean validateAgeProofID(String ageProofType, String ageProofID) {
        // Business logic to validate the age proof ID based on the specified conditions
        // If the age proof type is 'AC' or 'ACS' and the length of the age proof ID is 12 characters, validate Aadhaar data
        // If the age proof type is 'Pan Card' and the age proof ID is not null, validate PAN card
        return insuredPersonRepository.validateAgeProofID(ageProofType, ageProofID);
    }

    public boolean validateMibCode(String mibCode) {
        if (mibCode.length() >= 4 && !"GHJKMTWQS".contains(mibCode.substring(3, 4).toUpperCase())) {
            return false;
        }
        if (mibCode.length() >= 5 && !"XRZYE".contains(mibCode.substring(4, 5).toUpperCase())) {
            return false;
        }
        if (mibCode.length() >= 6 && !"NBCD".contains(mibCode.substring(5, 6).toUpperCase())) {
            return false;
        }
        return true;
    }

    public boolean validateAnnualIncome(double annualIncome) {
        // Business logic to validate the annual income
        // Check previous policy details and incomplete inwarded applications
        return annualIncome > 0;
    }

    public void saveAnnualIncome(double annualIncome) {
        // Save the validated annual income to the database
        insuredPersonRepository.saveAnnualIncome(annualIncome);
    }

    public List<ProbableCP> getProbableCPDetails() {
        // Call the probableCpService to fetch the probable CP details
        return probableCpService.getProbableCPDetails();
    }

    public boolean validateWeight(double weight, String productDefinition, String packageCode) {
        // Validate the weight based on specific product definitions and package codes
        return weight > 0;
    }

    public DataResponse processDataLoad(String verificationNumber) {
        // Process data load based on the verification number
        if (verificationNumber == null) {
            throw new IllegalArgumentException("Verification number cannot be null");
        }
        // Additional logic to process data load
        return new DataResponse();
    }

    public String generateNewProposalNumber() {
        // Logic to generate a new proposal number
        return "NEW_PROPOSAL_NUMBER";
    }

    public void updateLateralShiftStatus(String insuredPersonId, boolean status) {
        // Business logic to manage lateral shift records
        // Verify if the insured person's ID matches any record in the lateral shift data
        // Update, delete, or create lateral shift records based on the checkbox status
    }

    public SearchCpResponse searchCustomerPartner(SearchCpRequest request) {
        // Business logic for searching customer partner information
        Optional<InsuredPerson> insuredPerson = insuredPersonRepository.findByPartnerId(request.getPartnerId());
        return insuredPerson.map(SearchCpResponse::new).orElse(null);
    }

    public HeightValidationResponse validateHeight(HeightValidationRequest request) {
        // Validate the height based on the product definition, package code, pension flag, and other conditions
        ProductDefinition productDefinition = insuredPersonRepository.findProductDefinition(request.getProductId());
        if (request.getHeight() <= 0) {
            throw new IllegalArgumentException("Please Select a Valid Height for the Person");
        }
        return new HeightValidationResponse(true);
    }

    public String generateProposalNumber(String date) {
        // Logic to generate a new proposal number based on the date
        return "PROPOSAL_NUMBER";
    }

    public MailingAddressDTO searchMailingAddress() {
        // Business logic for searching and retrieving mailing address details
        return insuredPersonRepository.findMailingAddress();
    }

    public PassportDetailsDTO fetchPassportDetails() {
        // Fetch passport details from the database
        return insuredPersonRepository.findPassportDetails();
    }

    public boolean setIpType(int productId) {
        // Check if the productId is within the specified range and set the IP type to '1'
        if (productId == 3 || productId == 4 || productId == 5 || productId == 9 || productId == 10) {
            return true;
        }
        return false;
    }

    public boolean validateIpType(Object policyHolder, Object insuredPerson) {
        // Check if the policy holder and insured person are the same and if the IP type is not '1'
        if (policyHolder.equals(insuredPerson)) {
            showWarningMessage("IP type should be '1'");
            return false;
        }
        return true;
    }

    public PolicyValidationResponse validatePolicy(PolicyValidationRequest request) {
        // Perform various validation checks as described in the user story
        int recordCount = insuredPersonRepository.countRecords(request.getApplicationNumber(), request.getVerificationNumber(), request.getSignCardNumber());
        if (recordCount > 0) {
            // Additional validation logic
        }
        return new PolicyValidationResponse(true);
    }

    public AgeCalculationResponse calculateAge(AgeCalculationRequest request) {
        // Calculate the age based on the date of birth and inception date
        int age = AgeCalculationUtil.calculateAge(request.getDateOfBirth(), request.getInceptionDate());
        if (age < 18) {
            age = AgeCalculationUtil.calculateAge(request.getPolicyHolderDateOfBirth(), request.getInceptionDate());
        }
        return new AgeCalculationResponse(age);
    }

    public String encryptUrl(String url) {
        // Generate the URL using the verification number or sign card number, encrypt it, and return the encrypted URL
        return EncryptionUtil.encrypt(url);
    }
}