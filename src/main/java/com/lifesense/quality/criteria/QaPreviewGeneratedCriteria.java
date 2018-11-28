package com.lifesense.quality.criteria;

import com.lifesense.quality.base.GeneratedCriteria;
import com.lifesense.quality.domain.QaPreview;

import java.util.List;

/**
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */
public class QaPreviewGeneratedCriteria extends GeneratedCriteria<QaPreview> {

    public QaPreviewGeneratedCriteria andIdIsNull() {
        addCriterion("QA_PREVIEW.id is null");
        return this;
    }

    public QaPreviewGeneratedCriteria andIdIsNotNull() {
        addCriterion("QA_PREVIEW.id is not null");
        return this;
    }

    public QaPreviewGeneratedCriteria andIdEqualTo(Long value) {
        addCriterion("QA_PREVIEW.id =", value, "id");
        return this;
    }

    public QaPreviewGeneratedCriteria andIdNotEqualTo(Long value) {
        addCriterion("QA_PREVIEW.id <>", value, "id");
        return this;
    }

    public QaPreviewGeneratedCriteria andIdGreaterThan(Long value) {
        addCriterion("QA_PREVIEW.id >", value, "id");
        return this;
    }

    public QaPreviewGeneratedCriteria andIdGreaterThanOrEqualTo(Long value) {
        addCriterion("QA_PREVIEW.id >=", value, "id");
        return this;
    }

    public QaPreviewGeneratedCriteria andIdLessThan(Long value) {
        addCriterion("QA_PREVIEW.id <", value, "id");
        return this;
    }

    public QaPreviewGeneratedCriteria andIdLessThanOrEqualTo(Long value) {
        addCriterion("QA_PREVIEW.id <=", value, "id");
        return this;
    }

    public QaPreviewGeneratedCriteria andIdIn(List<Long> values) {
        addCriterion("QA_PREVIEW.id in", values, "id");
        return this;
    }

    public QaPreviewGeneratedCriteria andIdNotIn(List<Long> values) {
        addCriterion("QA_PREVIEW.id not in", values, "id");
        return this;
    }

    public QaPreviewGeneratedCriteria andIdBetween(Long value1, Long value2) {
        addCriterion("QA_PREVIEW.id between", value1, value2, "id");
        return this;
    }

    public QaPreviewGeneratedCriteria andIdNotBetween(Long value1, Long value2) {
        addCriterion("QA_PREVIEW.id not between", value1, value2, "id");
        return this;
    }

    public QaPreviewGeneratedCriteria andCodeIsNull() {
        addCriterion("QA_PREVIEW.code is null");
        return this;
    }

    public QaPreviewGeneratedCriteria andCodeIsNotNull() {
        addCriterion("QA_PREVIEW.code is not null");
        return this;
    }

    public QaPreviewGeneratedCriteria andCodeEqualTo(String value) {
        addCriterion("QA_PREVIEW.code =", value, "code");
        return this;
    }

    public QaPreviewGeneratedCriteria andCodeNotEqualTo(String value) {
        addCriterion("QA_PREVIEW.code <>", value, "code");
        return this;
    }

    public QaPreviewGeneratedCriteria andCodeGreaterThan(String value) {
        addCriterion("QA_PREVIEW.code >", value, "code");
        return this;
    }

    public QaPreviewGeneratedCriteria andCodeGreaterThanOrEqualTo(String value) {
        addCriterion("QA_PREVIEW.code >=", value, "code");
        return this;
    }

    public QaPreviewGeneratedCriteria andCodeLessThan(String value) {
        addCriterion("QA_PREVIEW.code <", value, "code");
        return this;
    }

    public QaPreviewGeneratedCriteria andCodeLessThanOrEqualTo(String value) {
        addCriterion("QA_PREVIEW.code <=", value, "code");
        return this;
    }

    public QaPreviewGeneratedCriteria andCodeLike(String value) {
        addCriterion("QA_PREVIEW.code like", value, "code");
        return this;
    }

    public QaPreviewGeneratedCriteria andCodeNotLike(String value) {
        addCriterion("QA_PREVIEW.code not like", value, "code");
        return this;
    }

    public QaPreviewGeneratedCriteria andCodeIn(List<String> values) {
        addCriterion("QA_PREVIEW.code in", values, "code");
        return this;
    }

    public QaPreviewGeneratedCriteria andCodeNotIn(List<String> values) {
        addCriterion("QA_PREVIEW.code not in", values, "code");
        return this;
    }

    public QaPreviewGeneratedCriteria andCodeBetween(String value1, String value2) {
        addCriterion("QA_PREVIEW.code between", value1, value2, "code");
        return this;
    }

    public QaPreviewGeneratedCriteria andCodeNotBetween(String value1, String value2) {
        addCriterion("QA_PREVIEW.code not between", value1, value2, "code");
        return this;
    }

    public QaPreviewGeneratedCriteria andNameIsNull() {
        addCriterion("QA_PREVIEW.name is null");
        return this;
    }

    public QaPreviewGeneratedCriteria andNameIsNotNull() {
        addCriterion("QA_PREVIEW.name is not null");
        return this;
    }

    public QaPreviewGeneratedCriteria andNameEqualTo(String value) {
        addCriterion("QA_PREVIEW.name =", value, "name");
        return this;
    }

    public QaPreviewGeneratedCriteria andNameNotEqualTo(String value) {
        addCriterion("QA_PREVIEW.name <>", value, "name");
        return this;
    }

    public QaPreviewGeneratedCriteria andNameGreaterThan(String value) {
        addCriterion("QA_PREVIEW.name >", value, "name");
        return this;
    }

    public QaPreviewGeneratedCriteria andNameGreaterThanOrEqualTo(String value) {
        addCriterion("QA_PREVIEW.name >=", value, "name");
        return this;
    }

    public QaPreviewGeneratedCriteria andNameLessThan(String value) {
        addCriterion("QA_PREVIEW.name <", value, "name");
        return this;
    }

    public QaPreviewGeneratedCriteria andNameLessThanOrEqualTo(String value) {
        addCriterion("QA_PREVIEW.name <=", value, "name");
        return this;
    }

    public QaPreviewGeneratedCriteria andNameLike(String value) {
        addCriterion("QA_PREVIEW.name like", value, "name");
        return this;
    }

    public QaPreviewGeneratedCriteria andNameNotLike(String value) {
        addCriterion("QA_PREVIEW.name not like", value, "name");
        return this;
    }

    public QaPreviewGeneratedCriteria andNameIn(List<String> values) {
        addCriterion("QA_PREVIEW.name in", values, "name");
        return this;
    }

    public QaPreviewGeneratedCriteria andNameNotIn(List<String> values) {
        addCriterion("QA_PREVIEW.name not in", values, "name");
        return this;
    }

    public QaPreviewGeneratedCriteria andNameBetween(String value1, String value2) {
        addCriterion("QA_PREVIEW.name between", value1, value2, "name");
        return this;
    }

    public QaPreviewGeneratedCriteria andNameNotBetween(String value1, String value2) {
        addCriterion("QA_PREVIEW.name not between", value1, value2, "name");
        return this;
    }

    public QaPreviewGeneratedCriteria andUriIsNull() {
        addCriterion("QA_PREVIEW.uri is null");
        return this;
    }

    public QaPreviewGeneratedCriteria andUriIsNotNull() {
        addCriterion("QA_PREVIEW.uri is not null");
        return this;
    }

    public QaPreviewGeneratedCriteria andUriEqualTo(String value) {
        addCriterion("QA_PREVIEW.uri =", value, "uri");
        return this;
    }

    public QaPreviewGeneratedCriteria andUriNotEqualTo(String value) {
        addCriterion("QA_PREVIEW.uri <>", value, "uri");
        return this;
    }

    public QaPreviewGeneratedCriteria andUriGreaterThan(String value) {
        addCriterion("QA_PREVIEW.uri >", value, "uri");
        return this;
    }

    public QaPreviewGeneratedCriteria andUriGreaterThanOrEqualTo(String value) {
        addCriterion("QA_PREVIEW.uri >=", value, "uri");
        return this;
    }

    public QaPreviewGeneratedCriteria andUriLessThan(String value) {
        addCriterion("QA_PREVIEW.uri <", value, "uri");
        return this;
    }

    public QaPreviewGeneratedCriteria andUriLessThanOrEqualTo(String value) {
        addCriterion("QA_PREVIEW.uri <=", value, "uri");
        return this;
    }

    public QaPreviewGeneratedCriteria andUriLike(String value) {
        addCriterion("QA_PREVIEW.uri like", value, "uri");
        return this;
    }

    public QaPreviewGeneratedCriteria andUriNotLike(String value) {
        addCriterion("QA_PREVIEW.uri not like", value, "uri");
        return this;
    }

    public QaPreviewGeneratedCriteria andUriIn(List<String> values) {
        addCriterion("QA_PREVIEW.uri in", values, "uri");
        return this;
    }

    public QaPreviewGeneratedCriteria andUriNotIn(List<String> values) {
        addCriterion("QA_PREVIEW.uri not in", values, "uri");
        return this;
    }

    public QaPreviewGeneratedCriteria andUriBetween(String value1, String value2) {
        addCriterion("QA_PREVIEW.uri between", value1, value2, "uri");
        return this;
    }

    public QaPreviewGeneratedCriteria andUriNotBetween(String value1, String value2) {
        addCriterion("QA_PREVIEW.uri not between", value1, value2, "uri");
        return this;
    }

    public QaPreviewGeneratedCriteria andValidIsNull() {
        addCriterion("QA_PREVIEW.valid is null");
        return this;
    }

    public QaPreviewGeneratedCriteria andValidIsNotNull() {
        addCriterion("QA_PREVIEW.valid is not null");
        return this;
    }

    public QaPreviewGeneratedCriteria andValidEqualTo(Integer value) {
        addCriterion("QA_PREVIEW.valid =", value, "valid");
        return this;
    }

    public QaPreviewGeneratedCriteria andValidNotEqualTo(Integer value) {
        addCriterion("QA_PREVIEW.valid <>", value, "valid");
        return this;
    }

    public QaPreviewGeneratedCriteria andValidGreaterThan(Integer value) {
        addCriterion("QA_PREVIEW.valid >", value, "valid");
        return this;
    }

    public QaPreviewGeneratedCriteria andValidGreaterThanOrEqualTo(Integer value) {
        addCriterion("QA_PREVIEW.valid >=", value, "valid");
        return this;
    }

    public QaPreviewGeneratedCriteria andValidLessThan(Integer value) {
        addCriterion("QA_PREVIEW.valid <", value, "valid");
        return this;
    }

    public QaPreviewGeneratedCriteria andValidLessThanOrEqualTo(Integer value) {
        addCriterion("QA_PREVIEW.valid <=", value, "valid");
        return this;
    }

    public QaPreviewGeneratedCriteria andValidLike(Integer value) {
        addCriterion("QA_PREVIEW.valid like", value, "valid");
        return this;
    }

    public QaPreviewGeneratedCriteria andValidNotLike(Integer value) {
        addCriterion("QA_PREVIEW.valid not like", value, "valid");
        return this;
    }

    public QaPreviewGeneratedCriteria andValidIn(List<Integer> values) {
        addCriterion("QA_PREVIEW.valid in", values, "valid");
        return this;
    }

    public QaPreviewGeneratedCriteria andValidNotIn(List<Integer> values) {
        addCriterion("QA_PREVIEW.valid not in", values, "valid");
        return this;
    }

    public QaPreviewGeneratedCriteria andValidBetween(Integer value1, Integer value2) {
        addCriterion("QA_PREVIEW.valid between", value1, value2, "valid");
        return this;
    }

    public QaPreviewGeneratedCriteria andValidNotBetween(Integer value1, Integer value2) {
        addCriterion("QA_PREVIEW.valid not between", value1, value2, "valid");
        return this;
    }

    public QaPreviewGeneratedCriteria andDescriptionIsNull() {
        addCriterion("QA_PREVIEW.description is null");
        return this;
    }

    public QaPreviewGeneratedCriteria andDescriptionIsNotNull() {
        addCriterion("QA_PREVIEW.description is not null");
        return this;
    }

    public QaPreviewGeneratedCriteria andDescriptionEqualTo(String value) {
        addCriterion("QA_PREVIEW.description =", value, "description");
        return this;
    }

    public QaPreviewGeneratedCriteria andDescriptionNotEqualTo(String value) {
        addCriterion("QA_PREVIEW.description <>", value, "description");
        return this;
    }

    public QaPreviewGeneratedCriteria andDescriptionGreaterThan(String value) {
        addCriterion("QA_PREVIEW.description >", value, "description");
        return this;
    }

    public QaPreviewGeneratedCriteria andDescriptionGreaterThanOrEqualTo(String value) {
        addCriterion("QA_PREVIEW.description >=", value, "description");
        return this;
    }

    public QaPreviewGeneratedCriteria andDescriptionLessThan(String value) {
        addCriterion("QA_PREVIEW.description <", value, "description");
        return this;
    }

    public QaPreviewGeneratedCriteria andDescriptionLessThanOrEqualTo(String value) {
        addCriterion("QA_PREVIEW.description <=", value, "description");
        return this;
    }

    public QaPreviewGeneratedCriteria andDescriptionLike(String value) {
        addCriterion("QA_PREVIEW.description like", value, "description");
        return this;
    }

    public QaPreviewGeneratedCriteria andDescriptionNotLike(String value) {
        addCriterion("QA_PREVIEW.description not like", value, "description");
        return this;
    }

    public QaPreviewGeneratedCriteria andDescriptionIn(List<String> values) {
        addCriterion("QA_PREVIEW.description in", values, "description");
        return this;
    }

    public QaPreviewGeneratedCriteria andDescriptionNotIn(List<String> values) {
        addCriterion("QA_PREVIEW.description not in", values, "description");
        return this;
    }

    public QaPreviewGeneratedCriteria andDescriptionBetween(String value1, String value2) {
        addCriterion("QA_PREVIEW.description between", value1, value2, "description");
        return this;
    }

    public QaPreviewGeneratedCriteria andDescriptionNotBetween(String value1, String value2) {
        addCriterion("QA_PREVIEW.description not between", value1, value2, "description");
        return this;
    }
}