package com.project.azbj_fm2002.service;

import com.project.azbj_fm2002.repository.SolCoversRepository;
import com.project.azbj_fm2002.model.SolCovers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SolCoversService {

    @Autowired
    private SolCoversRepository solCoversRepository;

    public List<SolCovers> getAllRecords() {
        return solCoversRepository.findAll();
    }

    public void updateRecord(SolCovers record) {
        solCoversRepository.save(record);
    }

    public void updateCovers() {
        List<SolCovers> records = solCoversRepository.findAll();
        for (SolCovers record : records) {
            // Assuming sumAssured is fetched from sol_coverhead section
            Double sumAssured = getSumAssuredFromCoverhead();
            if (sumAssured != null) {
                record.setSumInsuredWholeCover(sumAssured);
                solCoversRepository.save(record);
            }
        }
    }

    public void updateCovers(double benefitTerm, double premiumTerm) {
        List<SolCovers> records = solCoversRepository.findAll();
        for (SolCovers record : records) {
            record.setBenefitTerm(benefitTerm);
            record.setPremiumTerm(premiumTerm);
            solCoversRepository.save(record);
        }
    }

    public void deleteRecord(String id) {
        solCoversRepository.deleteById(id);
    }

    private Double getSumAssuredFromCoverhead() {
        // Mock method to simulate fetching sum assured from sol_coverhead
        // In real implementation, this would fetch the value from the sol_coverhead section
        return 100000.0;
    }
}
