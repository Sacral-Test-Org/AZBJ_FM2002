package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.SignatureConfidenceRepository;
import com.azbj.fm2002.model.SignatureConfidence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignatureConfidenceService {

    @Autowired
    private SignatureConfidenceRepository signatureConfidenceRepository;

    public List<SignatureConfidence> getSignatureConfidenceDetails(String applicationNumber) {
        return signatureConfidenceRepository.findSignatureConfidenceDetails(applicationNumber);
    }

    public String generateSecureUrl(String type, String category, String id) {
        String verificationOrSignCardNumber = signatureConfidenceRepository.fetchVerificationOrSignCardNumber(id);
        if (verificationOrSignCardNumber == null) {
            return null;
        }
        return azbj_encrypt_dms_link(type, category, verificationOrSignCardNumber);
    }

    private String azbj_encrypt_dms_link(String type, String category, String id) {
        // Assuming this is a placeholder for the actual encryption logic
        return "https://secure.url/" + type + "/" + category + "/" + id;
    }
}
