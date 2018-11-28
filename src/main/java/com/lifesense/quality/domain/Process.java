package com.lifesense.quality.domain;

import com.lifesense.quality.base.BaseDomain;

/**
 * PROCESS
 *
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */

public class Process extends BaseDomain<Long> {

    private Integer type;

    private String code;

    private String sntregex;

    private String name;

    private String remark;

    private Integer valid;


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public String getSntregex() {
        return sntregex;
    }

    public void setSntregex(String sntregex) {
        this.sntregex = sntregex;
    }

}