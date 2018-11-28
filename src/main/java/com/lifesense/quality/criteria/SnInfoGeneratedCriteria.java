package com.lifesense.quality.criteria;

import com.lifesense.quality.base.GeneratedCriteria;
import com.lifesense.quality.domain.SnInfo;

import java.util.List;

/**
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */
public class SnInfoGeneratedCriteria extends GeneratedCriteria<SnInfo> {


    public SnInfoGeneratedCriteria andSnIsNull() {
        addCriterion("sn is null");
        return this;
    }

    public SnInfoGeneratedCriteria andSnIsNotNull() {
        addCriterion("sn is not null");
        return this;
    }

    public SnInfoGeneratedCriteria andSnEqualTo(String value) {
        addCriterion("sn =", value, "sn");
        return this;
    }

    public SnInfoGeneratedCriteria andSnNotEqualTo(String value) {
        addCriterion("sn <>", value, "sn");
        return this;
    }

    public SnInfoGeneratedCriteria andSnGreaterThan(String value) {
        addCriterion("sn >", value, "sn");
        return this;
    }

    public SnInfoGeneratedCriteria andSnGreaterThanOrEqualTo(String value) {
        addCriterion("sn >=", value, "sn");
        return this;
    }

    public SnInfoGeneratedCriteria andSnLessThan(String value) {
        addCriterion("sn <", value, "sn");
        return this;
    }

    public SnInfoGeneratedCriteria andSnLessThanOrEqualTo(String value) {
        addCriterion("sn <=", value, "sn");
        return this;
    }

    public SnInfoGeneratedCriteria andSnLike(String value) {
        addCriterion("sn like", value, "sn");
        return this;
    }

    public SnInfoGeneratedCriteria andSnNotLike(String value) {
        addCriterion("sn not like", value, "sn");
        return this;
    }

    public SnInfoGeneratedCriteria andSnIn(List<String> values) {
        addCriterion("sn in", values, "sn");
        return this;
    }

    public SnInfoGeneratedCriteria andSnNotIn(List<String> values) {
        addCriterion("sn not in", values, "sn");
        return this;
    }

    public SnInfoGeneratedCriteria andSnBetween(String value1, String value2) {
        addCriterion("sn between", value1, value2, "sn");
        return this;
    }

    public SnInfoGeneratedCriteria andSnNotBetween(String value1, String value2) {
        addCriterion("sn not between", value1, value2, "sn");
        return this;
    }

    public SnInfoGeneratedCriteria andProductIdIn(List<Long> values) {
        addCriterion("product_id in", values, "product_id");
        return this;
    }

    public SnInfoGeneratedCriteria andTypeIsNull() {
        addCriterion("type is null");
        return this;
    }

    public SnInfoGeneratedCriteria andTypeIsNotNull() {
        addCriterion("type is not null");
        return this;
    }

    public SnInfoGeneratedCriteria andTypeEqualTo(String value) {
        addCriterion("type =", value, "type");
        return this;
    }

    public SnInfoGeneratedCriteria andTypeNotEqualTo(String value) {
        addCriterion("type <>", value, "type");
        return this;
    }

    public SnInfoGeneratedCriteria andTypeGreaterThan(String value) {
        addCriterion("type >", value, "type");
        return this;
    }

    public SnInfoGeneratedCriteria andTypeGreaterThanOrEqualTo(String value) {
        addCriterion("type >=", value, "type");
        return this;
    }

    public SnInfoGeneratedCriteria andTypeLessThan(String value) {
        addCriterion("type <", value, "type");
        return this;
    }

    public SnInfoGeneratedCriteria andTypeLessThanOrEqualTo(String value) {
        addCriterion("type <=", value, "type");
        return this;
    }

    public SnInfoGeneratedCriteria andTypeLike(String value) {
        addCriterion("type like", value, "type");
        return this;
    }

    public SnInfoGeneratedCriteria andTypeNotLike(String value) {
        addCriterion("type not like", value, "type");
        return this;
    }

    public SnInfoGeneratedCriteria andTypeIn(List<String> values) {
        addCriterion("type in", values, "type");
        return this;
    }

    public SnInfoGeneratedCriteria andTypeNotIn(List<String> values) {
        addCriterion("type not in", values, "type");
        return this;
    }

    public SnInfoGeneratedCriteria andTypeBetween(String value1, String value2) {
        addCriterion("type between", value1, value2, "type");
        return this;
    }

    public SnInfoGeneratedCriteria andTypeNotBetween(String value1, String value2) {
        addCriterion("type not between", value1, value2, "type");
        return this;
    }

    public SnInfoGeneratedCriteria andCodeIsNull() {
        addCriterion("code is null");
        return this;
    }

    public SnInfoGeneratedCriteria andCodeIsNotNull() {
        addCriterion("code is not null");
        return this;
    }

    public SnInfoGeneratedCriteria andCodeEqualTo(String value) {
        addCriterion("code =", value, "code");
        return this;
    }

    public SnInfoGeneratedCriteria andCodeNotEqualTo(String value) {
        addCriterion("code <>", value, "code");
        return this;
    }

    public SnInfoGeneratedCriteria andCodeGreaterThan(String value) {
        addCriterion("code >", value, "code");
        return this;
    }

    public SnInfoGeneratedCriteria andCodeGreaterThanOrEqualTo(String value) {
        addCriterion("code >=", value, "code");
        return this;
    }

    public SnInfoGeneratedCriteria andCodeLessThan(String value) {
        addCriterion("code <", value, "code");
        return this;
    }

    public SnInfoGeneratedCriteria andCodeLessThanOrEqualTo(String value) {
        addCriterion("code <=", value, "code");
        return this;
    }

    public SnInfoGeneratedCriteria andCodeLike(String value) {
        addCriterion("code like", value, "code");
        return this;
    }

    public SnInfoGeneratedCriteria andCodeNotLike(String value) {
        addCriterion("code not like", value, "code");
        return this;
    }

    public SnInfoGeneratedCriteria andCodeIn(List<String> values) {
        addCriterion("code in", values, "code");
        return this;
    }

    public SnInfoGeneratedCriteria andCodeNotIn(List<String> values) {
        addCriterion("code not in", values, "code");
        return this;
    }

    public SnInfoGeneratedCriteria andCodeBetween(String value1, String value2) {
        addCriterion("code between", value1, value2, "code");
        return this;
    }

    public SnInfoGeneratedCriteria andCodeNotBetween(String value1, String value2) {
        addCriterion("code not between", value1, value2, "code");
        return this;
    }

    public SnInfoGeneratedCriteria andCategoryIsNull() {
        addCriterion("category is null");
        return this;
    }

    public SnInfoGeneratedCriteria andCategoryIsNotNull() {
        addCriterion("category is not null");
        return this;
    }

    public SnInfoGeneratedCriteria andCategoryEqualTo(String value) {
        addCriterion("category =", value, "category");
        return this;
    }

    public SnInfoGeneratedCriteria andCategoryNotEqualTo(String value) {
        addCriterion("category <>", value, "category");
        return this;
    }

    public SnInfoGeneratedCriteria andCategoryGreaterThan(String value) {
        addCriterion("category >", value, "category");
        return this;
    }

    public SnInfoGeneratedCriteria andCategoryGreaterThanOrEqualTo(String value) {
        addCriterion("category >=", value, "category");
        return this;
    }

    public SnInfoGeneratedCriteria andCategoryLessThan(String value) {
        addCriterion("category <", value, "category");
        return this;
    }

    public SnInfoGeneratedCriteria andCategoryLessThanOrEqualTo(String value) {
        addCriterion("category <=", value, "category");
        return this;
    }

    public SnInfoGeneratedCriteria andCategoryLike(String value) {
        addCriterion("category like", value, "category");
        return this;
    }

    public SnInfoGeneratedCriteria andCategoryNotLike(String value) {
        addCriterion("category not like", value, "category");
        return this;
    }

    public SnInfoGeneratedCriteria andCategoryIn(List<String> values) {
        addCriterion("category in", values, "category");
        return this;
    }

    public SnInfoGeneratedCriteria andCategoryNotIn(List<String> values) {
        addCriterion("category not in", values, "category");
        return this;
    }

    public SnInfoGeneratedCriteria andCategoryBetween(String value1, String value2) {
        addCriterion("category between", value1, value2, "category");
        return this;
    }

    public SnInfoGeneratedCriteria andCategoryNotBetween(String value1, String value2) {
        addCriterion("category not between", value1, value2, "category");
        return this;
    }

    public SnInfoGeneratedCriteria andYmdIsNull() {
        addCriterion("ymd is null");
        return this;
    }

    public SnInfoGeneratedCriteria andYmdIsNotNull() {
        addCriterion("ymd is not null");
        return this;
    }

    public SnInfoGeneratedCriteria andYmdEqualTo(String value) {
        addCriterion("ymd =", value, "ymd");
        return this;
    }

    public SnInfoGeneratedCriteria andYmdNotEqualTo(String value) {
        addCriterion("ymd <>", value, "ymd");
        return this;
    }

    public SnInfoGeneratedCriteria andYmdGreaterThan(String value) {
        addCriterion("ymd >", value, "ymd");
        return this;
    }

    public SnInfoGeneratedCriteria andYmdGreaterThanOrEqualTo(String value) {
        addCriterion("ymd >=", value, "ymd");
        return this;
    }

    public SnInfoGeneratedCriteria andYmdLessThan(String value) {
        addCriterion("ymd <", value, "ymd");
        return this;
    }

    public SnInfoGeneratedCriteria andYmdLessThanOrEqualTo(String value) {
        addCriterion("ymd <=", value, "ymd");
        return this;
    }

    public SnInfoGeneratedCriteria andYmdLike(String value) {
        addCriterion("ymd like", value, "ymd");
        return this;
    }

    public SnInfoGeneratedCriteria andYmdNotLike(String value) {
        addCriterion("ymd not like", value, "ymd");
        return this;
    }

    public SnInfoGeneratedCriteria andYmdIn(List<String> values) {
        addCriterion("ymd in", values, "ymd");
        return this;
    }

    public SnInfoGeneratedCriteria andYmdNotIn(List<String> values) {
        addCriterion("ymd not in", values, "ymd");
        return this;
    }

    public SnInfoGeneratedCriteria andYmdBetween(String value1, String value2) {
        addCriterion("ymd between", value1, value2, "ymd");
        return this;
    }

    public SnInfoGeneratedCriteria andYmdNotBetween(String value1, String value2) {
        addCriterion("ymd not between", value1, value2, "ymd");
        return this;
    }

    public SnInfoGeneratedCriteria andSerialNumberIsNull() {
        addCriterion("serial_number is null");
        return this;
    }

    public SnInfoGeneratedCriteria andSerialNumberIsNotNull() {
        addCriterion("serial_number is not null");
        return this;
    }

    public SnInfoGeneratedCriteria andSerialNumberEqualTo(String value) {
        addCriterion("serial_number =", value, "serialNumber");
        return this;
    }

    public SnInfoGeneratedCriteria andSerialNumberNotEqualTo(String value) {
        addCriterion("serial_number <>", value, "serialNumber");
        return this;
    }

    public SnInfoGeneratedCriteria andSerialNumberGreaterThan(String value) {
        addCriterion("serial_number >", value, "serialNumber");
        return this;
    }

    public SnInfoGeneratedCriteria andSerialNumberGreaterThanOrEqualTo(String value) {
        addCriterion("serial_number >=", value, "serialNumber");
        return this;
    }

    public SnInfoGeneratedCriteria andSerialNumberLessThan(String value) {
        addCriterion("serial_number <", value, "serialNumber");
        return this;
    }

    public SnInfoGeneratedCriteria andSerialNumberLessThanOrEqualTo(String value) {
        addCriterion("serial_number <=", value, "serialNumber");
        return this;
    }

    public SnInfoGeneratedCriteria andSerialNumberLike(String value) {
        addCriterion("serial_number like", value, "serialNumber");
        return this;
    }

    public SnInfoGeneratedCriteria andSerialNumberNotLike(String value) {
        addCriterion("serial_number not like", value, "serialNumber");
        return this;
    }

    public SnInfoGeneratedCriteria andSerialNumberIn(List<String> values) {
        addCriterion("serial_number in", values, "serialNumber");
        return this;
    }

    public SnInfoGeneratedCriteria andSerialNumberNotIn(List<String> values) {
        addCriterion("serial_number not in", values, "serialNumber");
        return this;
    }

    public SnInfoGeneratedCriteria andSerialNumberBetween(String value1, String value2) {
        addCriterion("serial_number between", value1, value2, "serialNumber");
        return this;
    }

    public SnInfoGeneratedCriteria andSerialNumberNotBetween(String value1, String value2) {
        addCriterion("serial_number not between", value1, value2, "serialNumber");
        return this;
    }
}