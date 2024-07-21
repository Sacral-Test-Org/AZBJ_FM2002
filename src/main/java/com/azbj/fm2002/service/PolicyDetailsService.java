package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.PolicyDetailsRepository;
import com.azbj.fm2002.dto.PreviousPolicyDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PolicyDetailsService {

    @Autowired
    private PolicyDetailsRepository policyDetailsRepository;

    public List<PreviousPolicyDetailsDTO> getPreviousPolicyDetails(String customerId) {
        try {
            return policyDetailsRepository.findPreviousPolicyDetails(customerId);
        } catch (Exception e) {
            // Handle exception and inform the user appropriately
            throw new RuntimeException("Error fetching previous policy details", e);
        }
    }
}
