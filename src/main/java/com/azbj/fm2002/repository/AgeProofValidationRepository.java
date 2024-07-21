package com.azbj.fm2002.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AgeProofValidationRepository extends JpaRepository<AgeProof, Long> {

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM AgeProof a WHERE a.ageProofType = :ageProofType AND a.ageProofID = :ageProofID")
    boolean validateAgeProofID(@Param("ageProofType") String ageProofType, @Param("ageProofID") String ageProofID);

    @Query("SELECT a.ageUid FROM AgeProof a WHERE a.ageProof = :ageProof")
    String findAgeUidByAgeProof(@Param("ageProof") String ageProof);

    @Query("SELECT a.ageProofType FROM AgeProof a WHERE a.ageProofDetails = :ageProofDetails")
    String findAgeProofType(@Param("ageProofDetails") Object ageProofDetails);

    @Query("SELECT new com.azbj.fm2002.dto.ValidationResponse(a.ageProofType, a.ageProofID, a.agentCode) FROM AgeProof a WHERE a.ageProofType = :ageProofType AND a.ageProofID = :ageProofID AND a.agentCode = :agentCode")
    ValidationResponse validate(@Param("ageProofType") String ageProofType, @Param("ageProofID") String ageProofID, @Param("agentCode") String agentCode);

    @Query("SELECT new com.azbj.fm2002.dto.AgeProofDetails(a.proofType, a.proofDesc) FROM AgeProof a WHERE a.proofType = :proofType")
    AgeProofDetails findAgeProofDetails(@Param("proofType") String proofType);
}
