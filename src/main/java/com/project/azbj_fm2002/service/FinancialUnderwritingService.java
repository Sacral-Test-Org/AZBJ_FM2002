package com.project.azbj_fm2002.service;

import com.project.azbj_fm2002.repository.FinancialUnderwritingRepository;
import com.project.azbj_fm2002.dto.FinancialUnderwritingDTO;
import com.project.azbj_fm2002.model.FinancialUnderwriting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialUnderwritingService {

    @Autowired
    private FinancialUnderwritingRepository financialUnderwritingRepository;

    public void saveFinancialUnderwritingDetails(FinancialUnderwritingDTO financialUnderwritingDTO) {
        if (financialUnderwritingDTO.getPremiumPayer() == null) {
            financialUnderwritingDTO.setPremiumPayer(1);
            throw new IllegalArgumentException("Regular income should not be null");
        }

        FinancialUnderwriting financialUnderwriting = new FinancialUnderwriting();
        financialUnderwriting.setContractId(financialUnderwritingDTO.getContractId());
        financialUnderwriting.setPolicyRef(financialUnderwritingDTO.getPolicyRef());
        financialUnderwriting.setPremiumPayer(financialUnderwritingDTO.getPremiumPayer());
        financialUnderwriting.setYrs(financialUnderwritingDTO.getYrs());
        financialUnderwriting.setItrs(financialUnderwritingDTO.getItrs());
        financialUnderwriting.setComputation(financialUnderwritingDTO.getComputation());
        financialUnderwriting.setGrossIncome(financialUnderwritingDTO.getGrossIncome());
        financialUnderwriting.setNetProfit(financialUnderwritingDTO.getNetProfit());
        financialUnderwriting.setExemptedIncome(financialUnderwritingDTO.getExemptedIncome());
        financialUnderwriting.setOneTimeIncome(financialUnderwritingDTO.getOneTimeIncome());
        financialUnderwriting.setTotalIncome(financialUnderwritingDTO.getTotalIncome());
        financialUnderwriting.setDeduction(financialUnderwritingDTO.getDeduction());
        financialUnderwriting.setTax(financialUnderwritingDTO.getTax());
        financialUnderwriting.setProofType(financialUnderwritingDTO.getProofType());

        if (financialUnderwritingDTO.isDeleteFlag()) {
            financialUnderwritingDTO.setDeleteFlag(false);
            financialUnderwritingRepository.deleteByContractIdAndPremiumPayer(financialUnderwritingDTO.getContractId(), financialUnderwritingDTO.getPremiumPayer());
        } else {
            financialUnderwritingRepository.save(financialUnderwriting);
        }

        if (financialUnderwritingDTO.getGrossIncome() < 10000 || financialUnderwritingDTO.getTotalIncome() < 10000) {
            System.out.println("Warning: Gross income or total income is below the threshold.");
        }

        // Additional logic for updating/inserting liquid investment, spouse financial details, beneficial ownership, policy risk details, and total sum assured
        // This part of the logic would involve calling respective repository methods to perform the required database operations
    }
}
