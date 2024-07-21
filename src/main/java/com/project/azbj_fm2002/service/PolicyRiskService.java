package com.project.azbj_fm2002.service;

import com.project.azbj_fm2002.repository.PolicyRiskRepository;
import com.project.azbj_fm2002.dto.PolicyRiskDTO;
import com.project.azbj_fm2002.model.PolicyRisk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyRiskService {

    @Autowired
    private PolicyRiskRepository policyRiskRepository;

    public void savePolicyRiskDetails(PolicyRiskDTO policyRiskDTO) {
        // Validate input
        if (policyRiskDTO == null) {
            throw new IllegalArgumentException("PolicyRiskDTO cannot be null");
        }

        // Map DTO to entity
        PolicyRisk policyRisk = new PolicyRisk();
        policyRisk.setContractId(policyRiskDTO.getContractId());
        policyRisk.setPolicyNo(policyRiskDTO.getPolicyNo());
        policyRisk.setLifeCoverageSum(policyRiskDTO.getLifeCoverageSum());
        policyRisk.setYrOfIssue(policyRiskDTO.getYrOfIssue());
        policyRisk.setIpType(policyRiskDTO.getIpType() != null ? policyRiskDTO.getIpType() : 1);
        policyRisk.setPremium(policyRiskDTO.getPremium() != null ? policyRiskDTO.getPremium() : 0);

        // Save to repository
        policyRiskRepository.save(policyRisk);
    }
}
