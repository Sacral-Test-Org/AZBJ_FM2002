package com.azbj.fm2002.service;

import com.azbj.fm2002.dto.BiReportRequest;
import com.azbj.fm2002.dto.BiReportResponse;
import com.azbj.fm2002.dto.GstCalculationRequest;
import com.azbj.fm2002.dto.GstCalculationResponse;
import com.azbj.fm2002.repository.AzbjCoDetailsRepository;
import com.azbj.fm2002.util.BiReportUtil;
import com.azbj.fm2002.util.GstCalculationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class AzbjCoDetailsService {

    @Autowired
    private AzbjCoDetailsRepository azbjCoDetailsRepository;

    @Autowired
    private BiReportUtil biReportUtil;

    @Autowired
    private GstCalculationUtil gstCalculationUtil;

    public BiReportResponse generateBiReport(BiReportRequest request) {
        BiReportResponse response = biReportUtil.generateBiReport(request);

        if (response.isSuccess()) {
            azbjCoDetailsRepository.updateBiDetails(request);
        } else {
            // Handle failure response
            // Log the error and reset visual attributes if necessary
        }

        return response;
    }

    public GstCalculationResponse calculateGst(GstCalculationRequest request) {
        Date documentDate = azbjCoDetailsRepository.getDocumentDate(request.getContractId());
        Date serviceTaxDate = azbjCoDetailsRepository.getServiceTaxDate(request.getContractId(), documentDate);
        String postalCode = azbjCoDetailsRepository.getPostalCode(request.getInsuredPersonId());
        String agentCode = azbjCoDetailsRepository.getAgentCode(request.getContractId());
        String branchCode = azbjCoDetailsRepository.getBranchCode(agentCode);

        if (request.getSumAssured().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Sum assured must be greater than zero.");
        }

        GstCalculationResponse gstResponse = gstCalculationUtil.calculateGstAmount(
                request.getProductId(),
                request.getCoverCode(),
                request.getPremium(),
                serviceTaxDate != null ? serviceTaxDate : new Date(),
                postalCode,
                request.getSumAssured(),
                "PREMIUM"
        );

        return gstResponse;
    }
}
