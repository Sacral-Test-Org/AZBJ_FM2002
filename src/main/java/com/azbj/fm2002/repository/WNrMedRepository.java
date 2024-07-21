package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.WNrMed;
import com.azbj.fm2002.model.ReceiptStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WNrMedRepository extends JpaRepository<WNrMed, Long> {

    @Query("SELECT w FROM WNrMed w WHERE w.productId = :productId")
    Optional<WNrMed> findByProductId(@Param("productId") int productId);

    @Modifying
    @Query("UPDATE WNrMed w SET w.receiptStatus = :receiptStatus, w.receiptDate = :receiptDate WHERE w.id = :id")
    void updateReceiptStatus(@Param("id") Long id, @Param("receiptStatus") ReceiptStatus receiptStatus, @Param("receiptDate") String receiptDate);
}
