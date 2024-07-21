package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.AmlRepository;
import com.azbj.fm2002.dto.AmlDetailsDTO;
import com.azbj.fm2002.dto.PanDetailsDTO;
import com.azbj.fm2002.dto.ValidationResponse;
import com.azbj.fm2002.util.AmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmlService {

    @Autowired
    private AmlRepository amlRepository;

    @Autowired
    private AmlUtil amlUtil;

    public List<String> fetchProofTypes() {
        return amlRepository.findProofTypes();
    }

    public List<String> fetchProofDescriptions() {
        return amlRepository.findProofDescriptions();
    }

    public AmlDetailsDTO populateAmlDetails() {
        List<String> proofTypes = amlRepository.findActiveProofTypes();
        String partnerId = "somePartnerId"; // This should be dynamically fetched based on context
        String contractId = amlRepository.findContractId(partnerId);
        int amlRecordCount = amlRepository.countAmlRecords(contractId);
        String policyRef = amlRepository.findPolicyRef(contractId);
        List<AmlDetailsDTO> amlRecords = amlRepository.findAmlRecords(contractId);

        if (amlRecords.isEmpty()) {
            throw new RuntimeException("No AML details are present for the policy.");
        }

        // Assuming we return the first record for simplicity
        return amlRecords.get(0);
    }

    public String fetchDocumentType() {
        return amlRepository.findDocumentType();
    }

    public String fetchChkEditAml() {
        return amlRepository.findChkEditAml();
    }

    public ValidationResponse validateAmlDetails(Object amlValidationRequest) {
        String productId = "someProductId"; // This should be dynamically fetched based on context
        Object productDefinition = amlRepository.findProductDefinitions(productId);
        double totalPremium = amlUtil.calculateTotalPremium(amlValidationRequest);

        // Perform validation logic here
        ValidationResponse response = new ValidationResponse();
        response.setValid(totalPremium > 10000);
        return response;
    }

    public String getChkEditAmlStatus() {
        return amlRepository.getChkEditAmlStatus();
    }

    public ValidationResponse validateDocumentId(String documentId) {
        return amlRepository.validateDocumentId(documentId);
    }

    public List<PanDetailsDTO> getPanDetails() {
        return amlRepository.findAll();
    }
}
