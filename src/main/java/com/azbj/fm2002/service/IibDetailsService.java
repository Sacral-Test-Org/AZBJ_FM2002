package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.IibDetailsRepository;
import com.azbj.fm2002.model.IibDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IibDetailsService {

    @Autowired
    private IibDetailsRepository iibDetailsRepository;

    public List<IibDetails> getIibMatchedDetails(String transactionId) {
        // Fetch IIB matched details based on the transaction ID
        return iibDetailsRepository.findByTransactionId(transactionId);
    }
}
