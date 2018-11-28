package com.lifesense.quality.domain;

import com.lifesense.quality.base.BaseDomain;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * PRODUCT_TYPE
 *
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */

public class ProductType extends BaseDomain<Long> {

    @NotEmpty
    private String code;

    private String name;

    private Integer valid;


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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", valid=").append(valid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}