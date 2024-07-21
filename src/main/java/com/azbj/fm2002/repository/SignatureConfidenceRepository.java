package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.SignatureConfidence;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignatureConfidenceRepository extends CrudRepository<SignatureConfidence, Long> {

    @Query("SELECT sc FROM SignatureConfidence sc WHERE sc.applicationNumber = :applicationNumber")
    List<SignatureConfidence> findSignatureConfidenceDetails(@Param("applicationNumber") String applicationNumber);

    @Query("SELECT NVL(ip_verf_no, ip_sign_card_no) FROM InsuredPerson WHERE id = :id")
    String fetchVerificationOrSignCardNumber(@Param("id") String id);
}
