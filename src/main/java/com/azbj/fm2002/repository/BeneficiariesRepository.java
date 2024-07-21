package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.NomineeDetails;
import com.azbj.fm2002.model.Appointee;
import com.azbj.fm2002.model.BeneficiaryTrusteeDTO;
import com.azbj.fm2002.model.ProofDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeneficiariesRepository extends JpaRepository<NomineeDetails, Long> {

    // Method to save the selected gender
    @Query("UPDATE NomineeDetails SET gender = :gender WHERE id = :id")
    void save(@Param("gender") String gender, @Param("id") Long id);

    // Method to retrieve the saved gender
    @Query("SELECT gender FROM NomineeDetails WHERE id = :id")
    String findGender(@Param("id") Long id);

    // Method to delete a nominee
    @Query("DELETE FROM NomineeDetails WHERE id = :nomineeId")
    void deleteNominee(@Param("nomineeId") Long nomineeId);

    // Method to fetch nominee details
    @Query("SELECT CHAR_VALUE FROM azbj_system_constants WHERE sys_type='NOM_DET'")
    List<String> findNomineeDetails();

    // Method to fetch existing nominee details based on applicationNo and proposalNo
    @Query("SELECT n FROM NomineeDetails n WHERE n.applicationNo = :applicationNo OR n.proposalNo = :proposalNo")
    List<NomineeDetails> findNomineeDetails(@Param("applicationNo") String applicationNo, @Param("proposalNo") String proposalNo);

    // Method to save nominee details
    @Query("INSERT INTO NomineeDetails (name, birthplace, relation, dob, gender) VALUES (:name, :birthplace, :relation, :dob, :gender)")
    void saveAll(@Param("nomineeDetails") List<NomineeDetails> nomineeDetails);

    // Method to find appointee by name
    @Query("SELECT a FROM Appointee a WHERE a.name = :appointeeName")
    Appointee findAppointeeByName(@Param("appointeeName") String appointeeName);

    // Method to find records by contract ID
    @Query("SELECT b FROM BeneficiaryTrusteeDTO b WHERE b.contractId = :contractId")
    List<BeneficiaryTrusteeDTO> findByContractId(@Param("contractId") String contractId);

    // Method to fetch identification proof details
    @Query("SELECT document_type, proof_desc FROM azbj_aml_proof_master WHERE partner_type = :partnerType")
    List<ProofDetails> fetchIdentificationProofDetails(@Param("partnerType") String partnerType);

    // Method to fetch address proof details
    @Query("SELECT document_type, proof_desc FROM azbj_aml_proof_master WHERE partner_type = :partnerType")
    List<ProofDetails> fetchAddressProofDetails(@Param("partnerType") String partnerType);
}
