package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.UwCommentsRepository;
import com.azbj.fm2002.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UwCommentsService {

    @Autowired
    private UwCommentsRepository uwCommentsRepository;

    public List<Comment> getComments(String contractId, String userId, String userProfile) {
        if (userId.startsWith("P00%")) {
            return uwCommentsRepository.findAllCommentsByContractId(contractId);
        } else if (!"1".equals(userProfile)) {
            return uwCommentsRepository.findCommentsByContractIdAndUserIdNotStartingWithAndFlagNot(contractId, "P00%", "Y");
        } else {
            return uwCommentsRepository.findCommentsByContractIdAndFlag(contractId, "N");
        }
    }
}
