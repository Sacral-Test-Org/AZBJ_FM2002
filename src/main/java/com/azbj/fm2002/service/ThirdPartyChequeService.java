package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.ThirdPartyChequeRepository;
import com.azbj.fm2002.dto.ThirdPartyChequeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThirdPartyChequeService {

    @Autowired
    private ThirdPartyChequeRepository thirdPartyChequeRepository;

    public ThirdPartyChequeDTO manageThirdPartyChequeDetails(ThirdPartyChequeDTO thirdPartyChequeDTO) {
        // Business logic for managing third-party cheque details
        // Save the third-party cheque details using the repository
        return thirdPartyChequeRepository.save(thirdPartyChequeDTO);
    }
}
