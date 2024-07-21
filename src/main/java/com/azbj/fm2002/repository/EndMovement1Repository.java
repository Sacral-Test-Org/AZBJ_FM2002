package com.azbj.fm2002.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EndMovement1Repository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertComment(String comment) {
        String sql = "INSERT INTO azbj_uw_comments (comment) VALUES (?)";
        jdbcTemplate.update(sql, comment);
    }

    public void updateProposalStatus(String status) {
        String sql = "UPDATE azbj_phub_tracker SET status = ? WHERE some_condition = true";
        jdbcTemplate.update(sql, status);
    }

    public void deleteComment(Long commentId) {
        String sql1 = "DELETE FROM azbj_uw_comments WHERE comment_id = ?";
        String sql2 = "DELETE FROM azbj_deqc_reason_comments WHERE comment_id = ?";
        jdbcTemplate.update(sql1, commentId);
        jdbcTemplate.update(sql2, commentId);
    }

    public void logActivity(String activityDetails) {
        String sql = "INSERT INTO azbj_bbu_activity_dtls (activity_details) VALUES (?)";
        jdbcTemplate.update(sql, activityDetails);
    }

    public void setPolicyNumber(String policyNumber) {
        String sql = "UPDATE azbj_rv_approval_cases SET policy_number = ? WHERE some_condition = true";
        jdbcTemplate.update(sql, policyNumber);
    }
}
