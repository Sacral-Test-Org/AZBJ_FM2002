package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.PanelDoctorRepository;
import com.azbj.fm2002.dto.*;
import com.azbj.fm2002.exception.DoctorSignatureException;
import com.azbj.fm2002.util.PanelDoctorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanelDoctorService {

    @Autowired
    private PanelDoctorRepository panelDoctorRepository;

    public DoctorDetails validateDoctorCode(String doctorCode) {
        return panelDoctorRepository.findDoctorByCode(doctorCode);
    }

    public void deleteDoctor(String doctorCode) {
        panelDoctorRepository.deleteDoctorByCode(doctorCode);
    }

    public List<DoctorPanelData> populateDoctorPanel() {
        return panelDoctorRepository.findAllDoctors();
    }

    public List<ImageData> viewImages(String doctorCode) {
        return panelDoctorRepository.findImagesByDoctorCode(doctorCode);
    }

    public String getOpusDate() {
        return panelDoctorRepository.getOpusDate();
    }

    public boolean validateDateReceived(String dateReceived) {
        String opusDate = getOpusDate();
        return PanelDoctorUtil.isDateEqual(dateReceived, opusDate);
    }

    public String validateDoctorCode(String lifeType, String testCode, String applicationNo) {
        return panelDoctorRepository.findDoctorCode(lifeType, testCode, applicationNo);
    }

    public List<Doctor> fetchDoctorNames() {
        return panelDoctorRepository.findDoctorNames();
    }

    public PanelDoctorValidationResponse validateTestCode(PanelDoctorValidationRequest request) {
        boolean isAuthorized = panelDoctorRepository.checkDoctorAuthorization(request.getDoctorCode(), request.getTestCode());
        PanelDoctorValidationResponse response = new PanelDoctorValidationResponse();
        response.setAuthorized(isAuthorized);
        return response;
    }

    public boolean checkPaymentStatusAndDelete(String doctorCode, String testCode) {
        boolean isPaid = panelDoctorRepository.checkPaymentStatus(doctorCode, testCode);
        if (!isPaid) {
            panelDoctorRepository.deleteDoctorRecord(doctorCode, testCode);
            return true;
        }
        return false;
    }

    public List<DoctorDetailsDTO> fetchDoctorDetails(String policyRef) {
        return panelDoctorRepository.fetchDoctorDetails(policyRef);
    }

    public DoctorSignatureDTO verifyDoctorSignature(String doctorCode) throws DoctorSignatureException {
        try {
            return panelDoctorRepository.findDoctorSignature(doctorCode);
        } catch (Exception e) {
            throw new DoctorSignatureException("Error verifying doctor signature", e);
        }
    }

    public List<DoctorClientNamesResponse> fetchClientNames(String doctorCode) {
        return panelDoctorRepository.findClientNamesByDoctorCode(doctorCode);
    }
}
