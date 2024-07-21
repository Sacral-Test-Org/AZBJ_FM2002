package com.project.azbj_fm2002.service;

import com.project.azbj_fm2002.repository.SpouseFinancialDetailsRepository;
import com.project.azbj_fm2002.dto.SpouseFinancialDetailsDTO;
import com.project.azbj_fm2002.model.SpouseFinancialDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpouseFinancialDetailsService {

    @Autowired
    private SpouseFinancialDetailsRepository spouseFinancialDetailsRepository;

    public void saveSpouseFinancialDetails(SpouseFinancialDetailsDTO spouseFinancialDetailsDTO) {
        if (spouseFinancialDetailsDTO == null) {
            throw new IllegalArgumentException("Spouse financial details cannot be null");
        }

        SpouseFinancialDetails spouseFinancialDetails = new SpouseFinancialDetails();
        spouseFinancialDetails.setContractId(spouseFinancialDetailsDTO.getContractId());
        spouseFinancialDetails.setApplicationNo(spouseFinancialDetailsDTO.getApplicationNo());
        spouseFinancialDetails.setProposalNo(spouseFinancialDetailsDTO.getProposalNo());
        spouseFinancialDetails.setSpIncProofType(spouseFinancialDetailsDTO.getSpIncProofType());
        spouseFinancialDetails.setSpGrossIncome(spouseFinancialDetailsDTO.getSpGrossIncome());
        spouseFinancialDetails.setSpExemptedIncome(spouseFinancialDetailsDTO.getSpExemptedIncome());
        spouseFinancialDetails.setSpOnetimeIncome(spouseFinancialDetailsDTO.getSpOnetimeIncome());
        spouseFinancialDetails.setSpTotalIncome(spouseFinancialDetailsDTO.getSpTotalIncome());
        spouseFinancialDetails.setSpDeduction(spouseFinancialDetailsDTO.getSpDeduction());
        spouseFinancialDetails.setSpTax(spouseFinancialDetailsDTO.getSpTax());
        spouseFinancialDetails.setSpNetIncome(spouseFinancialDetailsDTO.getSpNetIncome());
        spouseFinancialDetails.setSpPlProofType(spouseFinancialDetailsDTO.getSpPlProofType());
        spouseFinancialDetails.setSpGrossPl(spouseFinancialDetailsDTO.getSpGrossPl());
        spouseFinancialDetails.setSpExemptedPl(spouseFinancialDetailsDTO.getSpExemptedPl());
        spouseFinancialDetails.setSpOnetimePl(spouseFinancialDetailsDTO.getSpOnetimePl());
        spouseFinancialDetails.setSpTotalPl(spouseFinancialDetailsDTO.getSpTotalPl());
        spouseFinancialDetails.setSpDeductionPl(spouseFinancialDetailsDTO.getSpDeductionPl());
        spouseFinancialDetails.setSpTaxPl(spouseFinancialDetailsDTO.getSpTaxPl());
        spouseFinancialDetails.setSpNetPl(spouseFinancialDetailsDTO.getSpNetPl());
        spouseFinancialDetails.setIpNo(spouseFinancialDetailsDTO.getIpNo());

        spouseFinancialDetailsRepository.save(spouseFinancialDetails);
    }
}
