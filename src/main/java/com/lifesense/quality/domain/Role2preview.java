package com.lifesense.quality.domain;

import com.lifesense.quality.base.BaseDomain;

/**
 * ROLE2PREVIEW
 *
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */

public class Role2preview extends BaseDomain<Long> {

    private String roleCode;

    private String previewCode;

    private static final long serialVersionUID = 1L;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getPreviewCode() {
        return previewCode;
    }

    public void setPreviewCode(String previewCode) {
        this.previewCode = previewCode;
    }
}