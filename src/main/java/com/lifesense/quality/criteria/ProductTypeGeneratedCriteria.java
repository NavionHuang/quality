package com.lifesense.quality.criteria;

import com.lifesense.quality.base.GeneratedCriteria;
import com.lifesense.quality.domain.ProductType;

import java.util.List;

/**
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */
public class ProductTypeGeneratedCriteria extends GeneratedCriteria<ProductType> {


    public ProductTypeGeneratedCriteria andIdIsNull() {
        addCriterion("ID is null");
        return this;
    }

    public ProductTypeGeneratedCriteria andIdIsNotNull() {
        addCriterion("ID is not null");
        return this;
    }

    public ProductTypeGeneratedCriteria andIdEqualTo(Long value) {
        addCriterion("ID =", value, "id");
        return this;
    }

    public ProductTypeGeneratedCriteria andIdNotEqualTo(Long value) {
        addCriterion("ID <>", value, "id");
        return this;
    }

    public ProductTypeGeneratedCriteria andIdGreaterThan(Long value) {
        addCriterion("ID >", value, "id");
        return this;
    }

    public ProductTypeGeneratedCriteria andIdGreaterThanOrEqualTo(Long value) {
        addCriterion("ID >=", value, "id");
        return this;
    }

    public ProductTypeGeneratedCriteria andIdLessThan(Long value) {
        addCriterion("ID <", value, "id");
        return this;
    }

    public ProductTypeGeneratedCriteria andIdLessThanOrEqualTo(Long value) {
        addCriterion("ID <=", value, "id");
        return this;
    }

    public ProductTypeGeneratedCriteria andIdIn(List<Long> values) {
        addCriterion("ID in", values, "id");
        return this;
    }

    public ProductTypeGeneratedCriteria andIdNotIn(List<Long> values) {
        addCriterion("ID not in", values, "id");
        return this;
    }

    public ProductTypeGeneratedCriteria andIdBetween(Long value1, Long value2) {
        addCriterion("ID between", value1, value2, "id");
        return this;
    }

    public ProductTypeGeneratedCriteria andIdNotBetween(Long value1, Long value2) {
        addCriterion("ID not between", value1, value2, "id");
        return this;
    }

    public ProductTypeGeneratedCriteria andCodeIsNull() {
        addCriterion("CODE is null");
        return this;
    }

    public ProductTypeGeneratedCriteria andCodeIsNotNull() {
        addCriterion("CODE is not null");
        return this;
    }

    public ProductTypeGeneratedCriteria andCodeEqualTo(String value) {
        addCriterion("CODE =", value, "code");
        return this;
    }

    public ProductTypeGeneratedCriteria andCodeNotEqualTo(String value) {
        addCriterion("CODE <>", value, "code");
        return this;
    }

    public ProductTypeGeneratedCriteria andCodeGreaterThan(String value) {
        addCriterion("CODE >", value, "code");
        return this;
    }

    public ProductTypeGeneratedCriteria andCodeGreaterThanOrEqualTo(String value) {
        addCriterion("CODE >=", value, "code");
        return this;
    }

    public ProductTypeGeneratedCriteria andCodeLessThan(String value) {
        addCriterion("CODE <", value, "code");
        return this;
    }

    public ProductTypeGeneratedCriteria andCodeLessThanOrEqualTo(String value) {
        addCriterion("CODE <=", value, "code");
        return this;
    }

    public ProductTypeGeneratedCriteria andCodeLike(String value) {
        addCriterion("CODE like", value, "code");
        return this;
    }

    public ProductTypeGeneratedCriteria andCodeNotLike(String value) {
        addCriterion("CODE not like", value, "code");
        return this;
    }

    public ProductTypeGeneratedCriteria andCodeIn(List<String> values) {
        addCriterion("CODE in", values, "code");
        return this;
    }

    public ProductTypeGeneratedCriteria andCodeNotIn(List<String> values) {
        addCriterion("CODE not in", values, "code");
        return this;
    }

    public ProductTypeGeneratedCriteria andCodeBetween(String value1, String value2) {
        addCriterion("CODE between", value1, value2, "code");
        return this;
    }

    public ProductTypeGeneratedCriteria andCodeNotBetween(String value1, String value2) {
        addCriterion("CODE not between", value1, value2, "code");
        return this;
    }

    public ProductTypeGeneratedCriteria andNameIsNull() {
        addCriterion("NAME is null");
        return this;
    }

    public ProductTypeGeneratedCriteria andNameIsNotNull() {
        addCriterion("NAME is not null");
        return this;
    }

    public ProductTypeGeneratedCriteria andNameEqualTo(String value) {
        addCriterion("NAME =", value, "name");
        return this;
    }

    public ProductTypeGeneratedCriteria andNameNotEqualTo(String value) {
        addCriterion("NAME <>", value, "name");
        return this;
    }

    public ProductTypeGeneratedCriteria andNameGreaterThan(String value) {
        addCriterion("NAME >", value, "name");
        return this;
    }

    public ProductTypeGeneratedCriteria andNameGreaterThanOrEqualTo(String value) {
        addCriterion("NAME >=", value, "name");
        return this;
    }

    public ProductTypeGeneratedCriteria andNameLessThan(String value) {
        addCriterion("NAME <", value, "name");
        return this;
    }

    public ProductTypeGeneratedCriteria andNameLessThanOrEqualTo(String value) {
        addCriterion("NAME <=", value, "name");
        return this;
    }

    public ProductTypeGeneratedCriteria andNameLike(String value) {
        addCriterion("NAME like", value, "name");
        return this;
    }

    public ProductTypeGeneratedCriteria andNameNotLike(String value) {
        addCriterion("NAME not like", value, "name");
        return this;
    }

    public ProductTypeGeneratedCriteria andNameIn(List<String> values) {
        addCriterion("NAME in", values, "name");
        return this;
    }

    public ProductTypeGeneratedCriteria andNameNotIn(List<String> values) {
        addCriterion("NAME not in", values, "name");
        return this;
    }

    public ProductTypeGeneratedCriteria andNameBetween(String value1, String value2) {
        addCriterion("NAME between", value1, value2, "name");
        return this;
    }

    public ProductTypeGeneratedCriteria andNameNotBetween(String value1, String value2) {
        addCriterion("NAME not between", value1, value2, "name");
        return this;
    }

    public ProductTypeGeneratedCriteria andValidIsNull() {
        addCriterion("valid is null");
        return this;
    }

    public ProductTypeGeneratedCriteria andValidIsNotNull() {
        addCriterion("valid is not null");
        return this;
    }

    public ProductTypeGeneratedCriteria andValidEqualTo(Integer value) {
        addCriterion("valid =", value, "valid");
        return this;
    }

    public ProductTypeGeneratedCriteria andValidNotEqualTo(Integer value) {
        addCriterion("valid <>", value, "valid");
        return this;
    }

    public ProductTypeGeneratedCriteria andValidGreaterThan(Integer value) {
        addCriterion("valid >", value, "valid");
        return this;
    }

    public ProductTypeGeneratedCriteria andValidGreaterThanOrEqualTo(Integer value) {
        addCriterion("valid >=", value, "valid");
        return this;
    }

    public ProductTypeGeneratedCriteria andValidLessThan(Integer value) {
        addCriterion("valid <", value, "valid");
        return this;
    }

    public ProductTypeGeneratedCriteria andValidLessThanOrEqualTo(Integer value) {
        addCriterion("valid <=", value, "valid");
        return this;
    }

    public ProductTypeGeneratedCriteria andValidIn(List<Integer> values) {
        addCriterion("valid in", values, "valid");
        return this;
    }

    public ProductTypeGeneratedCriteria andValidNotIn(List<Integer> values) {
        addCriterion("valid not in", values, "valid");
        return this;
    }

    public ProductTypeGeneratedCriteria andValidBetween(Integer value1, Integer value2) {
        addCriterion("valid between", value1, value2, "valid");
        return this;
    }

    public ProductTypeGeneratedCriteria andValidNotBetween(Integer value1, Integer value2) {
        addCriterion("valid not between", value1, value2, "valid");
        return this;
    }

}