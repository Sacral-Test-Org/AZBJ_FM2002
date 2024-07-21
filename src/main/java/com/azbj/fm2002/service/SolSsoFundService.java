package com.azbj.fm2002.service;

import com.azbj.fm2002.dto.SolSsoFundValidationRequest;
import com.azbj.fm2002.dto.SolSsoFundValidationResponse;
import com.azbj.fm2002.exception.SolSsoFundValidationException;
import com.azbj.fm2002.repository.SolSsoFundRepository;
import com.azbj.fm2002.model.SolSsoFund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolSsoFundService {

    @Autowired
    private SolSsoFundRepository solSsoFundRepository;

    public SolSsoFundValidationResponse validateApportionment(SolSsoFundValidationRequest request) {
        List<Integer> validProductIds = List.of(31, 32, 33, 34, 49, 50);
        if (validProductIds.contains(request.getProductId()) && "NCPPF".equals(request.getFundId())) {
            if (request.getApportionmentPercentage() > 20) {
                throw new SolSsoFundValidationException("Apportionment for Cash Plus Pension Fund cannot be more than 20");
            }
        }
        // Update form status to 'Y'
        SolSsoFund solSsoFund = solSsoFundRepository.findByProductIdAndFundId(request.getProductId(), request.getFundId())
                .orElseThrow(() -> new SolSsoFundValidationException("Fund not found"));
        solSsoFund.setFormStatus("Y");
        solSsoFundRepository.save(solSsoFund);
        return new SolSsoFundValidationResponse("Validation successful", "Y");
    }

    public List<Fund> fetchFunds(String productId, String dateRange, String coverCode) {
        return solSsoFundRepository.findFunds(productId, dateRange, coverCode);
    }
}
