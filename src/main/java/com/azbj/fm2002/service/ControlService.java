package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.ControlRepository;
import com.azbj.fm2002.repository.AzbjSystemConstantsRepository;
import com.azbj.fm2002.repository.SurrogateProofDetailsRepository;
import com.azbj.fm2002.dto.HoAllocationListDTO;
import com.azbj.fm2002.dto.ScrutinyFailureRequest;
import com.azbj.fm2002.dto.ScrutinyFailureResponse;
import com.azbj.fm2002.dto.SurrogateProofDetailsDTO;
import com.azbj.fm2002.entity.ControlItem;
import com.azbj.fm2002.entity.ReinsuranceData;
import com.azbj.fm2002.entity.SurrogateProofDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControlService {

    @Autowired
    private ControlRepository controlRepository;

    @Autowired
    private AzbjSystemConstantsRepository azbjSystemConstantsRepository;

    @Autowired
    private SurrogateProofDetailsRepository surrogateProofDetailsRepository;

    public List<ControlItem> getControlItems() {
        return controlRepository.findAll();
    }

    public void saveControlItems(List<ControlItem> controlItems) {
        controlRepository.saveAll(controlItems);
    }

    public void populateAutoReinsurance() {
        controlRepository.populateAutoReinsurance();
    }

    public void updateFormStatus(String formId, String status) {
        controlRepository.updateFormStatus(formId, status);
    }

    public List<String> fetchRejectionReasons() {
        return azbjSystemConstantsRepository.findRejectionReasons();
    }

    public List<HoAllocationListDTO> fetchHoAllocationList() {
        return controlRepository.findActiveHoAllocationList();
    }

    public boolean validateHoAllocationList(String selectedValue) {
        return controlRepository.findHoAllocationByValue(selectedValue) != null;
    }

    public String initiateReinsuranceProcess() {
        ReinsuranceData data = controlRepository.fetchReinsuranceData();
        if (data.getCoverageAmount() <= 25000000) {
            controlRepository.clearReinsuranceRecords();
            return "AUTO";
        } else {
            controlRepository.enableReinsuranceCodeValidation();
            return "FACULTATIVE";
        }
    }

    public List<String> fetchDoctorCodes() {
        return controlRepository.findDoctorCodes();
    }

    public String getBILink(String agentBiNumber) {
        String biLink = azbjSystemConstantsRepository.findBILink();
        if (biLink != null && agentBiNumber != null) {
            return biLink + agentBiNumber;
        } else {
            throw new RuntimeException("BI link or agent BI number is null");
        }
    }

    public void deleteRelatedRecords(String contractId) {
        controlRepository.deleteByContractId(contractId);
    }

    public ScrutinyFailureResponse validateApplicationNumber(ScrutinyFailureRequest request) {
        boolean isValidAppNumber = controlRepository.findApplicationNumber(request.getApplicationNumber());
        boolean isAuthorizedUser = controlRepository.findUserId(request.getUserId());
        ScrutinyFailureResponse response = new ScrutinyFailureResponse();
        response.setValidAppNumber(isValidAppNumber);
        response.setAuthorizedUser(isAuthorizedUser);
        return response;
    }

    public SurrogateProofDetailsEntity manageSurrogateProofDetails(SurrogateProofDetailsDTO dto) {
        SurrogateProofDetailsEntity entity = new SurrogateProofDetailsEntity();
        entity.setProofType(dto.getProofType());
        entity.setProofDescription(dto.getProofDescription());
        entity.setFieldValue(dto.getFieldValue());
        entity.setDocumentDate(dto.getDocumentDate());
        entity.setDerivedIncome(dto.getDerivedIncome());
        entity.setDerivedTasaValue(dto.getDerivedTasaValue());
        return surrogateProofDetailsRepository.save(entity);
    }
}
