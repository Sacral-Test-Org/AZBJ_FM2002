package com.azbj.fm2002.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AzbjBatchItemsRepository extends CrudRepository<AzbjBatchItems, Long> {

    @Query("SELECT perm_receipt_date FROM azbj_batch_items WHERE perm_receipt_no = :receiptNo AND NVL(PRINT, 'X') <> 'C' AND TRANSACTION_TYPE = 'FRP'")
    Date getPermanentReceiptDate(@Param("receiptNo") String receiptNo);
}
