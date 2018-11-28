package com.lifesense.quality.domain;

import com.lifesense.quality.base.BaseDomain;

import java.util.Date;

/**
 * REPAIR_RECORD
 *
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */

public class RepairRecord extends BaseDomain<Long> {

    private Long processRecordId;

    private String processCode;

    private String processName;

    private String repairProcessCode;

    private String repairProcessName;

    private String productLine;

    private String productLineName;

    private Long productId;

    private String badCode;

    private String badName;

    private String badType;

    private String badReson;

    private Integer repair;

    private Long userId;

    private String userName;

    private Date createTime;

    private Date modifyTime;

    private String remark;

    private String cpsn;

    private String blsn;

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCpsn() {
        return cpsn;
    }

    public void setCpsn(String cpsn) {
        this.cpsn = cpsn;
    }

    public String getBlsn() {
        return blsn;
    }

    public void setBlsn(String blsn) {
        this.blsn = blsn;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getRepairProcessName() {
        return repairProcessName;
    }

    public void setRepairProcessName(String repairProcessName) {
        this.repairProcessName = repairProcessName;
    }

    public String getProductLineName() {
        return productLineName;
    }

    public void setProductLineName(String productLineName) {
        this.productLineName = productLineName;
    }

    public Long getProcessRecordId() {
        return processRecordId;
    }

    public void setProcessRecordId(Long processRecordId) {
        this.processRecordId = processRecordId;
    }

    public String getRepairProcessCode() {
        return repairProcessCode;
    }

    public void setRepairProcessCode(String repairProcessCode) {
        this.repairProcessCode = repairProcessCode;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getBadCode() {
        return badCode;
    }

    public void setBadCode(String badCode) {
        this.badCode = badCode;
    }

    public String getBadName() {
        return badName;
    }

    public void setBadName(String badName) {
        this.badName = badName;
    }

    public String getBadType() {
        return badType;
    }

    public void setBadType(String badType) {
        this.badType = badType;
    }

    public String getBadReson() {
        return badReson;
    }

    public void setBadReson(String badReson) {
        this.badReson = badReson;
    }

    public Integer getRepair() {
        return repair;
    }

    public void setRepair(Integer repair) {
        this.repair = repair;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}