package com.azbj.fm2002.repository;

import com.azbj.fm2002.dto.CounterOfferDTO;
import com.azbj.fm2002.dto.CounterOfferRequest;
import com.azbj.fm2002.dto.CounterOfferValidationRequest;
import com.azbj.fm2002.dto.CounterOfferValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CounterOfferRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveCounterOfferDetails(CounterOfferDTO counterOfferDetails) {
        String sql = "INSERT INTO CUSTOMER.AZBJ_MODIFIED_OFFER (policy_ref, contract_id, APPLICATION_NO, activity_no, activity_date, event_type, user_id, TOP_INDICATOR, product_id, package_code, cover_code, sum_assured, benefit_term, premium_term, premium, GST, DEPOSIT_COLL, BOP, CHECK_CO_FLAG, multiplier, ml_perc, ml_amt, oc_perc, oc_amt, sr_perc, sr_amt, nri_perc, nri_amt, CO_REASON1, CO_REASON2, CO_REASON3, sign_mismatch_flg, OLD_BI_NO, B_URL, BI_NO, B_MESSAGE, B_STEP, B_STATUS, B_PREMIUM_TERM, B_BENEFIT_TERM, B_PREM, B_SUM_ASSURED, B_QUOTEID, RIDER_NAME, RIDER_COVER) VALUES (?, ?, TO_CHAR(NVL(?, ?)), ?, NVL(?, SYSDATE), ?, USER, 'Y', ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_number(?), to_number(?), to_number(?), to_number(?), to_number(?), to_number(?), to_number(?), to_number(?), ?, ?, ?, ?, ?, ?, ?, ?, ?, to_number(?), to_number(?), to_number(?), to_number(?), ?, ?, ?);";
        jdbcTemplate.update(sql, counterOfferDetails.getPolicyRef(), counterOfferDetails.getContractId(), counterOfferDetails.getApplicationNo(), counterOfferDetails.getActivityNo(), counterOfferDetails.getActivityDate(), counterOfferDetails.getEventType(), counterOfferDetails.getProductId(), counterOfferDetails.getPackageCode(), counterOfferDetails.getCoverCode(), counterOfferDetails.getSumAssured(), counterOfferDetails.getBenefitTerm(), counterOfferDetails.getPremiumTerm(), counterOfferDetails.getPremium(), counterOfferDetails.getGst(), counterOfferDetails.getDepositColl(), counterOfferDetails.getBop(), counterOfferDetails.getCheckCoFlag(), counterOfferDetails.getMultiplier(), counterOfferDetails.getMlPerc(), counterOfferDetails.getMlAmt(), counterOfferDetails.getOcPerc(), counterOfferDetails.getOcAmt(), counterOfferDetails.getSrPerc(), counterOfferDetails.getSrAmt(), counterOfferDetails.getNriPerc(), counterOfferDetails.getNriAmt(), counterOfferDetails.getCoReason1(), counterOfferDetails.getCoReason2(), counterOfferDetails.getCoReason3(), counterOfferDetails.getSignMismatchFlg(), counterOfferDetails.getOldBiNo(), counterOfferDetails.getBUrl(), counterOfferDetails.getBiNo(), counterOfferDetails.getBMessage(), counterOfferDetails.getBStep(), counterOfferDetails.getBStatus(), counterOfferDetails.getBPremiumTerm(), counterOfferDetails.getBBenefitTerm(), counterOfferDetails.getBPrem(), counterOfferDetails.getBSumAssured(), counterOfferDetails.getBQuoteid(), counterOfferDetails.getRiderName(), counterOfferDetails.getRiderCover());
    }

    public {productLinkedToUnit: boolean, groupProductStatus: string} findProductAndGroupStatus(String productId, String groupId) {
        String sql = "SELECT product_linked_to_unit, group_product_status FROM product_group_status WHERE product_id = ? AND group_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{productId, groupId}, (rs, rowNum) -> new {productLinkedToUnit: rs.getBoolean("product_linked_to_unit"), groupProductStatus: rs.getString("group_product_status")});
    }

    public int checkExistingOffers(String policyRef) {
        String sql = "SELECT COUNT(1) FROM AZBJ_MODIFIED_OFFER WHERE policy_ref = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{policyRef}, Integer.class);
    }

    public void updateExistingOffers(String policyRef) {
        String sql = "UPDATE AZBJ_MODIFIED_OFFER SET TOP_INDICATOR = 'N' WHERE policy_ref = ?";
        jdbcTemplate.update(sql, policyRef);
    }

    public void insertNewOffer(CounterOfferRequest request) {
        String sql = "INSERT INTO CUSTOMER.AZBJ_MODIFIED_OFFER (policy_ref, contract_id, APPLICATION_NO, activity_no, activity_date, event_type, user_id, TOP_INDICATOR, product_id, package_code, cover_code, sum_assured, benefit_term, premium_term, premium, GST, DEPOSIT_COLL, BOP, CHECK_CO_FLAG, multiplier, ml_perc, ml_amt, oc_perc, oc_amt, sr_perc, sr_amt, nri_perc, nri_amt, CO_REASON1, CO_REASON2, CO_REASON3, sign_mismatch_flg, OLD_BI_NO, B_URL, BI_NO, B_MESSAGE, B_STEP, B_STATUS, B_PREMIUM_TERM, B_BENEFIT_TERM, B_PREM, B_SUM_ASSURED, B_QUOTEID, RIDER_NAME, RIDER_COVER) VALUES (?, ?, TO_CHAR(NVL(?, ?)), ?, NVL(?, SYSDATE), ?, USER, 'Y', ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_number(?), to_number(?), to_number(?), to_number(?), to_number(?), to_number(?), to_number(?), to_number(?), ?, ?, ?, ?, ?, ?, ?, ?, ?, to_number(?), to_number(?), to_number(?), to_number(?), ?, ?, ?);";
        jdbcTemplate.update(sql, request.getPolicyRef(), request.getContractId(), request.getApplicationNo(), request.getActivityNo(), request.getActivityDate(), request.getEventType(), request.getProductId(), request.getPackageCode(), request.getCoverCode(), request.getSumAssured(), request.getBenefitTerm(), request.getPremiumTerm(), request.getPremium(), request.getGst(), request.getDepositColl(), request.getBop(), request.getCheckCoFlag(), request.getMultiplier(), request.getMlPerc(), request.getMlAmt(), request.getOcPerc(), request.getOcAmt(), request.getSrPerc(), request.getSrAmt(), request.getNriPerc(), request.getNriAmt(), request.getCoReason1(), request.getCoReason2(), request.getCoReason3(), request.getSignMismatchFlg(), request.getOldBiNo(), request.getBUrl(), request.getBiNo(), request.getBMessage(), request.getBStep(), request.getBStatus(), request.getBPremiumTerm(), request.getBBenefitTerm(), request.getBPrem(), request.getBSumAssured(), request.getBQuoteid(), request.getRiderName(), request.getRiderCover());
    }

    public CounterOfferValidationResponse findCounterOfferDetails(CounterOfferValidationRequest request) {
        String sql = "SELECT * FROM AZBJ_MODIFIED_OFFER WHERE policy_ref = ? AND contract_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{request.getPolicyRef(), request.getContractId()}, (rs, rowNum) -> new CounterOfferValidationResponse(rs.getString("policy_ref"), rs.getString("contract_id"), rs.getString("APPLICATION_NO"), rs.getString("activity_no"), rs.getDate("activity_date"), rs.getString("event_type"), rs.getString("user_id"), rs.getString("TOP_INDICATOR"), rs.getString("product_id"), rs.getString("package_code"), rs.getString("cover_code"), rs.getBigDecimal("sum_assured"), rs.getInt("benefit_term"), rs.getInt("premium_term"), rs.getBigDecimal("premium"), rs.getBigDecimal("GST"), rs.getBigDecimal("DEPOSIT_COLL"), rs.getBigDecimal("BOP"), rs.getString("CHECK_CO_FLAG"), rs.getBigDecimal("multiplier"), rs.getBigDecimal("ml_perc"), rs.getBigDecimal("ml_amt"), rs.getBigDecimal("oc_perc"), rs.getBigDecimal("oc_amt"), rs.getBigDecimal("sr_perc"), rs.getBigDecimal("sr_amt"), rs.getBigDecimal("nri_perc"), rs.getBigDecimal("nri_amt"), rs.getString("CO_REASON1"), rs.getString("CO_REASON2"), rs.getString("CO_REASON3"), rs.getString("sign_mismatch_flg"), rs.getString("OLD_BI_NO"), rs.getString("B_URL"), rs.getString("BI_NO"), rs.getString("B_MESSAGE"), rs.getString("B_STEP"), rs.getString("B_STATUS"), rs.getInt("B_PREMIUM_TERM"), rs.getInt("B_BENEFIT_TERM"), rs.getBigDecimal("B_PREM"), rs.getBigDecimal("B_SUM_ASSURED"), rs.getString("B_QUOTEID"), rs.getString("RIDER_NAME"), rs.getString("RIDER_COVER")));
    }

    public boolean findDuplicateCounterOffer(String selectedOfferType) {
        String sql = "SELECT COUNT(1) FROM AZBJ_MODIFIED_OFFER WHERE event_type = ?";
        int count = jdbcTemplate.queryForObject(sql, new Object[]{selectedOfferType}, Integer.class);
        return count > 0;
    }
}
