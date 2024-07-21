package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.FcfDeclineMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FcfDeclineMemberRepository extends JpaRepository<FcfDeclineMember, Long> {
    // Method to save a record to the FCF_DECLINE_MEMBER table
    @Override
    FcfDeclineMember save(FcfDeclineMember fcfDeclineMember);
}
