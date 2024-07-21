package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.ProposalActionsDTO;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProposalActionsUtil {

    public boolean validateProposalActions(ProposalActionsDTO proposalActionsDTO) {
        // Clear any existing issue button disable messages
        proposalActionsDTO.clearIssueButtonDisableMessages();

        // Save the current status of the proposal
        proposalActionsDTO.saveCurrentStatus();

        // Validate the proposal for HNI (High Net-worth Individual) values
        if (!proposalActionsDTO.validateHNIValues()) {
            return false;
        }

        // Enable or disable specific actions based on the combo flag, RCU validation, and tele-verification status
        boolean isComboFlagValid = proposalActionsDTO.isComboFlagValid();
        boolean isRCUValid = proposalActionsDTO.validateRCU();
        boolean isTeleVerificationValid = proposalActionsDTO.isTeleVerificationValid();

        if (!isComboFlagValid || !isRCUValid || !isTeleVerificationValid) {
            return false;
        }

        // Display appropriate messages for combo products, RCU cases, and pending branch verifications
        proposalActionsDTO.displayMessages();

        // Enable or disable specific actions based on the presence of validation errors
        if (proposalActionsDTO.hasValidationErrors()) {
            return false;
        }

        // Check for incomplete inwarded applications and ensure all requirements are received before issuance
        if (!proposalActionsDTO.areAllRequirementsReceived()) {
            return false;
        }

        // Validate individual and family shareholdings for key-man proposals
        if (!proposalActionsDTO.validateShareholdings()) {
            return false;
        }

        // Ensure the proposal's product type selected in cashiering matches the BBU (Back-end Business Unit) type
        if (!proposalActionsDTO.isProductTypeMatchingBBU()) {
            return false;
        }

        // Handle high-risk CP (Corporate Partner) partners by restricting issuance to HOD (Head of Department) IDs only
        if (proposalActionsDTO.isHighRiskCP() && !proposalActionsDTO.isIssuedByHOD()) {
            return false;
        }

        // Validate the proposal against various conditions such as thumb impression cases, non-standard age proofs, and specific product requirements
        if (!proposalActionsDTO.validateSpecialConditions()) {
            return false;
        }

        return true;
    }

    public Map<String, BigDecimal> calculateTaxes(ProposalActionsDTO proposalActionsDTO) {
        Map<String, BigDecimal> taxes = new HashMap<>();

        // Calculate and display the appropriate service tax, education cess, and higher education cess based on the proposal's details
        BigDecimal serviceTax = proposalActionsDTO.calculateServiceTax();
        BigDecimal educationCess = proposalActionsDTO.calculateEducationCess();
        BigDecimal higherEducationCess = proposalActionsDTO.calculateHigherEducationCess();

        taxes.put("serviceTax", serviceTax);
        taxes.put("educationCess", educationCess);
        taxes.put("higherEducationCess", higherEducationCess);

        // Ensure the proposal's premium is sufficient to cover all charges, including COI (Cost of Insurance), admin fees, and service taxes
        if (!proposalActionsDTO.isPremiumSufficient()) {
            throw new IllegalArgumentException("Insufficient premium to cover all charges");
        }

        return taxes;
    }
}
