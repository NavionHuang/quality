package com.lifesense.quality.criteria;

import com.lifesense.quality.base.GeneratedCriteria;
import com.lifesense.quality.domain.WorkSheet;

import java.util.Date;
import java.util.List;

/**
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */
public class WorkSheetGeneratedCriteria extends GeneratedCriteria<WorkSheet> {


    public WorkSheetGeneratedCriteria andIdIsNull() {
        addCriterion("ID is null");
        return this;
    }

    public WorkSheetGeneratedCriteria andIdIsNotNull() {
        addCriterion("ID is not null");
        return this;
    }

    public WorkSheetGeneratedCriteria andIdEqualTo(Long value) {
        addCriterion("ID =", value, "id");
        return this;
    }

    public WorkSheetGeneratedCriteria andIdNotEqualTo(Long value) {
        addCriterion("ID <>", value, "id");
        return this;
    }

    public WorkSheetGeneratedCriteria andIdGreaterThan(Long value) {
        addCriterion("ID >", value, "id");
        return this;
    }

    public WorkSheetGeneratedCriteria andIdGreaterThanOrEqualTo(Long value) {
        addCriterion("ID >=", value, "id");
        return this;
    }

    public WorkSheetGeneratedCriteria andIdLessThan(Long value) {
        addCriterion("ID <", value, "id");
        return this;
    }

    public WorkSheetGeneratedCriteria andIdLessThanOrEqualTo(Long value) {
        addCriterion("ID <=", value, "id");
        return this;
    }

    public WorkSheetGeneratedCriteria andIdIn(List<Long> values) {
        addCriterion("ID in", values, "id");
        return this;
    }

    public WorkSheetGeneratedCriteria andIdNotIn(List<Long> values) {
        addCriterion("ID not in", values, "id");
        return this;
    }

    public WorkSheetGeneratedCriteria andIdBetween(Long value1, Long value2) {
        addCriterion("ID between", value1, value2, "id");
        return this;
    }

    public WorkSheetGeneratedCriteria andIdNotBetween(Long value1, Long value2) {
        addCriterion("ID not between", value1, value2, "id");
        return this;
    }

    public WorkSheetGeneratedCriteria andSheetNoIsNull() {
        addCriterion("SHEET_NO is null");
        return this;
    }

    public WorkSheetGeneratedCriteria andSheetNoIsNotNull() {
        addCriterion("SHEET_NO is not null");
        return this;
    }

    public WorkSheetGeneratedCriteria andSheetNoEqualTo(String value) {
        addCriterion("SHEET_NO =", value, "sheetNo");
        return this;
    }

    public WorkSheetGeneratedCriteria andSheetNoNotEqualTo(String value) {
        addCriterion("SHEET_NO <>", value, "sheetNo");
        return this;
    }

    public WorkSheetGeneratedCriteria andSheetNoGreaterThan(String value) {
        addCriterion("SHEET_NO >", value, "sheetNo");
        return this;
    }

    public WorkSheetGeneratedCriteria andSheetNoGreaterThanOrEqualTo(String value) {
        addCriterion("SHEET_NO >=", value, "sheetNo");
        return this;
    }

    public WorkSheetGeneratedCriteria andSheetNoLessThan(String value) {
        addCriterion("SHEET_NO <", value, "sheetNo");
        return this;
    }

    public WorkSheetGeneratedCriteria andSheetNoLessThanOrEqualTo(String value) {
        addCriterion("SHEET_NO <=", value, "sheetNo");
        return this;
    }

    public WorkSheetGeneratedCriteria andSheetNoLike(String value) {
        addCriterion("SHEET_NO like", value, "sheetNo");
        return this;
    }

    public WorkSheetGeneratedCriteria andSheetNoNotLike(String value) {
        addCriterion("SHEET_NO not like", value, "sheetNo");
        return this;
    }

    public WorkSheetGeneratedCriteria andSheetNoIn(List<String> values) {
        addCriterion("SHEET_NO in", values, "sheetNo");
        return this;
    }

    public WorkSheetGeneratedCriteria andSheetNoNotIn(List<String> values) {
        addCriterion("SHEET_NO not in", values, "sheetNo");
        return this;
    }

    public WorkSheetGeneratedCriteria andSheetNoBetween(String value1, String value2) {
        addCriterion("SHEET_NO between", value1, value2, "sheetNo");
        return this;
    }

    public WorkSheetGeneratedCriteria andSheetNoNotBetween(String value1, String value2) {
        addCriterion("SHEET_NO not between", value1, value2, "sheetNo");
        return this;
    }

    public WorkSheetGeneratedCriteria andProductTypeCodeIsNull() {
        addCriterion("PRODUCT_TYPE_CODE is null");
        return this;
    }

    public WorkSheetGeneratedCriteria andProductTypeCodeIsNotNull() {
        addCriterion("PRODUCT_TYPE_CODE is not null");
        return this;
    }

    public WorkSheetGeneratedCriteria andProductTypeCodeEqualTo(String value) {
        addCriterion("PRODUCT_TYPE_CODE =", value, "productTypeCode");
        return this;
    }

    public WorkSheetGeneratedCriteria andProductTypeCodeNotEqualTo(String value) {
        addCriterion("PRODUCT_TYPE_CODE <>", value, "productTypeCode");
        return this;
    }

    public WorkSheetGeneratedCriteria andProductTypeCodeGreaterThan(String value) {
        addCriterion("PRODUCT_TYPE_CODE >", value, "productTypeCode");
        return this;
    }

    public WorkSheetGeneratedCriteria andProductTypeCodeGreaterThanOrEqualTo(String value) {
        addCriterion("PRODUCT_TYPE_CODE >=", value, "productTypeCode");
        return this;
    }

    public WorkSheetGeneratedCriteria andProductTypeCodeLessThan(String value) {
        addCriterion("PRODUCT_TYPE_CODE <", value, "productTypeCode");
        return this;
    }

    public WorkSheetGeneratedCriteria andProductTypeCodeLessThanOrEqualTo(String value) {
        addCriterion("PRODUCT_TYPE_CODE <=", value, "productTypeCode");
        return this;
    }

    public WorkSheetGeneratedCriteria andProductTypeCodeLike(String value) {
        addCriterion("PRODUCT_TYPE_CODE like", value, "productTypeCode");
        return this;
    }

    public WorkSheetGeneratedCriteria andProductTypeCodeNotLike(String value) {
        addCriterion("PRODUCT_TYPE_CODE not like", value, "productTypeCode");
        return this;
    }

    public WorkSheetGeneratedCriteria andProductTypeCodeIn(List<String> values) {
        addCriterion("PRODUCT_TYPE_CODE in", values, "productTypeCode");
        return this;
    }

    public WorkSheetGeneratedCriteria andProductTypeCodeNotIn(List<String> values) {
        addCriterion("PRODUCT_TYPE_CODE not in", values, "productTypeCode");
        return this;
    }

    public WorkSheetGeneratedCriteria andProductTypeCodeBetween(String value1, String value2) {
        addCriterion("PRODUCT_TYPE_CODE between", value1, value2, "productTypeCode");
        return this;
    }

    public WorkSheetGeneratedCriteria andProductTypeCodeNotBetween(String value1, String value2) {
        addCriterion("PRODUCT_TYPE_CODE not between", value1, value2, "productTypeCode");
        return this;
    }

    public WorkSheetGeneratedCriteria andTypeIsNull() {
        addCriterion("TYPE is null");
        return this;
    }

    public WorkSheetGeneratedCriteria andTypeIsNotNull() {
        addCriterion("TYPE is not null");
        return this;
    }

    public WorkSheetGeneratedCriteria andTypeEqualTo(Short value) {
        addCriterion("TYPE =", value, "type");
        return this;
    }

    public WorkSheetGeneratedCriteria andTypeNotEqualTo(Short value) {
        addCriterion("TYPE <>", value, "type");
        return this;
    }

    public WorkSheetGeneratedCriteria andTypeGreaterThan(Short value) {
        addCriterion("TYPE >", value, "type");
        return this;
    }

    public WorkSheetGeneratedCriteria andTypeGreaterThanOrEqualTo(Short value) {
        addCriterion("TYPE >=", value, "type");
        return this;
    }

    public WorkSheetGeneratedCriteria andTypeLessThan(Short value) {
        addCriterion("TYPE <", value, "type");
        return this;
    }

    public WorkSheetGeneratedCriteria andTypeLessThanOrEqualTo(Short value) {
        addCriterion("TYPE <=", value, "type");
        return this;
    }

    public WorkSheetGeneratedCriteria andTypeIn(List<Short> values) {
        addCriterion("TYPE in", values, "type");
        return this;
    }

    public WorkSheetGeneratedCriteria andTypeNotIn(List<Short> values) {
        addCriterion("TYPE not in", values, "type");
        return this;
    }

    public WorkSheetGeneratedCriteria andTypeBetween(Short value1, Short value2) {
        addCriterion("TYPE between", value1, value2, "type");
        return this;
    }

    public WorkSheetGeneratedCriteria andTypeNotBetween(Short value1, Short value2) {
        addCriterion("TYPE not between", value1, value2, "type");
        return this;
    }

    public WorkSheetGeneratedCriteria andOutputNumIsNull() {
        addCriterion("OUTPUT_NUM is null");
        return this;
    }

    public WorkSheetGeneratedCriteria andOutputNumIsNotNull() {
        addCriterion("OUTPUT_NUM is not null");
        return this;
    }

    public WorkSheetGeneratedCriteria andOutputNumEqualTo(Long value) {
        addCriterion("OUTPUT_NUM =", value, "outputNum");
        return this;
    }

    public WorkSheetGeneratedCriteria andOutputNumNotEqualTo(Long value) {
        addCriterion("OUTPUT_NUM <>", value, "outputNum");
        return this;
    }

    public WorkSheetGeneratedCriteria andOutputNumGreaterThan(Long value) {
        addCriterion("OUTPUT_NUM >", value, "outputNum");
        return this;
    }

    public WorkSheetGeneratedCriteria andOutputNumGreaterThanOrEqualTo(Long value) {
        addCriterion("OUTPUT_NUM >=", value, "outputNum");
        return this;
    }

    public WorkSheetGeneratedCriteria andOutputNumLessThan(Long value) {
        addCriterion("OUTPUT_NUM <", value, "outputNum");
        return this;
    }

    public WorkSheetGeneratedCriteria andOutputNumLessThanOrEqualTo(Long value) {
        addCriterion("OUTPUT_NUM <=", value, "outputNum");
        return this;
    }

    public WorkSheetGeneratedCriteria andOutputNumIn(List<Long> values) {
        addCriterion("OUTPUT_NUM in", values, "outputNum");
        return this;
    }

    public WorkSheetGeneratedCriteria andOutputNumNotIn(List<Long> values) {
        addCriterion("OUTPUT_NUM not in", values, "outputNum");
        return this;
    }

    public WorkSheetGeneratedCriteria andOutputNumBetween(Long value1, Long value2) {
        addCriterion("OUTPUT_NUM between", value1, value2, "outputNum");
        return this;
    }

    public WorkSheetGeneratedCriteria andOutputNumNotBetween(Long value1, Long value2) {
        addCriterion("OUTPUT_NUM not between", value1, value2, "outputNum");
        return this;
    }

    public WorkSheetGeneratedCriteria andStartTimeIsNull() {
        addCriterion("START_TIME is null");
        return this;
    }

    public WorkSheetGeneratedCriteria andStartTimeIsNotNull() {
        addCriterion("START_TIME is not null");
        return this;
    }

    public WorkSheetGeneratedCriteria andStartTimeEqualTo(Date value) {
        addCriterion("START_TIME =", value, "startTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andStartTimeNotEqualTo(Date value) {
        addCriterion("START_TIME <>", value, "startTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andStartTimeGreaterThan(Date value) {
        addCriterion("START_TIME >", value, "startTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andStartTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("START_TIME >=", value, "startTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andStartTimeLessThan(Date value) {
        addCriterion("START_TIME <", value, "startTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andStartTimeLessThanOrEqualTo(Date value) {
        addCriterion("START_TIME <=", value, "startTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andStartTimeIn(List<Date> values) {
        addCriterion("START_TIME in", values, "startTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andStartTimeNotIn(List<Date> values) {
        addCriterion("START_TIME not in", values, "startTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andStartTimeBetween(Date value1, Date value2) {
        addCriterion("START_TIME between", value1, value2, "startTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andStartTimeNotBetween(Date value1, Date value2) {
        addCriterion("START_TIME not between", value1, value2, "startTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andEndTimeIsNull() {
        addCriterion("END_TIME is null");
        return this;
    }

    public WorkSheetGeneratedCriteria andEndTimeIsNotNull() {
        addCriterion("END_TIME is not null");
        return this;
    }

    public WorkSheetGeneratedCriteria andEndTimeEqualTo(Date value) {
        addCriterion("END_TIME =", value, "endTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andEndTimeNotEqualTo(Date value) {
        addCriterion("END_TIME <>", value, "endTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andEndTimeGreaterThan(Date value) {
        addCriterion("END_TIME >", value, "endTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andEndTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("END_TIME >=", value, "endTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andEndTimeLessThan(Date value) {
        addCriterion("END_TIME <", value, "endTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andEndTimeLessThanOrEqualTo(Date value) {
        addCriterion("END_TIME <=", value, "endTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andEndTimeIn(List<Date> values) {
        addCriterion("END_TIME in", values, "endTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andEndTimeNotIn(List<Date> values) {
        addCriterion("END_TIME not in", values, "endTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andEndTimeBetween(Date value1, Date value2) {
        addCriterion("END_TIME between", value1, value2, "endTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andEndTimeNotBetween(Date value1, Date value2) {
        addCriterion("END_TIME not between", value1, value2, "endTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andValidIsNull() {
        addCriterion("VALID is null");
        return this;
    }

    public WorkSheetGeneratedCriteria andValidIsNotNull() {
        addCriterion("VALID is not null");
        return this;
    }

    public WorkSheetGeneratedCriteria andValidEqualTo(Integer value) {
        addCriterion("VALID =", value, "valid");
        return this;
    }

    public WorkSheetGeneratedCriteria andValidNotEqualTo(Integer value) {
        addCriterion("VALID <>", value, "valid");
        return this;
    }

    public WorkSheetGeneratedCriteria andValidGreaterThan(Integer value) {
        addCriterion("VALID >", value, "valid");
        return this;
    }

    public WorkSheetGeneratedCriteria andValidGreaterThanOrEqualTo(Integer value) {
        addCriterion("VALID >=", value, "valid");
        return this;
    }

    public WorkSheetGeneratedCriteria andValidLessThan(Integer value) {
        addCriterion("VALID <", value, "valid");
        return this;
    }

    public WorkSheetGeneratedCriteria andValidLessThanOrEqualTo(Integer value) {
        addCriterion("VALID <=", value, "valid");
        return this;
    }

    public WorkSheetGeneratedCriteria andValidIn(List<Integer> values) {
        addCriterion("VALID in", values, "valid");
        return this;
    }

    public WorkSheetGeneratedCriteria andValidNotIn(List<Integer> values) {
        addCriterion("VALID not in", values, "valid");
        return this;
    }

    public WorkSheetGeneratedCriteria andValidBetween(Integer value1, Integer value2) {
        addCriterion("VALID between", value1, value2, "valid");
        return this;
    }

    public WorkSheetGeneratedCriteria andValidNotBetween(Integer value1, Integer value2) {
        addCriterion("VALID not between", value1, value2, "valid");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateTimeIsNull() {
        addCriterion("CREATE_TIME is null");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateTimeIsNotNull() {
        addCriterion("CREATE_TIME is not null");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateTimeEqualTo(Date value) {
        addCriterion("CREATE_TIME =", value, "createTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateTimeNotEqualTo(Date value) {
        addCriterion("CREATE_TIME <>", value, "createTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateTimeGreaterThan(Date value) {
        addCriterion("CREATE_TIME >", value, "createTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("CREATE_TIME >=", value, "createTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateTimeLessThan(Date value) {
        addCriterion("CREATE_TIME <", value, "createTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateTimeLessThanOrEqualTo(Date value) {
        addCriterion("CREATE_TIME <=", value, "createTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateTimeIn(List<Date> values) {
        addCriterion("CREATE_TIME in", values, "createTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateTimeNotIn(List<Date> values) {
        addCriterion("CREATE_TIME not in", values, "createTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateTimeBetween(Date value1, Date value2) {
        addCriterion("CREATE_TIME between", value1, value2, "createTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateTimeNotBetween(Date value1, Date value2) {
        addCriterion("CREATE_TIME not between", value1, value2, "createTime");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateUserIsNull() {
        addCriterion("CREATE_USER is null");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateUserIsNotNull() {
        addCriterion("CREATE_USER is not null");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateUserEqualTo(String value) {
        addCriterion("CREATE_USER =", value, "createUser");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateUserNotEqualTo(String value) {
        addCriterion("CREATE_USER <>", value, "createUser");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateUserGreaterThan(String value) {
        addCriterion("CREATE_USER >", value, "createUser");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateUserGreaterThanOrEqualTo(String value) {
        addCriterion("CREATE_USER >=", value, "createUser");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateUserLessThan(String value) {
        addCriterion("CREATE_USER <", value, "createUser");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateUserLessThanOrEqualTo(String value) {
        addCriterion("CREATE_USER <=", value, "createUser");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateUserLike(String value) {
        addCriterion("CREATE_USER like", value, "createUser");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateUserNotLike(String value) {
        addCriterion("CREATE_USER not like", value, "createUser");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateUserIn(List<String> values) {
        addCriterion("CREATE_USER in", values, "createUser");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateUserNotIn(List<String> values) {
        addCriterion("CREATE_USER not in", values, "createUser");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateUserBetween(String value1, String value2) {
        addCriterion("CREATE_USER between", value1, value2, "createUser");
        return this;
    }

    public WorkSheetGeneratedCriteria andCreateUserNotBetween(String value1, String value2) {
        addCriterion("CREATE_USER not between", value1, value2, "createUser");
        return this;
    }

    public WorkSheetGeneratedCriteria andSheetPoEqualTo(String value) {
        addCriterion("SHEET_PO =", value, "sheetPo");
        return this;
    }

    public WorkSheetGeneratedCriteria andProductNoEqualTo(String value) {
        addCriterion("product_no =", value, "productNo");
        return this;
    }
}