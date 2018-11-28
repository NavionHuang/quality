package com.lifesense.quality.criteria;

import com.lifesense.quality.base.GeneratedCriteria;
import com.lifesense.quality.domain.QaUser;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */
public class QaUserGeneratedCriteria extends GeneratedCriteria<QaUser> {


    public QaUserGeneratedCriteria andIdIsNull() {
        addCriterion("ID is null");
        return this;
    }

    public QaUserGeneratedCriteria andIdIsNotNull() {
        addCriterion("ID is not null");
        return this;
    }

    public QaUserGeneratedCriteria andIdEqualTo(Long value) {
        addCriterion("ID =", value, "id");
        return this;
    }

    public QaUserGeneratedCriteria andIdNotEqualTo(Long value) {
        addCriterion("ID <>", value, "id");
        return this;
    }

    public QaUserGeneratedCriteria andIdGreaterThan(Long value) {
        addCriterion("ID >", value, "id");
        return this;
    }

    public QaUserGeneratedCriteria andIdGreaterThanOrEqualTo(Long value) {
        addCriterion("ID >=", value, "id");
        return this;
    }

    public QaUserGeneratedCriteria andIdLessThan(Long value) {
        addCriterion("ID <", value, "id");
        return this;
    }

    public QaUserGeneratedCriteria andIdLessThanOrEqualTo(Long value) {
        addCriterion("ID <=", value, "id");
        return this;
    }

    public QaUserGeneratedCriteria andIdIn(List<Long> values) {
        addCriterion("ID in", values, "id");
        return this;
    }

    public QaUserGeneratedCriteria andIdNotIn(List<Long> values) {
        addCriterion("ID not in", values, "id");
        return this;
    }

    public QaUserGeneratedCriteria andIdBetween(Long value1, Long value2) {
        addCriterion("ID between", value1, value2, "id");
        return this;
    }

    public QaUserGeneratedCriteria andIdNotBetween(Long value1, Long value2) {
        addCriterion("ID not between", value1, value2, "id");
        return this;
    }

    public QaUserGeneratedCriteria andAccountIsNull() {
        addCriterion("ACCOUNT is null");
        return this;
    }

    public QaUserGeneratedCriteria andAccountIsNotNull() {
        addCriterion("ACCOUNT is not null");
        return this;
    }

    public QaUserGeneratedCriteria andAccountEqualTo(String value) {
        addCriterion("ACCOUNT =", value, "account");
        return this;
    }

    public QaUserGeneratedCriteria andAccountNotEqualTo(String value) {
        addCriterion("ACCOUNT <>", value, "account");
        return this;
    }

    public QaUserGeneratedCriteria andAccountGreaterThan(String value) {
        addCriterion("ACCOUNT >", value, "account");
        return this;
    }

    public QaUserGeneratedCriteria andAccountGreaterThanOrEqualTo(String value) {
        addCriterion("ACCOUNT >=", value, "account");
        return this;
    }

    public QaUserGeneratedCriteria andAccountLessThan(String value) {
        addCriterion("ACCOUNT <", value, "account");
        return this;
    }

    public QaUserGeneratedCriteria andAccountLessThanOrEqualTo(String value) {
        addCriterion("ACCOUNT <=", value, "account");
        return this;
    }

    public QaUserGeneratedCriteria andAccountLike(String value) {
        addCriterion("ACCOUNT like", value, "account");
        return this;
    }

    public QaUserGeneratedCriteria andAccountNotLike(String value) {
        addCriterion("ACCOUNT not like", value, "account");
        return this;
    }

    public QaUserGeneratedCriteria andAccountIn(List<String> values) {
        addCriterion("ACCOUNT in", values, "account");
        return this;
    }

    public QaUserGeneratedCriteria andAccountNotIn(List<String> values) {
        addCriterion("ACCOUNT not in", values, "account");
        return this;
    }

    public QaUserGeneratedCriteria andAccountBetween(String value1, String value2) {
        addCriterion("ACCOUNT between", value1, value2, "account");
        return this;
    }

    public QaUserGeneratedCriteria andAccountNotBetween(String value1, String value2) {
        addCriterion("ACCOUNT not between", value1, value2, "account");
        return this;
    }

    public QaUserGeneratedCriteria andPasswordIsNull() {
        addCriterion("PASSWORD is null");
        return this;
    }

    public QaUserGeneratedCriteria andPasswordIsNotNull() {
        addCriterion("PASSWORD is not null");
        return this;
    }

    public QaUserGeneratedCriteria andPasswordEqualTo(String value) {
        addCriterion("PASSWORD =", value, "password");
        return this;
    }

    public QaUserGeneratedCriteria andPasswordNotEqualTo(String value) {
        addCriterion("PASSWORD <>", value, "password");
        return this;
    }

    public QaUserGeneratedCriteria andPasswordGreaterThan(String value) {
        addCriterion("PASSWORD >", value, "password");
        return this;
    }

    public QaUserGeneratedCriteria andPasswordGreaterThanOrEqualTo(String value) {
        addCriterion("PASSWORD >=", value, "password");
        return this;
    }

    public QaUserGeneratedCriteria andPasswordLessThan(String value) {
        addCriterion("PASSWORD <", value, "password");
        return this;
    }

    public QaUserGeneratedCriteria andPasswordLessThanOrEqualTo(String value) {
        addCriterion("PASSWORD <=", value, "password");
        return this;
    }

    public QaUserGeneratedCriteria andPasswordLike(String value) {
        addCriterion("PASSWORD like", value, "password");
        return this;
    }

    public QaUserGeneratedCriteria andPasswordNotLike(String value) {
        addCriterion("PASSWORD not like", value, "password");
        return this;
    }

    public QaUserGeneratedCriteria andPasswordIn(List<String> values) {
        addCriterion("PASSWORD in", values, "password");
        return this;
    }

    public QaUserGeneratedCriteria andPasswordNotIn(List<String> values) {
        addCriterion("PASSWORD not in", values, "password");
        return this;
    }

    public QaUserGeneratedCriteria andPasswordBetween(String value1, String value2) {
        addCriterion("PASSWORD between", value1, value2, "password");
        return this;
    }

    public QaUserGeneratedCriteria andPasswordNotBetween(String value1, String value2) {
        addCriterion("PASSWORD not between", value1, value2, "password");
        return this;
    }

    public QaUserGeneratedCriteria andCodeIsNull() {
        addCriterion("CODE is null");
        return this;
    }

    public QaUserGeneratedCriteria andCodeIsNotNull() {
        addCriterion("CODE is not null");
        return this;
    }

    public QaUserGeneratedCriteria andCodeEqualTo(String value) {
        addCriterion("CODE =", value, "code");
        return this;
    }

    public QaUserGeneratedCriteria andCodeNotEqualTo(String value) {
        addCriterion("CODE <>", value, "code");
        return this;
    }

    public QaUserGeneratedCriteria andCodeGreaterThan(String value) {
        addCriterion("CODE >", value, "code");
        return this;
    }

    public QaUserGeneratedCriteria andCodeGreaterThanOrEqualTo(String value) {
        addCriterion("CODE >=", value, "code");
        return this;
    }

    public QaUserGeneratedCriteria andCodeLessThan(String value) {
        addCriterion("CODE <", value, "code");
        return this;
    }

    public QaUserGeneratedCriteria andCodeLessThanOrEqualTo(String value) {
        addCriterion("CODE <=", value, "code");
        return this;
    }

    public QaUserGeneratedCriteria andCodeLike(String value) {
        addCriterion("CODE like", value, "code");
        return this;
    }

    public QaUserGeneratedCriteria andCodeNotLike(String value) {
        addCriterion("CODE not like", value, "code");
        return this;
    }

    public QaUserGeneratedCriteria andCodeIn(List<String> values) {
        addCriterion("CODE in", values, "code");
        return this;
    }

    public QaUserGeneratedCriteria andCodeNotIn(List<String> values) {
        addCriterion("CODE not in", values, "code");
        return this;
    }

    public QaUserGeneratedCriteria andCodeBetween(String value1, String value2) {
        addCriterion("CODE between", value1, value2, "code");
        return this;
    }

    public QaUserGeneratedCriteria andCodeNotBetween(String value1, String value2) {
        addCriterion("CODE not between", value1, value2, "code");
        return this;
    }

    public QaUserGeneratedCriteria andNameIsNull() {
        addCriterion("NAME is null");
        return this;
    }

    public QaUserGeneratedCriteria andNameIsNotNull() {
        addCriterion("NAME is not null");
        return this;
    }

    public QaUserGeneratedCriteria andNameEqualTo(String value) {
        addCriterion("NAME =", value, "name");
        return this;
    }

    public QaUserGeneratedCriteria andNameNotEqualTo(String value) {
        addCriterion("NAME <>", value, "name");
        return this;
    }

    public QaUserGeneratedCriteria andNameGreaterThan(String value) {
        addCriterion("NAME >", value, "name");
        return this;
    }

    public QaUserGeneratedCriteria andNameGreaterThanOrEqualTo(String value) {
        addCriterion("NAME >=", value, "name");
        return this;
    }

    public QaUserGeneratedCriteria andNameLessThan(String value) {
        addCriterion("NAME <", value, "name");
        return this;
    }

    public QaUserGeneratedCriteria andNameLessThanOrEqualTo(String value) {
        addCriterion("NAME <=", value, "name");
        return this;
    }

    public QaUserGeneratedCriteria andNameLike(String value) {
        addCriterion("NAME like", value, "name");
        return this;
    }

    public QaUserGeneratedCriteria andNameNotLike(String value) {
        addCriterion("NAME not like", value, "name");
        return this;
    }

    public QaUserGeneratedCriteria andNameIn(List<String> values) {
        addCriterion("NAME in", values, "name");
        return this;
    }

    public QaUserGeneratedCriteria andNameNotIn(List<String> values) {
        addCriterion("NAME not in", values, "name");
        return this;
    }

    public QaUserGeneratedCriteria andNameBetween(String value1, String value2) {
        addCriterion("NAME between", value1, value2, "name");
        return this;
    }

    public QaUserGeneratedCriteria andNameNotBetween(String value1, String value2) {
        addCriterion("NAME not between", value1, value2, "name");
        return this;
    }

    public QaUserGeneratedCriteria andProcessCodeIsNull() {
        addCriterion("PROCESS_CODE is null");
        return this;
    }

    public QaUserGeneratedCriteria andProcessCodeIsNotNull() {
        addCriterion("PROCESS_CODE is not null");
        return this;
    }

    public QaUserGeneratedCriteria andProcessCodeEqualTo(String value) {
        addCriterion("PROCESS_CODE =", value, "processCode");
        return this;
    }

    public QaUserGeneratedCriteria andProcessCodeNotEqualTo(String value) {
        addCriterion("PROCESS_CODE <>", value, "processCode");
        return this;
    }

    public QaUserGeneratedCriteria andProcessCodeGreaterThan(String value) {
        addCriterion("PROCESS_CODE >", value, "processCode");
        return this;
    }

    public QaUserGeneratedCriteria andProcessCodeGreaterThanOrEqualTo(String value) {
        addCriterion("PROCESS_CODE >=", value, "processCode");
        return this;
    }

    public QaUserGeneratedCriteria andProcessCodeLessThan(String value) {
        addCriterion("PROCESS_CODE <", value, "processCode");
        return this;
    }

    public QaUserGeneratedCriteria andProcessCodeLessThanOrEqualTo(String value) {
        addCriterion("PROCESS_CODE <=", value, "processCode");
        return this;
    }

    public QaUserGeneratedCriteria andProcessCodeLike(String value) {
        addCriterion("PROCESS_CODE like", value, "processCode");
        return this;
    }

    public QaUserGeneratedCriteria andProcessCodeNotLike(String value) {
        addCriterion("PROCESS_CODE not like", value, "processCode");
        return this;
    }

    public QaUserGeneratedCriteria andProcessCodeIn(List<String> values) {
        addCriterion("PROCESS_CODE in", values, "processCode");
        return this;
    }

    public QaUserGeneratedCriteria andProcessCodeNotIn(List<String> values) {
        addCriterion("PROCESS_CODE not in", values, "processCode");
        return this;
    }

    public QaUserGeneratedCriteria andProcessCodeBetween(String value1, String value2) {
        addCriterion("PROCESS_CODE between", value1, value2, "processCode");
        return this;
    }

    public QaUserGeneratedCriteria andProcessCodeNotBetween(String value1, String value2) {
        addCriterion("PROCESS_CODE not between", value1, value2, "processCode");
        return this;
    }

    public QaUserGeneratedCriteria andValidIsNull() {
        addCriterion("VALID is null");
        return this;
    }

    public QaUserGeneratedCriteria andValidIsNotNull() {
        addCriterion("VALID is not null");
        return this;
    }

    public QaUserGeneratedCriteria andValidEqualTo(Integer value) {
        addCriterion("VALID =", value, "valid");
        return this;
    }

    public QaUserGeneratedCriteria andValidNotEqualTo(Integer value) {
        addCriterion("VALID <>", value, "valid");
        return this;
    }

    public QaUserGeneratedCriteria andValidGreaterThan(Integer value) {
        addCriterion("VALID >", value, "valid");
        return this;
    }

    public QaUserGeneratedCriteria andValidGreaterThanOrEqualTo(Integer value) {
        addCriterion("VALID >=", value, "valid");
        return this;
    }

    public QaUserGeneratedCriteria andValidLessThan(Integer value) {
        addCriterion("VALID <", value, "valid");
        return this;
    }

    public QaUserGeneratedCriteria andValidLessThanOrEqualTo(Integer value) {
        addCriterion("VALID <=", value, "valid");
        return this;
    }

    public QaUserGeneratedCriteria andValidIn(List<Integer> values) {
        addCriterion("VALID in", values, "valid");
        return this;
    }

    public QaUserGeneratedCriteria andValidNotIn(List<Integer> values) {
        addCriterion("VALID not in", values, "valid");
        return this;
    }

    public QaUserGeneratedCriteria andValidBetween(Integer value1, Integer value2) {
        addCriterion("VALID between", value1, value2, "valid");
        return this;
    }

    public QaUserGeneratedCriteria andValidNotBetween(Integer value1, Integer value2) {
        addCriterion("VALID not between", value1, value2, "valid");
        return this;
    }

    public QaUserGeneratedCriteria andCreateUserIdIsNull() {
        addCriterion("CREATE_USER_ID is null");
        return this;
    }

    public QaUserGeneratedCriteria andCreateUserIdIsNotNull() {
        addCriterion("CREATE_USER_ID is not null");
        return this;
    }

    public QaUserGeneratedCriteria andCreateUserIdEqualTo(BigDecimal value) {
        addCriterion("CREATE_USER_ID =", value, "createUserId");
        return this;
    }

    public QaUserGeneratedCriteria andCreateUserIdNotEqualTo(BigDecimal value) {
        addCriterion("CREATE_USER_ID <>", value, "createUserId");
        return this;
    }

    public QaUserGeneratedCriteria andCreateUserIdGreaterThan(BigDecimal value) {
        addCriterion("CREATE_USER_ID >", value, "createUserId");
        return this;
    }

    public QaUserGeneratedCriteria andCreateUserIdGreaterThanOrEqualTo(BigDecimal value) {
        addCriterion("CREATE_USER_ID >=", value, "createUserId");
        return this;
    }

    public QaUserGeneratedCriteria andCreateUserIdLessThan(BigDecimal value) {
        addCriterion("CREATE_USER_ID <", value, "createUserId");
        return this;
    }

    public QaUserGeneratedCriteria andCreateUserIdLessThanOrEqualTo(BigDecimal value) {
        addCriterion("CREATE_USER_ID <=", value, "createUserId");
        return this;
    }

    public QaUserGeneratedCriteria andCreateUserIdIn(List<BigDecimal> values) {
        addCriterion("CREATE_USER_ID in", values, "createUserId");
        return this;
    }

    public QaUserGeneratedCriteria andCreateUserIdNotIn(List<BigDecimal> values) {
        addCriterion("CREATE_USER_ID not in", values, "createUserId");
        return this;
    }

    public QaUserGeneratedCriteria andCreateUserIdBetween(BigDecimal value1, BigDecimal value2) {
        addCriterion("CREATE_USER_ID between", value1, value2, "createUserId");
        return this;
    }

    public QaUserGeneratedCriteria andCreateUserIdNotBetween(BigDecimal value1, BigDecimal value2) {
        addCriterion("CREATE_USER_ID not between", value1, value2, "createUserId");
        return this;
    }

    public QaUserGeneratedCriteria andCreateTimeIsNull() {
        addCriterion("CREATE_TIME is null");
        return this;
    }

    public QaUserGeneratedCriteria andCreateTimeIsNotNull() {
        addCriterion("CREATE_TIME is not null");
        return this;
    }

    public QaUserGeneratedCriteria andCreateTimeEqualTo(Date value) {
        addCriterion("CREATE_TIME =", value, "createTime");
        return this;
    }

    public QaUserGeneratedCriteria andCreateTimeNotEqualTo(Date value) {
        addCriterion("CREATE_TIME <>", value, "createTime");
        return this;
    }

    public QaUserGeneratedCriteria andCreateTimeGreaterThan(Date value) {
        addCriterion("CREATE_TIME >", value, "createTime");
        return this;
    }

    public QaUserGeneratedCriteria andCreateTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("CREATE_TIME >=", value, "createTime");
        return this;
    }

    public QaUserGeneratedCriteria andCreateTimeLessThan(Date value) {
        addCriterion("CREATE_TIME <", value, "createTime");
        return this;
    }

    public QaUserGeneratedCriteria andCreateTimeLessThanOrEqualTo(Date value) {
        addCriterion("CREATE_TIME <=", value, "createTime");
        return this;
    }

    public QaUserGeneratedCriteria andCreateTimeIn(List<Date> values) {
        addCriterion("CREATE_TIME in", values, "createTime");
        return this;
    }

    public QaUserGeneratedCriteria andCreateTimeNotIn(List<Date> values) {
        addCriterion("CREATE_TIME not in", values, "createTime");
        return this;
    }

    public QaUserGeneratedCriteria andCreateTimeBetween(Date value1, Date value2) {
        addCriterion("CREATE_TIME between", value1, value2, "createTime");
        return this;
    }

    public QaUserGeneratedCriteria andCreateTimeNotBetween(Date value1, Date value2) {
        addCriterion("CREATE_TIME not between", value1, value2, "createTime");
        return this;
    }

    public QaUserGeneratedCriteria andModifyTimeIsNull() {
        addCriterion("MODIFY_TIME is null");
        return this;
    }

    public QaUserGeneratedCriteria andModifyTimeIsNotNull() {
        addCriterion("MODIFY_TIME is not null");
        return this;
    }

    public QaUserGeneratedCriteria andModifyTimeEqualTo(Date value) {
        addCriterion("MODIFY_TIME =", value, "modifyTime");
        return this;
    }

    public QaUserGeneratedCriteria andModifyTimeNotEqualTo(Date value) {
        addCriterion("MODIFY_TIME <>", value, "modifyTime");
        return this;
    }

    public QaUserGeneratedCriteria andModifyTimeGreaterThan(Date value) {
        addCriterion("MODIFY_TIME >", value, "modifyTime");
        return this;
    }

    public QaUserGeneratedCriteria andModifyTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("MODIFY_TIME >=", value, "modifyTime");
        return this;
    }

    public QaUserGeneratedCriteria andModifyTimeLessThan(Date value) {
        addCriterion("MODIFY_TIME <", value, "modifyTime");
        return this;
    }

    public QaUserGeneratedCriteria andModifyTimeLessThanOrEqualTo(Date value) {
        addCriterion("MODIFY_TIME <=", value, "modifyTime");
        return this;
    }

    public QaUserGeneratedCriteria andModifyTimeIn(List<Date> values) {
        addCriterion("MODIFY_TIME in", values, "modifyTime");
        return this;
    }

    public QaUserGeneratedCriteria andModifyTimeNotIn(List<Date> values) {
        addCriterion("MODIFY_TIME not in", values, "modifyTime");
        return this;
    }

    public QaUserGeneratedCriteria andModifyTimeBetween(Date value1, Date value2) {
        addCriterion("MODIFY_TIME between", value1, value2, "modifyTime");
        return this;
    }

    public QaUserGeneratedCriteria andModifyTimeNotBetween(Date value1, Date value2) {
        addCriterion("MODIFY_TIME not between", value1, value2, "modifyTime");
        return this;
    }

    public QaUserGeneratedCriteria andLineCodeEqualTo(String value) {
        addCriterion("LINE_CODE =", value, "lineCode");
        return this;
    }
}