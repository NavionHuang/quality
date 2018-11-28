package com.lifesense.quality.domain;

import com.lifesense.quality.base.BaseDomain;

import java.util.Date;

/**
 * QA_USER
 *
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */

public class QaUser extends BaseDomain<Long> {

    private String account;

    private String password;

    private String code;

    private String name;

    private String processCode;

    private String lineCode;

    private Integer processSign;

    private Integer valid;

    private Long createUserId;

    private Date createTime;

    private Date modifyTime;

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public Integer getProcessSign() {
        return processSign;
    }

    public void setProcessSign(Integer processSign) {
        this.processSign = processSign;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", processCode=").append(processCode);
        sb.append(", processSign=").append(processSign);
        sb.append(", valid=").append(valid);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}