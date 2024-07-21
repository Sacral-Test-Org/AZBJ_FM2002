package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.MedUwRepository;
import com.azbj.fm2002.dto.MedicalTestDTO;
import com.azbj.fm2002.dto.ValidateTestRequest;
import com.azbj.fm2002.dto.ValidateTestResponse;
import com.azbj.fm2002.dto.DeleteMedicalTestRequest;
import com.azbj.fm2002.dto.DeleteMedicalTestResponse;
import com.azbj.fm2002.exception.DeleteMedicalTestException;
import com.azbj.fm2002.util.DeleteMedicalTestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MedUwService {

    @Autowired
    private MedUwRepository medUwRepository;

    public MedicalTestDTO addTest(MedicalTestDTO medicalTestDTO) {
        return medUwRepository.save(medicalTestDTO);
    }

    public void deleteTest(Long testId) {
        medUwRepository.deleteById(testId);
    }

    public MedicalTestDTO validateTest(Long testId) {
        return medUwRepository.findById(testId).orElse(null);
    }

    public List<MedicalTestDTO> accessMedicalsGrid() {
        return medUwRepository.findAll();
    }

    public boolean validateDate(Date muDateRecd, Date opusDate) {
        return !muDateRecd.after(opusDate);
    }

    public boolean markAsRetest(Long testId) {
        MedicalTestDTO test = medUwRepository.findTestById(testId);
        if (test == null) {
            return false;
        }
        if (test.isRetest()) {
            return false;
        }
        test.setRetest(true);
        medUwRepository.save(test);
        return true;
    }

    public void updateDateReceived(String resultReceived) {
        if ("Y".equals(resultReceived)) {
            // Update the "Date Received" field with the current date
            // Update global flags clean_fmr_flag and clean_fmr to 'N'
        } else if ("N".equals(resultReceived)) {
            // Clear the "Date Received" field
            // Update global flags clean_fmr_flag and clean_fmr to 'N'
        }
    }

    public ValidationResponse validateTestConductedFrom(String agentCode, String testNumber, String testConductedFrom) {
        // Implement the validation logic based on the specified conditions
        return new ValidationResponse();
    }

    public boolean validateMedicalType(String medicalType, boolean isSystemGenerated) {
        if (!isSystemGenerated && "REG_M".equals(medicalType)) {
            return false;
        }
        if (isSystemGenerated && !"REG_M".equals(medicalType)) {
            return false;
        }
        return true;
    }

    public void updateReceiptStatus(String receiptStatus) {
        if ("Y".equals(receiptStatus)) {
            // Set the receipt date to the current date if not already set
            // Update the receipt date variable
        } else if ("N".equals(receiptStatus)) {
            // Clear the receipt date
            // Reset the receipt date variable to null
            // Set the global and agent flags to 'N'
        } else if ("W".equals(receiptStatus) || "NR".equals(receiptStatus)) {
            // Call a procedure to handle waived requirements
            // Navigate to the next or previous record based on the key pressed
        }
        // Update the user who raised the medical request if the receipt status is 'Y' or 'N'
    }

    public ValidateTestResponse validateTest(ValidateTestRequest request) {
        // Call the necessary repository methods to perform the validation
        return new ValidateTestResponse();
    }

    public DeleteMedicalTestResponse deleteMedicalTest(DeleteMedicalTestRequest request) throws DeleteMedicalTestException {
        boolean isLockedAndConveyed = medUwRepository.checkIfLockedAndConveyed(request.getPartnerId(), request.getApplicationNo(), request.getMedTestId());
        if (isLockedAndConveyed) {
            throw new DeleteMedicalTestException("Test is locked and conveyed to partner.");
        }
        medUwRepository.clearTestConductedFrom(request.getPartnerId(), request.getApplicationNo());
        boolean hasReTests = medUwRepository.checkForReTests(request.getTestNo(), request.getIpType());
        if (hasReTests) {
            throw new DeleteMedicalTestException("Re-tests present for the current test.");
        }
        medUwRepository.deleteMedicalTest(request.getMedTestId());
        DeleteMedicalTestUtil.logDeletion(request.getContractId(), request.getTestNo(), request.getIpType(), request.getUser(), new Date());
        return new DeleteMedicalTestResponse("Test deleted successfully.");
    }

    public List<MedUwResponse> getMedicalUnderwritingDetails() {
        return medUwRepository.findAll();
    }

    public void saveMedicalUnderwritingDetails(MedUwRequest request) {
        medUwRepository.save(request);
    }
}
