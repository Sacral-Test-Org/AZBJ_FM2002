package com.project.azbj_fm2002.service;

import com.project.azbj_fm2002.repository.BeneficialOwnershipRepository;
import com.project.azbj_fm2002.dto.BeneficialOwnerDTO;
import com.project.azbj_fm2002.entity.BeneficialOwnership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeneficialOwnershipService {

    @Autowired
    private BeneficialOwnershipRepository beneficialOwnershipRepository;

    @Transactional
    public void saveBeneficialOwnershipDetails(String contractId, List<BeneficialOwnerDTO> beneficialOwners) {
        // Validate shareholding limits
        double totalShares = beneficialOwners.stream().mapToDouble(BeneficialOwnerDTO::getShares).sum();
        if (totalShares > 100) {
            throw new IllegalArgumentException("The sum of shares of the controlling beneficiary exceeds 100%.");
        }

        // Retrieve maximum allowed values for family and individual shareholdings
        double maxFamilyShareholding = beneficialOwnershipRepository.getMaxFamilyShareholding();
        double maxIndividualShareholding = beneficialOwnershipRepository.getMaxIndividualShareholding();

        // Validate individual and family shareholding limits
        for (BeneficialOwnerDTO owner : beneficialOwners) {
            if (owner.getIndividualShareholding() > maxIndividualShareholding || owner.getFamilyShareholding() > maxFamilyShareholding) {
                if (!owner.isSupervisorApprovalGranted()) {
                    throw new IllegalArgumentException("Shareholding exceeds the maximum allowed values and supervisor approval is not granted.");
                }
            }
        }

        // Delete existing records for the given contract ID
        beneficialOwnershipRepository.deleteByContractId(contractId);

        // Insert new records into the beneficial ownership table
        List<BeneficialOwnership> ownershipEntities = beneficialOwners.stream().map(owner -> {
            BeneficialOwnership entity = new BeneficialOwnership();
            entity.setContractId(contractId);
            entity.setBeneficialOwner(owner.getBeneficialOwner());
            entity.setShares(owner.getShares());
            entity.setColorPhoto(owner.getColorPhoto());
            entity.setIdentityProofDesc(owner.getIdentityProofDesc());
            entity.setIdentityDocId(owner.getIdentityDocId());
            entity.setIdentityDocDate(owner.getIdentityDocDate());
            entity.setAddressProofDesc(owner.getAddressProofDesc());
            entity.setAddressDocId(owner.getAddressDocId());
            entity.setAddressDocDate(owner.getAddressDocDate());
            entity.setAddress(owner.getAddress());
            entity.setInsertDate(owner.getInsertDate());
            entity.setInsertUser(owner.getInsertUser());
            entity.setIndividualShareholding(owner.getIndividualShareholding());
            entity.setFamilyShareholdings(owner.getFamilyShareholdings());
            entity.setApprovalId(owner.getApprovalId());
            entity.setDateOfBirth(owner.getDateOfBirth());
            return entity;
        }).collect(Collectors.toList());

        beneficialOwnershipRepository.saveAll(ownershipEntities);

        // Display success message
        System.out.println("Beneficial ownership details saved successfully.");
    }
}