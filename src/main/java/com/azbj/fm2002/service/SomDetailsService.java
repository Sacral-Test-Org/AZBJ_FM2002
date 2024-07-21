package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.SomDetailsRepository;
import com.azbj.fm2002.dto.SomDetails;
import com.azbj.fm2002.dto.HubInchargeDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SomDetailsService {

    @Autowired
    private SomDetailsRepository somDetailsRepository;

    public List<SomDetails> getSomDetails() {
        return somDetailsRepository.findSomDetails();
    }

    public boolean validateFlag() {
        return somDetailsRepository.validateFlag();
    }

    public void updateProposalStatus() {
        somDetailsRepository.updateProposalStatus();
    }

    public HubInchargeDetailsDTO getHubInchargeDetails(String branchCode, String applicationNo) {
        return somDetailsRepository.findHubInchargeDetails(branchCode, applicationNo);
    }
}
