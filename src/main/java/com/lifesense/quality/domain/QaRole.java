package com.lifesense.quality.domain;

import com.lifesense.quality.base.BaseDomain;

/**
 * QA_ROLE
 *
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */
public class QaRole extends BaseDomain<Long> {

    private String code;

    private String name;

    private Integer valid;

    private String description;


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

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}