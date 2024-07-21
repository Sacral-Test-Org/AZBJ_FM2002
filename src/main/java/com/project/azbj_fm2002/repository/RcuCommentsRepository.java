package com.project.azbj_fm2002.repository;

import com.project.azbj_fm2002.model.RcuComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RcuCommentsRepository extends JpaRepository<RcuComments, Long> {

    @Query("SELECT r FROM RcuComments r WHERE r.policyNo = :#{#params['POLICY_NO']} AND r.moduleName = :#{#params['MODULE_NAME']}")
    List<RcuComments> findByParams(@Param("params") Map<String, Object> params);
}
