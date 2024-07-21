package com.azbj.fm2002.repository;

import com.azbj.fm2002.dto.*;
import com.azbj.fm2002.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface CoverheadRepository extends JpaRepository<Coverhead, Long> {

    @Query("SELECT multiplier FROM azbj_tasa_suc_multiplier WHERE product_id = ?1")
    BigDecimal getMultiplier(Long productId);

    @Query("SELECT age_proof_type FROM age_proof WHERE details = ?1")
    String findAgeProofType(String ageProofDetails);

    @Query("SELECT payment_method FROM payment_methods WHERE booking_frequency = ?1 AND agent_code = ?2")
    List<String> findPaymentMethods(String bookingFrequency, String agentCode);

    @Query("SELECT validation_result FROM booking_frequency_validation WHERE booking_frequency = ?1 AND product_id = ?2 AND receipt_date = ?3 AND opus_date = ?4")
    String validateBookingFrequencyAndProductId(String bookingFrequency, String productId, Date receiptDate, Date opusDate);

    @Query("UPDATE discount_status SET status = ?1")
    void updateDiscountStatus(String discountStatus);

    @Query("SELECT * FROM products WHERE product_id = ?1")
    Product findProductById(String productId);

    @Query("SELECT next_item FROM products WHERE product_id = ?1")
    String findNextItemByProductId(String productId);

    @Query("SELECT * FROM covers")
    List<Cover> findCovers();

    @Query("SELECT * FROM loadings")
    List<Loading> findLoadings();

    @Query("UPDATE loadings SET details = ?1 WHERE id = ?2")
    void updateLoading(Loading loading);

    @Query("SELECT validate_inception_date(?1) FROM dual")
    ValidationResult validateInceptionDate(Date inceptionDate);

    @Query("SELECT * FROM product_details WHERE product_id = ?1")
    ProductDetails findProductDetails(Long productId);

    @Query("SELECT * FROM package_details WHERE package_code = ?1")
    PackageDetails findPackageDetails(String packageCode);

    @Query("SELECT EXISTS(SELECT 1 FROM packages WHERE package_code = ?1)")
    boolean findPackageCode(String packageCode);

    @Query("UPDATE benefit_type SET type = ?1 WHERE package_code = ?2")
    void updateBenefitType(String packageCode);

    @Query("SELECT receipt_date FROM azbj_batch_items WHERE policy_id = ?1")
    Date fetchReceiptDate(String policyId);

    @Query("SELECT multiplier FROM azbj_tasa_suc_multiplier WHERE product_id = ?1")
    BigDecimal fetchMultiplier(String productId);

    @Query("SELECT premium_term FROM azbj_mortgage_term WHERE product_id = ?1 AND cover_code = ?2 AND loan_term = ?3")
    Integer findPremiumTerm(Long productId, String coverCode, Integer loanTerm);

    @Query("SELECT service_tax_applicable FROM service_tax WHERE email = ?1")
    boolean findServiceTaxApplicabilityByEmail(String email);

    @Query("SELECT * FROM further_requirements")
    List<Requirement> findFurtherRequirements();

    @Query("SELECT global_loading_flag FROM loan_types WHERE loan_type = ?1")
    String findGlobalLoadingFlag(String loanType);

    @Query("SELECT * FROM product_details WHERE product_id = ?1")
    ProductDetails findProductDetails(int productId);

    @Query("SELECT partner_reference FROM partners WHERE partner_id = ?1")
    PartnerReference findPartnerReference(String partnerId);

    @Query("SELECT * FROM pan_approval_details WHERE application_number = ?1")
    List<PanApprovalDetailsDTO> findPanApprovalDetails(String applicationNumber);

    @Query("UPDATE coverhead_variables SET variables = ?1 WHERE id = ?2")
    void updateCoverheadVariables(OkButtonRequest request);

    @Query("UPDATE form_status SET status = ?1")
    void updateFormStatus(String formStatus);

    @Query("SELECT * FROM policy_holders WHERE id = ?1")
    PolicyHolder findPolicyHolder(Long policyHolderId);

    @Query("SELECT * FROM insured_persons WHERE id = ?1")
    InsuredPerson findInsuredPerson(Long insuredPersonId);

    @Query("UPDATE fields SET details = ?1 WHERE id = ?2")
    void updateFields(GpbOptedRequest request);

    @Query("UPDATE insurance_offer SET details = ?1 WHERE id = ?2")
    ModifyInsuranceOfferResponse updateInsuranceOffer(ModifyInsuranceOfferRequest request);

    @Query("SELECT * FROM product_details WHERE product_id = ?1")
    ProductDetails findProductDetails(String productId);

    @Query("SELECT * FROM age_proof_details WHERE age_proof_type = ?1")
    AgeProofDetails findAgeProofDetails(String ageProofType);

    @Query("SELECT * FROM solution_product_details WHERE solution_name = ?1")
    SolutionProductDetails fetchSolutionProductDetails(String solutionName);

    @Query("SELECT * FROM data")
    List<Data> fetchData();

    @Query("UPDATE related_covers SET benefit_term = ?1, premium_term = ?2 WHERE cover_code IS NOT NULL AND package_code = ?3")
    int updateRelatedCovers(String benefitTerm, String premiumTerm, String packageCode);

    @Query("SELECT * FROM required_data WHERE product_id = ?1")
    Object fetchRequiredData(Long productId);

    @Query("SELECT * FROM terms WHERE request = ?1")
    UpdateTermsResponse updateTerms(UpdateTermsRequest request);

    @Query("SELECT * FROM product_conditions WHERE product_id = ?1")
    ProductConditions fetchProductConditions(String productId);

}