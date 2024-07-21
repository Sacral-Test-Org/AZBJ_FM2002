package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.AccountDetailsRepository;
import com.azbj.fm2002.model.BankDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailsService {

    @Autowired
    private AccountDetailsRepository accountDetailsRepository;

    public BankDetails fetchBankDetails(String ifscCode) {
        BankDetails bankDetails = accountDetailsRepository.findBankDetailsByIfscCode(ifscCode);
        if (bankDetails == null) {
            bankDetails = new BankDetails();
            bankDetails.setBankName("");
            bankDetails.setBankBranch("");
            bankDetails.setMicr("");
        }
        return bankDetails;
    }
}
