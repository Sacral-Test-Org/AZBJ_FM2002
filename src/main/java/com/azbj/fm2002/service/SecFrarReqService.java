package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.SecFrarReqRepository;
import com.azbj.fm2002.dto.SecFrarReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecFrarReqService {

    @Autowired
    private SecFrarReqRepository secFrarReqRepository;

    public List<SecFrarReqDTO> getFrarRequirements() {
        return secFrarReqRepository.findAll();
    }

    public void saveComments(String comments) {
        // Assuming there's a method in the repository to save comments
        secFrarReqRepository.saveComments(comments);
    }

    public boolean authenticate(String supervisorId, String password) {
        // Assuming there's a method in the repository to authenticate
        return secFrarReqRepository.authenticate(supervisorId, password);
    }

    public String getReasonDescription(int reason) {
        switch (reason) {
            case 1:
                return "Document Required";
            case 2:
                return "Internal Requirement";
            case 3:
                return "Image not clear";
            case 4:
                return "Suspect document";
            case 5:
                return "Image not clear";
            default:
                return "Unknown reason";
        }
    }

    public String approveRequest(SecFrarReqDTO secFrarReqDTO) {
        if (secFrarReqDTO.getUwReason() == null) {
            return "U/W Reason not selected";
        }
        if (secFrarReqDTO.getUwReason() == 1 && (secFrarReqDTO.getSupervisorComments() == null || secFrarReqDTO.getSupervisorComments().isEmpty())) {
            return "Please Select Supervisor comment";
        }
        if (secFrarReqDTO.getSupervisorId() == null || secFrarReqDTO.getSupervisorId().isEmpty()) {
            return "Please enter Supervisor ID";
        }
        if (secFrarReqDTO.getPassword() == null || secFrarReqDTO.getPassword().isEmpty()) {
            return "Please enter Password";
        }

        boolean isAuthenticated = authenticate(secFrarReqDTO.getSupervisorId(), secFrarReqDTO.getPassword());
        if (isAuthenticated) {
            int updatedRecords = secFrarReqRepository.updateRecords(secFrarReqDTO.getSupervisorId(), secFrarReqDTO.getPassword());
            if (updatedRecords > 0) {
                return "Approved";
            } else {
                return "Approval failed";
            }
        } else {
            return "Authentication failed";
        }
    }
}