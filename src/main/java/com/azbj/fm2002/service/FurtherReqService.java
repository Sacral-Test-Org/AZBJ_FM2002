package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.FurtherReqRepository;
import com.azbj.fm2002.repository.AzbjSystemConstantsRepository;
import com.azbj.fm2002.dto.WNrFurDTO;
import com.azbj.fm2002.dto.ReceiptStatusValidationRequest;
import com.azbj.fm2002.dto.ReceiptStatusValidationResponse;
import com.azbj.fm2002.dto.FurtherReqDTO;
import com.azbj.fm2002.dto.IncomeTaxDeclarationRequest;
import com.azbj.fm2002.dto.IncomeTaxDeclarationResponse;
import com.azbj.fm2002.dto.LOVData;
import com.azbj.fm2002.dto.ReqNoDTO;
import com.azbj.fm2002.dto.FurtherReqResponse;
import com.azbj.fm2002.exception.ReceiptStatusValidationException;
import com.azbj.fm2002.util.ReceiptStatusValidationUtil;
import com.azbj.fm2002.model.FurtherReq;
import com.azbj.fm2002.model.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FurtherReqService {

    @Autowired
    private FurtherReqRepository furtherReqRepository;

    @Autowired
    private AzbjSystemConstantsRepository azbjSystemConstantsRepository;

    public void saveFormData(FurtherReq formData) {
        furtherReqRepository.save(formData);
    }

    public boolean checkFieldStatus(String fieldName) {
        return furtherReqRepository.findByFieldName(fieldName);
    }

    public boolean validateRequestNumber(String requestNumber) {
        List<AzbjSystemConstants> constants = azbjSystemConstantsRepository.findBySysTypeAndDateRange("FR_REQ", new Date());
        return constants.stream().anyMatch(constant -> constant.getSysCode().equals(requestNumber));
    }

    public Date fetchCurrentDate() {
        return new Date();
    }

    public Date fetchExternalDate() {
        // Call to external API to fetch the date
        return new Date(); // Placeholder for actual external API call
    }

    public List<ReqNoDTO> fetchReqNoData() {
        return azbjSystemConstantsRepository.findReqNoData();
    }

    public String validateFRResRecd(WNrFurDTO wNrFurDTO) {
        if ("Y".equals(wNrFurDTO.getFrResRecd()) || "N".equals(wNrFurDTO.getFrResRecd())) {
            wNrFurDTO.setFrReqRaisedBy("currentUserId"); // Replace with actual user ID
            return "Valid";
        } else {
            return "Invalid FR_RES_RECD value";
        }
    }

    public String processKeyDown(WNrFurDTO wNrFurDTO) {
        if ("Y".equals(wNrFurDTO.getFrResRecd()) || "N".equals(wNrFurDTO.getFrResRecd())) {
            furtherReqRepository.azbjWaivedRequirements(wNrFurDTO);
            furtherReqRepository.delete(wNrFurDTO);
            return "Record deleted";
        } else {
            return "Invalid FR_RES_RECD value";
        }
    }

    public String processKeyUp(WNrFurDTO wNrFurDTO) {
        if ("Y".equals(wNrFurDTO.getFrResRecd()) || "N".equals(wNrFurDTO.getFrResRecd())) {
            furtherReqRepository.azbjWaivedRequirements(wNrFurDTO);
            furtherReqRepository.delete(wNrFurDTO);
            return "Record deleted";
        } else {
            return "Invalid FR_RES_RECD value";
        }
    }

    public ResponseEntity<?> checkAndPopulateFrarDetails() {
        int primaryCount = furtherReqRepository.getPrimaryFrarCount();
        int secondaryCount = furtherReqRepository.getSecondaryFrarCount();
        if (primaryCount > secondaryCount) {
            furtherReqRepository.populateSecondaryFrarDetails();
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Primary FRAR count is not greater than secondary FRAR count");
        }
    }

    public List<String> fetchLOVData() {
        return furtherReqRepository.fetchLOVData();
    }

    public List<Requirement> fetchRcuRequirements(String applicationNo) {
        List<String> alternateReqs = furtherReqRepository.findDistinctAlternateReqs(applicationNo);
        List<Requirement> requirements = new ArrayList<>();
        for (String req : alternateReqs) {
            Optional<String> desc = furtherReqRepository.findSysDesc(req);
            Requirement requirement = new Requirement();
            requirement.setReqType(req);
            requirement.setReqDesc(desc.orElse(""));
            requirements.add(requirement);
        }
        return requirements;
    }

    public void validateIpType(int productId, boolean isSamePerson) {
        List<Integer> productIds = Arrays.asList(3, 4, 5, 9, 10, 12, 14, 16, 20, 23, 24, 25, 31, 32, 33, 34, 37, 49, 50);
        if (productIds.contains(productId)) {
            // Set IP Type to 1
        }
        if (isSamePerson) {
            // Display warning message
            furtherReqRepository.updateValidationVariable(true);
        }
    }

    public Date getSpecificDate() {
        return furtherReqRepository.fetchSpecificDate();
    }

    public boolean checkGlobalCondition() {
        // Check global condition related to rule confidence
        return true; // Placeholder
    }

    public void setLOV(boolean flag) {
        List<LOV> lovList = furtherReqRepository.fetchLOV(flag);
        // Set LOV
    }

    public void resetFields() {
        // Reset fields
    }

    public List<LOV> fetchLOVValues(String phonePeFlag) {
        return furtherReqRepository.findLOVValues(phonePeFlag);
    }

    public boolean validateRequirement(long requirementId) {
        Optional<Requirement> requirement = furtherReqRepository.findById(requirementId);
        return requirement.isPresent();
    }

    public void deleteRequirement(long requirementId) {
        furtherReqRepository.deleteById(requirementId);
    }

    public ReceiptStatusValidationResponse validateReceiptStatus(ReceiptStatusValidationRequest request) {
        UserAndStatus userAndStatus = furtherReqRepository.findUserAndStatus(request.getContractId(), request.getTestNumber());
        if (!"currentUserId".equals(userAndStatus.getUserId()) && "Y".equals(request.getReceiptStatus())) {
            throw new ReceiptStatusValidationException("Request cannot be marked as received by another user manually");
        }
        if ("Y".equals(request.getReceiptStatus())) {
            request.setReceivedDate(new Date());
        } else {
            request.setReceivedDate(null);
        }
        if ("M393".equals(request.getTestNumber()) && "N".equals(request.getReceiptStatus())) {
            // Navigate to SEC_FRAR_REQ block and update fields
        }
        if ("M592".equals(request.getTestNumber()) && "N".equals(request.getReceiptStatus())) {
            int questionCount = furtherReqRepository.checkActiveQuestions(request.getPolicyNo(), request.getContractId());
            if (questionCount == 0) {
                throw new ReceiptStatusValidationException("Enter underwriting requirement questions");
            }
        }
        if ("Y".equals(request.getReceiptStatus()) && !"M548".equals(request.getTestNumber())) {
            int count = furtherReqRepository.checkTestNumberInSystemConstants(request.getTestNumber());
            if (count > 0) {
                int approvalCount = furtherReqRepository.checkApprovedStatusInApprovalCases(request.getApplicationNo());
                if (approvalCount == 0) {
                    request.setReceiptStatus("N");
                }
            }
        }
        if ("Y".equals(request.getReceiptStatus()) && "M675".equals(request.getTestNumber()) && !"2000002995".equals(request.getAgentCode())) {
            String consentInfo = ReceiptStatusValidationUtil.validateConsentInformation(request.getApplicationNo(), "consentPartId", request.getAgentCode(), "productId");
            if ("NR".equals(consentInfo)) {
                request.setReceiptStatus("N");
                throw new ReceiptStatusValidationException("Request cannot be marked as received due to consent information");
            }
        }
        if ("Y".equals(request.getReceiptStatus()) && "M675".equals(request.getTestNumber()) && !"2000002995".equals(request.getAgentCode())) {
            // Set received flag for M675 to Y
        }
        return new ReceiptStatusValidationResponse(request);
    }

    public IncomeTaxDeclarationResponse processDeclaration(IncomeTaxDeclarationRequest request) {
        List<FurtherReq> furtherReqs = furtherReqRepository.findByTestNumber("M682");
        boolean mandFlag = furtherReqs.stream().anyMatch(req -> "M682".equals(req.getTestNumber()));
        boolean reqFlag = furtherReqs.stream().anyMatch(req -> "M711".equals(req.getTestNumber()));
        if (mandFlag) {
            // Create parameter list and call AZBJ_INCOMETAX_QUEST_DTLS form
        } else {
            throw new RuntimeException("Declaration under Income Tax Rules 2015 not received");
        }
        return new IncomeTaxDeclarationResponse();
    }

    public FurtherReqDTO addTestRequirement(FurtherReqDTO testRequirement) {
        FurtherReq savedReq = furtherReqRepository.save(testRequirement.toEntity());
        return new FurtherReqDTO(savedReq);
    }

    public void deleteTestRequirement(Long testId) {
        furtherReqRepository.deleteById(testId);
    }

    public List<FurtherReqDTO> getTestRequirements() {
        List<FurtherReq> reqs = furtherReqRepository.findAll();
        return reqs.stream().map(FurtherReqDTO::new).collect(Collectors.toList());
    }

    public boolean validateTestNumber(String testNumber) {
        return furtherReqRepository.findByTestNumber(testNumber).isPresent();
    }

    public FurtherReqDTO markAsReceived(Long testId) {
        Optional<FurtherReq> reqOpt = furtherReqRepository.findById(testId);
        if (reqOpt.isPresent()) {
            FurtherReq req = reqOpt.get();
            req.setReceivedStatus("Y");
            req.setDateReceived(new Date());
            FurtherReq savedReq = furtherReqRepository.save(req);
            return new FurtherReqDTO(savedReq);
        } else {
            throw new RuntimeException("Test requirement not found");
        }
    }

    public boolean checkMaritalStatus(String maritalStatus) {
        return "W".equals(maritalStatus) || "M".equals(maritalStatus) || "D".equals(maritalStatus) || "N".equals(maritalStatus);
    }

    public void navigateToFurtherReqBlock() {
        // Navigate to Further Requirements block
    }

    public void createOrUpdateRecord(String testNumber, String description, Date dateCalled, String raisedBy) {
        Optional<FurtherReq> reqOpt = furtherReqRepository.findByTestNumber(testNumber);
        if (!reqOpt.isPresent()) {
            FurtherReq req = new FurtherReq();
            req.setTestNumber(testNumber);
            req.setDescription(description);
            req.setDateCalled(dateCalled);
            req.setRaisedBy(raisedBy);
            furtherReqRepository.save(req);
        }
    }

    public void deleteRecord(String testNumber) {
        furtherReqRepository.deleteByTestNumber(testNumber);
    }

    public List<LOVData> fetchLOVData() {
        return furtherReqRepository.getLOVData();
    }

    public List<FurtherRequirement> fetchFurtherRequirements() {
        return furtherReqRepository.findFurtherRequirements();
    }

    public void deleteRequirement(Long testNo) {
        if (furtherReqRepository.isWipContinue()) {
            if (furtherReqRepository.existsByTestNo(testNo)) {
                furtherReqRepository.deleteByTestNo(testNo);
            }
        }
        furtherReqRepository.deleteByTestNo(testNo);
    }

    public void synchronizeRecords() {
        List<FurtherReq> tFurtherReqs = furtherReqRepository.findAllTFurtherReqs();
        for (FurtherReq tReq : tFurtherReqs) {
            Optional<FurtherReq> reqOpt = furtherReqRepository.findRecordByTestNumber(tReq.getTestNumber());
            if (reqOpt.isPresent()) {
                FurtherReq req = reqOpt.get();
                req.setDateCalled(tReq.getDateCalled());
                req.setResultReceived(tReq.getResultReceived());
                req.setDateReceived(tReq.getDateReceived());
                req.setIpType(tReq.getIpType());
                furtherReqRepository.save(req);
            } else {
                furtherReqRepository.save(tReq);
            }
        }
    }

    public List<FurtherReqResponse> getFurtherRequirements() {
        return furtherReqRepository.findFurtherRequirements();
    }

    public List<LOVData> fetchLOVData() {
        return furtherReqRepository.executeLOVQuery();
    }
}