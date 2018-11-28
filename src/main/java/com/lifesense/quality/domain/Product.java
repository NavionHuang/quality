package com.lifesense.quality.domain;

import com.lifesense.quality.base.BaseDomain;

import java.util.Date;

/**
 * PRODUCT
 *
 * @author
 */
public class Product extends BaseDomain<Long> {
    private String sheetPo;
    private String productNo;
    private String productTypeCode;
    private String productTypeName;
    private String cpsn;

    private String blsn;

    private String bbsn;

    private String cgqsn;

    private String smssn;

    private String bxksn;

    private String chsn;

    private Integer valid;

    private Date createTime;

    private Date modifyTime;

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

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

    public String getProductTypeCode() {
        return productTypeCode;
    }

    public void setProductTypeCode(String productTypeCode) {
        this.productTypeCode = productTypeCode;
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

    public String getBbsn() {
        return bbsn;
    }

    public void setBbsn(String bbsn) {
        this.bbsn = bbsn;
    }

    public String getCgqsn() {
        return cgqsn;
    }

    public void setCgqsn(String cgqsn) {
        this.cgqsn = cgqsn;
    }

    public String getSmssn() {
        return smssn;
    }

    public void setSmssn(String smssn) {
        this.smssn = smssn;
    }

    public String getBxksn() {
        return bxksn;
    }

    public void setBxksn(String bxksn) {
        this.bxksn = bxksn;
    }

    public String getChsn() {
        return chsn;
    }

    public void setChsn(String chsn) {
        this.chsn = chsn;
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

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}