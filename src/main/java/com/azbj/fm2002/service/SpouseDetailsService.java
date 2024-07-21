package com.azbj.fm2002.service;

import com.azbj.fm2002.dto.SpouseFinancialDetailsDTO;
import com.azbj.fm2002.repository.SpouseDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SpouseDetailsService {

    @Autowired
    private SpouseDetailsRepository spouseDetailsRepository;

    public ValidationResult validateDOB(Date dob, Date policyInceptionDate) {
        ValidationResult result = new ValidationResult();
        Date currentDate = new Date();
        if (dob.after(currentDate)) {
            result.setValid(false);
            result.setMessage("Date of birth cannot be in the future.");
            return result;
        }
        int entryAge = calculateAge(dob, policyInceptionDate);
        if (entryAge >= 18) {
            result.setValid(false);
            result.setMessage("Appointee cannot be entered for a major.");
        } else {
            result.setValid(true);
            result.setMessage("Date of birth is valid.");
        }
        return result;
    }

    private int calculateAge(Date dob, Date policyInceptionDate) {
        long ageInMillis = policyInceptionDate.getTime() - dob.getTime();
        Date age = new Date(ageInMillis);
        return age.getYear() - 70; // 1970 is the epoch year
    }

    public SpouseFinancialDetailsDTO addSpouseFinancialDetails(SpouseFinancialDetailsDTO details) {
        return spouseDetailsRepository.save(details);
    }

    public SpouseFinancialDetailsDTO getSpouseFinancialDetails(Long id) {
        return spouseDetailsRepository.findById(id).orElse(null);
    }

    public SpouseFinancialDetailsDTO updateSpouseFinancialDetails(SpouseFinancialDetailsDTO details) {
        return spouseDetailsRepository.save(details);
    }

    public List<String> getProofTypes() {
        return spouseDetailsRepository.findAllProofTypes();
    }

    public void saveProofType(String proofType) {
        spouseDetailsRepository.saveProofType(proofType);
    }

    public double calculateNetProfit(double spouseNetIncome, double averageNetProfit) {
        double netProfit = averageNetProfit - spouseNetIncome;
        spouseDetailsRepository.saveNetProfit(netProfit);
        return netProfit;
    }

    public static class ValidationResult {
        private boolean isValid;
        private String message;

        public boolean isValid() {
            return isValid;
        }

        public void setValid(boolean valid) {
            isValid = valid;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}