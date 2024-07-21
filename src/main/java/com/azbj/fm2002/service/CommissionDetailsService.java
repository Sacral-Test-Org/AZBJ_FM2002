package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.CommissionDetailsRepository;
import com.azbj.fm2002.model.CommissionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommissionDetailsService {

    private final CommissionDetailsRepository commissionDetailsRepository;

    @Autowired
    public CommissionDetailsService(CommissionDetailsRepository commissionDetailsRepository) {
        this.commissionDetailsRepository = commissionDetailsRepository;
    }

    public CommissionDetails getCommissionDetails(String agentCode) {
        return commissionDetailsRepository.findCommissionDetailsByAgentCode(agentCode);
    }
}
