package com.lifesense.quality.criteria;

import com.lifesense.quality.base.GeneratedCriteria;
import com.lifesense.quality.domain.ProcessRecord;

import java.util.Date;
import java.util.List;

/**
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */
public class ProcessRecordGeneratedCriteria extends GeneratedCriteria<ProcessRecord> {


    public ProcessRecordGeneratedCriteria andIdIsNull() {
        addCriterion("ID is null");
        return this;
    }

    public ProcessRecordGeneratedCriteria andIdIsNotNull() {
        addCriterion("ID is not null");
        return this;
    }

    public ProcessRecordGeneratedCriteria andIdEqualTo(Long value) {
        addCriterion("ID =", value, "id");
        return this;
    }

    public ProcessRecordGeneratedCriteria andIdNotEqualTo(Long value) {
        addCriterion("ID <>", value, "id");
        return this;
    }

    public ProcessRecordGeneratedCriteria andIdGreaterThan(Long value) {
        addCriterion("ID >", value, "id");
        return this;
    }

    public ProcessRecordGeneratedCriteria andIdGreaterThanOrEqualTo(Long value) {
        addCriterion("ID >=", value, "id");
        return this;
    }

    public ProcessRecordGeneratedCriteria andIdLessThan(Long value) {
        addCriterion("ID <", value, "id");
        return this;
    }

    public ProcessRecordGeneratedCriteria andIdLessThanOrEqualTo(Long value) {
        addCriterion("ID <=", value, "id");
        return this;
    }

    public ProcessRecordGeneratedCriteria andIdIn(List<Long> values) {
        addCriterion("ID in", values, "id");
        return this;
    }

    public ProcessRecordGeneratedCriteria andIdNotIn(List<Long> values) {
        addCriterion("ID not in", values, "id");
        return this;
    }

    public ProcessRecordGeneratedCriteria andIdBetween(Long value1, Long value2) {
        addCriterion("ID between", value1, value2, "id");
        return this;
    }

    public ProcessRecordGeneratedCriteria andIdNotBetween(Long value1, Long value2) {
        addCriterion("ID not between", value1, value2, "id");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductIdIsNull() {
        addCriterion("product_id is null");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductIdIsNotNull() {
        addCriterion("product_id is not null");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductIdEqualTo(Long value) {
        addCriterion("product_id =", value, "productId");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductIdNotEqualTo(Long value) {
        addCriterion("product_id <>", value, "productId");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductIdGreaterThan(Long value) {
        addCriterion("product_id >", value, "productId");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductIdGreaterThanOrEqualTo(Long value) {
        addCriterion("product_id >=", value, "productId");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductIdLessThan(Long value) {
        addCriterion("product_id <", value, "productId");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductIdLessThanOrEqualTo(Long value) {
        addCriterion("product_id <=", value, "productId");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductIdIn(List<Long> values) {
        addCriterion("product_id in", values, "productId");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductIdNotIn(List<Long> values) {
        addCriterion("product_id not in", values, "productId");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductIdBetween(Long value1, Long value2) {
        addCriterion("product_id between", value1, value2, "productId");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductIdNotBetween(Long value1, Long value2) {
        addCriterion("product_id not between", value1, value2, "productId");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductLineIsNull() {
        addCriterion("PRODUCT_LINE is null");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductLineIsNotNull() {
        addCriterion("PRODUCT_LINE is not null");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductLineEqualTo(String value) {
        addCriterion("PRODUCT_LINE =", value, "productLine");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductLineNotEqualTo(String value) {
        addCriterion("PRODUCT_LINE <>", value, "productLine");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductLineGreaterThan(String value) {
        addCriterion("PRODUCT_LINE >", value, "productLine");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductLineGreaterThanOrEqualTo(String value) {
        addCriterion("PRODUCT_LINE >=", value, "productLine");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductLineLessThan(String value) {
        addCriterion("PRODUCT_LINE <", value, "productLine");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductLineLessThanOrEqualTo(String value) {
        addCriterion("PRODUCT_LINE <=", value, "productLine");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductLineLike(String value) {
        addCriterion("PRODUCT_LINE like", value, "productLine");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductLineNotLike(String value) {
        addCriterion("PRODUCT_LINE not like", value, "productLine");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductLineIn(List<String> values) {
        addCriterion("PRODUCT_LINE in", values, "productLine");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductLineNotIn(List<String> values) {
        addCriterion("PRODUCT_LINE not in", values, "productLine");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductLineBetween(String value1, String value2) {
        addCriterion("PRODUCT_LINE between", value1, value2, "productLine");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProductLineNotBetween(String value1, String value2) {
        addCriterion("PRODUCT_LINE not between", value1, value2, "productLine");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProcessCodeIsNull() {
        addCriterion("PROCESS_CODE is null");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProcessCodeIsNotNull() {
        addCriterion("PROCESS_CODE is not null");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProcessCodeEqualTo(String value) {
        addCriterion("PROCESS_CODE =", value, "processCode");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProcessCodeNotEqualTo(String value) {
        addCriterion("PROCESS_CODE <>", value, "processCode");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProcessCodeGreaterThan(String value) {
        addCriterion("PROCESS_CODE >", value, "processCode");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProcessCodeGreaterThanOrEqualTo(String value) {
        addCriterion("PROCESS_CODE >=", value, "processCode");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProcessCodeLessThan(String value) {
        addCriterion("PROCESS_CODE <", value, "processCode");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProcessCodeLessThanOrEqualTo(String value) {
        addCriterion("PROCESS_CODE <=", value, "processCode");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProcessCodeLike(String value) {
        addCriterion("PROCESS_CODE like", value, "processCode");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProcessCodeNotLike(String value) {
        addCriterion("PROCESS_CODE not like", value, "processCode");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProcessCodeIn(List<String> values) {
        addCriterion("PROCESS_CODE in", values, "processCode");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProcessCodeNotIn(List<String> values) {
        addCriterion("PROCESS_CODE not in", values, "processCode");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProcessCodeBetween(String value1, String value2) {
        addCriterion("PROCESS_CODE between", value1, value2, "processCode");
        return this;
    }

    public ProcessRecordGeneratedCriteria andProcessCodeNotBetween(String value1, String value2) {
        addCriterion("PROCESS_CODE not between", value1, value2, "processCode");
        return this;
    }

    public ProcessRecordGeneratedCriteria andStatusIsNull() {
        addCriterion("status is null");
        return this;
    }

    public ProcessRecordGeneratedCriteria andStatusIsNotNull() {
        addCriterion("status is not null");
        return this;
    }

    public ProcessRecordGeneratedCriteria andStatusEqualTo(String value) {
        addCriterion("status =", value, "status");
        return this;
    }

    public ProcessRecordGeneratedCriteria andStatusNotEqualTo(String value) {
        addCriterion("status <>", value, "status");
        return this;
    }

    public ProcessRecordGeneratedCriteria andStatusGreaterThan(String value) {
        addCriterion("status >", value, "status");
        return this;
    }

    public ProcessRecordGeneratedCriteria andStatusGreaterThanOrEqualTo(String value) {
        addCriterion("status >=", value, "status");
        return this;
    }

    public ProcessRecordGeneratedCriteria andStatusLessThan(String value) {
        addCriterion("status <", value, "status");
        return this;
    }

    public ProcessRecordGeneratedCriteria andStatusLessThanOrEqualTo(String value) {
        addCriterion("status <=", value, "status");
        return this;
    }

    public ProcessRecordGeneratedCriteria andStatusLike(String value) {
        addCriterion("status like", value, "status");
        return this;
    }

    public ProcessRecordGeneratedCriteria andStatusNotLike(String value) {
        addCriterion("status not like", value, "status");
        return this;
    }

    public ProcessRecordGeneratedCriteria andStatusIn(List<String> values) {
        addCriterion("status in", values, "status");
        return this;
    }

    public ProcessRecordGeneratedCriteria andStatusNotIn(List<String> values) {
        addCriterion("status not in", values, "status");
        return this;
    }

    public ProcessRecordGeneratedCriteria andStatusBetween(String value1, String value2) {
        addCriterion("status between", value1, value2, "status");
        return this;
    }

    public ProcessRecordGeneratedCriteria andStatusNotBetween(String value1, String value2) {
        addCriterion("status not between", value1, value2, "status");
        return this;
    }

    public ProcessRecordGeneratedCriteria andUserIdIsNull() {
        addCriterion("user_id is null");
        return this;
    }

    public ProcessRecordGeneratedCriteria andUserIdIsNotNull() {
        addCriterion("user_id is not null");
        return this;
    }

    public ProcessRecordGeneratedCriteria andUserIdEqualTo(Long value) {
        addCriterion("user_id =", value, "userId");
        return this;
    }

    public ProcessRecordGeneratedCriteria andUserIdNotEqualTo(Long value) {
        addCriterion("user_id <>", value, "userId");
        return this;
    }

    public ProcessRecordGeneratedCriteria andUserIdGreaterThan(Long value) {
        addCriterion("user_id >", value, "userId");
        return this;
    }

    public ProcessRecordGeneratedCriteria andUserIdGreaterThanOrEqualTo(Long value) {
        addCriterion("user_id >=", value, "userId");
        return this;
    }

    public ProcessRecordGeneratedCriteria andUserIdLessThan(Long value) {
        addCriterion("user_id <", value, "userId");
        return this;
    }

    public ProcessRecordGeneratedCriteria andUserIdLessThanOrEqualTo(Long value) {
        addCriterion("user_id <=", value, "userId");
        return this;
    }

    public ProcessRecordGeneratedCriteria andUserIdIn(List<Long> values) {
        addCriterion("user_id in", values, "userId");
        return this;
    }

    public ProcessRecordGeneratedCriteria andUserIdNotIn(List<Long> values) {
        addCriterion("user_id not in", values, "userId");
        return this;
    }

    public ProcessRecordGeneratedCriteria andUserIdBetween(Long value1, Long value2) {
        addCriterion("user_id between", value1, value2, "userId");
        return this;
    }

    public ProcessRecordGeneratedCriteria andUserIdNotBetween(Long value1, Long value2) {
        addCriterion("user_id not between", value1, value2, "userId");
        return this;
    }

    public ProcessRecordGeneratedCriteria andDescriptionIsNull() {
        addCriterion("description is null");
        return this;
    }

    public ProcessRecordGeneratedCriteria andDescriptionIsNotNull() {
        addCriterion("description is not null");
        return this;
    }

    public ProcessRecordGeneratedCriteria andDescriptionEqualTo(String value) {
        addCriterion("description =", value, "description");
        return this;
    }

    public ProcessRecordGeneratedCriteria andDescriptionNotEqualTo(String value) {
        addCriterion("description <>", value, "description");
        return this;
    }

    public ProcessRecordGeneratedCriteria andDescriptionGreaterThan(String value) {
        addCriterion("description >", value, "description");
        return this;
    }

    public ProcessRecordGeneratedCriteria andDescriptionGreaterThanOrEqualTo(String value) {
        addCriterion("description >=", value, "description");
        return this;
    }

    public ProcessRecordGeneratedCriteria andDescriptionLessThan(String value) {
        addCriterion("description <", value, "description");
        return this;
    }

    public ProcessRecordGeneratedCriteria andDescriptionLessThanOrEqualTo(String value) {
        addCriterion("description <=", value, "description");
        return this;
    }

    public ProcessRecordGeneratedCriteria andDescriptionLike(String value) {
        addCriterion("description like", value, "description");
        return this;
    }

    public ProcessRecordGeneratedCriteria andDescriptionNotLike(String value) {
        addCriterion("description not like", value, "description");
        return this;
    }

    public ProcessRecordGeneratedCriteria andDescriptionIn(List<String> values) {
        addCriterion("description in", values, "description");
        return this;
    }

    public ProcessRecordGeneratedCriteria andDescriptionNotIn(List<String> values) {
        addCriterion("description not in", values, "description");
        return this;
    }

    public ProcessRecordGeneratedCriteria andDescriptionBetween(String value1, String value2) {
        addCriterion("description between", value1, value2, "description");
        return this;
    }

    public ProcessRecordGeneratedCriteria andDescriptionNotBetween(String value1, String value2) {
        addCriterion("description not between", value1, value2, "description");
        return this;
    }

    public ProcessRecordGeneratedCriteria andContentJsonIsNull() {
        addCriterion("content_json is null");
        return this;
    }

    public ProcessRecordGeneratedCriteria andContentJsonIsNotNull() {
        addCriterion("content_json is not null");
        return this;
    }

    public ProcessRecordGeneratedCriteria andContentJsonEqualTo(String value) {
        addCriterion("content_json =", value, "contentJson");
        return this;
    }

    public ProcessRecordGeneratedCriteria andContentJsonNotEqualTo(String value) {
        addCriterion("content_json <>", value, "contentJson");
        return this;
    }

    public ProcessRecordGeneratedCriteria andContentJsonGreaterThan(String value) {
        addCriterion("content_json >", value, "contentJson");
        return this;
    }

    public ProcessRecordGeneratedCriteria andContentJsonGreaterThanOrEqualTo(String value) {
        addCriterion("content_json >=", value, "contentJson");
        return this;
    }

    public ProcessRecordGeneratedCriteria andContentJsonLessThan(String value) {
        addCriterion("content_json <", value, "contentJson");
        return this;
    }

    public ProcessRecordGeneratedCriteria andContentJsonLessThanOrEqualTo(String value) {
        addCriterion("content_json <=", value, "contentJson");
        return this;
    }

    public ProcessRecordGeneratedCriteria andContentJsonLike(String value) {
        addCriterion("content_json like", value, "contentJson");
        return this;
    }

    public ProcessRecordGeneratedCriteria andContentJsonNotLike(String value) {
        addCriterion("content_json not like", value, "contentJson");
        return this;
    }

    public ProcessRecordGeneratedCriteria andContentJsonIn(List<String> values) {
        addCriterion("content_json in", values, "contentJson");
        return this;
    }

    public ProcessRecordGeneratedCriteria andContentJsonNotIn(List<String> values) {
        addCriterion("content_json not in", values, "contentJson");
        return this;
    }

    public ProcessRecordGeneratedCriteria andContentJsonBetween(String value1, String value2) {
        addCriterion("content_json between", value1, value2, "contentJson");
        return this;
    }

    public ProcessRecordGeneratedCriteria andContentJsonNotBetween(String value1, String value2) {
        addCriterion("content_json not between", value1, value2, "contentJson");
        return this;
    }

    public ProcessRecordGeneratedCriteria andCreateTimeIsNull() {
        addCriterion("CREATE_TIME is null");
        return this;
    }

    public ProcessRecordGeneratedCriteria andCreateTimeIsNotNull() {
        addCriterion("CREATE_TIME is not null");
        return this;
    }

    public ProcessRecordGeneratedCriteria andCreateTimeEqualTo(Date value) {
        addCriterion("CREATE_TIME =", value, "createTime");
        return this;
    }

    public ProcessRecordGeneratedCriteria andCreateTimeNotEqualTo(Date value) {
        addCriterion("CREATE_TIME <>", value, "createTime");
        return this;
    }

    public ProcessRecordGeneratedCriteria andCreateTimeGreaterThan(Date value) {
        addCriterion("CREATE_TIME >", value, "createTime");
        return this;
    }

    public ProcessRecordGeneratedCriteria andCreateTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("CREATE_TIME >=", value, "createTime");
        return this;
    }

    public ProcessRecordGeneratedCriteria andCreateTimeLessThan(Date value) {
        addCriterion("CREATE_TIME <", value, "createTime");
        return this;
    }

    public ProcessRecordGeneratedCriteria andCreateTimeLessThanOrEqualTo(Date value) {
        addCriterion("CREATE_TIME <=", value, "createTime");
        return this;
    }

    public ProcessRecordGeneratedCriteria andCreateTimeIn(List<Date> values) {
        addCriterion("CREATE_TIME in", values, "createTime");
        return this;
    }

    public ProcessRecordGeneratedCriteria andCreateTimeNotIn(List<Date> values) {
        addCriterion("CREATE_TIME not in", values, "createTime");
        return this;
    }

    public ProcessRecordGeneratedCriteria andCreateTimeBetween(Date value1, Date value2) {
        addCriterion("CREATE_TIME between", value1, value2, "createTime");
        return this;
    }

    public ProcessRecordGeneratedCriteria andCreateTimeNotBetween(Date value1, Date value2) {
        addCriterion("CREATE_TIME not between", value1, value2, "createTime");
        return this;
    }
}