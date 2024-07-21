package com.azbj.fm2002.repository;

import com.azbj.fm2002.dto.ThirdPartyChequeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyChequeRepository extends JpaRepository<ThirdPartyChequeDTO, Long> {
    ThirdPartyChequeDTO save(ThirdPartyChequeDTO thirdPartyChequeDTO);
}