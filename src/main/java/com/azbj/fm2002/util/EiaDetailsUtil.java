package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.EiaDetailsDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EiaDetailsUtil {

    public static EiaDetailsDTO convertToEiaDetailsDTO(ResultSet resultSet) throws SQLException {
        EiaDetailsDTO eiaDetailsDTO = new EiaDetailsDTO();
        eiaDetailsDTO.setEiaAccountType(resultSet.getString("EIA_ACCOUNT_TYPE"));
        eiaDetailsDTO.setEiaDocType(resultSet.getString("EIA_DOC_TYPE"));
        return eiaDetailsDTO;
    }

    public static boolean validateEiaDetails(EiaDetailsDTO eiaDetailsDTO) {
        if (eiaDetailsDTO == null) {
            return false;
        }
        return eiaDetailsDTO.getEiaAccountType() != null && !eiaDetailsDTO.getEiaAccountType().isEmpty()
                && eiaDetailsDTO.getEiaDocType() != null && !eiaDetailsDTO.getEiaDocType().isEmpty();
    }

    public static EiaDetailsDTO formatEiaDetails(EiaDetailsDTO eiaDetailsDTO) {
        if (eiaDetailsDTO == null) {
            return null;
        }
        eiaDetailsDTO.setEiaAccountType(eiaDetailsDTO.getEiaAccountType().trim().toUpperCase());
        eiaDetailsDTO.setEiaDocType(eiaDetailsDTO.getEiaDocType().trim().toUpperCase());
        return eiaDetailsDTO;
    }
}
