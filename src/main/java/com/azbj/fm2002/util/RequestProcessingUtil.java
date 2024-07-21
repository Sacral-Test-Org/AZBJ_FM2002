package com.azbj.fm2002.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.azbj.fm2002.dto.RequestProcessingDTO;
import com.azbj.fm2002.service.DatabaseService;

public class RequestProcessingUtil {

    private static final Logger logger = Logger.getLogger(RequestProcessingUtil.class.getName());

    public static String determineRaisedBy(String testNumber, String contractId) {
        String raisedBy = "USER CALLED";
        String query = "SELECT CASE WHEN COUNT(1) > 0 THEN 'SYS-USER CALLED' ELSE 'USER CALLED' END AS RAISED_BY " +
                       "FROM wip_azbj_med_uw WHERE contract_id IN (SELECT contract_id FROM wip_azbj_policy_bases_ext " +
                       "WHERE sign_Card_no = TO_CHAR(NVL(:insured_person.ip_verf_no, :insured_person.ip_sign_card_no))) " +
                       "AND testno = ?";
        try (Connection connection = DatabaseService.getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, testNumber);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    raisedBy = resultSet.getString("RAISED_BY");
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error determining raised by field", e);
        }
        return raisedBy;
    }

    public static void processRequest(RequestProcessingDTO requestProcessingDTO) {
        logger.info("Processing request: " + requestProcessingDTO);
        // Validate request type
        if ("MED".equals(requestProcessingDTO.getRequestType())) {
            // Navigate to medical underwriting section
            logger.info("Navigating to medical underwriting section");
            if (requestProcessingDTO.getTestNumber() != null) {
                // Create new record if no test number exists
                logger.info("Creating new record in medical underwriting section");
                // Populate fields
                requestProcessingDTO.setValidationControl("N");
                String raisedBy = determineRaisedBy(requestProcessingDTO.getTestNumber(), requestProcessingDTO.getContractId());
                requestProcessingDTO.setRaisedBy(raisedBy);
                if (requestProcessingDTO.getPolicyHolder().equals(requestProcessingDTO.getInsured())) {
                    requestProcessingDTO.setInsuredPersonType(1);
                }
                // Disable test number field
                requestProcessingDTO.setTestNumberDisabled(true);
                // Navigate to results received field
                logger.info("Navigating to results received field");
            }
        } else {
            // Navigate to further requests section
            logger.info("Navigating to further requests section");
            if (requestProcessingDTO.getTestNumber() != null) {
                // Create new record if no test number exists
                logger.info("Creating new record in further requests section");
                // Populate fields
                requestProcessingDTO.setResultsReceived("N");
                String raisedBy = determineRaisedBy(requestProcessingDTO.getTestNumber(), requestProcessingDTO.getContractId());
                requestProcessingDTO.setRaisedBy(raisedBy);
                if (requestProcessingDTO.getPolicyHolder().equals(requestProcessingDTO.getInsured())) {
                    requestProcessingDTO.setInsuredPersonType(1);
                }
                // Disable test number field
                requestProcessingDTO.setTestNumberDisabled(true);
                // Navigate to results received field
                logger.info("Navigating to results received field");
            }
        }
    }
}