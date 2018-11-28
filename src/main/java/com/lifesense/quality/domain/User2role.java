package com.lifesense.quality.domain;

import com.lifesense.quality.base.BaseDomain;

/**
 * USER2ROLE
 *
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */
public class User2role extends BaseDomain<Long> {
    private Long userId;

    private String roleCode;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

}