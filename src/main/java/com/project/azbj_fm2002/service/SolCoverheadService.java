package com.project.azbj_fm2002.service;

import com.project.azbj_fm2002.repository.SolCoverheadRepository;
import com.project.azbj_fm2002.model.SolCoverhead;
import com.project.azbj_fm2002.model.SolCovers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SolCoverheadService {

    @Autowired
    private SolCoverheadRepository solCoverheadRepository;

    @Autowired
    private SolCoversService solCoversService;

    public Double getSumAssured() {
        return solCoverheadRepository.findSumAssured();
    }

    public String getSolutionName() {
        return solCoverheadRepository.findSolutionName();
    }

    public List<SolCoverhead> calculateTerms(String productDefinition, int pensionFlag, String bookingFrequency, Date dateOfBirth, int vestingAge) {
        List<SolCoverhead> records = solCoverheadRepository.findRelevantData(productDefinition, pensionFlag, bookingFrequency, dateOfBirth, vestingAge);
        for (SolCoverhead record : records) {
            int entryAge = calculateEntryAge(dateOfBirth, record.getInceptionDate());
            int benefitTerm = vestingAge - entryAge;
            int premiumTerm = (productDefinition.matches("NEW_UG_EASY_PENSION_PLUS%|MOD_NEW_UG_EASY_PEN_PLUS|FUTURE_SECURE") && !"01".equals(bookingFrequency)) ? benefitTerm : 0;
            record.setBenefitTerm(benefitTerm);
            record.setPremiumTerm(premiumTerm);
            solCoverheadRepository.save(record);
        }
        return records;
    }

    private int calculateEntryAge(Date dateOfBirth, Date inceptionDate) {
        // Implement the logic to calculate entry age based on dateOfBirth and inceptionDate
        return 0; // Placeholder return value
    }

    public void processRecords() {
        List<SolCovers> covers = solCoversService.findAll();
        for (SolCovers cover : covers) {
            if (cover.getCoverCode().startsWith("R") && !"R036A01".equals(cover.getCoverCode())) {
                double sumInsuredWholeCover = calculateSumInsuredWholeCover(cover);
                cover.setSumInsuredWholeCover(sumInsuredWholeCover);
                solCoversService.updateRecord(cover);
            } else if ("R036A01".equals(cover.getCoverCode())) {
                boolean userWantsWaver = promptUserForWaver();
                if (!userWantsWaver) {
                    solCoversService.deleteRecord(cover.getCoverCode());
                }
            }
        }
    }

    private double calculateSumInsuredWholeCover(SolCovers cover) {
        // Implement the logic to calculate sum insured whole cover based on cover details
        return 0.0; // Placeholder return value
    }

    private boolean promptUserForWaver() {
        // Implement the logic to prompt the user and return their decision
        return false; // Placeholder return value
    }

    public String determineDiscountType() {
        return solCoverheadRepository.findDiscountType();
    }

    public void deleteBeneficiaryTrusteeRep(String contractId) {
        solCoverheadRepository.deleteByContractId(contractId);
    }
}