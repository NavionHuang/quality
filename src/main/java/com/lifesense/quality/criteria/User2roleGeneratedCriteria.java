package com.lifesense.quality.criteria;

import com.lifesense.quality.base.GeneratedCriteria;
import com.lifesense.quality.domain.User2role;

import java.util.List;

/**
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */
public class User2roleGeneratedCriteria extends GeneratedCriteria<User2role> {

    public User2roleGeneratedCriteria andUserIdIsNull() {
        addCriterion("USER2ROLE.USER_ID is null");
        return this;
    }

    public User2roleGeneratedCriteria andUserIdIsNotNull() {
        addCriterion("USER2ROLE.USER_ID is not null");
        return this;
    }

    public User2roleGeneratedCriteria andUserIdEqualTo(Long value) {
        addCriterion("USER2ROLE.USER_ID =", value, "userId");
        return this;
    }

    public User2roleGeneratedCriteria andUserIdNotEqualTo(Long value) {
        addCriterion("USER2ROLE.USER_ID <>", value, "userId");
        return this;
    }

    public User2roleGeneratedCriteria andUserIdGreaterThan(Long value) {
        addCriterion("USER2ROLE.USER_ID >", value, "userId");
        return this;
    }

    public User2roleGeneratedCriteria andUserIdGreaterThanOrEqualTo(Long value) {
        addCriterion("USER2ROLE.USER_ID >=", value, "userId");
        return this;
    }

    public User2roleGeneratedCriteria andUserIdLessThan(Long value) {
        addCriterion("USER2ROLE.USER_ID <", value, "userId");
        return this;
    }

    public User2roleGeneratedCriteria andUserIdLessThanOrEqualTo(Long value) {
        addCriterion("USER2ROLE.USER_ID <=", value, "userId");
        return this;
    }

    public User2roleGeneratedCriteria andUserIdIn(List<Long> values) {
        addCriterion("USER2ROLE.USER_ID in", values, "userId");
        return this;
    }

    public User2roleGeneratedCriteria andUserIdNotIn(List<Long> values) {
        addCriterion("USER2ROLE.USER_ID not in", values, "userId");
        return this;
    }

    public User2roleGeneratedCriteria andUserIdBetween(Long value1, Long value2) {
        addCriterion("USER2ROLE.USER_ID between", value1, value2, "userId");
        return this;
    }

    public User2roleGeneratedCriteria andUserIdNotBetween(Long value1, Long value2) {
        addCriterion("USER2ROLE.USER_ID not between", value1, value2, "userId");
        return this;
    }

    public User2roleGeneratedCriteria andRoleCodeIsNull() {
        addCriterion("USER2ROLE.ROLE_CODE is null");
        return this;
    }

    public User2roleGeneratedCriteria andRoleCodeIsNotNull() {
        addCriterion("USER2ROLE.ROLE_CODE is not null");
        return this;
    }

    public User2roleGeneratedCriteria andRoleCodeEqualTo(String value) {
        addCriterion("USER2ROLE.ROLE_CODE =", value, "roleCode");
        return this;
    }

    public User2roleGeneratedCriteria andRoleCodeNotEqualTo(String value) {
        addCriterion("USER2ROLE.ROLE_CODE <>", value, "roleCode");
        return this;
    }

    public User2roleGeneratedCriteria andRoleCodeGreaterThan(String value) {
        addCriterion("USER2ROLE.ROLE_CODE >", value, "roleCode");
        return this;
    }

    public User2roleGeneratedCriteria andRoleCodeGreaterThanOrEqualTo(String value) {
        addCriterion("USER2ROLE.ROLE_CODE >=", value, "roleCode");
        return this;
    }

    public User2roleGeneratedCriteria andRoleCodeLessThan(String value) {
        addCriterion("USER2ROLE.ROLE_CODE <", value, "roleCode");
        return this;
    }

    public User2roleGeneratedCriteria andRoleCodeLessThanOrEqualTo(String value) {
        addCriterion("USER2ROLE.ROLE_CODE <=", value, "roleCode");
        return this;
    }

    public User2roleGeneratedCriteria andRoleCodeLike(String value) {
        addCriterion("USER2ROLE.ROLE_CODE like", value, "roleCode");
        return this;
    }

    public User2roleGeneratedCriteria andRoleCodeNotLike(String value) {
        addCriterion("USER2ROLE.ROLE_CODE not like", value, "roleCode");
        return this;
    }

    public User2roleGeneratedCriteria andRoleCodeIn(List<String> values) {
        addCriterion("USER2ROLE.ROLE_CODE in", values, "roleCode");
        return this;
    }

    public User2roleGeneratedCriteria andRoleCodeNotIn(List<String> values) {
        addCriterion("USER2ROLE.ROLE_CODE not in", values, "roleCode");
        return this;
    }

    public User2roleGeneratedCriteria andRoleCodeBetween(String value1, String value2) {
        addCriterion("USER2ROLE.ROLE_CODE between", value1, value2, "roleCode");
        return this;
    }

    public User2roleGeneratedCriteria andRoleCodeNotBetween(String value1, String value2) {
        addCriterion("USER2ROLE.ROLE_CODE not between", value1, value2, "roleCode");
        return this;
    }
}