package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.SolSsoFund;
import com.azbj.fm2002.model.Fund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SolSsoFundRepository extends JpaRepository<SolSsoFund, Long> {

    @Query("SELECT s FROM SolSsoFund s WHERE s.productId = :productId AND s.fundId = :fundId")
    Optional<SolSsoFund> findByProductIdAndFundId(@Param("productId") int productId, @Param("fundId") String fundId);

    @Query("SELECT new com.azbj.fm2002.model.Fund(a.fundShortName, a.fundFullName) " +
            "FROM AZBJ_TFV_FUND_DEFINITION a, azbj_cover_funds b " +
            "WHERE a.fundShortName = b.fundName " +
            "AND b.productId = :productId " +
            "AND :dateRange > NVL(startDate, '01-apr-2005') " +
            "AND :dateRange < NVL(endDate, '01-jan-3000') " +
            "AND a.fundId <> 'FVFD000025' " +
            "AND b.coverCode = :coverCode " +
            "ORDER BY a.fundShortName")
    List<Fund> findFunds(@Param("productId") String productId, @Param("dateRange") String dateRange, @Param("coverCode") String coverCode);
}
