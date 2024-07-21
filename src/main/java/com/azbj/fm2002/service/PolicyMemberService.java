package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.PolicyMemberRepository;
import com.azbj.fm2002.dto.*;
import com.azbj.fm2002.util.*;
import com.azbj.fm2002.exception.*;
import com.azbj.fm2002.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.*;

@Service
public class PolicyMemberService {

    @Autowired
    private PolicyMemberRepository policyMemberRepository;

    public PolicyMember addMember(PolicyMember memberDetails) {
        return policyMemberRepository.save(memberDetails);
    }

    public void deleteMember(Long memberId) {
        policyMemberRepository.deleteById(memberId);
    }

    public boolean validateMember(PolicyMember memberDetails) {
        // Implement validation logic based on business rules
        // Example: Check if all required fields are populated
        return memberDetails != null && memberDetails.getName() != null && !memberDetails.getName().isEmpty();
    }

    public void declineMember(Long memberId) {
        Optional<PolicyMember> memberOpt = policyMemberRepository.findById(memberId);
        if (memberOpt.isPresent()) {
            PolicyMember member = memberOpt.get();
            member.setStatus("Declined");
            policyMemberRepository.save(member);
        }
    }

    public PolicyMember loadMemberDetails(Long memberId) {
        return policyMemberRepository.findById(memberId).orElse(null);
    }

    public boolean queryHniPolicies() {
        // Implement logic to query HNI policies
        return true; // Placeholder return value
    }

    public boolean checkPreviousLapsePolicies() {
        // Implement logic to query the balic_history_details table
        return true; // Placeholder return value
    }

    public void updateWeightChange(double weightChange) {
        // Implement logic to update weight change value
    }

    public void updateFormStatus(String formStatus) {
        // Implement logic to update form status
    }

    public AgeProofDetails getAgeProofDetails(String proofType) {
        return policyMemberRepository.findAgeProofDetails(proofType);
    }

    public void deleteMember(String memberId) {
        policyMemberRepository.deleteFromCovers(memberId);
        policyMemberRepository.deleteFromFurtherRequirements(memberId);
        policyMemberRepository.deleteFromFcfLoadingDetails(memberId);
        policyMemberRepository.deleteFromBbuQuestions(memberId);
        policyMemberRepository.deleteFromPolicyMember(memberId);
    }

    public SumAssuredCalculationResponse calculateSumAssured(SumAssuredCalculationRequest request) {
        List<PolicyMember> policyMemberDetails = policyMemberRepository.fetchPolicyMemberDetails(request.getPartId());
        BigDecimal sumAssured = SumAssuredCalculationUtil.calculateSumAssured(policyMemberDetails, request.getInsuredDob(), request.getPremiumAmount(), request.getDateReceived());
        return new SumAssuredCalculationResponse(sumAssured);
    }

    public PolicyMemberDTO savePolicyMember(PolicyMemberDTO policyMember) {
        return policyMemberRepository.save(policyMember);
    }

    public Optional<PolicyMemberDTO> getPolicyMemberDetails(Long policyMemberId) {
        return policyMemberRepository.findById(policyMemberId);
    }

    public void declineMember(String memberId) {
        policyMemberRepository.deleteById(memberId);
        policyMemberRepository.deleteByMemberId(memberId);
        policyMemberRepository.save(new FcfDeclineMember(memberId));
        policyMemberRepository.deleteByMemberId(memberId);
    }

    public void updateLateralShiftStatus(LateralShiftDTO lateralShiftDTO) {
        List<LateralShiftRecord> records = policyMemberRepository.findLateralShiftRecords(lateralShiftDTO.getPartnerId());
        for (LateralShiftRecord record : records) {
            if (lateralShiftDTO.isChecked()) {
                policyMemberRepository.saveLateralShiftRecord(record);
            } else {
                policyMemberRepository.deleteLateralShiftRecord(record);
            }
        }
    }

    public void transferMemberLoadingDetails() {
        List<PolicyMember> policyMembers = policyMemberRepository.findPolicyMemberRecords();
        List<LoadingDetails> loadingDetails = policyMemberRepository.findLoadingDetailsRecords();
        for (PolicyMember member : policyMembers) {
            boolean exists = loadingDetails.stream().anyMatch(ld -> ld.getIpNumber().equals(member.getIpNumber()));
            if (!exists && !Arrays.asList("Son", "Daughter", "Child").contains(member.getRelation())) {
                LoadingDetails newRecord = new LoadingDetails(member.getIpNumber(), member.getName(), member.getPartId(), member.getRelation(), "L066A01", "Bajaj Allianz Family CareFirst Main Benefit");
                policyMemberRepository.saveLoadingDetailsRecord(newRecord);
            }
        }
    }

    public PolicyMemberValidationResponse validateAndCalculateWeight(PolicyMemberValidationRequest request) {
        boolean isValidWeight = PolicyMemberValidationUtil.validateWeight(request.getWeight());
        if (!isValidWeight) {
            throw new AddMemberException("Invalid weight");
        }
        double bmi = PolicyMemberValidationUtil.calculateBMI(request.getWeight(), request.getHeight());
        return new PolicyMemberValidationResponse(bmi);
    }

    public List<AgeProofType> fetchValidAgeProofTypes() {
        return policyMemberRepository.findValidAgeProofTypes();
    }

    public ValidationResponse validateAgeProof(String ageProof, String agentCode) {
        Agent agent = policyMemberRepository.findAgentByCode(agentCode);
        if ("SYBM".equals(ageProof) && !agent.getCode().startsWith("522")) {
            return new ValidationResponse(false, "Syndicate Bank BM Certificate is allowed only for Syndicate Bank");
        }
        return new ValidationResponse(true, "Valid age proof");
    }

    public AddMemberResponse addMember(AddMemberRequest request) {
        boolean isValid = AddMemberUtil.validateMemberDetails(request);
        if (!isValid) {
            throw new AddMemberException("Invalid member details");
        }
        PolicyMember member = new PolicyMember();
        member.setName(request.getName());
        member.setRelation(request.getRelation());
        member.setCoverCode(request.getCoverCode());
        member.setIpNumber(request.getIpNumber());
        policyMemberRepository.save(member);
        return new AddMemberResponse(member.getId());
    }

    public boolean validateBMI(BMIData bmiData) {
        boolean isValid = PolicyMemberValidationUtil.validateBMI(bmiData);
        return isValid;
    }

    public HeightValidationResponse validateHeight(HeightValidationRequest request) {
        return policyMemberRepository.validateHeight(request);
    }
}