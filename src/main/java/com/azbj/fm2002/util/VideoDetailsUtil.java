package com.azbj.fm2002.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class VideoDetailsUtil {

    public static String getVideoURL(String applicationNumber, String verificationNumber, String signCardNumber, LocalDate dateOfBirth, int productId, String agentBusinessIdentifier) {
        String videoURL = null;
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Retrieve application number if not provided
            if (applicationNumber == null) {
                applicationNumber = getApplicationNumber(connection, verificationNumber, signCardNumber);
            }

            // Calculate age
            int age = calculateAge(dateOfBirth, LocalDate.now());

            if (applicationNumber != null) {
                if (productId == 297 || productId == 345) {
                    videoURL = getVideoURLFromVideoDtls(connection, applicationNumber);
                } else {
                    boolean isEligible = checkVideoEligibility(connection, applicationNumber);
                    if (isEligible) {
                        if (productId == 321) {
                            videoURL = getVideoURLForProduct321(connection, applicationNumber, agentBusinessIdentifier);
                        } else {
                            videoURL = getVideoURLForOtherProducts(connection, applicationNumber);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return videoURL;
    }

    private static String getApplicationNumber(Connection connection, String verificationNumber, String signCardNumber) throws SQLException {
        String applicationNumber = null;
        String query = "SELECT application_no FROM insured_person WHERE verification_no = ? OR sign_card_no = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, verificationNumber);
            preparedStatement.setString(2, signCardNumber);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    applicationNumber = resultSet.getString("application_no");
                }
            }
        }
        return applicationNumber;
    }

    private static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    private static String getVideoURLFromVideoDtls(Connection connection, String applicationNumber) throws SQLException {
        String videoURL = null;
        String query = "SELECT view_video_url FROM azbj_video_dtls WHERE module_flag = 'BLACKCAT' AND application_no = ? AND insert_time_stamp = (SELECT MAX(insert_time_stamp) FROM azbj_video_dtls WHERE module_flag = 'BLACKCAT' AND application_no = ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, applicationNumber);
            preparedStatement.setString(2, applicationNumber);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    videoURL = resultSet.getString("view_video_url");
                }
            }
        }
        return videoURL;
    }

    private static boolean checkVideoEligibility(Connection connection, String applicationNumber) throws SQLException {
        boolean isEligible = false;
        String query = "SELECT CASE WHEN COUNT(1) > 0 THEN 'Y' ELSE 'N' END AS eligible FROM azbj_proposal_appln_det_ext WHERE UPPER(med_pivc_flag) = 'VIDEO' AND appln_no = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, applicationNumber);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    isEligible = "Y".equals(resultSet.getString("eligible"));
                }
            }
        }
        return isEligible;
    }

    private static String getVideoURLForProduct321(Connection connection, String applicationNumber, String agentBusinessIdentifier) throws SQLException {
        String videoURL = null;
        String query = "SELECT NVL(url_path, 'X') AS url_path FROM azbj_pivc_dtls WHERE bi_no = ? AND ROWNUM = 1";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, agentBusinessIdentifier);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    videoURL = resultSet.getString("url_path");
                    if (!videoURL.startsWith("HTTP")) {
                        videoURL = getSystemConstant(connection, "PIVC_LINK", "PIVC_VIDEO") + applicationNumber;
                    }
                }
            }
        }
        return videoURL;
    }

    private static String getVideoURLForOtherProducts(Connection connection, String applicationNumber) throws SQLException {
        String videoURL = null;
        String query = "SELECT COUNT(1) AS video_count FROM balic.pdbdocument a, balic.ddt_1 WHERE folddocindex = documentindex AND UPPER(field_7) = ? AND UPPER(name) LIKE ? || '_VIDEOPIVC'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, applicationNumber.toUpperCase());
            preparedStatement.setString(2, applicationNumber.toUpperCase());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next() && resultSet.getInt("video_count") == 0) {
                    videoURL = getSystemConstant(connection, "PIVC_LINK", "PIVC_VIDEO") + applicationNumber;
                } else {
                    videoURL = getSystemConstant(connection, "PIVC_LINK", "PIVC_VIDEO") + applicationNumber;
                }
            }
        }
        return videoURL;
    }

    private static String getSystemConstant(Connection connection, String sysType, String sysCode) throws SQLException {
        String sysDesc = null;
        String query = "SELECT sys_desc FROM azbj_system_constants WHERE sys_type = ? AND sys_code = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, sysType);
            preparedStatement.setString(2, sysCode);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    sysDesc = resultSet.getString("sys_desc");
                }
            }
        }
        return sysDesc;
    }
}
