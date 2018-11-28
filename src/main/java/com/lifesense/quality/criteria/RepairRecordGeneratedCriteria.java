package com.lifesense.quality.criteria;

import com.lifesense.quality.base.GeneratedCriteria;
import com.lifesense.quality.domain.RepairRecord;

import java.util.Date;
import java.util.List;

/**
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */
public class RepairRecordGeneratedCriteria extends GeneratedCriteria<RepairRecord> {


    public RepairRecordGeneratedCriteria andIdIsNull() {
        addCriterion("ID is null");
        return this;
    }

    public RepairRecordGeneratedCriteria andIdIsNotNull() {
        addCriterion("ID is not null");
        return this;
    }

    public RepairRecordGeneratedCriteria andIdEqualTo(Long value) {
        addCriterion("ID =", value, "id");
        return this;
    }

    public RepairRecordGeneratedCriteria andIdNotEqualTo(Long value) {
        addCriterion("ID <>", value, "id");
        return this;
    }

    public RepairRecordGeneratedCriteria andIdGreaterThan(Long value) {
        addCriterion("ID >", value, "id");
        return this;
    }

    public RepairRecordGeneratedCriteria andIdGreaterThanOrEqualTo(Long value) {
        addCriterion("ID >=", value, "id");
        return this;
    }

    public RepairRecordGeneratedCriteria andIdLessThan(Long value) {
        addCriterion("ID <", value, "id");
        return this;
    }

    public RepairRecordGeneratedCriteria andIdLessThanOrEqualTo(Long value) {
        addCriterion("ID <=", value, "id");
        return this;
    }

    public RepairRecordGeneratedCriteria andIdIn(List<Long> values) {
        addCriterion("ID in", values, "id");
        return this;
    }

    public RepairRecordGeneratedCriteria andIdNotIn(List<Long> values) {
        addCriterion("ID not in", values, "id");
        return this;
    }

    public RepairRecordGeneratedCriteria andIdBetween(Long value1, Long value2) {
        addCriterion("ID between", value1, value2, "id");
        return this;
    }

    public RepairRecordGeneratedCriteria andIdNotBetween(Long value1, Long value2) {
        addCriterion("ID not between", value1, value2, "id");
        return this;
    }

    public RepairRecordGeneratedCriteria andProcessRecordIdIsNull() {
        addCriterion("process_record_ID is null");
        return this;
    }

    public RepairRecordGeneratedCriteria andProcessRecordIdIsNotNull() {
        addCriterion("process_record_ID is not null");
        return this;
    }

    public RepairRecordGeneratedCriteria andProcessRecordIdEqualTo(Long value) {
        addCriterion("process_record_ID =", value, "processRecordId");
        return this;
    }

    public RepairRecordGeneratedCriteria andProcessRecordIdNotEqualTo(Long value) {
        addCriterion("process_record_ID <>", value, "processRecordId");
        return this;
    }

    public RepairRecordGeneratedCriteria andProcessRecordIdGreaterThan(Long value) {
        addCriterion("process_record_ID >", value, "processRecordId");
        return this;
    }

    public RepairRecordGeneratedCriteria andProcessRecordIdGreaterThanOrEqualTo(Long value) {
        addCriterion("process_record_ID >=", value, "processRecordId");
        return this;
    }

    public RepairRecordGeneratedCriteria andProcessRecordIdLessThan(Long value) {
        addCriterion("process_record_ID <", value, "processRecordId");
        return this;
    }

    public RepairRecordGeneratedCriteria andProcessRecordIdLessThanOrEqualTo(Long value) {
        addCriterion("process_record_ID <=", value, "processRecordId");
        return this;
    }

    public RepairRecordGeneratedCriteria andProcessRecordIdIn(List<Long> values) {
        addCriterion("process_record_ID in", values, "processRecordId");
        return this;
    }

    public RepairRecordGeneratedCriteria andProcessRecordIdNotIn(List<Long> values) {
        addCriterion("process_record_ID not in", values, "processRecordId");
        return this;
    }

    public RepairRecordGeneratedCriteria andProcessRecordIdBetween(Long value1, Long value2) {
        addCriterion("process_record_ID between", value1, value2, "processRecordId");
        return this;
    }

    public RepairRecordGeneratedCriteria andProcessRecordIdNotBetween(Long value1, Long value2) {
        addCriterion("process_record_ID not between", value1, value2, "processRecordId");
        return this;
    }

    public RepairRecordGeneratedCriteria andProductIdIsNull() {
        addCriterion("product_id is null");
        return this;
    }

    public RepairRecordGeneratedCriteria andProductIdIsNotNull() {
        addCriterion("product_id is not null");
        return this;
    }

    public RepairRecordGeneratedCriteria andProductIdEqualTo(Long value) {
        addCriterion("product_id =", value, "productId");
        return this;
    }

    public RepairRecordGeneratedCriteria andProductIdNotEqualTo(Long value) {
        addCriterion("product_id <>", value, "productId");
        return this;
    }

    public RepairRecordGeneratedCriteria andProductIdGreaterThan(Long value) {
        addCriterion("product_id >", value, "productId");
        return this;
    }

    public RepairRecordGeneratedCriteria andProductIdGreaterThanOrEqualTo(Long value) {
        addCriterion("product_id >=", value, "productId");
        return this;
    }

    public RepairRecordGeneratedCriteria andProductIdLessThan(Long value) {
        addCriterion("product_id <", value, "productId");
        return this;
    }

    public RepairRecordGeneratedCriteria andProductIdLessThanOrEqualTo(Long value) {
        addCriterion("product_id <=", value, "productId");
        return this;
    }

    public RepairRecordGeneratedCriteria andProductIdLike(Long value) {
        addCriterion("product_id like", value, "productId");
        return this;
    }

    public RepairRecordGeneratedCriteria andProductIdNotLike(Long value) {
        addCriterion("product_id not like", value, "productId");
        return this;
    }

    public RepairRecordGeneratedCriteria andProductIdIn(List<Long> values) {
        addCriterion("product_id in", values, "productId");
        return this;
    }

    public RepairRecordGeneratedCriteria andProductIdNotIn(List<Long> values) {
        addCriterion("product_id not in", values, "productId");
        return this;
    }

    public RepairRecordGeneratedCriteria andProductIdBetween(Long value1, Long value2) {
        addCriterion("product_id between", value1, value2, "productId");
        return this;
    }

    public RepairRecordGeneratedCriteria andProductIdNotBetween(Long value1, Long value2) {
        addCriterion("product_id not between", value1, value2, "productId");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadCodeIsNull() {
        addCriterion("BAD_CODE is null");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadCodeIsNotNull() {
        addCriterion("BAD_CODE is not null");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadCodeEqualTo(String value) {
        addCriterion("BAD_CODE =", value, "badCode");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadCodeNotEqualTo(String value) {
        addCriterion("BAD_CODE <>", value, "badCode");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadCodeGreaterThan(String value) {
        addCriterion("BAD_CODE >", value, "badCode");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadCodeGreaterThanOrEqualTo(String value) {
        addCriterion("BAD_CODE >=", value, "badCode");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadCodeLessThan(String value) {
        addCriterion("BAD_CODE <", value, "badCode");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadCodeLessThanOrEqualTo(String value) {
        addCriterion("BAD_CODE <=", value, "badCode");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadCodeLike(String value) {
        addCriterion("BAD_CODE like", value, "badCode");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadCodeNotLike(String value) {
        addCriterion("BAD_CODE not like", value, "badCode");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadCodeIn(List<String> values) {
        addCriterion("BAD_CODE in", values, "badCode");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadCodeNotIn(List<String> values) {
        addCriterion("BAD_CODE not in", values, "badCode");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadCodeBetween(String value1, String value2) {
        addCriterion("BAD_CODE between", value1, value2, "badCode");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadCodeNotBetween(String value1, String value2) {
        addCriterion("BAD_CODE not between", value1, value2, "badCode");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadNameIsNull() {
        addCriterion("BAD_NAME is null");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadNameIsNotNull() {
        addCriterion("BAD_NAME is not null");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadNameEqualTo(String value) {
        addCriterion("BAD_NAME =", value, "badName");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadNameNotEqualTo(String value) {
        addCriterion("BAD_NAME <>", value, "badName");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadNameGreaterThan(String value) {
        addCriterion("BAD_NAME >", value, "badName");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadNameGreaterThanOrEqualTo(String value) {
        addCriterion("BAD_NAME >=", value, "badName");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadNameLessThan(String value) {
        addCriterion("BAD_NAME <", value, "badName");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadNameLessThanOrEqualTo(String value) {
        addCriterion("BAD_NAME <=", value, "badName");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadNameLike(String value) {
        addCriterion("BAD_NAME like", value, "badName");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadNameNotLike(String value) {
        addCriterion("BAD_NAME not like", value, "badName");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadNameIn(List<String> values) {
        addCriterion("BAD_NAME in", values, "badName");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadNameNotIn(List<String> values) {
        addCriterion("BAD_NAME not in", values, "badName");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadNameBetween(String value1, String value2) {
        addCriterion("BAD_NAME between", value1, value2, "badName");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadNameNotBetween(String value1, String value2) {
        addCriterion("BAD_NAME not between", value1, value2, "badName");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadTypeIsNull() {
        addCriterion("BAD_TYPE is null");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadTypeIsNotNull() {
        addCriterion("BAD_TYPE is not null");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadTypeEqualTo(String value) {
        addCriterion("BAD_TYPE =", value, "badType");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadTypeNotEqualTo(String value) {
        addCriterion("BAD_TYPE <>", value, "badType");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadTypeGreaterThan(String value) {
        addCriterion("BAD_TYPE >", value, "badType");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadTypeGreaterThanOrEqualTo(String value) {
        addCriterion("BAD_TYPE >=", value, "badType");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadTypeLessThan(String value) {
        addCriterion("BAD_TYPE <", value, "badType");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadTypeLessThanOrEqualTo(String value) {
        addCriterion("BAD_TYPE <=", value, "badType");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadTypeLike(String value) {
        addCriterion("BAD_TYPE like", value, "badType");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadTypeNotLike(String value) {
        addCriterion("BAD_TYPE not like", value, "badType");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadTypeIn(List<String> values) {
        addCriterion("BAD_TYPE in", values, "badType");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadTypeNotIn(List<String> values) {
        addCriterion("BAD_TYPE not in", values, "badType");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadTypeBetween(String value1, String value2) {
        addCriterion("BAD_TYPE between", value1, value2, "badType");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadTypeNotBetween(String value1, String value2) {
        addCriterion("BAD_TYPE not between", value1, value2, "badType");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadResonIsNull() {
        addCriterion("BAD_RESON is null");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadResonIsNotNull() {
        addCriterion("BAD_RESON is not null");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadResonEqualTo(String value) {
        addCriterion("BAD_RESON =", value, "badReson");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadResonNotEqualTo(String value) {
        addCriterion("BAD_RESON <>", value, "badReson");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadResonGreaterThan(String value) {
        addCriterion("BAD_RESON >", value, "badReson");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadResonGreaterThanOrEqualTo(String value) {
        addCriterion("BAD_RESON >=", value, "badReson");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadResonLessThan(String value) {
        addCriterion("BAD_RESON <", value, "badReson");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadResonLessThanOrEqualTo(String value) {
        addCriterion("BAD_RESON <=", value, "badReson");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadResonLike(String value) {
        addCriterion("BAD_RESON like", value, "badReson");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadResonNotLike(String value) {
        addCriterion("BAD_RESON not like", value, "badReson");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadResonIn(List<String> values) {
        addCriterion("BAD_RESON in", values, "badReson");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadResonNotIn(List<String> values) {
        addCriterion("BAD_RESON not in", values, "badReson");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadResonBetween(String value1, String value2) {
        addCriterion("BAD_RESON between", value1, value2, "badReson");
        return this;
    }

    public RepairRecordGeneratedCriteria andBadResonNotBetween(String value1, String value2) {
        addCriterion("BAD_RESON not between", value1, value2, "badReson");
        return this;
    }

    public RepairRecordGeneratedCriteria andRepairIsNull() {
        addCriterion("REPAIR is null");
        return this;
    }

    public RepairRecordGeneratedCriteria andRepairIsNotNull() {
        addCriterion("REPAIR is not null");
        return this;
    }

    public RepairRecordGeneratedCriteria andRepairEqualTo(int value) {
        addCriterion("REPAIR =", value, "repair");
        return this;
    }

    public RepairRecordGeneratedCriteria andRepairNotEqualTo(int value) {
        addCriterion("REPAIR <>", value, "repair");
        return this;
    }

    public RepairRecordGeneratedCriteria andRepairGreaterThan(int value) {
        addCriterion("REPAIR >", value, "repair");
        return this;
    }

    public RepairRecordGeneratedCriteria andRepairGreaterThanOrEqualTo(int value) {
        addCriterion("REPAIR >=", value, "repair");
        return this;
    }

    public RepairRecordGeneratedCriteria andRepairLessThan(int value) {
        addCriterion("REPAIR <", value, "repair");
        return this;
    }

    public RepairRecordGeneratedCriteria andRepairLessThanOrEqualTo(int value) {
        addCriterion("REPAIR <=", value, "repair");
        return this;
    }

    public RepairRecordGeneratedCriteria andRepairIn(List<Integer> values) {
        addCriterion("REPAIR in", values, "repair");
        return this;
    }

    public RepairRecordGeneratedCriteria andRepairNotIn(List<Integer> values) {
        addCriterion("REPAIR not in", values, "repair");
        return this;
    }

    public RepairRecordGeneratedCriteria andRepairBetween(int value1, int value2) {
        addCriterion("REPAIR between", value1, value2, "repair");
        return this;
    }

    public RepairRecordGeneratedCriteria andRepairNotBetween(int value1, int value2) {
        addCriterion("REPAIR not between", value1, value2, "repair");
        return this;
    }

    public RepairRecordGeneratedCriteria andUserIdIsNull() {
        addCriterion("user_id is null");
        return this;
    }

    public RepairRecordGeneratedCriteria andUserIdIsNotNull() {
        addCriterion("user_id is not null");
        return this;
    }

    public RepairRecordGeneratedCriteria andUserIdEqualTo(Long value) {
        addCriterion("user_id =", value, "userId");
        return this;
    }

    public RepairRecordGeneratedCriteria andUserIdNotEqualTo(Long value) {
        addCriterion("user_id <>", value, "userId");
        return this;
    }

    public RepairRecordGeneratedCriteria andUserIdGreaterThan(Long value) {
        addCriterion("user_id >", value, "userId");
        return this;
    }

    public RepairRecordGeneratedCriteria andUserIdGreaterThanOrEqualTo(Long value) {
        addCriterion("user_id >=", value, "userId");
        return this;
    }

    public RepairRecordGeneratedCriteria andUserIdLessThan(Long value) {
        addCriterion("user_id <", value, "userId");
        return this;
    }

    public RepairRecordGeneratedCriteria andUserIdLessThanOrEqualTo(Long value) {
        addCriterion("user_id <=", value, "userId");
        return this;
    }

    public RepairRecordGeneratedCriteria andUserIdLike(Long value) {
        addCriterion("user_id like", value, "userId");
        return this;
    }

    public RepairRecordGeneratedCriteria andUserIdNotLike(Long value) {
        addCriterion("user_id not like", value, "userId");
        return this;
    }

    public RepairRecordGeneratedCriteria andUserIdIn(List<Long> values) {
        addCriterion("user_id in", values, "userId");
        return this;
    }

    public RepairRecordGeneratedCriteria andUserIdNotIn(List<Long> values) {
        addCriterion("user_id not in", values, "userId");
        return this;
    }

    public RepairRecordGeneratedCriteria andUserIdBetween(Long value1, Long value2) {
        addCriterion("user_id between", value1, value2, "userId");
        return this;
    }

    public RepairRecordGeneratedCriteria andUserIdNotBetween(Long value1, Long value2) {
        addCriterion("user_id not between", value1, value2, "userId");
        return this;
    }

    public RepairRecordGeneratedCriteria andCreateTimeIsNull() {
        addCriterion("CREATE_TIME is null");
        return this;
    }

    public RepairRecordGeneratedCriteria andCreateTimeIsNotNull() {
        addCriterion("CREATE_TIME is not null");
        return this;
    }

    public RepairRecordGeneratedCriteria andCreateTimeEqualTo(Date value) {
        addCriterion("CREATE_TIME =", value, "createTime");
        return this;
    }

    public RepairRecordGeneratedCriteria andCreateTimeNotEqualTo(Date value) {
        addCriterion("CREATE_TIME <>", value, "createTime");
        return this;
    }

    public RepairRecordGeneratedCriteria andCreateTimeGreaterThan(Date value) {
        addCriterion("CREATE_TIME >", value, "createTime");
        return this;
    }

    public RepairRecordGeneratedCriteria andCreateTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("CREATE_TIME >=", value, "createTime");
        return this;
    }

    public RepairRecordGeneratedCriteria andCreateTimeLessThan(Date value) {
        addCriterion("CREATE_TIME <", value, "createTime");
        return this;
    }

    public RepairRecordGeneratedCriteria andCreateTimeLessThanOrEqualTo(Date value) {
        addCriterion("CREATE_TIME <=", value, "createTime");
        return this;
    }

    public RepairRecordGeneratedCriteria andCreateTimeIn(List<Date> values) {
        addCriterion("CREATE_TIME in", values, "createTime");
        return this;
    }

    public RepairRecordGeneratedCriteria andCreateTimeNotIn(List<Date> values) {
        addCriterion("CREATE_TIME not in", values, "createTime");
        return this;
    }

    public RepairRecordGeneratedCriteria andCreateTimeBetween(Date value1, Date value2) {
        addCriterion("CREATE_TIME between", value1, value2, "createTime");
        return this;
    }

    public RepairRecordGeneratedCriteria andCreateTimeNotBetween(Date value1, Date value2) {
        addCriterion("CREATE_TIME not between", value1, value2, "createTime");
        return this;
    }

    public RepairRecordGeneratedCriteria andModifyTimeIsNull() {
        addCriterion("MODIFY_TIME is null");
        return this;
    }

    public RepairRecordGeneratedCriteria andModifyTimeIsNotNull() {
        addCriterion("MODIFY_TIME is not null");
        return this;
    }

    public RepairRecordGeneratedCriteria andModifyTimeEqualTo(Date value) {
        addCriterion("MODIFY_TIME =", value, "modifyTime");
        return this;
    }

    public RepairRecordGeneratedCriteria andModifyTimeNotEqualTo(Date value) {
        addCriterion("MODIFY_TIME <>", value, "modifyTime");
        return this;
    }

    public RepairRecordGeneratedCriteria andModifyTimeGreaterThan(Date value) {
        addCriterion("MODIFY_TIME >", value, "modifyTime");
        return this;
    }

    public RepairRecordGeneratedCriteria andModifyTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("MODIFY_TIME >=", value, "modifyTime");
        return this;
    }

    public RepairRecordGeneratedCriteria andModifyTimeLessThan(Date value) {
        addCriterion("MODIFY_TIME <", value, "modifyTime");
        return this;
    }

    public RepairRecordGeneratedCriteria andModifyTimeLessThanOrEqualTo(Date value) {
        addCriterion("MODIFY_TIME <=", value, "modifyTime");
        return this;
    }

    public RepairRecordGeneratedCriteria andModifyTimeIn(List<Date> values) {
        addCriterion("MODIFY_TIME in", values, "modifyTime");
        return this;
    }

    public RepairRecordGeneratedCriteria andModifyTimeNotIn(List<Date> values) {
        addCriterion("MODIFY_TIME not in", values, "modifyTime");
        return this;
    }

    public RepairRecordGeneratedCriteria andModifyTimeBetween(Date value1, Date value2) {
        addCriterion("MODIFY_TIME between", value1, value2, "modifyTime");
        return this;
    }

    public RepairRecordGeneratedCriteria andModifyTimeNotBetween(Date value1, Date value2) {
        addCriterion("MODIFY_TIME not between", value1, value2, "modifyTime");
        return this;
    }

    public RepairRecordGeneratedCriteria andRemarkIsNull() {
        addCriterion("remark is null");
        return this;
    }

    public RepairRecordGeneratedCriteria andRemarkIsNotNull() {
        addCriterion("remark is not null");
        return this;
    }

    public RepairRecordGeneratedCriteria andRemarkEqualTo(String value) {
        addCriterion("remark =", value, "remark");
        return this;
    }

    public RepairRecordGeneratedCriteria andRemarkNotEqualTo(String value) {
        addCriterion("remark <>", value, "remark");
        return this;
    }

    public RepairRecordGeneratedCriteria andRemarkGreaterThan(String value) {
        addCriterion("remark >", value, "remark");
        return this;
    }

    public RepairRecordGeneratedCriteria andRemarkGreaterThanOrEqualTo(String value) {
        addCriterion("remark >=", value, "remark");
        return this;
    }

    public RepairRecordGeneratedCriteria andRemarkLessThan(String value) {
        addCriterion("remark <", value, "remark");
        return this;
    }

    public RepairRecordGeneratedCriteria andRemarkLessThanOrEqualTo(String value) {
        addCriterion("remark <=", value, "remark");
        return this;
    }

    public RepairRecordGeneratedCriteria andRemarkLike(String value) {
        addCriterion("remark like", value, "remark");
        return this;
    }

    public RepairRecordGeneratedCriteria andRemarkNotLike(String value) {
        addCriterion("remark not like", value, "remark");
        return this;
    }

    public RepairRecordGeneratedCriteria andRemarkIn(List<String> values) {
        addCriterion("remark in", values, "remark");
        return this;
    }

    public RepairRecordGeneratedCriteria andRemarkNotIn(List<String> values) {
        addCriterion("remark not in", values, "remark");
        return this;
    }

    public RepairRecordGeneratedCriteria andRemarkBetween(String value1, String value2) {
        addCriterion("remark between", value1, value2, "remark");
        return this;
    }

    public RepairRecordGeneratedCriteria andRemarkNotBetween(String value1, String value2) {
        addCriterion("remark not between", value1, value2, "remark");
        return this;
    }
}