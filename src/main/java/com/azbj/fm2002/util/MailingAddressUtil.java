package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.MailingAddressDTO;

public class MailingAddressUtil {

    public static String formatAddress(MailingAddressDTO address) {
        if (address == null) {
            return "";
        }

        StringBuilder formattedAddress = new StringBuilder();

        formattedAddress.append(address.getAddressLine1()).append("\n");
        formattedAddress.append(address.getAddressLine2()).append("\n");
        if (address.getAreaFreeText() != null && !address.getAreaFreeText().isEmpty()) {
            formattedAddress.append(address.getAreaFreeText()).append("\n");
        }
        formattedAddress.append(address.getAddressLine3()).append("\n");
        formattedAddress.append(address.getAddressLine4()).append("\n");
        formattedAddress.append(address.getAddressLine5()).append("\n");
        formattedAddress.append(address.getAddressLine6()).append("\n");
        formattedAddress.append(address.getAddressLine7()).append("\n");
        formattedAddress.append("COUNTRY- ").append(address.getCountry().toUpperCase()).append(" ").append(address.getPostcode());

        return formattedAddress.toString();
    }
}
