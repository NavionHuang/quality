package com.lifesense.quality.criteria;

import com.lifesense.quality.base.GeneratedCriteria;
import com.lifesense.quality.domain.SysLog;

import java.util.Date;
import java.util.List;

/**
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */
public class SysLogGeneratedCriteria extends GeneratedCriteria<SysLog> {

    public SysLogGeneratedCriteria andIdIsNull() {
        addCriterion("ID is null");
        return this;
    }

    public SysLogGeneratedCriteria andIdIsNotNull() {
        addCriterion("ID is not null");
        return this;
    }

    public SysLogGeneratedCriteria andIdEqualTo(Long value) {
        addCriterion("ID =", value, "id");
        return this;
    }

    public SysLogGeneratedCriteria andIdNotEqualTo(Long value) {
        addCriterion("ID <>", value, "id");
        return this;
    }

    public SysLogGeneratedCriteria andIdGreaterThan(Long value) {
        addCriterion("ID >", value, "id");
        return this;
    }

    public SysLogGeneratedCriteria andIdGreaterThanOrEqualTo(Long value) {
        addCriterion("ID >=", value, "id");
        return this;
    }

    public SysLogGeneratedCriteria andIdLessThan(Long value) {
        addCriterion("ID <", value, "id");
        return this;
    }

    public SysLogGeneratedCriteria andIdLessThanOrEqualTo(Long value) {
        addCriterion("ID <=", value, "id");
        return this;
    }

    public SysLogGeneratedCriteria andIdIn(List<Long> values) {
        addCriterion("ID in", values, "id");
        return this;
    }

    public SysLogGeneratedCriteria andIdNotIn(List<Long> values) {
        addCriterion("ID not in", values, "id");
        return this;
    }

    public SysLogGeneratedCriteria andIdBetween(Long value1, Long value2) {
        addCriterion("ID between", value1, value2, "id");
        return this;
    }

    public SysLogGeneratedCriteria andIdNotBetween(Long value1, Long value2) {
        addCriterion("ID not between", value1, value2, "id");
        return this;
    }

    public SysLogGeneratedCriteria andUserIdIsNull() {
        addCriterion("user_id is null");
        return this;
    }

    public SysLogGeneratedCriteria andUserIdIsNotNull() {
        addCriterion("user_id is not null");
        return this;
    }

    public SysLogGeneratedCriteria andUserIdEqualTo(Long value) {
        addCriterion("user_id =", value, "userId");
        return this;
    }

    public SysLogGeneratedCriteria andUserIdNotEqualTo(Long value) {
        addCriterion("user_id <>", value, "userId");
        return this;
    }

    public SysLogGeneratedCriteria andUserIdGreaterThan(Long value) {
        addCriterion("user_id >", value, "userId");
        return this;
    }

    public SysLogGeneratedCriteria andUserIdGreaterThanOrEqualTo(Long value) {
        addCriterion("user_id >=", value, "userId");
        return this;
    }

    public SysLogGeneratedCriteria andUserIdLessThan(Long value) {
        addCriterion("user_id <", value, "userId");
        return this;
    }

    public SysLogGeneratedCriteria andUserIdLessThanOrEqualTo(Long value) {
        addCriterion("user_id <=", value, "userId");
        return this;
    }

    public SysLogGeneratedCriteria andUserIdIn(List<Long> values) {
        addCriterion("user_id in", values, "userId");
        return this;
    }

    public SysLogGeneratedCriteria andUserIdNotIn(List<Long> values) {
        addCriterion("user_id not in", values, "userId");
        return this;
    }

    public SysLogGeneratedCriteria andUserIdBetween(Long value1, Long value2) {
        addCriterion("user_id between", value1, value2, "userId");
        return this;
    }

    public SysLogGeneratedCriteria andUserIdNotBetween(Long value1, Long value2) {
        addCriterion("user_id not between", value1, value2, "userId");
        return this;
    }

    public SysLogGeneratedCriteria andProductIdEqualTo(Long value) {
        addCriterion("PRODUCT_ID =", value, "productId");
        return this;
    }

    public SysLogGeneratedCriteria andProcessCodeEqualTo(Long value) {
        addCriterion("PROCESS_CODE =", value, "processCode");
        return this;
    }


    public SysLogGeneratedCriteria andContentIsNull() {
        addCriterion("content is null");
        return this;
    }

    public SysLogGeneratedCriteria andContentIsNotNull() {
        addCriterion("content is not null");
        return this;
    }

    public SysLogGeneratedCriteria andContentEqualTo(String value) {
        addCriterion("content =", value, "content");
        return this;
    }

    public SysLogGeneratedCriteria andContentNotEqualTo(String value) {
        addCriterion("content <>", value, "content");
        return this;
    }

    public SysLogGeneratedCriteria andContentGreaterThan(String value) {
        addCriterion("content >", value, "content");
        return this;
    }

    public SysLogGeneratedCriteria andContentGreaterThanOrEqualTo(String value) {
        addCriterion("content >=", value, "content");
        return this;
    }

    public SysLogGeneratedCriteria andContentLessThan(String value) {
        addCriterion("content <", value, "content");
        return this;
    }

    public SysLogGeneratedCriteria andContentLessThanOrEqualTo(String value) {
        addCriterion("content <=", value, "content");
        return this;
    }

    public SysLogGeneratedCriteria andContentLike(String value) {
        addCriterion("content like", value, "content");
        return this;
    }

    public SysLogGeneratedCriteria andContentNotLike(String value) {
        addCriterion("content not like", value, "content");
        return this;
    }

    public SysLogGeneratedCriteria andContentIn(List<String> values) {
        addCriterion("content in", values, "content");
        return this;
    }

    public SysLogGeneratedCriteria andContentNotIn(List<String> values) {
        addCriterion("content not in", values, "content");
        return this;
    }

    public SysLogGeneratedCriteria andContentBetween(String value1, String value2) {
        addCriterion("content between", value1, value2, "content");
        return this;
    }

    public SysLogGeneratedCriteria andContentNotBetween(String value1, String value2) {
        addCriterion("content not between", value1, value2, "content");
        return this;
    }

    public SysLogGeneratedCriteria andCreateTimeIsNull() {
        addCriterion("CREATE_TIME is null");
        return this;
    }

    public SysLogGeneratedCriteria andCreateTimeIsNotNull() {
        addCriterion("CREATE_TIME is not null");
        return this;
    }

    public SysLogGeneratedCriteria andCreateTimeEqualTo(Date value) {
        addCriterion("CREATE_TIME =", value, "createTime");
        return this;
    }

    public SysLogGeneratedCriteria andCreateTimeNotEqualTo(Date value) {
        addCriterion("CREATE_TIME <>", value, "createTime");
        return this;
    }

    public SysLogGeneratedCriteria andCreateTimeGreaterThan(Date value) {
        addCriterion("CREATE_TIME >", value, "createTime");
        return this;
    }

    public SysLogGeneratedCriteria andCreateTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("CREATE_TIME >=", value, "createTime");
        return this;
    }

    public SysLogGeneratedCriteria andCreateTimeLessThan(Date value) {
        addCriterion("CREATE_TIME <", value, "createTime");
        return this;
    }

    public SysLogGeneratedCriteria andCreateTimeLessThanOrEqualTo(Date value) {
        addCriterion("CREATE_TIME <=", value, "createTime");
        return this;
    }

    public SysLogGeneratedCriteria andCreateTimeIn(List<Date> values) {
        addCriterion("CREATE_TIME in", values, "createTime");
        return this;
    }

    public SysLogGeneratedCriteria andCreateTimeNotIn(List<Date> values) {
        addCriterion("CREATE_TIME not in", values, "createTime");
        return this;
    }

    public SysLogGeneratedCriteria andCreateTimeBetween(Date value1, Date value2) {
        addCriterion("CREATE_TIME between", value1, value2, "createTime");
        return this;
    }

    public SysLogGeneratedCriteria andCreateTimeNotBetween(Date value1, Date value2) {
        addCriterion("CREATE_TIME not between", value1, value2, "createTime");
        return this;
    }

}