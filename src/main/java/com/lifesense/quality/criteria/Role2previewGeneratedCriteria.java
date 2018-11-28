package com.lifesense.quality.criteria;

import com.lifesense.quality.base.GeneratedCriteria;
import com.lifesense.quality.domain.Role2preview;

import java.util.List;

/**
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */
public class Role2previewGeneratedCriteria extends GeneratedCriteria<Role2preview> {

    public GeneratedCriteria andRoleCodeIsNull() {
        addCriterion("ROLE2PREVIEW.ROLE_CODE is null");
        return this;
    }

    public GeneratedCriteria andRoleCodeIsNotNull() {
        addCriterion("ROLE2PREVIEW.ROLE_CODE is not null");
        return this;
    }

    public GeneratedCriteria andRoleCodeEqualTo(String value) {
        addCriterion("ROLE2PREVIEW.ROLE_CODE =", value, "roleCode");
        return this;
    }

    public GeneratedCriteria andRoleCodeNotEqualTo(String value) {
        addCriterion("ROLE2PREVIEW.ROLE_CODE <>", value, "roleCode");
        return this;
    }

    public GeneratedCriteria andRoleCodeGreaterThan(String value) {
        addCriterion("ROLE2PREVIEW.ROLE_CODE >", value, "roleCode");
        return this;
    }

    public GeneratedCriteria andRoleCodeGreaterThanOrEqualTo(String value) {
        addCriterion("ROLE2PREVIEW.ROLE_CODE >=", value, "roleCode");
        return this;
    }

    public GeneratedCriteria andRoleCodeLessThan(String value) {
        addCriterion("ROLE2PREVIEW.ROLE_CODE <", value, "roleCode");
        return this;
    }

    public GeneratedCriteria andRoleCodeLessThanOrEqualTo(String value) {
        addCriterion("ROLE2PREVIEW.ROLE_CODE <=", value, "roleCode");
        return this;
    }

    public GeneratedCriteria andRoleCodeLike(String value) {
        addCriterion("ROLE2PREVIEW.ROLE_CODE like", value, "roleCode");
        return this;
    }

    public GeneratedCriteria andRoleCodeNotLike(String value) {
        addCriterion("ROLE2PREVIEW.ROLE_CODE not like", value, "roleCode");
        return this;
    }

    public GeneratedCriteria andRoleCodeIn(List<String> values) {
        addCriterion("ROLE2PREVIEW.ROLE_CODE in", values, "roleCode");
        return this;
    }

    public GeneratedCriteria andRoleCodeNotIn(List<String> values) {
        addCriterion("ROLE2PREVIEW.ROLE_CODE not in", values, "roleCode");
        return this;
    }

    public GeneratedCriteria andRoleCodeBetween(String value1, String value2) {
        addCriterion("ROLE2PREVIEW.ROLE_CODE between", value1, value2, "roleCode");
        return this;
    }

    public GeneratedCriteria andRoleCodeNotBetween(String value1, String value2) {
        addCriterion("ROLE2PREVIEW.ROLE_CODE not between", value1, value2, "roleCode");
        return this;
    }

    public GeneratedCriteria andPreviewCodeIsNull() {
        addCriterion("ROLE2PREVIEW.PREVIEW_CODE is null");
        return this;
    }

    public GeneratedCriteria andPreviewCodeIsNotNull() {
        addCriterion("ROLE2PREVIEW.PREVIEW_CODE is not null");
        return this;
    }

    public GeneratedCriteria andPreviewCodeEqualTo(String value) {
        addCriterion("ROLE2PREVIEW.PREVIEW_CODE =", value, "previewCode");
        return this;
    }

    public GeneratedCriteria andPreviewCodeNotEqualTo(String value) {
        addCriterion("ROLE2PREVIEW.PREVIEW_CODE <>", value, "previewCode");
        return this;
    }

    public GeneratedCriteria andPreviewCodeGreaterThan(String value) {
        addCriterion("ROLE2PREVIEW.PREVIEW_CODE >", value, "previewCode");
        return this;
    }

    public GeneratedCriteria andPreviewCodeGreaterThanOrEqualTo(String value) {
        addCriterion("ROLE2PREVIEW.PREVIEW_CODE >=", value, "previewCode");
        return this;
    }

    public GeneratedCriteria andPreviewCodeLessThan(String value) {
        addCriterion("ROLE2PREVIEW.PREVIEW_CODE <", value, "previewCode");
        return this;
    }

    public GeneratedCriteria andPreviewCodeLessThanOrEqualTo(String value) {
        addCriterion("ROLE2PREVIEW.PREVIEW_CODE <=", value, "previewCode");
        return this;
    }

    public GeneratedCriteria andPreviewCodeLike(String value) {
        addCriterion("ROLE2PREVIEW.PREVIEW_CODE like", value, "previewCode");
        return this;
    }

    public GeneratedCriteria andPreviewCodeNotLike(String value) {
        addCriterion("ROLE2PREVIEW.PREVIEW_CODE not like", value, "previewCode");
        return this;
    }

    public GeneratedCriteria andPreviewCodeIn(List<String> values) {
        addCriterion("ROLE2PREVIEW.PREVIEW_CODE in", values, "previewCode");
        return this;
    }

    public GeneratedCriteria andPreviewCodeNotIn(List<String> values) {
        addCriterion("ROLE2PREVIEW.PREVIEW_CODE not in", values, "previewCode");
        return this;
    }

    public GeneratedCriteria andPreviewCodeBetween(String value1, String value2) {
        addCriterion("ROLE2PREVIEW.PREVIEW_CODE between", value1, value2, "previewCode");
        return this;
    }

    public GeneratedCriteria andPreviewCodeNotBetween(String value1, String value2) {
        addCriterion("ROLE2PREVIEW.PREVIEW_CODE not between", value1, value2, "previewCode");
        return this;
    }
}