package com.lifesense.quality.api;

import java.util.List;

/**
 * @Auther zcd
 * @Date
 */
public class ResponseData {
    private String code;
    private List<String> msg;
    private List<ProductInfo> data;

    public ResponseData(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getMsg() {
        return msg;
    }

    public void setMsg(List<String> msg) {
        this.msg = msg;
    }

    public List<ProductInfo> getData() {
        return data;
    }

    public void setData(List<ProductInfo> data) {
        this.data = data;
    }
}
