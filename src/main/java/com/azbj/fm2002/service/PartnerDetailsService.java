package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.PartnerDetailsRepository;
import com.azbj.fm2002.dto.PartnerDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnerDetailsService {

    @Autowired
    private PartnerDetailsRepository partnerDetailsRepository;

    public PartnerDetailsDTO fetchPartnerDetails(String partnerName) {
        if (partnerName == null || partnerName.isEmpty()) {
            return new PartnerDetailsDTO(); // Return empty DTO if partner name is empty
        }
        try {
            return partnerDetailsRepository.getPartnerDetails(partnerName);
        } catch (Exception e) {
            return new PartnerDetailsDTO(); // Return empty DTO if any exception occurs
        }
    }
}
