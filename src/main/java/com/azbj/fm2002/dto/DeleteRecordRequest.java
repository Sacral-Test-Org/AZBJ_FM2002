package com.azbj.fm2002.dto;

public class DeleteRecordRequest {
    private Long recordId;

    public DeleteRecordRequest() {}

    public DeleteRecordRequest(Long recordId) {
        this.recordId = recordId;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }
}