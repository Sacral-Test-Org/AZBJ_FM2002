package com.azbj.fm2002.repository;

import com.azbj.fm2002.dto.AmlDetailsDTO;
import com.azbj.fm2002.dto.PanDetailsDTO;
import com.azbj.fm2002.dto.ProductDefinition;
import com.azbj.fm2002.dto.ValidationResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmlRepository extends JpaRepository<AmlDetailsDTO, Long> {

    @Query("SELECT DISTINCT proof_type FROM azbj_aml_proof_master WHERE active_flag = 'Y'")
    List<String> findProofTypes();

    @Query("SELECT DISTINCT proof_desc FROM azbj_aml_proof_master WHERE active_flag = 'Y'")
    List<String> findProofDescriptions();

    @Query("SELECT * FROM azbj_aml_proof_master WHERE active_flag = 'Y'")
    List<AmlDetailsDTO> saveAmlDetails();

    @Query("SELECT document_type FROM azbj_aml_proof_master WHERE active_flag = 'Y'")
    String findDocumentType();

    @Query("SELECT chk_edit_aml FROM azbj_aml_proof_master WHERE active_flag = 'Y'")
    String findChkEditAml();

    @Query("SELECT * FROM product_definitions WHERE product_id = ?1")
    ProductDefinition findProductDefinitions(String productId);

    @Query("SELECT DISTINCT proof_type FROM azbj_aml_proof_master WHERE active_flag = 'Y'")
    List<String> findActiveProofTypes();

    @Query("SELECT contract_id FROM azbj_policy_contract_ext WHERE partner_id = ?1 AND top_indicator = 'Y' AND action_code <> 'D'")
    String findContractId(String partnerId);

    @Query("SELECT COUNT(*) FROM azbj_aml_nb_records_NEW WHERE contract_id = ?1")
    int countAmlRecords(String contractId);

    @Query("SELECT policy_ref FROM ocp_policy_bases WHERE contract_id = ?1 AND top_indicator = 'Y' AND action_code <> 'D'")
    String findPolicyRef(String contractId);

    @Query("SELECT * FROM azbj_aml_nb_records_NEW WHERE contract_id = ?1")
    List<AmlDetailsDTO> findAmlRecords(String contractId);

    @Query("SELECT chk_edit_aml FROM azbj_aml_proof_master WHERE active_flag = 'Y'")
    String getChkEditAmlStatus();

    @Query("SELECT CASE WHEN document_id ~ '^[A-Z]{3}[C,P,H,F,A,T,B,L,J,G][A-Z][0-9]{4}[A-Z]$' THEN 'VALID' ELSE 'INVALID' END FROM azbj_aml_proof_master WHERE document_id = ?1")
    ValidationResponse validateDocumentId(String documentId);

    @Query("SELECT * FROM azbj_pan_details")
    List<PanDetailsDTO> findAll();
}
