package com.lifesense.quality.criteria;

import com.lifesense.quality.base.GeneratedCriteria;
import com.lifesense.quality.domain.Product;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ProductGeneratedCriteria extends GeneratedCriteria<Product> {

        public ProductGeneratedCriteria andIdIsNull() {
            addCriterion("ID is null");
            return  this;
        }

        public ProductGeneratedCriteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return  this;
        }

        public ProductGeneratedCriteria andIdEqualTo(BigDecimal value) {
            addCriterion("ID =", value, "id");
            return  this;
        }

        public ProductGeneratedCriteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("ID <>", value, "id");
            return  this;
        }

        public ProductGeneratedCriteria andIdGreaterThan(BigDecimal value) {
            addCriterion("ID >", value, "id");
            return  this;
        }

        public ProductGeneratedCriteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID >=", value, "id");
            return  this;
        }

        public ProductGeneratedCriteria andIdLessThan(BigDecimal value) {
            addCriterion("ID <", value, "id");
            return  this;
        }

        public ProductGeneratedCriteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID <=", value, "id");
            return  this;
        }

        public ProductGeneratedCriteria andIdIn(List<BigDecimal> values) {
            addCriterion("ID in", values, "id");
            return  this;
        }

        public ProductGeneratedCriteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("ID not in", values, "id");
            return  this;
        }

        public ProductGeneratedCriteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID between", value1, value2, "id");
            return  this;
        }

        public ProductGeneratedCriteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID not between", value1, value2, "id");
            return  this;
        }

        public ProductGeneratedCriteria andSheetPoIsNull() {
            addCriterion("SHEET_PO is null");
            return  this;
        }

        public ProductGeneratedCriteria andSheetPoIsNotNull() {
            addCriterion("SHEET_PO is not null");
            return  this;
        }

        public ProductGeneratedCriteria andSheetPoEqualTo(String value) {
            addCriterion("SHEET_PO =", value, "SheetPo");
            return  this;
        }

        public ProductGeneratedCriteria andSheetPoNotEqualTo(String value) {
            addCriterion("SHEET_PO <>", value, "SheetPo");
            return  this;
        }

        public ProductGeneratedCriteria andSheetPoGreaterThan(String value) {
            addCriterion("SHEET_PO >", value, "SheetPo");
            return  this;
        }

        public ProductGeneratedCriteria andSheetPoGreaterThanOrEqualTo(String value) {
            addCriterion("SHEET_PO >=", value, "SheetPo");
            return  this;
        }

        public ProductGeneratedCriteria andSheetPoLessThan(String value) {
            addCriterion("SHEET_PO <", value, "SheetPo");
            return  this;
        }

        public ProductGeneratedCriteria andSheetPoLessThanOrEqualTo(String value) {
            addCriterion("SHEET_PO <=", value, "SheetPo");
            return  this;
        }

        public ProductGeneratedCriteria andSheetPoLike(String value) {
            addCriterion("SHEET_PO like", value, "SheetPo");
            return  this;
        }

        public ProductGeneratedCriteria andSheetPoNotLike(String value) {
            addCriterion("SHEET_PO not like", value, "SheetPo");
            return  this;
        }

        public ProductGeneratedCriteria andSheetPoIn(List<String> values) {
            addCriterion("SHEET_PO in", values, "SheetPo");
            return  this;
        }

        public ProductGeneratedCriteria andSheetPoNotIn(List<String> values) {
            addCriterion("SHEET_PO not in", values, "SheetPo");
            return  this;
        }

        public ProductGeneratedCriteria andSheetPoBetween(String value1, String value2) {
            addCriterion("SHEET_PO between", value1, value2, "SheetPo");
            return  this;
        }

        public ProductGeneratedCriteria andSheetPoNotBetween(String value1, String value2) {
            addCriterion("SHEET_PO not between", value1, value2, "SheetPo");
            return  this;
        }

        public ProductGeneratedCriteria andProductTypeCodeIsNull() {
            addCriterion("PRODUCT_TYPE_CODE is null");
            return  this;
        }

        public ProductGeneratedCriteria andProductTypeCodeIsNotNull() {
            addCriterion("PRODUCT_TYPE_CODE is not null");
            return  this;
        }

        public ProductGeneratedCriteria andProductTypeCodeEqualTo(String value) {
            addCriterion("PRODUCT_TYPE_CODE =", value, "productTypeCode");
            return  this;
        }

        public ProductGeneratedCriteria andProductTypeCodeNotEqualTo(String value) {
            addCriterion("PRODUCT_TYPE_CODE <>", value, "productTypeCode");
            return  this;
        }

        public ProductGeneratedCriteria andProductTypeCodeGreaterThan(String value) {
            addCriterion("PRODUCT_TYPE_CODE >", value, "productTypeCode");
            return  this;
        }

        public ProductGeneratedCriteria andProductTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_TYPE_CODE >=", value, "productTypeCode");
            return  this;
        }

        public ProductGeneratedCriteria andProductTypeCodeLessThan(String value) {
            addCriterion("PRODUCT_TYPE_CODE <", value, "productTypeCode");
            return  this;
        }

        public ProductGeneratedCriteria andProductTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_TYPE_CODE <=", value, "productTypeCode");
            return  this;
        }

        public ProductGeneratedCriteria andProductTypeCodeLike(String value) {
            addCriterion("PRODUCT_TYPE_CODE like", value, "productTypeCode");
            return  this;
        }

        public ProductGeneratedCriteria andProductTypeCodeNotLike(String value) {
            addCriterion("PRODUCT_TYPE_CODE not like", value, "productTypeCode");
            return  this;
        }

        public ProductGeneratedCriteria andProductTypeCodeIn(List<String> values) {
            addCriterion("PRODUCT_TYPE_CODE in", values, "productTypeCode");
            return  this;
        }

        public ProductGeneratedCriteria andProductTypeCodeNotIn(List<String> values) {
            addCriterion("PRODUCT_TYPE_CODE not in", values, "productTypeCode");
            return  this;
        }

        public ProductGeneratedCriteria andProductTypeCodeBetween(String value1, String value2) {
            addCriterion("PRODUCT_TYPE_CODE between", value1, value2, "productTypeCode");
            return  this;
        }

        public ProductGeneratedCriteria andProductTypeCodeNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_TYPE_CODE not between", value1, value2, "productTypeCode");
            return  this;
        }

        public ProductGeneratedCriteria andCpsnIsNull() {
            addCriterion("CPSN is null");
            return  this;
        }

        public ProductGeneratedCriteria andCpsnIsNotNull() {
            addCriterion("CPSN is not null");
            return  this;
        }

        public ProductGeneratedCriteria andCpsnEqualTo(String value) {
            addCriterion("CPSN =", value, "cpsn");
            return  this;
        }

        public ProductGeneratedCriteria andCpsnNotEqualTo(String value) {
            addCriterion("CPSN <>", value, "cpsn");
            return  this;
        }

        public ProductGeneratedCriteria andCpsnGreaterThan(String value) {
            addCriterion("CPSN >", value, "cpsn");
            return  this;
        }

        public ProductGeneratedCriteria andCpsnGreaterThanOrEqualTo(String value) {
            addCriterion("CPSN >=", value, "cpsn");
            return  this;
        }

        public ProductGeneratedCriteria andCpsnLessThan(String value) {
            addCriterion("CPSN <", value, "cpsn");
            return  this;
        }

        public ProductGeneratedCriteria andCpsnLessThanOrEqualTo(String value) {
            addCriterion("CPSN <=", value, "cpsn");
            return  this;
        }

        public ProductGeneratedCriteria andCpsnLike(String value) {
            addCriterion("CPSN like", value, "cpsn");
            return  this;
        }

        public ProductGeneratedCriteria andCpsnNotLike(String value) {
            addCriterion("CPSN not like", value, "cpsn");
            return  this;
        }

        public ProductGeneratedCriteria andCpsnIn(List<String> values) {
            addCriterion("CPSN in", values, "cpsn");
            return  this;
        }

        public ProductGeneratedCriteria andCpsnNotIn(List<String> values) {
            addCriterion("CPSN not in", values, "cpsn");
            return  this;
        }

        public ProductGeneratedCriteria andCpsnBetween(String value1, String value2) {
            addCriterion("CPSN between", value1, value2, "cpsn");
            return  this;
        }

        public ProductGeneratedCriteria andCpsnNotBetween(String value1, String value2) {
            addCriterion("CPSN not between", value1, value2, "cpsn");
            return  this;
        }

        public ProductGeneratedCriteria andBlsnIsNull() {
            addCriterion("BLSN is null");
            return  this;
        }

        public ProductGeneratedCriteria andBlsnIsNotNull() {
            addCriterion("BLSN is not null");
            return  this;
        }

        public ProductGeneratedCriteria andBlsnEqualTo(String value) {
            addCriterion("BLSN =", value, "blsn");
            return  this;
        }

        public ProductGeneratedCriteria andBlsnNotEqualTo(String value) {
            addCriterion("BLSN <>", value, "blsn");
            return  this;
        }

        public ProductGeneratedCriteria andBlsnGreaterThan(String value) {
            addCriterion("BLSN >", value, "blsn");
            return  this;
        }

        public ProductGeneratedCriteria andBlsnGreaterThanOrEqualTo(String value) {
            addCriterion("BLSN >=", value, "blsn");
            return  this;
        }

        public ProductGeneratedCriteria andBlsnLessThan(String value) {
            addCriterion("BLSN <", value, "blsn");
            return  this;
        }

        public ProductGeneratedCriteria andBlsnLessThanOrEqualTo(String value) {
            addCriterion("BLSN <=", value, "blsn");
            return  this;
        }

        public ProductGeneratedCriteria andBlsnLike(String value) {
            addCriterion("BLSN like", value, "blsn");
            return  this;
        }

        public ProductGeneratedCriteria andBlsnNotLike(String value) {
            addCriterion("BLSN not like", value, "blsn");
            return  this;
        }

        public ProductGeneratedCriteria andBlsnIn(List<String> values) {
            addCriterion("BLSN in", values, "blsn");
            return  this;
        }

        public ProductGeneratedCriteria andBlsnNotIn(List<String> values) {
            addCriterion("BLSN not in", values, "blsn");
            return  this;
        }

        public ProductGeneratedCriteria andBlsnBetween(String value1, String value2) {
            addCriterion("BLSN between", value1, value2, "blsn");
            return  this;
        }

        public ProductGeneratedCriteria andBlsnNotBetween(String value1, String value2) {
            addCriterion("BLSN not between", value1, value2, "blsn");
            return  this;
        }

        public ProductGeneratedCriteria andBbsnIsNull() {
            addCriterion("BBSN is null");
            return  this;
        }

        public ProductGeneratedCriteria andBbsnIsNotNull() {
            addCriterion("BBSN is not null");
            return  this;
        }

        public ProductGeneratedCriteria andBbsnEqualTo(String value) {
            addCriterion("BBSN =", value, "bbsn");
            return  this;
        }

        public ProductGeneratedCriteria andBbsnNotEqualTo(String value) {
            addCriterion("BBSN <>", value, "bbsn");
            return  this;
        }

        public ProductGeneratedCriteria andBbsnGreaterThan(String value) {
            addCriterion("BBSN >", value, "bbsn");
            return  this;
        }

        public ProductGeneratedCriteria andBbsnGreaterThanOrEqualTo(String value) {
            addCriterion("BBSN >=", value, "bbsn");
            return  this;
        }

        public ProductGeneratedCriteria andBbsnLessThan(String value) {
            addCriterion("BBSN <", value, "bbsn");
            return  this;
        }

        public ProductGeneratedCriteria andBbsnLessThanOrEqualTo(String value) {
            addCriterion("BBSN <=", value, "bbsn");
            return  this;
        }

        public ProductGeneratedCriteria andBbsnLike(String value) {
            addCriterion("BBSN like", value, "bbsn");
            return  this;
        }

        public ProductGeneratedCriteria andBbsnNotLike(String value) {
            addCriterion("BBSN not like", value, "bbsn");
            return  this;
        }

        public ProductGeneratedCriteria andBbsnIn(List<String> values) {
            addCriterion("BBSN in", values, "bbsn");
            return  this;
        }

        public ProductGeneratedCriteria andBbsnNotIn(List<String> values) {
            addCriterion("BBSN not in", values, "bbsn");
            return  this;
        }

        public ProductGeneratedCriteria andBbsnBetween(String value1, String value2) {
            addCriterion("BBSN between", value1, value2, "bbsn");
            return  this;
        }

        public ProductGeneratedCriteria andBbsnNotBetween(String value1, String value2) {
            addCriterion("BBSN not between", value1, value2, "bbsn");
            return  this;
        }

        public ProductGeneratedCriteria andCgqsnIsNull() {
            addCriterion("CGQSN is null");
            return  this;
        }

        public ProductGeneratedCriteria andCgqsnIsNotNull() {
            addCriterion("CGQSN is not null");
            return  this;
        }

        public ProductGeneratedCriteria andCgqsnEqualTo(String value) {
            addCriterion("CGQSN =", value, "cgqsn");
            return  this;
        }

        public ProductGeneratedCriteria andCgqsnNotEqualTo(String value) {
            addCriterion("CGQSN <>", value, "cgqsn");
            return  this;
        }

        public ProductGeneratedCriteria andCgqsnGreaterThan(String value) {
            addCriterion("CGQSN >", value, "cgqsn");
            return  this;
        }

        public ProductGeneratedCriteria andCgqsnGreaterThanOrEqualTo(String value) {
            addCriterion("CGQSN >=", value, "cgqsn");
            return  this;
        }

        public ProductGeneratedCriteria andCgqsnLessThan(String value) {
            addCriterion("CGQSN <", value, "cgqsn");
            return  this;
        }

        public ProductGeneratedCriteria andCgqsnLessThanOrEqualTo(String value) {
            addCriterion("CGQSN <=", value, "cgqsn");
            return  this;
        }

        public ProductGeneratedCriteria andCgqsnLike(String value) {
            addCriterion("CGQSN like", value, "cgqsn");
            return  this;
        }

        public ProductGeneratedCriteria andCgqsnNotLike(String value) {
            addCriterion("CGQSN not like", value, "cgqsn");
            return  this;
        }

        public ProductGeneratedCriteria andCgqsnIn(List<String> values) {
            addCriterion("CGQSN in", values, "cgqsn");
            return  this;
        }

        public ProductGeneratedCriteria andCgqsnNotIn(List<String> values) {
            addCriterion("CGQSN not in", values, "cgqsn");
            return  this;
        }

        public ProductGeneratedCriteria andCgqsnBetween(String value1, String value2) {
            addCriterion("CGQSN between", value1, value2, "cgqsn");
            return  this;
        }

        public ProductGeneratedCriteria andCgqsnNotBetween(String value1, String value2) {
            addCriterion("CGQSN not between", value1, value2, "cgqsn");
            return  this;
        }

        public ProductGeneratedCriteria andSmssnIsNull() {
            addCriterion("SMSSN is null");
            return  this;
        }

        public ProductGeneratedCriteria andSmssnIsNotNull() {
            addCriterion("SMSSN is not null");
            return  this;
        }

        public ProductGeneratedCriteria andSmssnEqualTo(String value) {
            addCriterion("SMSSN =", value, "smssn");
            return  this;
        }

        public ProductGeneratedCriteria andSmssnNotEqualTo(String value) {
            addCriterion("SMSSN <>", value, "smssn");
            return  this;
        }

        public ProductGeneratedCriteria andSmssnGreaterThan(String value) {
            addCriterion("SMSSN >", value, "smssn");
            return  this;
        }

        public ProductGeneratedCriteria andSmssnGreaterThanOrEqualTo(String value) {
            addCriterion("SMSSN >=", value, "smssn");
            return  this;
        }

        public ProductGeneratedCriteria andSmssnLessThan(String value) {
            addCriterion("SMSSN <", value, "smssn");
            return  this;
        }

        public ProductGeneratedCriteria andSmssnLessThanOrEqualTo(String value) {
            addCriterion("SMSSN <=", value, "smssn");
            return  this;
        }

        public ProductGeneratedCriteria andSmssnLike(String value) {
            addCriterion("SMSSN like", value, "smssn");
            return  this;
        }

        public ProductGeneratedCriteria andSmssnNotLike(String value) {
            addCriterion("SMSSN not like", value, "smssn");
            return  this;
        }

        public ProductGeneratedCriteria andSmssnIn(List<String> values) {
            addCriterion("SMSSN in", values, "smssn");
            return  this;
        }

        public ProductGeneratedCriteria andSmssnNotIn(List<String> values) {
            addCriterion("SMSSN not in", values, "smssn");
            return  this;
        }

        public ProductGeneratedCriteria andSmssnBetween(String value1, String value2) {
            addCriterion("SMSSN between", value1, value2, "smssn");
            return  this;
        }

        public ProductGeneratedCriteria andSmssnNotBetween(String value1, String value2) {
            addCriterion("SMSSN not between", value1, value2, "smssn");
            return  this;
        }

        public ProductGeneratedCriteria andBxksnIsNull() {
            addCriterion("BXKSN is null");
            return  this;
        }

        public ProductGeneratedCriteria andBxksnIsNotNull() {
            addCriterion("BXKSN is not null");
            return  this;
        }

        public ProductGeneratedCriteria andBxksnEqualTo(String value) {
            addCriterion("BXKSN =", value, "bxksn");
            return  this;
        }

        public ProductGeneratedCriteria andBxksnNotEqualTo(String value) {
            addCriterion("BXKSN <>", value, "bxksn");
            return  this;
        }

        public ProductGeneratedCriteria andBxksnGreaterThan(String value) {
            addCriterion("BXKSN >", value, "bxksn");
            return  this;
        }

        public ProductGeneratedCriteria andBxksnGreaterThanOrEqualTo(String value) {
            addCriterion("BXKSN >=", value, "bxksn");
            return  this;
        }

        public ProductGeneratedCriteria andBxksnLessThan(String value) {
            addCriterion("BXKSN <", value, "bxksn");
            return  this;
        }

        public ProductGeneratedCriteria andBxksnLessThanOrEqualTo(String value) {
            addCriterion("BXKSN <=", value, "bxksn");
            return  this;
        }

        public ProductGeneratedCriteria andBxksnLike(String value) {
            addCriterion("BXKSN like", value, "bxksn");
            return  this;
        }

        public ProductGeneratedCriteria andBxksnNotLike(String value) {
            addCriterion("BXKSN not like", value, "bxksn");
            return  this;
        }

        public ProductGeneratedCriteria andBxksnIn(List<String> values) {
            addCriterion("BXKSN in", values, "bxksn");
            return  this;
        }

        public ProductGeneratedCriteria andBxksnNotIn(List<String> values) {
            addCriterion("BXKSN not in", values, "bxksn");
            return  this;
        }

        public ProductGeneratedCriteria andBxksnBetween(String value1, String value2) {
            addCriterion("BXKSN between", value1, value2, "bxksn");
            return  this;
        }

        public ProductGeneratedCriteria andBxksnNotBetween(String value1, String value2) {
            addCriterion("BXKSN not between", value1, value2, "bxksn");
            return  this;
        }

        public ProductGeneratedCriteria andChsnIsNull() {
            addCriterion("CHSN is null");
            return  this;
        }

        public ProductGeneratedCriteria andChsnIsNotNull() {
            addCriterion("CHSN is not null");
            return  this;
        }

        public ProductGeneratedCriteria andChsnEqualTo(String value) {
            addCriterion("CHSN =", value, "chsn");
            return  this;
        }

        public ProductGeneratedCriteria andChsnNotEqualTo(String value) {
            addCriterion("CHSN <>", value, "chsn");
            return  this;
        }

        public ProductGeneratedCriteria andChsnGreaterThan(String value) {
            addCriterion("CHSN >", value, "chsn");
            return  this;
        }

        public ProductGeneratedCriteria andChsnGreaterThanOrEqualTo(String value) {
            addCriterion("CHSN >=", value, "chsn");
            return  this;
        }

        public ProductGeneratedCriteria andChsnLessThan(String value) {
            addCriterion("CHSN <", value, "chsn");
            return  this;
        }

        public ProductGeneratedCriteria andChsnLessThanOrEqualTo(String value) {
            addCriterion("CHSN <=", value, "chsn");
            return  this;
        }

        public ProductGeneratedCriteria andChsnLike(String value) {
            addCriterion("CHSN like", value, "chsn");
            return  this;
        }

        public ProductGeneratedCriteria andChsnNotLike(String value) {
            addCriterion("CHSN not like", value, "chsn");
            return  this;
        }

        public ProductGeneratedCriteria andChsnIn(List<String> values) {
            addCriterion("CHSN in", values, "chsn");
            return  this;
        }

        public ProductGeneratedCriteria andChsnNotIn(List<String> values) {
            addCriterion("CHSN not in", values, "chsn");
            return  this;
        }

        public ProductGeneratedCriteria andChsnBetween(String value1, String value2) {
            addCriterion("CHSN between", value1, value2, "chsn");
            return  this;
        }

        public ProductGeneratedCriteria andChsnNotBetween(String value1, String value2) {
            addCriterion("CHSN not between", value1, value2, "chsn");
            return  this;
        }

        public ProductGeneratedCriteria andValidIsNull() {
            addCriterion("VALID is null");
            return  this;
        }

        public ProductGeneratedCriteria andValidIsNotNull() {
            addCriterion("VALID is not null");
            return  this;
        }

        public ProductGeneratedCriteria andValidEqualTo(Short value) {
            addCriterion("VALID =", value, "valid");
            return  this;
        }

        public ProductGeneratedCriteria andValidNotEqualTo(Short value) {
            addCriterion("VALID <>", value, "valid");
            return  this;
        }

        public ProductGeneratedCriteria andValidGreaterThan(Short value) {
            addCriterion("VALID >", value, "valid");
            return  this;
        }

        public ProductGeneratedCriteria andValidGreaterThanOrEqualTo(Short value) {
            addCriterion("VALID >=", value, "valid");
            return  this;
        }

        public ProductGeneratedCriteria andValidLessThan(Short value) {
            addCriterion("VALID <", value, "valid");
            return  this;
        }

        public ProductGeneratedCriteria andValidLessThanOrEqualTo(Short value) {
            addCriterion("VALID <=", value, "valid");
            return  this;
        }

        public ProductGeneratedCriteria andValidIn(List<Short> values) {
            addCriterion("VALID in", values, "valid");
            return  this;
        }

        public ProductGeneratedCriteria andValidNotIn(List<Short> values) {
            addCriterion("VALID not in", values, "valid");
            return  this;
        }

        public ProductGeneratedCriteria andValidBetween(Short value1, Short value2) {
            addCriterion("VALID between", value1, value2, "valid");
            return  this;
        }

        public ProductGeneratedCriteria andValidNotBetween(Short value1, Short value2) {
            addCriterion("VALID not between", value1, value2, "valid");
            return  this;
        }

        public ProductGeneratedCriteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return  this;
        }

        public ProductGeneratedCriteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return  this;
        }

        public ProductGeneratedCriteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return  this;
        }

        public ProductGeneratedCriteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return  this;
        }

        public ProductGeneratedCriteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return  this;
        }

        public ProductGeneratedCriteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return  this;
        }

        public ProductGeneratedCriteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return  this;
        }

        public ProductGeneratedCriteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return  this;
        }

        public ProductGeneratedCriteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return  this;
        }

        public ProductGeneratedCriteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return  this;
        }

        public ProductGeneratedCriteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return  this;
        }

        public ProductGeneratedCriteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return  this;
        }

        public ProductGeneratedCriteria andModifyTimeIsNull() {
            addCriterion("MODIFY_TIME is null");
            return  this;
        }

        public ProductGeneratedCriteria andModifyTimeIsNotNull() {
            addCriterion("MODIFY_TIME is not null");
            return  this;
        }

        public ProductGeneratedCriteria andModifyTimeEqualTo(Date value) {
            addCriterion("MODIFY_TIME =", value, "modifyTime");
            return  this;
        }

        public ProductGeneratedCriteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("MODIFY_TIME <>", value, "modifyTime");
            return  this;
        }

        public ProductGeneratedCriteria andModifyTimeGreaterThan(Date value) {
            addCriterion("MODIFY_TIME >", value, "modifyTime");
            return  this;
        }

        public ProductGeneratedCriteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME >=", value, "modifyTime");
            return  this;
        }

        public ProductGeneratedCriteria andModifyTimeLessThan(Date value) {
            addCriterion("MODIFY_TIME <", value, "modifyTime");
            return  this;
        }

        public ProductGeneratedCriteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME <=", value, "modifyTime");
            return  this;
        }

        public ProductGeneratedCriteria andModifyTimeIn(List<Date> values) {
            addCriterion("MODIFY_TIME in", values, "modifyTime");
            return  this;
        }

        public ProductGeneratedCriteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("MODIFY_TIME not in", values, "modifyTime");
            return  this;
        }

        public ProductGeneratedCriteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME between", value1, value2, "modifyTime");
            return  this;
        }

        public ProductGeneratedCriteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME not between", value1, value2, "modifyTime");
            return  this;
        }
   
}