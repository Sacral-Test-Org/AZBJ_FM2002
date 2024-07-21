package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.PanApprovalRepository;
import com.azbj.fm2002.dto.PanApprovalDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanApprovalService {

    @Autowired
    private PanApprovalRepository panApprovalRepository;

    public void saveApprovalStatus(String approvalStatus) {
        panApprovalRepository.saveApprovalStatus(approvalStatus);
    }

    public List<PanApprovalDetailsDTO> getPanApprovalDetails(String applicationNumber) {
        return panApprovalRepository.findPanApprovalDetails(applicationNumber);
    }
}
