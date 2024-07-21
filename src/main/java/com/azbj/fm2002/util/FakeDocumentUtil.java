package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.FakeDocumentDTO;
import com.azbj.fm2002.entity.FakeDocumentEntity;
import java.util.Arrays;
import java.util.List;

public class FakeDocumentUtil {

    private static final List<String> VALID_CATEGORIES = Arrays.asList("Category1", "Category2", "Category3");
    private static final List<String> VALID_COMMENTS = Arrays.asList("Comment1", "Comment2", "Comment3");

    public static boolean validateCategory(String category) {
        return VALID_CATEGORIES.contains(category);
    }

    public static boolean validateComments(String comments) {
        return VALID_COMMENTS.contains(comments);
    }

    public static FakeDocumentEntity convertDtoToEntity(FakeDocumentDTO dto) {
        FakeDocumentEntity entity = new FakeDocumentEntity();
        entity.setDocumentDescription(dto.getDocumentDescription());
        entity.setDocumentType(dto.getDocumentType());
        entity.setDocumentCode(dto.getDocumentCode());
        entity.setFakeDocument(dto.isFakeDocument());
        entity.setDocumentProofType(dto.getDocumentProofType());
        entity.setComments(dto.getComments());
        entity.setCategory(dto.getCategory());
        entity.setDocumentCheckedStatus(dto.isDocumentCheckedStatus());
        return entity;
    }
}