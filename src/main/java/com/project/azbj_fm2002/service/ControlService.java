package com.project.azbj_fm2002.service;

import com.project.azbj_fm2002.repository.ControlRepository;
import com.project.azbj_fm2002.entity.Question;
import com.project.azbj_fm2002.entity.CRMComment;
import com.project.azbj_fm2002.entity.BeneficialOwnershipDetails;
import com.project.azbj_fm2002.entity.DoctorMobAppInfo;
import com.project.azbj_fm2002.entity.RiskScoreDetails;
import com.project.azbj_fm2002.entity.Policy;
import com.project.azbj_fm2002.entity.PreviousPolicy;
import com.project.azbj_fm2002.entity.VideoCalling;
import com.project.azbj_fm2002.dto.FinancialUnderwritingDTO;
import com.project.azbj_fm2002.dto.SaveInsuredPersonRequest;
import com.project.azbj_fm2002.dto.SaveInsuredPersonResponse;
import com.project.azbj_fm2002.dto.BeneficialOwnerDTO;
import com.project.azbj_fm2002.dto.AgentDetails;
import com.project.azbj_fm2002.dto.MatchedRecord;
import com.project.azbj_fm2002.dto.ProofType;
import com.project.azbj_fm2002.dto.FinancialDetails;
import com.project.azbj_fm2002.dto.SpouseFinancialDetails;
import com.project.azbj_fm2002.dto.LiquidInvestmentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Map;

@Service
public class ControlService {

    @Autowired
    private ControlRepository controlRepository;

    public List<Question> fetchQuestions() {
        return controlRepository.findAllQuestions();
    }

    public void saveResponses(String policyRef, String contractId, List<Question> questions) {
        try {
            controlRepository.deactivateActiveQuestions(policyRef, contractId);
            controlRepository.insertQuestions(policyRef, contractId, questions);
        } catch (Exception e) {
            // Log error
            System.err.println("Error saving responses: " + e.getMessage());
        }
    }

    public String saveRelationWithStaff(String relationWithStaff) {
        return controlRepository.save(relationWithStaff);
    }

    public List<CRMComment> getCRMComments(String contractId) {
        return controlRepository.findCRMCommentsByContractId(contractId);
    }

    public void updateCRMComments(List<CRMComment> crmComments) {
        controlRepository.saveAll(crmComments);
    }

    public void handleFormInvocation(String applicationNo, String callFormName, String proposalNo, String laName) {
        try {
            // Check if a parameter list named 'Param1' already exists
            // If 'Param1' exists, destroy and recreate it
            // Add parameters 'APPLICATION_NO', 'CALL_FORM_NAME', 'PROPOSAL_NO', and 'LA_NAME' to 'Param1'
            // Call the 'AZBJ_DATA_ENRICH_FORM' with the specified parameters
        } catch (Exception e) {
            // Handle any errors that occur during this process
            System.err.println("Error during form invocation: " + e.getMessage());
        }
    }

    public List<Control> getPartnerTypeData(String partnerType) {
        return controlRepository.findDataByPartnerType(partnerType);
    }

    public BeneficialOwnershipDetails retrieveBeneficialOwnershipDetails(String contractId) {
        try {
            return controlRepository.findBeneficialOwnershipDetails(contractId);
        } catch (Exception e) {
            handleException(e);
            return null;
        }
    }

    public void handleException(Exception error) {
        // Handle any exceptions that occur during data retrieval
        System.err.println("Error: " + error.getMessage());
    }

    public void setSuspectedScreenActive() {
        // Set a flag indicating that the suspected screen is active
    }

    public void handleError(Exception error) {
        // Log the error using Log4j
        System.err.println("Error: " + error.getMessage());
    }

    public boolean checkUserAuthorization() {
        return controlRepository.queryUserAuthorization();
    }

    public void updateHOAllocationValues() {
        controlRepository.updateValues();
    }

    public void saveBeneficialOwnershipDetails(String contractId, List<BeneficialOwnerDTO> beneficialOwners) {
        try {
            int maxFamilyShareholding = controlRepository.findMaxFamilyShareholding();
            int maxIndividualShareholding = controlRepository.findMaxIndividualShareholding();

            // Validate the shareholding limits
            for (BeneficialOwnerDTO owner : beneficialOwners) {
                if (owner.getShares() > maxFamilyShareholding || owner.getShares() > maxIndividualShareholding) {
                    throw new IllegalArgumentException("Shareholding exceeds the allowed limit");
                }
            }

            // Delete existing records for the given contract ID
            controlRepository.deleteByContractId(contractId);

            // Insert new records into the beneficial ownership table
            controlRepository.saveAll(beneficialOwners);
        } catch (Exception e) {
            handleException(e);
        }
    }

    public void enableInsertUpdate() {
        // Enable the ability to insert and update records in the risk score details section
    }

    public void navigateToControlSection() {
        // Navigate the user to the control section
    }

    public void updatePolicyStatus(String status) {
        controlRepository.updatePolicyStatus(status);
    }

    public List<DoctorMobAppInfo> getDoctorMobAppInfo(String applicationNumber) {
        return controlRepository.findDoctorMobAppInfo(applicationNumber);
    }

    public List<RiskScoreDetails> getRiskScoreDetails(String applicationNo) {
        return controlRepository.fetchRiskScoreDetails(applicationNo);
    }

    public boolean validateCredentials(String loginId, String password) {
        return controlRepository.validateCredentials(loginId, password);
    }

    public boolean authenticateSupervisor(String username, String password) {
        try {
            Supervisor supervisor = controlRepository.findSupervisor(username);
            return supervisor != null && supervisor.getPassword().equals(password);
        } catch (Exception e) {
            handleException(e);
            return false;
        }
    }

    public int azbj_calculate_ppc() {
        int v_ip_other_sa = 0;
        int v_ph_other_sa = 0;
        // Perform the PPC calculation
        return v_ip_other_sa + v_ph_other_sa;
    }

    public List<ProofType> getProofTypes(int premiumPayer) {
        String occupationStatus = controlRepository.findOccupationStatusByPremiumPayer(premiumPayer);
        return controlRepository.findProofTypesByOccupationStatus(occupationStatus);
    }

    public FinancialDetails getFinancialDetails(int premiumPayer) {
        return controlRepository.findFinancialDetailsByPremiumPayer(premiumPayer);
    }

    public SpouseFinancialDetails getSpouseFinancialDetails(int premiumPayer) {
        return controlRepository.findSpouseFinancialDetailsByPremiumPayer(premiumPayer);
    }

    public LiquidInvestmentDetails getLiquidInvestmentDetails(int premiumPayer) {
        return controlRepository.findLiquidInvestmentDetailsByPremiumPayer(premiumPayer);
    }

    public BeneficialOwnershipDetails getBeneficialOwnershipDetails(String contractId) {
        return controlRepository.findBeneficialOwnershipDetailsByContractId(contractId);
    }

    public List<MatchedRecord> getRefreshedDetails() {
        // Check if the "MATCH_ONLY_BY" field is not null
        // Fetch partner details based on the partner type and IDs
        // Fetch city details based on the address ID
        // Combine the matching lists for the insured person and policy holder
        // Filter the combined list based on the "MATCH_ONLY_BY" field value
        // Return the final list of matched records
        return null;
    }

    public Map<String, Object> createParameterList(Map<String, Object> params) {
        // Create a new parameter list with the given parameters
        return params;
    }

    public ResponseEntity<?> callForm(String formName, Map<String, Object> params) {
        // Call the specified form with the given parameters
        return ResponseEntity.ok().build();
    }

    public AgentDetails getAgentDetails(String agentCode) {
        try {
            String uniqueCode = controlRepository.findUniqueCodeByAgentCode(agentCode);
            int internalId = controlRepository.findInternalIdByAgentCode(agentCode);
            AgentDetails agentDetails = controlRepository.findAgentDetailsByUniqueCode(uniqueCode);
            agentDetails.setLicenseDetails(controlRepository.findLicenseDetailsByInternalId(internalId));
            agentDetails.setUnitManager(controlRepository.findUnitManagerByAgentCode(agentCode));
            return agentDetails;
        } catch (Exception e) {
            handleException(e);
            return null;
        }
    }

    public void updateFormStatus(String status) {
        controlRepository.updateFormStatus(status);
    }

    public ResponseEntity<?> updateCrifScoreAndIncomeSegment(String verificationNumber, String signCardNumber, String policyReference, Object userInfo) {
        try {
            int cibilScore = controlRepository.getCibilScore(verificationNumber, signCardNumber);
            int incomeSegment = controlRepository.getIncomeSegment(verificationNumber, signCardNumber);
            // Update the values and return the updated information
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(500).body("Error updating CRIF score and income segment");
        }
    }

    public SaveInsuredPersonResponse saveInsuredPersonDetails(SaveInsuredPersonRequest request) {
        try {
            List<Control> existingRecords = controlRepository.findExistingRecords(request.getApplicationNo(), "BBU", "Y");
            if (!existingRecords.isEmpty()) {
                controlRepository.updateTopIndicator(request.getApplicationNo(), "BBU", "N");
            }
            // Navigate to the 'SIP_CONTROL' section
            for (Control control : request.getSipControl()) {
                if (control.getSipProofType() != null) {
                    controlRepository.insertNewRecord(control);
                }
            }
            // Commit the transaction
            return new SaveInsuredPersonResponse("Success");
        } catch (Exception e) {
            handleException(e);
            return new SaveInsuredPersonResponse("Error: " + e.getMessage());
        }
    }

    public boolean validateAllPolicies() {
        List<Policy> policies = controlRepository.findAllPolicies();
        for (Policy policy : policies) {
            if (!policy.isReviewed()) {
                return false;
            }
        }
        return true;
    }

    public boolean validateUWDecision() {
        // Check if the "UW Decision" field is not empty
        return true;
    }

    public boolean validateUWComments() {
        // Check if the "UW Comments" field is not empty
        return true;
    }

    public List<PreviousPolicy> getPreviousPolicyDetails() {
        return controlRepository.findPreviousPolicyDetails();
    }

    public String validateAndProcessPolicy(boolean underwritingReview, String underwritingDecision, String underwritingComments) {
        try {
            int recordCount = controlRepository.checkRecordExists("applicationNo", "proposalNo");
            if (recordCount > 0) {
                controlRepository.updateRecord("applicationNo", "proposalNo");
            } else {
                controlRepository.insertRecord("applicationNo", "proposalNo", "userId", underwritingDecision, underwritingComments, new java.util.Date(), "Y");
            }
            return "Success";
        } catch (Exception e) {
            handleException(e);
            return "Error: " + e.getMessage();
        }
    }

    public VideoCalling fetchVideoCallingStatus(String applicationNumber) {
        return controlRepository.findVideoCallingStatus(applicationNumber);
    }

    public void saveFinancialUnderwritingDetails(FinancialUnderwritingDTO financialUnderwritingDTO) {
        try {
            controlRepository.save(financialUnderwritingDTO);
        } catch (Exception e) {
            handleException(e);
        }
    }
}
