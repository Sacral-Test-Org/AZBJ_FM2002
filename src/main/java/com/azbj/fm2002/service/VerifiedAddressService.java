package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.VerifiedAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Service
public class VerifiedAddressService {

    @Autowired
    private VerifiedAddressRepository verifiedAddressRepository;

    public Map<String, String> verifyAddress(HttpServletRequest request) {
        String contractId = request.getParameter("contractId");
        String signCardNo = request.getParameter("signCardNo");
        String verfNo = request.getParameter("verfNo");
        String columnName = "ADDRESS";
        String verifiedFlag = "Y";
        String verifiedUser = request.getUserPrincipal().getName();
        Date verifiedDate = new Date();
        String columnDesc = null;

        // Check if an entry for the address verification already exists
        int existingEntries = verifiedAddressRepository.checkExistingEntry(contractId, columnName);

        if (existingEntries == 0) {
            // Insert a new record
            verifiedAddressRepository.insertNewRecord(contractId, columnName, verifiedFlag, verifiedUser, verifiedDate, columnDesc);
            // Commit the transaction
            verifiedAddressRepository.commitTransaction();
        }

        // Retrieve and display the verified address details
        Map<String, String> verifiedAddressDetails = verifiedAddressRepository.getVerifiedAddressDetails(signCardNo, verfNo);

        return verifiedAddressDetails;
    }
}
