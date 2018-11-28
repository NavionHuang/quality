package com.lifesense.quality.criteria;

import com.lifesense.quality.base.GeneratedCriteria;
import com.lifesense.quality.domain.Process;

import java.util.List;

/**
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */
public class ProcessGeneratedCriteria extends GeneratedCriteria<Process> {


    public ProcessGeneratedCriteria andIdIsNull() {
        addCriterion("ID is null");
        return this;
    }

    public ProcessGeneratedCriteria andIdIsNotNull() {
        addCriterion("ID is not null");
        return this;
    }

    public ProcessGeneratedCriteria andIdEqualTo(Long value) {
        addCriterion("ID =", value, "id");
        return this;
    }

    public ProcessGeneratedCriteria andIdNotEqualTo(Long value) {
        addCriterion("ID <>", value, "id");
        return this;
    }

    public ProcessGeneratedCriteria andIdGreaterThan(Long value) {
        addCriterion("ID >", value, "id");
        return this;
    }

    public ProcessGeneratedCriteria andIdGreaterThanOrEqualTo(Long value) {
        addCriterion("ID >=", value, "id");
        return this;
    }

    public ProcessGeneratedCriteria andIdLessThan(Long value) {
        addCriterion("ID <", value, "id");
        return this;
    }

    public ProcessGeneratedCriteria andIdLessThanOrEqualTo(Long value) {
        addCriterion("ID <=", value, "id");
        return this;
    }

    public ProcessGeneratedCriteria andIdIn(List<Long> values) {
        addCriterion("ID in", values, "id");
        return this;
    }

    public ProcessGeneratedCriteria andIdNotIn(List<Long> values) {
        addCriterion("ID not in", values, "id");
        return this;
    }

    public ProcessGeneratedCriteria andIdBetween(Long value1, Long value2) {
        addCriterion("ID between", value1, value2, "id");
        return this;
    }

    public ProcessGeneratedCriteria andIdNotBetween(Long value1, Long value2) {
        addCriterion("ID not between", value1, value2, "id");
        return this;
    }

    public ProcessGeneratedCriteria andTypeIsNull() {
        addCriterion("TYPE is null");
        return this;
    }

    public ProcessGeneratedCriteria andTypeIsNotNull() {
        addCriterion("TYPE is not null");
        return this;
    }

    public ProcessGeneratedCriteria andTypeEqualTo(Integer value) {
        addCriterion("TYPE =", value, "type");
        return this;
    }

    public ProcessGeneratedCriteria andTypeNotEqualTo(Integer value) {
        addCriterion("TYPE <>", value, "type");
        return this;
    }

    public ProcessGeneratedCriteria andTypeGreaterThan(Integer value) {
        addCriterion("TYPE >", value, "type");
        return this;
    }

    public ProcessGeneratedCriteria andTypeGreaterThanOrEqualTo(Integer value) {
        addCriterion("TYPE >=", value, "type");
        return this;
    }

    public ProcessGeneratedCriteria andTypeLessThan(Integer value) {
        addCriterion("TYPE <", value, "type");
        return this;
    }

    public ProcessGeneratedCriteria andTypeLessThanOrEqualTo(Integer value) {
        addCriterion("TYPE <=", value, "type");
        return this;
    }

    public ProcessGeneratedCriteria andTypeLike(Integer value) {
        addCriterion("TYPE like", value, "type");
        return this;
    }

    public ProcessGeneratedCriteria andTypeNotLike(Integer value) {
        addCriterion("TYPE not like", value, "type");
        return this;
    }

    public ProcessGeneratedCriteria andTypeIn(List<Integer> values) {
        addCriterion("TYPE in", values, "type");
        return this;
    }

    public ProcessGeneratedCriteria andTypeNotIn(List<Integer> values) {
        addCriterion("TYPE not in", values, "type");
        return this;
    }

    public ProcessGeneratedCriteria andTypeBetween(Integer value1, Integer value2) {
        addCriterion("TYPE between", value1, value2, "type");
        return this;
    }

    public ProcessGeneratedCriteria andTypeNotBetween(Integer value1, Integer value2) {
        addCriterion("TYPE not between", value1, value2, "type");
        return this;
    }

    public ProcessGeneratedCriteria andCodeIsNull() {
        addCriterion("CODE is null");
        return this;
    }

    public ProcessGeneratedCriteria andCodeIsNotNull() {
        addCriterion("CODE is not null");
        return this;
    }

    public ProcessGeneratedCriteria andCodeEqualTo(String value) {
        addCriterion("CODE =", value, "code");
        return this;
    }

    public ProcessGeneratedCriteria andCodeNotEqualTo(String value) {
        addCriterion("CODE <>", value, "code");
        return this;
    }

    public ProcessGeneratedCriteria andCodeGreaterThan(String value) {
        addCriterion("CODE >", value, "code");
        return this;
    }

    public ProcessGeneratedCriteria andCodeGreaterThanOrEqualTo(String value) {
        addCriterion("CODE >=", value, "code");
        return this;
    }

    public ProcessGeneratedCriteria andCodeLessThan(String value) {
        addCriterion("CODE <", value, "code");
        return this;
    }

    public ProcessGeneratedCriteria andCodeLessThanOrEqualTo(String value) {
        addCriterion("CODE <=", value, "code");
        return this;
    }

    public ProcessGeneratedCriteria andCodeLike(String value) {
        addCriterion("CODE like", value, "code");
        return this;
    }

    public ProcessGeneratedCriteria andCodeNotLike(String value) {
        addCriterion("CODE not like", value, "code");
        return this;
    }

    public ProcessGeneratedCriteria andCodeIn(List<String> values) {
        addCriterion("CODE in", values, "code");
        return this;
    }

    public ProcessGeneratedCriteria andCodeNotIn(List<String> values) {
        addCriterion("CODE not in", values, "code");
        return this;
    }

    public ProcessGeneratedCriteria andCodeBetween(String value1, String value2) {
        addCriterion("CODE between", value1, value2, "code");
        return this;
    }

    public ProcessGeneratedCriteria andCodeNotBetween(String value1, String value2) {
        addCriterion("CODE not between", value1, value2, "code");
        return this;
    }

    public ProcessGeneratedCriteria andNameIsNull() {
        addCriterion("NAME is null");
        return this;
    }

    public ProcessGeneratedCriteria andNameIsNotNull() {
        addCriterion("NAME is not null");
        return this;
    }

    public ProcessGeneratedCriteria andNameEqualTo(String value) {
        addCriterion("NAME =", value, "name");
        return this;
    }

    public ProcessGeneratedCriteria andNameNotEqualTo(String value) {
        addCriterion("NAME <>", value, "name");
        return this;
    }

    public ProcessGeneratedCriteria andNameGreaterThan(String value) {
        addCriterion("NAME >", value, "name");
        return this;
    }

    public ProcessGeneratedCriteria andNameGreaterThanOrEqualTo(String value) {
        addCriterion("NAME >=", value, "name");
        return this;
    }

    public ProcessGeneratedCriteria andNameLessThan(String value) {
        addCriterion("NAME <", value, "name");
        return this;
    }

    public ProcessGeneratedCriteria andNameLessThanOrEqualTo(String value) {
        addCriterion("NAME <=", value, "name");
        return this;
    }

    public ProcessGeneratedCriteria andNameLike(String value) {
        addCriterion("NAME like", value, "name");
        return this;
    }

    public ProcessGeneratedCriteria andNameNotLike(String value) {
        addCriterion("NAME not like", value, "name");
        return this;
    }

    public ProcessGeneratedCriteria andNameIn(List<String> values) {
        addCriterion("NAME in", values, "name");
        return this;
    }

    public ProcessGeneratedCriteria andNameNotIn(List<String> values) {
        addCriterion("NAME not in", values, "name");
        return this;
    }

    public ProcessGeneratedCriteria andNameBetween(String value1, String value2) {
        addCriterion("NAME between", value1, value2, "name");
        return this;
    }

    public ProcessGeneratedCriteria andNameNotBetween(String value1, String value2) {
        addCriterion("NAME not between", value1, value2, "name");
        return this;
    }

    public ProcessGeneratedCriteria andRemarkIsNull() {
        addCriterion("REMARK is null");
        return this;
    }

    public ProcessGeneratedCriteria andRemarkIsNotNull() {
        addCriterion("REMARK is not null");
        return this;
    }

    public ProcessGeneratedCriteria andRemarkEqualTo(String value) {
        addCriterion("REMARK =", value, "remark");
        return this;
    }

    public ProcessGeneratedCriteria andRemarkNotEqualTo(String value) {
        addCriterion("REMARK <>", value, "remark");
        return this;
    }

    public ProcessGeneratedCriteria andRemarkGreaterThan(String value) {
        addCriterion("REMARK >", value, "remark");
        return this;
    }

    public ProcessGeneratedCriteria andRemarkGreaterThanOrEqualTo(String value) {
        addCriterion("REMARK >=", value, "remark");
        return this;
    }

    public ProcessGeneratedCriteria andRemarkLessThan(String value) {
        addCriterion("REMARK <", value, "remark");
        return this;
    }

    public ProcessGeneratedCriteria andRemarkLessThanOrEqualTo(String value) {
        addCriterion("REMARK <=", value, "remark");
        return this;
    }

    public ProcessGeneratedCriteria andRemarkLike(String value) {
        addCriterion("REMARK like", value, "remark");
        return this;
    }

    public ProcessGeneratedCriteria andRemarkNotLike(String value) {
        addCriterion("REMARK not like", value, "remark");
        return this;
    }

    public ProcessGeneratedCriteria andRemarkIn(List<String> values) {
        addCriterion("REMARK in", values, "remark");
        return this;
    }

    public ProcessGeneratedCriteria andRemarkNotIn(List<String> values) {
        addCriterion("REMARK not in", values, "remark");
        return this;
    }

    public ProcessGeneratedCriteria andRemarkBetween(String value1, String value2) {
        addCriterion("REMARK between", value1, value2, "remark");
        return this;
    }

    public ProcessGeneratedCriteria andRemarkNotBetween(String value1, String value2) {
        addCriterion("REMARK not between", value1, value2, "remark");
        return this;
    }

    public ProcessGeneratedCriteria andValidIsNull() {
        addCriterion("VALID is null");
        return this;
    }

    public ProcessGeneratedCriteria andValidIsNotNull() {
        addCriterion("VALID is not null");
        return this;
    }

    public ProcessGeneratedCriteria andValidEqualTo(Integer value) {
        addCriterion("VALID =", value, "valid");
        return this;
    }

    public ProcessGeneratedCriteria andValidNotEqualTo(Integer value) {
        addCriterion("VALID <>", value, "valid");
        return this;
    }

    public ProcessGeneratedCriteria andValidGreaterThan(Integer value) {
        addCriterion("VALID >", value, "valid");
        return this;
    }

    public ProcessGeneratedCriteria andValidGreaterThanOrEqualTo(Integer value) {
        addCriterion("VALID >=", value, "valid");
        return this;
    }

    public ProcessGeneratedCriteria andValidLessThan(Integer value) {
        addCriterion("VALID <", value, "valid");
        return this;
    }

    public ProcessGeneratedCriteria andValidLessThanOrEqualTo(Integer value) {
        addCriterion("VALID <=", value, "valid");
        return this;
    }

    public ProcessGeneratedCriteria andValidIn(List<Integer> values) {
        addCriterion("VALID in", values, "valid");
        return this;
    }

    public ProcessGeneratedCriteria andValidNotIn(List<Integer> values) {
        addCriterion("VALID not in", values, "valid");
        return this;
    }

    public ProcessGeneratedCriteria andValidBetween(Integer value1, Integer value2) {
        addCriterion("VALID between", value1, value2, "valid");
        return this;
    }

    public ProcessGeneratedCriteria andValidNotBetween(Integer value1, Integer value2) {
        addCriterion("VALID not between", value1, value2, "valid");
        return this;
    }

    public ProcessGeneratedCriteria andSpsEqualTo(Integer value) {
        addCriterion("SPS =", value, "sps");
        return this;
    }

}