package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.PolicyMemberService;
import com.azbj.fm2002.dto.*;
import com.azbj.fm2002.model.PolicyMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policy-members")
public class PolicyMemberController {

    @Autowired
    private PolicyMemberService policyMemberService;

    @PostMapping("/add")
    public ResponseEntity<PolicyMember> addMember(@RequestBody PolicyMember memberDetails) {
        PolicyMember addedMember = policyMemberService.addMember(memberDetails);
        return ResponseEntity.ok(addedMember);
    }

    @DeleteMapping("/delete/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
        policyMemberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/validate")
    public ResponseEntity<Boolean> validateMember(@RequestBody PolicyMember memberDetails) {
        boolean isValid = policyMemberService.validateMember(memberDetails);
        return ResponseEntity.ok(isValid);
    }

    @PostMapping("/decline/{memberId}")
    public ResponseEntity<Void> declineMember(@PathVariable Long memberId) {
        policyMemberService.declineMember(memberId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/load/{memberId}")
    public ResponseEntity<PolicyMember> loadMemberDetails(@PathVariable Long memberId) {
        PolicyMember memberDetails = policyMemberService.loadMemberDetails(memberId);
        return ResponseEntity.ok(memberDetails);
    }

    @GetMapping("/check-hni-policies")
    public ResponseEntity<Boolean> checkHniPolicies() {
        boolean result = policyMemberService.queryHniPolicies();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/query-previous-lapse-policies")
    public ResponseEntity<Boolean> queryPreviousLapsePolicies() {
        boolean result = policyMemberService.checkPreviousLapsePolicies();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/update-weight-change")
    public ResponseEntity<Void> updateWeightChange(@RequestBody Double weightChange) {
        policyMemberService.updateWeightChange(weightChange);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/update-form-status")
    public ResponseEntity<Void> updateFormStatus(@RequestBody String formStatus) {
        policyMemberService.updateFormStatus(formStatus);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/age-proof-details/{proofType}")
    public ResponseEntity<AgeProofDetails> getAgeProofDetails(@PathVariable String proofType) {
        AgeProofDetails details = policyMemberService.getAgeProofDetails(proofType);
        return ResponseEntity.ok(details);
    }

    @PostMapping("/calculate-sum-assured")
    public ResponseEntity<SumAssuredCalculationResponse> calculateSumAssured(@RequestBody SumAssuredCalculationRequest request) {
        SumAssuredCalculationResponse response = policyMemberService.calculateSumAssured(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<PolicyMemberDTO> savePolicyMember(@RequestBody PolicyMemberDTO policyMember) {
        PolicyMemberDTO savedMember = policyMemberService.savePolicyMember(policyMember);
        return ResponseEntity.ok(savedMember);
    }

    @GetMapping("/details/{policyMemberId}")
    public ResponseEntity<PolicyMemberDTO> getPolicyMemberDetails(@PathVariable Long policyMemberId) {
        PolicyMemberDTO memberDetails = policyMemberService.getPolicyMemberDetails(policyMemberId);
        return ResponseEntity.ok(memberDetails);
    }

    @PostMapping("/decline")
    public ResponseEntity<Void> declineMember(@RequestBody Long memberId) {
        policyMemberService.declineMember(memberId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/update-lateral-shift-status")
    public ResponseEntity<Void> updateLateralShiftStatus(@RequestBody LateralShiftDTO lateralShiftDTO) {
        policyMemberService.updateLateralShiftStatus(lateralShiftDTO);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/transfer-member-loading-details")
    public ResponseEntity<Void> transferMemberLoadingDetails() {
        policyMemberService.transferMemberLoadingDetails();
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/validate-and-calculate-weight")
    public ResponseEntity<PolicyMemberValidationResponse> validateAndCalculateWeight(@RequestBody PolicyMemberValidationRequest request) {
        PolicyMemberValidationResponse response = policyMemberService.validateAndCalculateWeight(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/valid-age-proof-types")
    public ResponseEntity<List<AgeProofType>> getValidAgeProofTypes() {
        List<AgeProofType> ageProofTypes = policyMemberService.fetchValidAgeProofTypes();
        return ResponseEntity.ok(ageProofTypes);
    }

    @PostMapping("/validate-age-proof")
    public ResponseEntity<ValidationResponse> validateAgeProof(@RequestBody AgeProofValidationRequest request) {
        ValidationResponse response = policyMemberService.validateAgeProof(request.getAgeProof(), request.getAgentCode());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add-member")
    public ResponseEntity<AddMemberResponse> addMember(@RequestBody AddMemberRequest request) {
        AddMemberResponse response = policyMemberService.addMember(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/validate-bmi")
    public ResponseEntity<Boolean> validateBMI(@RequestBody BMIDTO bmiData) {
        boolean result = policyMemberService.validateBMI(bmiData);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/validate-height")
    public ResponseEntity<HeightValidationResponse> validateHeight(@RequestBody HeightValidationRequest request) {
        HeightValidationResponse response = policyMemberService.validateHeight(request);
        return ResponseEntity.ok(response);
    }
}
