package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.SearchCpRequest;

public class SearchCpUtil {

    public static boolean validateSearchRequest(SearchCpRequest request) {
        if (request == null) {
            return false;
        }
        if (request.getPartnerId() == null || request.getPartnerId().isEmpty()) {
            return false;
        }
        if (request.getControlFlag() == null || (!request.getControlFlag().equals("Y") && !request.getControlFlag().equals("N"))) {
            return false;
        }
        return true;
    }
}
