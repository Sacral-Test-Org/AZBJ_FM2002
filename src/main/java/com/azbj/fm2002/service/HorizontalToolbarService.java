package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.HorizontalToolbarRepository;
import com.azbj.fm2002.dto.DeleteRecordRequest;
import com.azbj.fm2002.dto.SaveChangesRequest;
import com.azbj.fm2002.dto.SaveChangesResponse;
import com.azbj.fm2002.dto.ExitValidationResponse;
import com.azbj.fm2002.repository.AzbjSystemConstantsRepository;
import com.azbj.fm2002.repository.AzbjUwRequirementsRaisedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorizontalToolbarService {

    @Autowired
    private HorizontalToolbarRepository horizontalToolbarRepository;

    @Autowired
    private AzbjSystemConstantsRepository azbjSystemConstantsRepository;

    @Autowired
    private AzbjUwRequirementsRaisedRepository azbjUwRequirementsRaisedRepository;

    public void deleteRecord(DeleteRecordRequest request) {
        // Check for help or guidance related to the action
        checkHelpContext();
        // Proceed to delete the current record from the dataset
        horizontalToolbarRepository.deleteById(request.getRecordId());
        // Provide feedback or confirmation
        System.out.println("Record deleted successfully.");
    }

    public void checkHelpContext() {
        // Logic to check for help context and execute the 'F2' key trigger
        horizontalToolbarRepository.checkHelpContext();
    }

    public ExitValidationResponse validateExit() {
        ExitValidationResponse response = new ExitValidationResponse();
        // Validate if medical values are enabled
        List<MedicalValue> medicalValues = azbjUwRequirementsRaisedRepository.getMedicalValues("someContractId");
        if (!medicalValues.isEmpty()) {
            response.setCancExitEnabled(true);
        }
        // Check the dispatch flag for the contract ID
        String dispatchFlag = azbjSystemConstantsRepository.getSystemConstant("HUB", "SAVE_EXIT", "SAVE and EXIT button enable/disable");
        if ("N".equals(dispatchFlag)) {
            response.setCancExitEnabled(true);
        }
        // Check user flag
        if ("Y".equals("someUserFlag")) {
            response.setSaveExitEnabled(true);
        }
        // Handle exceptions and display appropriate error messages
        try {
            // Additional validation logic here
        } catch (Exception e) {
            response.setErrorMessage("An error occurred during the exit process.");
        }
        return response;
    }

    public SaveChangesResponse saveChanges(SaveChangesRequest request) {
        // Call the saveChanges method from the repository and handle the response
        SaveChangesResponse response = horizontalToolbarRepository.saveChanges(request);
        // Log the save action with relevant contract and insured person details
        System.out.println("Save action logged for contract: " + request.getContractId());
        return response;
    }

    public void enableCommitFormButton() {
        // Implement the business logic to enable the "Commit Form" button
        System.out.println("Commit Form button enabled.");
    }
}
