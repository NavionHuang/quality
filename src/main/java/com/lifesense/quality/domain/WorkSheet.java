package com.lifesense.quality.domain;

import com.lifesense.quality.base.BaseDomain;

import java.util.Date;

/**
 * WORK_SHEET
 *
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */
public class WorkSheet extends BaseDomain<Long> {

    private String sheetNo;

    private String sheetPo;

    private String productNo;

    private String productTypeCode;

    private String productTypeName;

    private Short type;

    private Long outputNum;

    private Date startTime;

    private Date endTime;

    private Integer valid;

    private Date createTime;

    private String createUser;

    public String getSheetPo() {
        return sheetPo;
    }

    public void setSheetPo(String sheetPo) {
        this.sheetPo = sheetPo;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getSheetNo() {
        return sheetNo;
    }

    public void setSheetNo(String sheetNo) {
        this.sheetNo = sheetNo;
    }

    public String getProductTypeCode() {
        return productTypeCode;
    }

    public void setProductTypeCode(String productTypeCode) {
        this.productTypeCode = productTypeCode;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Long getOutputNum() {
        return outputNum;
    }

    public void setOutputNum(Long outputNum) {
        this.outputNum = outputNum;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }
}