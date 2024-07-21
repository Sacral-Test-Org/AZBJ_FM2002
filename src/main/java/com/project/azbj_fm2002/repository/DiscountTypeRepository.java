package com.project.azbj_fm2002.repository;

import com.project.azbj_fm2002.entity.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountTypeRepository extends JpaRepository<DiscountType, Long> {

    @Query("SELECT dt FROM DiscountType dt WHERE dt.agentCode = :agentCode AND dt.productId = :productId AND dt.webAggregatorFlag = :webAggregatorFlag AND dt.groupEmployeeFlag = :groupEmployeeFlag AND dt.offlineOnlineFlag = :offlineOnlineFlag")
    DiscountType findDiscountType(@Param("agentCode") String agentCode,
                                  @Param("productId") Long productId,
                                  @Param("webAggregatorFlag") String webAggregatorFlag,
                                  @Param("groupEmployeeFlag") String groupEmployeeFlag,
                                  @Param("offlineOnlineFlag") String offlineOnlineFlag);
}
