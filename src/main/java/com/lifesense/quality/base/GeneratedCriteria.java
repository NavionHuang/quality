package com.lifesense.quality.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spring on 2018/5/1.
 */
public class GeneratedCriteria<T extends BaseDomain> {

    protected List<Criterion> criteria;

    public boolean isValid() {
        return criteria != null && criteria.size() > 0;
    }

    public List<Criterion> getCriteria() {
        return criteria;
    }

    protected void addCriterion(String condition) {
        if (condition == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        add(new Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
        if (value == null) {
            throw new RuntimeException("Value for " + property + " cannot be null");
        }
        add(new Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
        if (value1 == null || value2 == null) {
            throw new RuntimeException("Between values for " + property + " cannot be null");
        }
        add(new Criterion(condition, value1, value2));
    }

    private void add(Criterion criterion) {
        if (criteria == null) {
            criteria = new ArrayList<Criterion>();
        }
        criteria.add(criterion);
    }


}
