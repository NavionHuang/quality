package com.lifesense.quality.controller;

/**
 * Created by 赵春定 on 2017/8/8.
 */
public class ResponseMessage {
    private String code;
    private String msg;
    private Object data;

    public ResponseMessage(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
