package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.ProbableCpRepository;
import com.azbj.fm2002.util.PolicyDetailsUtil;
import com.azbj.fm2002.model.ProbableCP;
import com.azbj.fm2002.model.PolicyDetailsEntity;
import com.azbj.fm2002.dto.PolicyDetailsDTO;
import com.azbj.fm2002.dto.ReinsuranceDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProbableCpService {

    @Autowired
    private ProbableCpRepository probableCpRepository;

    @Autowired
    private PolicyDetailsUtil policyDetailsUtil;

    public List<ProbableCP> getProbableCPDetails(String applicationNumber, String verificationNumber, String signCardNumber) {
        return probableCpRepository.findProbableCPDetails(applicationNumber, verificationNumber, signCardNumber);
    }

    public PolicyDetailsDTO getPolicyDetails(String insuredPersonId) {
        PolicyDetailsEntity policyDetailsEntity = probableCpRepository.findPolicyDetails(insuredPersonId);
        BigDecimal premiumAmount = policyDetailsUtil.calculatePremium(policyDetailsEntity);
        LocalDate inceptionDate = policyDetailsUtil.calculateInceptionDate(policyDetailsEntity);
        ReinsuranceDetailsDTO reinsuranceDetails = policyDetailsUtil.calculateReinsuranceDetails(policyDetailsEntity);

        PolicyDetailsDTO policyDetailsDTO = new PolicyDetailsDTO();
        policyDetailsDTO.setPartnerId(policyDetailsEntity.getPartnerId());
        policyDetailsDTO.setPolicyReference(policyDetailsEntity.getPolicyReference());
        policyDetailsDTO.setPartnerName(policyDetailsEntity.getPartnerName());
        policyDetailsDTO.setAnnualPremium(policyDetailsEntity.getAnnualPremium());
        policyDetailsDTO.setPolicyStatus(policyDetailsEntity.getPolicyStatus());
        policyDetailsDTO.setCoverCode(policyDetailsEntity.getCoverCode());
        policyDetailsDTO.setSumInsured(policyDetailsEntity.getSumInsured());
        policyDetailsDTO.setEntryAge(policyDetailsEntity.getEntryAge());
        policyDetailsDTO.setPremiumTerm(policyDetailsEntity.getPremiumTerm());
        policyDetailsDTO.setBenefitTerm(policyDetailsEntity.getBenefitTerm());
        policyDetailsDTO.setInterestRate(policyDetailsEntity.getInterestRate());
        policyDetailsDTO.setFrequencyStandardPremium(policyDetailsEntity.getFrequencyStandardPremium());
        policyDetailsDTO.setExtraAmount(policyDetailsEntity.getExtraAmount());
        policyDetailsDTO.setMlPercentage(policyDetailsEntity.getMlPercentage());
        policyDetailsDTO.setOcPercentage(policyDetailsEntity.getOcPercentage());
        policyDetailsDTO.setNriPercentage(policyDetailsEntity.getNriPercentage());
        policyDetailsDTO.setSrPercentage(policyDetailsEntity.getSrPercentage());
        policyDetailsDTO.setPremiumDiscountAmount(policyDetailsEntity.getPremiumDiscountAmount());
        policyDetailsDTO.setPremiumAmount(premiumAmount);
        policyDetailsDTO.setInceptionDate(inceptionDate);
        policyDetailsDTO.setReinsuranceDetails(reinsuranceDetails);

        return policyDetailsDTO;
    }

    public List<ProbableCpDetails> getProbableCpDetails() {
        return probableCpRepository.findProbableCpDetails();
    }
}
