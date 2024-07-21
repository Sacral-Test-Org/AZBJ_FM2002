package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDetailsRepository extends JpaRepository<BankDetails, Long> {

    @Query("SELECT b FROM BankDetails b WHERE b.ifscCode = :ifscCode")
    BankDetails findBankDetailsByIfscCode(@Param("ifscCode") String ifscCode);
}
