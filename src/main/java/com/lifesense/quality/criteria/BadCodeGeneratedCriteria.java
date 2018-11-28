package com.lifesense.quality.criteria;

import com.lifesense.quality.base.GeneratedCriteria;
import com.lifesense.quality.domain.BadCode;

import java.util.List;

/**
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */
public class BadCodeGeneratedCriteria extends GeneratedCriteria<BadCode> {


    public BadCodeGeneratedCriteria andIdIsNull() {
        addCriterion("ID is null");
        return this;
    }

    public BadCodeGeneratedCriteria andIdIsNotNull() {
        addCriterion("ID is not null");
        return this;
    }

    public BadCodeGeneratedCriteria andIdEqualTo(Long value) {
        addCriterion("ID =", value, "id");
        return this;
    }

    public BadCodeGeneratedCriteria andIdNotEqualTo(Long value) {
        addCriterion("ID <>", value, "id");
        return this;
    }

    public BadCodeGeneratedCriteria andIdGreaterThan(Long value) {
        addCriterion("ID >", value, "id");
        return this;
    }

    public BadCodeGeneratedCriteria andIdGreaterThanOrEqualTo(Long value) {
        addCriterion("ID >=", value, "id");
        return this;
    }

    public BadCodeGeneratedCriteria andIdLessThan(Long value) {
        addCriterion("ID <", value, "id");
        return this;
    }

    public BadCodeGeneratedCriteria andIdLessThanOrEqualTo(Long value) {
        addCriterion("ID <=", value, "id");
        return this;
    }

    public BadCodeGeneratedCriteria andIdIn(List<Long> values) {
        addCriterion("ID in", values, "id");
        return this;
    }

    public BadCodeGeneratedCriteria andIdNotIn(List<Long> values) {
        addCriterion("ID not in", values, "id");
        return this;
    }

    public BadCodeGeneratedCriteria andIdBetween(Long value1, Long value2) {
        addCriterion("ID between", value1, value2, "id");
        return this;
    }

    public BadCodeGeneratedCriteria andIdNotBetween(Long value1, Long value2) {
        addCriterion("ID not between", value1, value2, "id");
        return this;
    }

    public BadCodeGeneratedCriteria andProcessCodeIsNull() {
        addCriterion("PROCESS_CODE is null");
        return this;
    }

    public BadCodeGeneratedCriteria andProcessCodeIsNotNull() {
        addCriterion("PROCESS_CODE is not null");
        return this;
    }

    public BadCodeGeneratedCriteria andProcessCodeEqualTo(String value) {
        addCriterion("PROCESS_CODE =", value, "processCode");
        return this;
    }

    public BadCodeGeneratedCriteria andProcessCodeNotEqualTo(String value) {
        addCriterion("PROCESS_CODE <>", value, "processCode");
        return this;
    }

    public BadCodeGeneratedCriteria andProcessCodeGreaterThan(String value) {
        addCriterion("PROCESS_CODE >", value, "processCode");
        return this;
    }

    public BadCodeGeneratedCriteria andProcessCodeGreaterThanOrEqualTo(String value) {
        addCriterion("PROCESS_CODE >=", value, "processCode");
        return this;
    }

    public BadCodeGeneratedCriteria andProcessCodeLessThan(String value) {
        addCriterion("PROCESS_CODE <", value, "processCode");
        return this;
    }

    public BadCodeGeneratedCriteria andProcessCodeLessThanOrEqualTo(String value) {
        addCriterion("PROCESS_CODE <=", value, "processCode");
        return this;
    }

    public BadCodeGeneratedCriteria andProcessCodeLike(String value) {
        addCriterion("PROCESS_CODE like", value, "processCode");
        return this;
    }

    public BadCodeGeneratedCriteria andProcessCodeNotLike(String value) {
        addCriterion("PROCESS_CODE not like", value, "processCode");
        return this;
    }

    public BadCodeGeneratedCriteria andProcessCodeIn(List<String> values) {
        addCriterion("PROCESS_CODE in", values, "processCode");
        return this;
    }

    public BadCodeGeneratedCriteria andProcessCodeNotIn(List<String> values) {
        addCriterion("PROCESS_CODE not in", values, "processCode");
        return this;
    }

    public BadCodeGeneratedCriteria andProcessCodeBetween(String value1, String value2) {
        addCriterion("PROCESS_CODE between", value1, value2, "processCode");
        return this;
    }

    public BadCodeGeneratedCriteria andProcessCodeNotBetween(String value1, String value2) {
        addCriterion("PROCESS_CODE not between", value1, value2, "processCode");
        return this;
    }

    public BadCodeGeneratedCriteria andCodeIsNull() {
        addCriterion("CODE is null");
        return this;
    }

    public BadCodeGeneratedCriteria andCodeIsNotNull() {
        addCriterion("CODE is not null");
        return this;
    }

    public BadCodeGeneratedCriteria andCodeEqualTo(String value) {
        addCriterion("CODE =", value, "code");
        return this;
    }

    public BadCodeGeneratedCriteria andCodeNotEqualTo(String value) {
        addCriterion("CODE <>", value, "code");
        return this;
    }

    public BadCodeGeneratedCriteria andCodeGreaterThan(String value) {
        addCriterion("CODE >", value, "code");
        return this;
    }

    public BadCodeGeneratedCriteria andCodeGreaterThanOrEqualTo(String value) {
        addCriterion("CODE >=", value, "code");
        return this;
    }

    public BadCodeGeneratedCriteria andCodeLessThan(String value) {
        addCriterion("CODE <", value, "code");
        return this;
    }

    public BadCodeGeneratedCriteria andCodeLessThanOrEqualTo(String value) {
        addCriterion("CODE <=", value, "code");
        return this;
    }

    public BadCodeGeneratedCriteria andCodeLike(String value) {
        addCriterion("CODE like", value, "code");
        return this;
    }

    public BadCodeGeneratedCriteria andCodeNotLike(String value) {
        addCriterion("CODE not like", value, "code");
        return this;
    }

    public BadCodeGeneratedCriteria andCodeIn(List<String> values) {
        addCriterion("CODE in", values, "code");
        return this;
    }

    public BadCodeGeneratedCriteria andCodeNotIn(List<String> values) {
        addCriterion("CODE not in", values, "code");
        return this;
    }

    public BadCodeGeneratedCriteria andCodeBetween(String value1, String value2) {
        addCriterion("CODE between", value1, value2, "code");
        return this;
    }

    public BadCodeGeneratedCriteria andCodeNotBetween(String value1, String value2) {
        addCriterion("CODE not between", value1, value2, "code");
        return this;
    }

    public BadCodeGeneratedCriteria andNameIsNull() {
        addCriterion("NAME is null");
        return this;
    }

    public BadCodeGeneratedCriteria andNameIsNotNull() {
        addCriterion("NAME is not null");
        return this;
    }

    public BadCodeGeneratedCriteria andNameEqualTo(String value) {
        addCriterion("NAME =", value, "name");
        return this;
    }

    public BadCodeGeneratedCriteria andNameNotEqualTo(String value) {
        addCriterion("NAME <>", value, "name");
        return this;
    }

    public BadCodeGeneratedCriteria andNameGreaterThan(String value) {
        addCriterion("NAME >", value, "name");
        return this;
    }

    public BadCodeGeneratedCriteria andNameGreaterThanOrEqualTo(String value) {
        addCriterion("NAME >=", value, "name");
        return this;
    }

    public BadCodeGeneratedCriteria andNameLessThan(String value) {
        addCriterion("NAME <", value, "name");
        return this;
    }

    public BadCodeGeneratedCriteria andNameLessThanOrEqualTo(String value) {
        addCriterion("NAME <=", value, "name");
        return this;
    }

    public BadCodeGeneratedCriteria andNameLike(String value) {
        addCriterion("NAME like", value, "name");
        return this;
    }

    public BadCodeGeneratedCriteria andNameNotLike(String value) {
        addCriterion("NAME not like", value, "name");
        return this;
    }

    public BadCodeGeneratedCriteria andNameIn(List<String> values) {
        addCriterion("NAME in", values, "name");
        return this;
    }

    public BadCodeGeneratedCriteria andNameNotIn(List<String> values) {
        addCriterion("NAME not in", values, "name");
        return this;
    }

    public BadCodeGeneratedCriteria andNameBetween(String value1, String value2) {
        addCriterion("NAME between", value1, value2, "name");
        return this;
    }

    public BadCodeGeneratedCriteria andNameNotBetween(String value1, String value2) {
        addCriterion("NAME not between", value1, value2, "name");
        return this;
    }

    public BadCodeGeneratedCriteria andRemarkIsNull() {
        addCriterion("REMARK is null");
        return this;
    }

    public BadCodeGeneratedCriteria andRemarkIsNotNull() {
        addCriterion("REMARK is not null");
        return this;
    }

    public BadCodeGeneratedCriteria andRemarkEqualTo(String value) {
        addCriterion("REMARK =", value, "remark");
        return this;
    }

    public BadCodeGeneratedCriteria andRemarkNotEqualTo(String value) {
        addCriterion("REMARK <>", value, "remark");
        return this;
    }

    public BadCodeGeneratedCriteria andRemarkGreaterThan(String value) {
        addCriterion("REMARK >", value, "remark");
        return this;
    }

    public BadCodeGeneratedCriteria andRemarkGreaterThanOrEqualTo(String value) {
        addCriterion("REMARK >=", value, "remark");
        return this;
    }

    public BadCodeGeneratedCriteria andRemarkLessThan(String value) {
        addCriterion("REMARK <", value, "remark");
        return this;
    }

    public BadCodeGeneratedCriteria andRemarkLessThanOrEqualTo(String value) {
        addCriterion("REMARK <=", value, "remark");
        return this;
    }

    public BadCodeGeneratedCriteria andRemarkLike(String value) {
        addCriterion("REMARK like", value, "remark");
        return this;
    }

    public BadCodeGeneratedCriteria andRemarkNotLike(String value) {
        addCriterion("REMARK not like", value, "remark");
        return this;
    }

    public BadCodeGeneratedCriteria andRemarkIn(List<String> values) {
        addCriterion("REMARK in", values, "remark");
        return this;
    }

    public BadCodeGeneratedCriteria andRemarkNotIn(List<String> values) {
        addCriterion("REMARK not in", values, "remark");
        return this;
    }

    public BadCodeGeneratedCriteria andRemarkBetween(String value1, String value2) {
        addCriterion("REMARK between", value1, value2, "remark");
        return this;
    }

    public BadCodeGeneratedCriteria andRemarkNotBetween(String value1, String value2) {
        addCriterion("REMARK not between", value1, value2, "remark");
        return this;
    }

    public BadCodeGeneratedCriteria andValidIsNull() {
        addCriterion("VALID is null");
        return this;
    }

    public BadCodeGeneratedCriteria andValidIsNotNull() {
        addCriterion("VALID is not null");
        return this;
    }

    public BadCodeGeneratedCriteria andValidEqualTo(Integer value) {
        addCriterion("VALID =", value, "valid");
        return this;
    }

    public BadCodeGeneratedCriteria andValidNotEqualTo(Integer value) {
        addCriterion("VALID <>", value, "valid");
        return this;
    }

    public BadCodeGeneratedCriteria andValidGreaterThan(Integer value) {
        addCriterion("VALID >", value, "valid");
        return this;
    }

    public BadCodeGeneratedCriteria andValidGreaterThanOrEqualTo(Integer value) {
        addCriterion("VALID >=", value, "valid");
        return this;
    }

    public BadCodeGeneratedCriteria andValidLessThan(Integer value) {
        addCriterion("VALID <", value, "valid");
        return this;
    }

    public BadCodeGeneratedCriteria andValidLessThanOrEqualTo(Integer value) {
        addCriterion("VALID <=", value, "valid");
        return this;
    }

    public BadCodeGeneratedCriteria andValidIn(List<Integer> values) {
        addCriterion("VALID in", values, "valid");
        return this;
    }

    public BadCodeGeneratedCriteria andValidNotIn(List<Integer> values) {
        addCriterion("VALID not in", values, "valid");
        return this;
    }

    public BadCodeGeneratedCriteria andValidBetween(Integer value1, Integer value2) {
        addCriterion("VALID between", value1, value2, "valid");
        return this;
    }

    public BadCodeGeneratedCriteria andValidNotBetween(Integer value1, Integer value2) {
        addCriterion("VALID not between", value1, value2, "valid");
        return this;
    }

}