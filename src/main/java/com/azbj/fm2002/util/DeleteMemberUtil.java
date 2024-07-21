package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.DeleteMemberRequest;

public class DeleteMemberUtil {

    public boolean validateDeleteRequest(DeleteMemberRequest request) {
        if (request == null) {
            return false;
        }
        if (request.getCoverCode() == null || request.getCoverCode().isEmpty()) {
            return false;
        }
        if (request.getIpNumber() == null || request.getIpNumber().isEmpty()) {
            return false;
        }
        if (request.getTestNumber() == null || request.getTestNumber().isEmpty()) {
            return false;
        }
        if (request.getPartId() == null || request.getPartId().isEmpty()) {
            return false;
        }
        return true;
    }
}
