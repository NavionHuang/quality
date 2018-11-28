package com.lifesense.quality.base;

import java.io.Serializable;

/**
 * Created by 赵春定 on 2017/9/1.
 */
public class BaseDomain<T> implements Serializable {

    protected static final long serialVersionUID = 6667600871541308622L;

    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
