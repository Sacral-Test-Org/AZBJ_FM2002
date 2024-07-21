package com.azbj.fm2002.dto;

import java.util.Date;

public class DiscountTypeResponse {
    private String discountType;
    private String employeeCode;
    private Date permReceiptDate;
    private Date irdaLaunchDate;

    public DiscountTypeResponse() {}

    public DiscountTypeResponse(String discountType, String employeeCode, Date permReceiptDate, Date irdaLaunchDate) {
        this.discountType = discountType;
        this.employeeCode = employeeCode;
        this.permReceiptDate = permReceiptDate;
        this.irdaLaunchDate = irdaLaunchDate;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Date getPermReceiptDate() {
        return permReceiptDate;
    }

    public void setPermReceiptDate(Date permReceiptDate) {
        this.permReceiptDate = permReceiptDate;
    }

    public Date getIrdaLaunchDate() {
        return irdaLaunchDate;
    }

    public void setIrdaLaunchDate(Date irdaLaunchDate) {
        this.irdaLaunchDate = irdaLaunchDate;
    }
}