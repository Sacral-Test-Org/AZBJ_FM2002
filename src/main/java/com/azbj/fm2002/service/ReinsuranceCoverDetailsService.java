package com.azbj.fm2002.service;

import com.azbj.fm2002.dto.MedicalLoadingValidationRequest;
import com.azbj.fm2002.dto.MedicalLoadingValidationResponse;
import com.azbj.fm2002.dto.CoverCodeDTO;
import com.azbj.fm2002.repository.ReinsuranceCoverDetailsRepository;
import com.azbj.fm2002.util.MedicalLoadingValidationUtil;
import com.azbj.fm2002.util.ReinsuranceCalculationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReinsuranceCoverDetailsService {

    @Autowired
    private ReinsuranceCoverDetailsRepository repository;

    public MedicalLoadingValidationResponse validateMedicalLoadingPercentage(MedicalLoadingValidationRequest request) {
        return MedicalLoadingValidationUtil.validate(request);
    }

    public double calculateReinsuranceAmount(double reinsurancePercentage, double coverAmount) {
        return ReinsuranceCalculationUtil.calculateReinsuranceAmount(reinsurancePercentage, coverAmount);
    }

    public List<CoverCodeDTO> fetchCoverCodes() {
        return repository.findCoverCodes();
    }
}
