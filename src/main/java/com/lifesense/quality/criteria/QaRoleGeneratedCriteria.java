package com.lifesense.quality.criteria;

import com.lifesense.quality.base.GeneratedCriteria;
import com.lifesense.quality.domain.QaRole;

import java.util.List;

/**
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */
public class QaRoleGeneratedCriteria extends GeneratedCriteria<QaRole> {


    public QaRoleGeneratedCriteria andIdIsNull() {
        addCriterion("QA_ROLE.id is null");
        return this;
    }

    public QaRoleGeneratedCriteria andIdIsNotNull() {
        addCriterion("QA_ROLE.id is not null");
        return this;
    }

    public QaRoleGeneratedCriteria andIdEqualTo(Long value) {
        addCriterion("QA_ROLE.id =", value, "id");
        return this;
    }

    public QaRoleGeneratedCriteria andIdNotEqualTo(Long value) {
        addCriterion("QA_ROLE.id <>", value, "id");
        return this;
    }

    public QaRoleGeneratedCriteria andIdGreaterThan(Long value) {
        addCriterion("QA_ROLE.id >", value, "id");
        return this;
    }

    public QaRoleGeneratedCriteria andIdGreaterThanOrEqualTo(Long value) {
        addCriterion("QA_ROLE.id >=", value, "id");
        return this;
    }

    public QaRoleGeneratedCriteria andIdLessThan(Long value) {
        addCriterion("QA_ROLE.id <", value, "id");
        return this;
    }

    public QaRoleGeneratedCriteria andIdLessThanOrEqualTo(Long value) {
        addCriterion("QA_ROLE.id <=", value, "id");
        return this;
    }

    public QaRoleGeneratedCriteria andIdIn(List<Long> values) {
        addCriterion("QA_ROLE.id in", values, "id");
        return this;
    }

    public QaRoleGeneratedCriteria andIdNotIn(List<Long> values) {
        addCriterion("QA_ROLE.id not in", values, "id");
        return this;
    }

    public QaRoleGeneratedCriteria andIdBetween(Long value1, Long value2) {
        addCriterion("QA_ROLE.id between", value1, value2, "id");
        return this;
    }

    public QaRoleGeneratedCriteria andIdNotBetween(Long value1, Long value2) {
        addCriterion("QA_ROLE.id not between", value1, value2, "id");
        return this;
    }

    public QaRoleGeneratedCriteria andCodeIsNull() {
        addCriterion("QA_ROLE.code is null");
        return this;
    }

    public QaRoleGeneratedCriteria andCodeIsNotNull() {
        addCriterion("QA_ROLE.code is not null");
        return this;
    }

    public QaRoleGeneratedCriteria andCodeEqualTo(String value) {
        addCriterion("QA_ROLE.code =", value, "code");
        return this;
    }

    public QaRoleGeneratedCriteria andCodeNotEqualTo(String value) {
        addCriterion("QA_ROLE.code <>", value, "code");
        return this;
    }

    public QaRoleGeneratedCriteria andCodeGreaterThan(String value) {
        addCriterion("QA_ROLE.code >", value, "code");
        return this;
    }

    public QaRoleGeneratedCriteria andCodeGreaterThanOrEqualTo(String value) {
        addCriterion("QA_ROLE.code >=", value, "code");
        return this;
    }

    public QaRoleGeneratedCriteria andCodeLessThan(String value) {
        addCriterion("QA_ROLE.code <", value, "code");
        return this;
    }

    public QaRoleGeneratedCriteria andCodeLessThanOrEqualTo(String value) {
        addCriterion("QA_ROLE.code <=", value, "code");
        return this;
    }

    public QaRoleGeneratedCriteria andCodeLike(String value) {
        addCriterion("QA_ROLE.code like", value, "code");
        return this;
    }

    public QaRoleGeneratedCriteria andCodeNotLike(String value) {
        addCriterion("QA_ROLE.code not like", value, "code");
        return this;
    }

    public QaRoleGeneratedCriteria andCodeIn(List<String> values) {
        addCriterion("QA_ROLE.code in", values, "code");
        return this;
    }

    public QaRoleGeneratedCriteria andCodeNotIn(List<String> values) {
        addCriterion("QA_ROLE.code not in", values, "code");
        return this;
    }

    public QaRoleGeneratedCriteria andCodeBetween(String value1, String value2) {
        addCriterion("QA_ROLE.code between", value1, value2, "code");
        return this;
    }

    public QaRoleGeneratedCriteria andCodeNotBetween(String value1, String value2) {
        addCriterion("QA_ROLE.code not between", value1, value2, "code");
        return this;
    }

    public QaRoleGeneratedCriteria andNameIsNull() {
        addCriterion("QA_ROLE.name is null");
        return this;
    }

    public QaRoleGeneratedCriteria andNameIsNotNull() {
        addCriterion("QA_ROLE.name is not null");
        return this;
    }

    public QaRoleGeneratedCriteria andNameEqualTo(String value) {
        addCriterion("QA_ROLE.name =", value, "name");
        return this;
    }

    public QaRoleGeneratedCriteria andNameNotEqualTo(String value) {
        addCriterion("QA_ROLE.name <>", value, "name");
        return this;
    }

    public QaRoleGeneratedCriteria andNameGreaterThan(String value) {
        addCriterion("QA_ROLE.name >", value, "name");
        return this;
    }

    public QaRoleGeneratedCriteria andNameGreaterThanOrEqualTo(String value) {
        addCriterion("QA_ROLE.name >=", value, "name");
        return this;
    }

    public QaRoleGeneratedCriteria andNameLessThan(String value) {
        addCriterion("QA_ROLE.name <", value, "name");
        return this;
    }

    public QaRoleGeneratedCriteria andNameLessThanOrEqualTo(String value) {
        addCriterion("QA_ROLE.name <=", value, "name");
        return this;
    }

    public QaRoleGeneratedCriteria andNameLike(String value) {
        addCriterion("QA_ROLE.name like", value, "name");
        return this;
    }

    public QaRoleGeneratedCriteria andNameNotLike(String value) {
        addCriterion("QA_ROLE.name not like", value, "name");
        return this;
    }

    public QaRoleGeneratedCriteria andNameIn(List<String> values) {
        addCriterion("QA_ROLE.name in", values, "name");
        return this;
    }

    public QaRoleGeneratedCriteria andNameNotIn(List<String> values) {
        addCriterion("QA_ROLE.name not in", values, "name");
        return this;
    }

    public QaRoleGeneratedCriteria andNameBetween(String value1, String value2) {
        addCriterion("QA_ROLE.name between", value1, value2, "name");
        return this;
    }

    public QaRoleGeneratedCriteria andNameNotBetween(String value1, String value2) {
        addCriterion("QA_ROLE.name not between", value1, value2, "name");
        return this;
    }

    public QaRoleGeneratedCriteria andValidIsNull() {
        addCriterion("QA_ROLE.valid is null");
        return this;
    }

    public QaRoleGeneratedCriteria andValidIsNotNull() {
        addCriterion("QA_ROLE.valid is not null");
        return this;
    }

    public QaRoleGeneratedCriteria andValidEqualTo(Integer value) {
        addCriterion("QA_ROLE.valid =", value, "valid");
        return this;
    }

    public QaRoleGeneratedCriteria andValidNotEqualTo(Integer value) {
        addCriterion("QA_ROLE.valid <>", value, "valid");
        return this;
    }

    public QaRoleGeneratedCriteria andValidGreaterThan(Integer value) {
        addCriterion("QA_ROLE.valid >", value, "valid");
        return this;
    }

    public QaRoleGeneratedCriteria andValidGreaterThanOrEqualTo(Integer value) {
        addCriterion("QA_ROLE.valid >=", value, "valid");
        return this;
    }

    public QaRoleGeneratedCriteria andValidLessThan(Integer value) {
        addCriterion("QA_ROLE.valid <", value, "valid");
        return this;
    }

    public QaRoleGeneratedCriteria andValidLessThanOrEqualTo(Integer value) {
        addCriterion("QA_ROLE.valid <=", value, "valid");
        return this;
    }

    public QaRoleGeneratedCriteria andValidIn(List<Integer> values) {
        addCriterion("QA_ROLE.valid in", values, "valid");
        return this;
    }

    public QaRoleGeneratedCriteria andValidNotIn(List<Integer> values) {
        addCriterion("QA_ROLE.valid not in", values, "valid");
        return this;
    }

    public QaRoleGeneratedCriteria andValidBetween(Integer value1, Integer value2) {
        addCriterion("QA_ROLE.valid between", value1, value2, "valid");
        return this;
    }

    public QaRoleGeneratedCriteria andValidNotBetween(Integer value1, Integer value2) {
        addCriterion("QA_ROLE.valid not between", value1, value2, "valid");
        return this;
    }

    public QaRoleGeneratedCriteria andDescriptionIsNull() {
        addCriterion("QA_ROLE.description is null");
        return this;
    }

    public QaRoleGeneratedCriteria andDescriptionIsNotNull() {
        addCriterion("QA_ROLE.description is not null");
        return this;
    }

    public QaRoleGeneratedCriteria andDescriptionEqualTo(String value) {
        addCriterion("QA_ROLE.description =", value, "description");
        return this;
    }

    public QaRoleGeneratedCriteria andDescriptionNotEqualTo(String value) {
        addCriterion("QA_ROLE.description <>", value, "description");
        return this;
    }

    public QaRoleGeneratedCriteria andDescriptionGreaterThan(String value) {
        addCriterion("QA_ROLE.description >", value, "description");
        return this;
    }

    public QaRoleGeneratedCriteria andDescriptionGreaterThanOrEqualTo(String value) {
        addCriterion("QA_ROLE.description >=", value, "description");
        return this;
    }

    public QaRoleGeneratedCriteria andDescriptionLessThan(String value) {
        addCriterion("QA_ROLE.description <", value, "description");
        return this;
    }

    public QaRoleGeneratedCriteria andDescriptionLessThanOrEqualTo(String value) {
        addCriterion("QA_ROLE.description <=", value, "description");
        return this;
    }

    public QaRoleGeneratedCriteria andDescriptionLike(String value) {
        addCriterion("QA_ROLE.description like", value, "description");
        return this;
    }

    public QaRoleGeneratedCriteria andDescriptionNotLike(String value) {
        addCriterion("QA_ROLE.description not like", value, "description");
        return this;
    }

    public QaRoleGeneratedCriteria andDescriptionIn(List<String> values) {
        addCriterion("QA_ROLE.description in", values, "description");
        return this;
    }

    public QaRoleGeneratedCriteria andDescriptionNotIn(List<String> values) {
        addCriterion("QA_ROLE.description not in", values, "description");
        return this;
    }

    public QaRoleGeneratedCriteria andDescriptionBetween(String value1, String value2) {
        addCriterion("QA_ROLE.description between", value1, value2, "description");
        return this;
    }

    public QaRoleGeneratedCriteria andDescriptionNotBetween(String value1, String value2) {
        addCriterion("QA_ROLE.description not between", value1, value2, "description");
        return this;
    }
}