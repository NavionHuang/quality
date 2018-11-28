package com.lifesense.quality.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spring on 2018/5/1.
 */
public final class BaseExample<T extends BaseDomain> {

    protected String orderByClause;

    protected boolean distinct;

    protected List<GeneratedCriteria<T>> oredCriteria;

    public BaseExample() {
        oredCriteria = new ArrayList<GeneratedCriteria<T>>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<GeneratedCriteria<T>> getOredCriteria() {
        return oredCriteria;
    }

    public <G extends GeneratedCriteria<T>> void or(G criteria) {
        oredCriteria.add(criteria);
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }
}
