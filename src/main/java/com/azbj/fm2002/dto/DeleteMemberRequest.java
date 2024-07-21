package com.azbj.fm2002.dto;

public class DeleteMemberRequest {
    private String memberId;

    public DeleteMemberRequest() {}

    public DeleteMemberRequest(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}