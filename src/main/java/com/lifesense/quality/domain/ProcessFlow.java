package com.lifesense.quality.domain;

import com.lifesense.quality.base.BaseDomain;

/**
 * PROCESS_FLOW
 *
 * @author 赵春定
 * @Date 2018-05-01
 * @Email 975511216@qq.com
 */
public class ProcessFlow extends BaseDomain<Long> {

    private String productTypeCode;

    private String processCode;

    private String processName;

    private String repairProcessCode;

    private String repairProcessName;

    private String nextProcessCode;

    private String nextProcessName;

    public String getProductTypeCode() {
        return productTypeCode;
    }

    public void setProductTypeCode(String productTypeCode) {
        this.productTypeCode = productTypeCode;
    }

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getRepairProcessCode() {
        return repairProcessCode;
    }

    public void setRepairProcessCode(String repairProcessCode) {
        this.repairProcessCode = repairProcessCode;
    }

    public String getRepairProcessName() {
        return repairProcessName;
    }

    public void setRepairProcessName(String repairProcessName) {
        this.repairProcessName = repairProcessName;
    }

    public String getNextProcessCode() {
        return nextProcessCode;
    }

    public void setNextProcessCode(String nextProcessCode) {
        this.nextProcessCode = nextProcessCode;
    }

    public String getNextProcessName() {
        return nextProcessName;
    }

    public void setNextProcessName(String nextProcessName) {
        this.nextProcessName = nextProcessName;
    }
}