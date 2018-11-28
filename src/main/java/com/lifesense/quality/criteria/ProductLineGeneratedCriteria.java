package com.lifesense.quality.criteria;

import com.lifesense.quality.base.GeneratedCriteria;
import com.lifesense.quality.domain.ProductLine;

import java.util.List;

/**
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */
public class ProductLineGeneratedCriteria extends GeneratedCriteria<ProductLine> {


    public ProductLineGeneratedCriteria andIdIsNull() {
        addCriterion("ID is null");
        return this;
    }

    public ProductLineGeneratedCriteria andIdIsNotNull() {
        addCriterion("ID is not null");
        return this;
    }

    public ProductLineGeneratedCriteria andIdEqualTo(Long value) {
        addCriterion("ID =", value, "id");
        return this;
    }

    public ProductLineGeneratedCriteria andIdNotEqualTo(Long value) {
        addCriterion("ID <>", value, "id");
        return this;
    }

    public ProductLineGeneratedCriteria andIdGreaterThan(Long value) {
        addCriterion("ID >", value, "id");
        return this;
    }

    public ProductLineGeneratedCriteria andIdGreaterThanOrEqualTo(Long value) {
        addCriterion("ID >=", value, "id");
        return this;
    }

    public ProductLineGeneratedCriteria andIdLessThan(Long value) {
        addCriterion("ID <", value, "id");
        return this;
    }

    public ProductLineGeneratedCriteria andIdLessThanOrEqualTo(Long value) {
        addCriterion("ID <=", value, "id");
        return this;
    }

    public ProductLineGeneratedCriteria andIdIn(List<Long> values) {
        addCriterion("ID in", values, "id");
        return this;
    }

    public ProductLineGeneratedCriteria andIdNotIn(List<Long> values) {
        addCriterion("ID not in", values, "id");
        return this;
    }

    public ProductLineGeneratedCriteria andIdBetween(Long value1, Long value2) {
        addCriterion("ID between", value1, value2, "id");
        return this;
    }

    public ProductLineGeneratedCriteria andIdNotBetween(Long value1, Long value2) {
        addCriterion("ID not between", value1, value2, "id");
        return this;
    }

    public ProductLineGeneratedCriteria andCodeIsNull() {
        addCriterion("CODE is null");
        return this;
    }

    public ProductLineGeneratedCriteria andCodeIsNotNull() {
        addCriterion("CODE is not null");
        return this;
    }

    public ProductLineGeneratedCriteria andCodeEqualTo(String value) {
        addCriterion("CODE =", value, "code");
        return this;
    }

    public ProductLineGeneratedCriteria andCodeNotEqualTo(String value) {
        addCriterion("CODE <>", value, "code");
        return this;
    }

    public ProductLineGeneratedCriteria andCodeGreaterThan(String value) {
        addCriterion("CODE >", value, "code");
        return this;
    }

    public ProductLineGeneratedCriteria andCodeGreaterThanOrEqualTo(String value) {
        addCriterion("CODE >=", value, "code");
        return this;
    }

    public ProductLineGeneratedCriteria andCodeLessThan(String value) {
        addCriterion("CODE <", value, "code");
        return this;
    }

    public ProductLineGeneratedCriteria andCodeLessThanOrEqualTo(String value) {
        addCriterion("CODE <=", value, "code");
        return this;
    }

    public ProductLineGeneratedCriteria andCodeLike(String value) {
        addCriterion("CODE like", value, "code");
        return this;
    }

    public ProductLineGeneratedCriteria andCodeNotLike(String value) {
        addCriterion("CODE not like", value, "code");
        return this;
    }

    public ProductLineGeneratedCriteria andCodeIn(List<String> values) {
        addCriterion("CODE in", values, "code");
        return this;
    }

    public ProductLineGeneratedCriteria andCodeNotIn(List<String> values) {
        addCriterion("CODE not in", values, "code");
        return this;
    }

    public ProductLineGeneratedCriteria andCodeBetween(String value1, String value2) {
        addCriterion("CODE between", value1, value2, "code");
        return this;
    }

    public ProductLineGeneratedCriteria andCodeNotBetween(String value1, String value2) {
        addCriterion("CODE not between", value1, value2, "code");
        return this;
    }

    public ProductLineGeneratedCriteria andNameIsNull() {
        addCriterion("NAME is null");
        return this;
    }

    public ProductLineGeneratedCriteria andNameIsNotNull() {
        addCriterion("NAME is not null");
        return this;
    }

    public ProductLineGeneratedCriteria andNameEqualTo(String value) {
        addCriterion("NAME =", value, "name");
        return this;
    }

    public ProductLineGeneratedCriteria andNameNotEqualTo(String value) {
        addCriterion("NAME <>", value, "name");
        return this;
    }

    public ProductLineGeneratedCriteria andNameGreaterThan(String value) {
        addCriterion("NAME >", value, "name");
        return this;
    }

    public ProductLineGeneratedCriteria andNameGreaterThanOrEqualTo(String value) {
        addCriterion("NAME >=", value, "name");
        return this;
    }

    public ProductLineGeneratedCriteria andNameLessThan(String value) {
        addCriterion("NAME <", value, "name");
        return this;
    }

    public ProductLineGeneratedCriteria andNameLessThanOrEqualTo(String value) {
        addCriterion("NAME <=", value, "name");
        return this;
    }

    public ProductLineGeneratedCriteria andNameLike(String value) {
        addCriterion("NAME like", value, "name");
        return this;
    }

    public ProductLineGeneratedCriteria andNameNotLike(String value) {
        addCriterion("NAME not like", value, "name");
        return this;
    }

    public ProductLineGeneratedCriteria andNameIn(List<String> values) {
        addCriterion("NAME in", values, "name");
        return this;
    }

    public ProductLineGeneratedCriteria andNameNotIn(List<String> values) {
        addCriterion("NAME not in", values, "name");
        return this;
    }

    public ProductLineGeneratedCriteria andNameBetween(String value1, String value2) {
        addCriterion("NAME between", value1, value2, "name");
        return this;
    }

    public ProductLineGeneratedCriteria andNameNotBetween(String value1, String value2) {
        addCriterion("NAME not between", value1, value2, "name");
        return this;
    }

    public ProductLineGeneratedCriteria andRemarkIsNull() {
        addCriterion("REMARK is null");
        return this;
    }

    public ProductLineGeneratedCriteria andRemarkIsNotNull() {
        addCriterion("REMARK is not null");
        return this;
    }

    public ProductLineGeneratedCriteria andRemarkEqualTo(String value) {
        addCriterion("REMARK =", value, "remark");
        return this;
    }

    public ProductLineGeneratedCriteria andRemarkNotEqualTo(String value) {
        addCriterion("REMARK <>", value, "remark");
        return this;
    }

    public ProductLineGeneratedCriteria andRemarkGreaterThan(String value) {
        addCriterion("REMARK >", value, "remark");
        return this;
    }

    public ProductLineGeneratedCriteria andRemarkGreaterThanOrEqualTo(String value) {
        addCriterion("REMARK >=", value, "remark");
        return this;
    }

    public ProductLineGeneratedCriteria andRemarkLessThan(String value) {
        addCriterion("REMARK <", value, "remark");
        return this;
    }

    public ProductLineGeneratedCriteria andRemarkLessThanOrEqualTo(String value) {
        addCriterion("REMARK <=", value, "remark");
        return this;
    }

    public ProductLineGeneratedCriteria andRemarkLike(String value) {
        addCriterion("REMARK like", value, "remark");
        return this;
    }

    public ProductLineGeneratedCriteria andRemarkNotLike(String value) {
        addCriterion("REMARK not like", value, "remark");
        return this;
    }

    public ProductLineGeneratedCriteria andRemarkIn(List<String> values) {
        addCriterion("REMARK in", values, "remark");
        return this;
    }

    public ProductLineGeneratedCriteria andRemarkNotIn(List<String> values) {
        addCriterion("REMARK not in", values, "remark");
        return this;
    }

    public ProductLineGeneratedCriteria andRemarkBetween(String value1, String value2) {
        addCriterion("REMARK between", value1, value2, "remark");
        return this;
    }

    public ProductLineGeneratedCriteria andRemarkNotBetween(String value1, String value2) {
        addCriterion("REMARK not between", value1, value2, "remark");
        return this;
    }

    public ProductLineGeneratedCriteria andValidIsNull() {
        addCriterion("VALID is null");
        return this;
    }

    public ProductLineGeneratedCriteria andValidIsNotNull() {
        addCriterion("VALID is not null");
        return this;
    }

    public ProductLineGeneratedCriteria andValidEqualTo(Integer value) {
        addCriterion("VALID =", value, "valid");
        return this;
    }

    public ProductLineGeneratedCriteria andValidNotEqualTo(Integer value) {
        addCriterion("VALID <>", value, "valid");
        return this;
    }

    public ProductLineGeneratedCriteria andValidGreaterThan(Integer value) {
        addCriterion("VALID >", value, "valid");
        return this;
    }

    public ProductLineGeneratedCriteria andValidGreaterThanOrEqualTo(Integer value) {
        addCriterion("VALID >=", value, "valid");
        return this;
    }

    public ProductLineGeneratedCriteria andValidLessThan(Integer value) {
        addCriterion("VALID <", value, "valid");
        return this;
    }

    public ProductLineGeneratedCriteria andValidLessThanOrEqualTo(Integer value) {
        addCriterion("VALID <=", value, "valid");
        return this;
    }

    public ProductLineGeneratedCriteria andValidIn(List<Integer> values) {
        addCriterion("VALID in", values, "valid");
        return this;
    }

    public ProductLineGeneratedCriteria andValidNotIn(List<Integer> values) {
        addCriterion("VALID not in", values, "valid");
        return this;
    }

    public ProductLineGeneratedCriteria andValidBetween(Integer value1, Integer value2) {
        addCriterion("VALID between", value1, value2, "valid");
        return this;
    }

    public ProductLineGeneratedCriteria andValidNotBetween(Integer value1, Integer value2) {
        addCriterion("VALID not between", value1, value2, "valid");
        return this;
    }

}