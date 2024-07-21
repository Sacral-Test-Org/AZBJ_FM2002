package com.azbj.fm2002.repository;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class VerifiedAddressRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int checkExistingEntry(String contractId, String columnName) {
        String sql = "SELECT COUNT(ROWNUM) FROM azbj_sign_address_verification WHERE contract_id = ? AND column_name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{contractId, columnName}, Integer.class);
    }

    public void insertNewRecord(String contractId, String columnName, String verifiedFlag, String verifiedUser, Date verifiedDate, String columnDesc) {
        String sql = "INSERT INTO azbj_sign_address_verification(contract_id, column_name, verified_flag, verified_user, verified_date, column_desc) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, contractId, columnName, verifiedFlag, verifiedUser, verifiedDate, columnDesc);
    }

    public void commitTransaction() {
        String sql = "FORMS_DDL('COMMIT')";
        jdbcTemplate.execute(sql);
    }

    public Map<String, String> getVerifiedAddressDetails(String signCardNo, String verfNo) {
        String sql = "CALL azbj_get_verified_address_dtls(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Map<String, String> addressDetails = new HashMap<>();
        jdbcTemplate.query(sql, new Object[]{signCardNo, verfNo}, rs -> {
            addressDetails.put("DOOR_NO", rs.getString("DOOR_NO"));
            addressDetails.put("BUILDING_NAME", rs.getString("BUILDING_NAME"));
            addressDetails.put("PLOT_NO_STREET", rs.getString("PLOT_NO_STREET"));
            addressDetails.put("AREA", rs.getString("AREA"));
            addressDetails.put("STATE", rs.getString("STATE"));
            addressDetails.put("PLACE", rs.getString("PLACE"));
            addressDetails.put("DISTRICT", rs.getString("DISTRICT"));
            addressDetails.put("PINCODE", rs.getString("PINCODE"));
            addressDetails.put("COUNTRY", rs.getString("COUNTRY"));
            addressDetails.put("FAX", rs.getString("FAX"));
            addressDetails.put("TELEPHONE", rs.getString("TELEPHONE"));
            addressDetails.put("EMAIL", rs.getString("EMAIL"));
        });
        return addressDetails;
    }
}
