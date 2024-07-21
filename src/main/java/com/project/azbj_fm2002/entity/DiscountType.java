package com.project.azbj_fm2002.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "discount_type")
public class DiscountType {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "agent_code")
    private String agentCode;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "discount_agent_flag")
    private String discountAgentFlag;

    @Column(name = "employee_code")
    private String employeeCode;

    @Column(name = "permanent_receipt_date")
    private Date permanentReceiptDate;

    @Column(name = "irda_launch_date")
    private Date irdaLaunchDate;

    @Column(name = "discount_type")
    private String discountType;

    @Column(name = "offline_online_flag")
    private String offlineOnlineFlag;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getDiscountAgentFlag() {
        return discountAgentFlag;
    }

    public void setDiscountAgentFlag(String discountAgentFlag) {
        this.discountAgentFlag = discountAgentFlag;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Date getPermanentReceiptDate() {
        return permanentReceiptDate;
    }

    public void setPermanentReceiptDate(Date permanentReceiptDate) {
        this.permanentReceiptDate = permanentReceiptDate;
    }

    public Date getIrdaLaunchDate() {
        return irdaLaunchDate;
    }

    public void setIrdaLaunchDate(Date irdaLaunchDate) {
        this.irdaLaunchDate = irdaLaunchDate;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getOfflineOnlineFlag() {
        return offlineOnlineFlag;
    }

    public void setOfflineOnlineFlag(String offlineOnlineFlag) {
        this.offlineOnlineFlag = offlineOnlineFlag;
    }
}
