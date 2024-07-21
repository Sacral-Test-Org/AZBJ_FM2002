package com.azbj.fm2002.repository;

import com.azbj.fm2002.dto.SecFrarReqDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SecFrarReqRepository extends JpaRepository<SecFrarReqDTO, Long> {

    @Query("SELECT s FROM SecFrarReqDTO s")
    List<SecFrarReqDTO> getFrarRequirements();

    @Query("UPDATE SecFrarReqDTO s SET s.supervisorComments = :comments WHERE s.id = :id")
    void saveComments(@Param("id") Long id, @Param("comments") String comments);

    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM SecFrarReqDTO s WHERE s.supervisorId = :supervisorId AND s.password = :password")
    boolean authenticate(@Param("supervisorId") String supervisorId, @Param("password") String password);

    @Query("SELECT r.description FROM Reason r WHERE r.reason = :reason")
    String findReasonDescription(@Param("reason") int reason);

    @Query("UPDATE SecFrarReqDTO s SET s.supervisorId = :supervisorId, s.password = :password, s.authFlag = 'Y' WHERE s.id = :id")
    int updateRecords(@Param("id") Long id, @Param("supervisorId") String supervisorId, @Param("password") String password);
}
