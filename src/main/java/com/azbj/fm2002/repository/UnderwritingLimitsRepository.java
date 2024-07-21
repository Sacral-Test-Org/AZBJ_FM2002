package com.azbj.fm2002.repository;

import com.azbj.fm2002.entity.UnderwritingLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnderwritingLimitsRepository extends JpaRepository<UnderwritingLimit, Long> {

    @Query("SELECT u FROM UnderwritingLimit u WHERE u.userId = :userId")
    List<UnderwritingLimit> findByUserId(@Param("userId") String userId);
}
