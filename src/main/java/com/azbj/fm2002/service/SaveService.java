package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.SaveRepository;
import com.azbj.fm2002.dto.SaveReasonDTO;
import com.azbj.fm2002.dto.SeniorUnderwriterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaveService {

    @Autowired
    private SaveRepository saveRepository;

    public String getSelectedAction() {
        return saveRepository.findSelectedAction();
    }

    public void setSelectedAction(String action) {
        saveRepository.saveSelectedAction(action);
    }

    public List<SeniorUnderwriterDTO> fetchSeniorUnderwriters() {
        return saveRepository.findSeniorUnderwriters();
    }

    public void updateStatus(String action) {
        String status = null;
        if ("ISSUED".equals(action)) {
            status = "IM";
        } else if ("REJECTED".equals(action) || "DECLINED".equals(action)) {
            status = "RM";
        }
        saveRepository.updateStatus(status);
    }

    public void saveReason(SaveReasonDTO saveReasonDTO) {
        saveRepository.saveReason(saveReasonDTO);
    }

    public Optional<SaveReasonDTO> getReason(Long id) {
        return saveRepository.findById(id);
    }

    public void setFlag(String svExRsn) {
        String flag = (svExRsn == null || svExRsn.isEmpty()) ? "N" : "Y";
        saveRepository.updateFlag(flag);
    }

    public void handleException(Exception e) {
        // Log the exception using a logging framework like Log4j
        // For example: logger.error("An error occurred", e);
    }

    public String saveReason(SaveReasonDTO saveReasonDTO) {
        if (saveReasonDTO.getReason() == null || saveReasonDTO.getReason().isEmpty()) {
            return "Please enter reason for Save & Exit and proceed.";
        }
        try {
            Long eventNo = saveRepository.getMaxEventNo(saveReasonDTO.getContractId()) + 1;
            saveReasonDTO.setEventNo(eventNo);
            saveRepository.saveReason(saveReasonDTO);
            return "Reason saved successfully, please continue.";
        } catch (Exception e) {
            handleException(e);
            return "An error occurred while saving the reason.";
        }
    }
}
