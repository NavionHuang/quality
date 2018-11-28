package com.lifesense.quality.domain;

import com.lifesense.quality.base.BaseDomain;

/**
 * BAD_CODE
 *
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */
public class BadCode extends BaseDomain<Long> {

    private String processCode;

    private String processName;

    private String code;

    private String name;

    private String remark;

    private Integer valid;


    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
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

}