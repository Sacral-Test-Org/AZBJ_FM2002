package com.azbj.fm2002.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientEnvironmentValidationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean validatePartnerReferences(String insuredPersonPartnerRef, String policyHolderPartnerRef) {
        if (insuredPersonPartnerRef == null || policyHolderPartnerRef == null) {
            return false;
        }
        return true;
    }

    public int checkEntries(String contractId, int ipNo) {
        String sql = "SELECT COUNT(1) FROM azbj_ip_ext WHERE contract_id = ? AND ip_no = ?";
        Integer count1 = jdbcTemplate.queryForObject(sql, new Object[]{contractId, ipNo}, Integer.class);

        sql = "SELECT COUNT(1) FROM wip_azbj_ip_ext WHERE contract_id = ? AND ip_no = ?";
        Integer count2 = jdbcTemplate.queryForObject(sql, new Object[]{contractId, ipNo}, Integer.class);

        return count1 + count2;
    }

    public void updateOrInsertPolicyCovers(String contractId, String coverCode, double sumInsured) {
        String updateSql = "UPDATE azbj_policy_covers_risk_sa SET sum_insured_whole_cover = ?, claimable_sa = ? WHERE contract_id = ? AND cover_code = ?";
        int rowsAffected = jdbcTemplate.update(updateSql, sumInsured, sumInsured, contractId, coverCode);

        if (rowsAffected == 0) {
            String insertSql = "INSERT INTO azbj_policy_covers_risk_sa (contract_id, action_code, top_indicator, product_id, cover_code, sum_insured_whole_cover, claimable_sa, claimable_year, create_date) VALUES (?, 'A', 'Y', ?, ?, ?, ?, 0, SYSDATE)";
            jdbcTemplate.update(insertSql, contractId, "product_id_placeholder", coverCode, sumInsured, sumInsured);
        }
    }

    public void updateOrInsertPreferredIC(String agentCode) {
        String countSql = "SELECT COUNT(*) FROM azbj_ic_upload_dtls WHERE ic_code = ? AND ic_type = 'PREFERRED_IC'";
        Integer count = jdbcTemplate.queryForObject(countSql, new Object[]{agentCode}, Integer.class);

        if (count > 0) {
            String updateSql = "UPDATE AZBJ_MEDUW_PREFERED_IC SET ACTIVE_FLAG = 'Y', CREATE_DATE = SYSDATE, CREATE_USER = USER WHERE AGENT_CODE = ?";
            int rowsAffected = jdbcTemplate.update(updateSql, agentCode);

            if (rowsAffected == 0) {
                String insertSql = "INSERT INTO AZBJ_MEDUW_PREFERED_IC (AGENT_CODE, ACTIVE_FLAG, CREATE_USER, CREATE_DATE) VALUES (?, 'Y', USER, SYSDATE)";
                jdbcTemplate.update(insertSql, agentCode);
            }
        }
    }

    public int checkExistingTransactions(String applicationNumber) {
        String sql = "SELECT COUNT(1) FROM bbu_trans a, bbu_trans_dtls b WHERE a.trans_id = b.trans_id AND action_id = 2 AND a.appl_no = NVL(?, TO_CHAR(?))";
        return jdbcTemplate.queryForObject(sql, new Object[]{applicationNumber, applicationNumber}, Integer.class);
    }

    public List<ManualCasePushDTO> retrieveMessages(String applicationNumber) {
        String sql = "SELECT DISTINCT (CASE WHEN source_flag = 'RULE' THEN 'Rule No ' WHEN source_flag = 'QC' THEN 'Question No ' WHEN source_flag = 'MED' THEN 'Medical Requirements' ELSE NULL END || NVL(a.rule_config_id, a.question_id) || '(' || NVL(fixed_msg, question_desc) || ')' || ' Raised Requirement ' || sys_code || '( ' || sys_desc || ' )' || (CASE WHEN req_received_date IS NOT NULL THEN ' And Received at DEQC' ELSE ' And Not received at DEQC' END) rule_message, (CASE WHEN source_flag = 'RULE' THEN 'Rule Configurator' WHEN source_flag = 'MED' THEN 'Medical Requirements' WHEN source_flag = 'QC' THEN 'QC REQUIREMENTS' ELSE NULL END) param_type FROM bbu_trans_rule_req_dtls a, azbj_system_constants b, bbu_rule_config c, azbj_qc_questions d, bbu_trans e WHERE a.trans_id = e.trans_id AND e.appl_no = NVL(?, TO_CHAR(?)) AND a.req_code = b.sys_code AND a.rule_config_id = c.rule_config_id(+) AND a.question_id = d.question_id(+) UNION ALL SELECT UNIQUE 'Question No ' || TO_NUMBER(SUBSTR(rule_message, 36, LENGTH(rule_message))) || '(' || d.question_desc || ') Failed at DEQC', 'QC REQUIREMENTS' FROM bbu_trans_dtls a, azbj_qc_questions d, bbu_trans b WHERE a.trans_id = b.trans_id AND b.appl_no = NVL(?, TO_CHAR(?)) AND action_id = 2 AND rule_message <> 'QC Requirements raised.' AND TO_NUMBER(SUBSTR(rule_message, 36, LENGTH(rule_message))) = d.question_id(+) AND param_val_string = 'QC REQUIREMENTS' AND 1 = (CASE WHEN rule_message NOT LIKE 'QC Failed for question %' AND rule_message NOT LIKE 'QC Requirements raised for question %' THEN 0 ELSE 1 END) AND NOT EXISTS (SELECT 1 FROM azbj_qc_ques_req WHERE question_id = TO_NUMBER(SUBSTR(rule_message, 36, LENGTH(rule_message)))) AND LENGTH(rule_message) > 23 UNION ALL SELECT UNIQUE (CASE WHEN a.rule_config_id IS NOT NULL THEN 'Rule No ' || a.rule_config_id || '( ' || rule_message || ' ) Failed at Rule Configurator ' ELSE rule_message END), (CASE WHEN a.rule_config_id IS NOT NULL THEN 'Rule Configurator' ELSE param_val_string END) FROM bbu_trans_dtls a, bbu_rule_config d, bbu_trans c WHERE NOT EXISTS (SELECT * FROM bbu_req_rule b WHERE b.rule_config_id = a.rule_config_id) AND a.rule_config_id = d.rule_config_id(+) AND a.trans_id = c.trans_id AND a.action_id = 2 AND c.appl_no = NVL(?, TO_CHAR(?)) AND a.rule_config_id IS NOT NULL UNION ALL SELECT UNIQUE a.rule_message rule_description, param_val_string FROM bbu_trans_dtls a, bbu_trans b WHERE a.action_id = 2 AND a.trans_id = b.trans_id AND b.appl_no = NVL(?, TO_CHAR(?)) AND rule_message NOT IN ('Medical Requirements raised in UW Rule Validations', 'Product Validations Failed.', 'QC Requirements raised.', 'Issuance Validations Failure...ORA-0000: normal, successful completion') AND rule_message NOT LIKE 'QC Requirements raised for question%' AND param_val_string IN ('PRODUCT VALIDATIONS', 'UW RULES', 'QC REQUIREMENTS', 'ISSUANCE') ORDER BY 2";
        return jdbcTemplate.query(sql, new Object[]{applicationNumber, applicationNumber, applicationNumber, applicationNumber, applicationNumber, applicationNumber, applicationNumber, applicationNumber}, (rs, rowNum) -> new ManualCasePushDTO(rs.getString("rule_message"), rs.getString("param_type")));
    }
}
