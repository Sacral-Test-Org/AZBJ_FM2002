package com.project.azbj_fm2002.controller;

import com.project.azbj_fm2002.service.ControlService;
import com.project.azbj_fm2002.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/control")
public class ControlController {

    @Autowired
    private ControlService controlService;

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getQuestions() {
        try {
            List<Question> questions = controlService.fetchQuestions();
            return ResponseEntity.ok(questions);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/saveResponses")
    public ResponseEntity<Void> saveResponses(@RequestParam String policyRef, @RequestParam String contractId, @RequestBody List<Question> questions) {
        try {
            controlService.saveResponses(policyRef, contractId, questions);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/saveRelationWithStaff")
    public ResponseEntity<String> saveRelationWithStaff(@RequestParam String relationWithStaff) {
        try {
            String result = controlService.saveRelationWithStaff(relationWithStaff);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving relation with staff");
        }
    }

    @GetMapping("/crmComments")
    public ResponseEntity<List<CRMComment>> getCRMComments(@RequestParam String contractId) {
        try {
            List<CRMComment> comments = controlService.getCRMComments(contractId);
            return ResponseEntity.ok(comments);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/updateCRMComments")
    public ResponseEntity<Void> updateCRMComments(@RequestBody List<CRMComment> crmComments) {
        try {
            controlService.updateCRMComments(crmComments);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/invokeEnrichmentForm")
    public ResponseEntity<Void> invokeEnrichmentForm(@RequestParam String applicationNo, @RequestParam String callFormName, @RequestParam String proposalNo, @RequestParam String laName) {
        try {
            controlService.handleFormInvocation(applicationNo, callFormName, proposalNo, laName);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/partnerTypeData")
    public ResponseEntity<List<Control>> getPartnerTypeData(@RequestParam String partnerType) {
        try {
            List<Control> data = controlService.getPartnerTypeData(partnerType);
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/beneficialOwnershipDetails")
    public ResponseEntity<BeneficialOwnershipDetails> getBeneficialOwnershipDetails(@RequestParam String contractId) {
        try {
            BeneficialOwnershipDetails details = controlService.retrieveBeneficialOwnershipDetails(contractId);
            return ResponseEntity.ok(details);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/setSuspectedScreenActive")
    public ResponseEntity<Void> setSuspectedScreenActive() {
        try {
            controlService.setSuspectedScreenActive();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/handleError")
    public ResponseEntity<String> handleError(@RequestBody Exception error) {
        try {
            controlService.handleError(error);
            return ResponseEntity.ok("Error handled");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error handling failed");
        }
    }

    @GetMapping("/checkAuthorization")
    public ResponseEntity<Boolean> checkAuthorization() {
        try {
            boolean isAuthorized = controlService.checkUserAuthorization();
            return ResponseEntity.ok(isAuthorized);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }

    @PostMapping("/updateValues")
    public ResponseEntity<Void> updateValues() {
        try {
            controlService.updateHOAllocationValues();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/saveBeneficialOwnershipDetails")
    public ResponseEntity<String> saveBeneficialOwnershipDetails(@RequestParam String contractId, @RequestBody List<BeneficialOwnerDTO> beneficialOwners) {
        try {
            controlService.saveBeneficialOwnershipDetails(contractId, beneficialOwners);
            return ResponseEntity.ok("Beneficial ownership details saved");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving beneficial ownership details");
        }
    }

    @PostMapping("/enableInsertUpdate")
    public ResponseEntity<Void> enableInsertUpdate() {
        try {
            controlService.enableInsertUpdate();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/navigateToControlSection")
    public ResponseEntity<Void> navigateToControlSection() {
        try {
            controlService.navigateToControlSection();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/updatePolicyStatus")
    public ResponseEntity<Void> updatePolicyStatus(@RequestParam String status) {
        try {
            controlService.updatePolicyStatus(status);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/doctorMobAppInfo")
    public ResponseEntity<List<DoctorMobAppInfo>> getDoctorMobAppInfo(@RequestParam String applicationNumber) {
        try {
            List<DoctorMobAppInfo> info = controlService.getDoctorMobAppInfo(applicationNumber);
            return ResponseEntity.ok(info);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/riskScoreDetails")
    public ResponseEntity<List<RiskScoreDetails>> fetchRiskScoreDetails(@RequestParam String applicationNo) {
        try {
            List<RiskScoreDetails> details = controlService.getRiskScoreDetails(applicationNo);
            return ResponseEntity.ok(details);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/validateCredentials")
    public ResponseEntity<String> validateCredentials(@RequestParam String loginId, @RequestParam String password) {
        try {
            boolean isValid = controlService.validateCredentials(loginId, password);
            if (isValid) {
                return ResponseEntity.ok("Approved");
            } else {
                return ResponseEntity.status(401).body("Invalid credentials");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error validating credentials");
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Boolean> authenticate(@RequestParam String username, @RequestParam String password) {
        try {
            boolean isAuthenticated = controlService.authenticateSupervisor(username, password);
            return ResponseEntity.ok(isAuthenticated);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }

    @PostMapping("/calculatePPC")
    public ResponseEntity<Integer> calculatePPC() {
        try {
            int result = controlService.azbj_calculate_ppc();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/proofTypes")
    public ResponseEntity<List<ProofType>> getProofTypes(@RequestParam int premiumPayer) {
        try {
            List<ProofType> proofTypes = controlService.getProofTypes(premiumPayer);
            return ResponseEntity.ok(proofTypes);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/financialDetails")
    public ResponseEntity<FinancialDetails> getFinancialDetails(@RequestParam int premiumPayer) {
        try {
            FinancialDetails details = controlService.getFinancialDetails(premiumPayer);
            return ResponseEntity.ok(details);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/spouseFinancialDetails")
    public ResponseEntity<SpouseFinancialDetails> getSpouseFinancialDetails(@RequestParam int premiumPayer) {
        try {
            SpouseFinancialDetails details = controlService.getSpouseFinancialDetails(premiumPayer);
            return ResponseEntity.ok(details);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/liquidInvestmentDetails")
    public ResponseEntity<LiquidInvestmentDetails> getLiquidInvestmentDetails(@RequestParam int premiumPayer) {
        try {
            LiquidInvestmentDetails details = controlService.getLiquidInvestmentDetails(premiumPayer);
            return ResponseEntity.ok(details);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/beneficialOwnershipDetails")
    public ResponseEntity<BeneficialOwnershipDetails> getBeneficialOwnershipDetails(@RequestParam String contractId) {
        try {
            BeneficialOwnershipDetails details = controlService.getBeneficialOwnershipDetails(contractId);
            return ResponseEntity.ok(details);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/refreshDetails")
    public ResponseEntity<List<MatchedRecord>> refreshDetails() {
        try {
            List<MatchedRecord> records = controlService.getRefreshedDetails();
            return ResponseEntity.ok(records);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/callRcuCommentsForm")
    public ResponseEntity<?> callRcuCommentsForm(@RequestParam String formName, @RequestBody Map<String, Object> params) {
        try {
            return controlService.callForm(formName, params);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error calling form");
        }
    }

    @GetMapping("/agentDetails")
    public ResponseEntity<AgentDetails> getAgentDetails(@RequestParam String agentCode) {
        try {
            AgentDetails details = controlService.getAgentDetails(agentCode);
            return ResponseEntity.ok(details);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/updateFormStatus")
    public ResponseEntity<Void> updateFormStatus(@RequestParam String status) {
        try {
            controlService.updateFormStatus(status);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/updateCrifScoreAndIncomeSegment")
    public ResponseEntity<Void> updateCrifScoreAndIncomeSegment(@RequestParam String verificationNumber, @RequestParam String signCardNumber, @RequestParam String policyReference, @RequestBody Map<String, Object> userInfo) {
        try {
            controlService.updateCrifScoreAndIncomeSegment(verificationNumber, signCardNumber, policyReference, userInfo);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/saveInsuredPersonDetails")
    public ResponseEntity<SaveInsuredPersonResponse> saveInsuredPersonDetails(@RequestBody SaveInsuredPersonRequest request) {
        try {
            SaveInsuredPersonResponse response = controlService.saveInsuredPersonDetails(request);
            return ResponseEntity.ok(response);
        } catch (SaveInsuredPersonException e) {
            return ResponseEntity.status(400).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/validatePolicies")
    public ResponseEntity<Boolean> validatePolicies() {
        try {
            boolean result = controlService.validateAllPolicies();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }

    @GetMapping("/validateUWDecision")
    public ResponseEntity<Boolean> validateUWDecision() {
        try {
            boolean result = controlService.validateUWDecision();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }

    @GetMapping("/validateUWComments")
    public ResponseEntity<Boolean> validateUWComments() {
        try {
            boolean result = controlService.validateUWComments();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }

    @GetMapping("/previousPolicyDetails")
    public ResponseEntity<List<PreviousPolicy>> getPreviousPolicyDetails() {
        try {
            List<PreviousPolicy> details = controlService.getPreviousPolicyDetails();
            return ResponseEntity.ok(details);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/validateAndProcessPolicy")
    public ResponseEntity<String> validateAndProcessPolicy(@RequestBody Map<String, Object> request) {
        try {
            String result = controlService.validateAndProcessPolicy(request);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing policy");
        }
    }

    @GetMapping("/videoCallingStatus")
    public ResponseEntity<VideoCalling> getVideoCallingStatus(@RequestParam String applicationNumber) {
        try {
            VideoCalling status = controlService.fetchVideoCallingStatus(applicationNumber);
            return ResponseEntity.ok(status);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/saveFinancialUnderwritingDetails")
    public ResponseEntity<String> saveFinancialUnderwritingDetails(@RequestBody FinancialUnderwritingDTO financialUnderwritingDTO) {
        try {
            controlService.saveFinancialUnderwritingDetails(financialUnderwritingDTO);
            return ResponseEntity.ok("Financial underwriting details saved");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving financial underwriting details");
        }
    }
}