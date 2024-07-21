package com.azbj.fm2002.repository;

import com.azbj.fm2002.dto.BlockAlertValidationRequest;
import com.azbj.fm2002.dto.BlockAlertValidationResponse;
import com.azbj.fm2002.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class BlockAlertRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BlockAlertValidationResponse validateConditions(BlockAlertValidationRequest request) {
        // Logic to validate conditions
        // This is a placeholder logic. Replace with actual database interaction logic.
        boolean isValid = true;
        // Perform necessary database interactions here
        return new BlockAlertValidationResponse(isValid);
    }

    public String getUnitlinkValue(String cn_product_id) {
        // Logic to get unitlink value from the database
        String sql = "SELECT unitlink FROM products WHERE product_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{cn_product_id}, String.class);
    }

    public boolean findConditions(BlockAlertValidationRequest request) {
        // Logic to find conditions from the database
        // This is a placeholder logic. Replace with actual database interaction logic.
        String sql = "SELECT COUNT(*) FROM conditions WHERE ..."; // Add actual condition
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count > 0;
    }

    public void updatePolicy(BlockAlertValidationRequest request) {
        // Logic to update policy status in the database
        String sql = "UPDATE policies SET status = ? WHERE policy_id = ?";
        jdbcTemplate.update(sql, request.getStatus(), request.getPolicyId());
    }

    public void deleteFromAzbjChkBackdation(String policyRef) {
        // Logic to delete records from azbj_chk_backdation table
        String sql = "DELETE FROM azbj_chk_backdation WHERE policy_ref = ?";
        jdbcTemplate.update(sql, policyRef);
    }

    public void insertIntoAzbjChkBackdation(String policyRef, String saveFlag, String userId, Date timeStamp) {
        // Logic to insert records into azbj_chk_backdation table
        String sql = "INSERT INTO azbj_chk_backdation (policy_ref, save_flag, user_id, time_stamp) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, policyRef, saveFlag, userId, timeStamp);
    }

    public Product findProductById(String productId) {
        // Logic to fetch product details based on product ID
        String sql = "SELECT * FROM products WHERE product_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{productId}, (rs, rowNum) ->
                new Product(rs.getString("product_id"), rs.getString("name"), rs.getString("unitlink")));
    }
}
