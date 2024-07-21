package com.azbj.fm2002.repository;

import com.azbj.fm2002.entity.FakeDocumentEntity;
import com.azbj.fm2002.dto.FakeDocumentDTO;
import com.azbj.fm2002.dto.LovData;
import com.azbj.fm2002.dto.ProofType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FakeDocumentRepository extends JpaRepository<FakeDocumentEntity, Long> {

    @Query("SELECT CASE WHEN COUNT(fd) > 0 THEN true ELSE false END FROM FakeDocumentEntity fd WHERE fd.documentId = :documentId AND fd.fakeDocument = 'Y'")
    boolean checkFakeDocument(@Param("documentId") Long documentId);

    @Query("UPDATE FakeDocumentEntity fd SET fd.fakeDocument = :#{#fakeDocumentDTO.fakeDocument}, fd.updateUser = :#{#fakeDocumentDTO.updateUser}, fd.updateDt = CURRENT_TIMESTAMP, fd.comments = :#{#fakeDocumentDTO.comments}, fd.fakeMark = :#{#fakeDocumentDTO.fakeMark}, fd.docProofType = :#{#fakeDocumentDTO.docProofType}, fd.category = :#{#fakeDocumentDTO.category} WHERE fd.contractId = :#{#fakeDocumentDTO.contractId} AND fd.documentCode = :#{#fakeDocumentDTO.documentCode}")
    void updateFakeDocumentStatus(@Param("fakeDocumentDTO") FakeDocumentDTO fakeDocumentDTO);

    @Query("SELECT new com.azbj.fm2002.dto.LovData(pm.proofType, pm.proofDesc, pm.displayMessage) FROM ProofMaster pm WHERE pm.partnerType = :partnerType AND pm.documentType IN :documentTypes")
    List<LovData> findLovData(@Param("partnerType") String partnerType, @Param("documentTypes") List<String> documentTypes);

    @Override
    <S extends FakeDocumentEntity> S save(S entity);

    @Query("SELECT new com.azbj.fm2002.dto.ProofType(pm.proofType, pm.proofDesc) FROM ProofMaster pm WHERE pm.documentType = :documentType")
    List<ProofType> findProofTypes(@Param("documentType") String documentType);
}
