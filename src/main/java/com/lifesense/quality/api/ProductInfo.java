package com.lifesense.quality.api;

import java.util.Map;

/**
 * @Auther zcd
 * @Date
 */
public class ProductInfo {
    private String sn;
    private String productLine;
    private String processCode;
    private String name;
    private String result;
    private Map data;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map getData() {
        return data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setData(Map data) {
        this.data = data;
    }
}
