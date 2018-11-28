package com.lifesense.quality.facade;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.base.BaseExample;
import com.lifesense.quality.base.IBaseService;
import com.lifesense.quality.criteria.ProcessFlowGeneratedCriteria;
import com.lifesense.quality.domain.ProcessFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther zcd
 * @Date
 */
@Service
public class ProcessFlowServiceFacadeImpl {

    @Autowired
    private IBaseService<ProcessFlow> processFlowIBaseService;

    /**
     * 分页查询
     *
     * @param record
     * @param pageNum
     * @param limit
     * @return
     */
    public PageInfo<ProcessFlow> getPageData(ProcessFlow record, int pageNum, int limit) {
        return processFlowIBaseService.queryPage(record, pageNum, limit);
    }

    public void batchSaveFlow(List<ProcessFlow> processFlows) {
        processFlows.forEach(p -> processFlowIBaseService.insert(p));
    }

    public void deleteFlowByType(String productTypeCode) {
        BaseExample<ProcessFlow> example = new BaseExample<>();
        ProcessFlowGeneratedCriteria criteria = new ProcessFlowGeneratedCriteria();
        criteria.andProductTypeCodeEqualTo(productTypeCode);
        example.or(criteria);
        processFlowIBaseService.deleteByCondition(example);
    }

    public List<ProcessFlow> queryFlowListByProductTypeCode(String productTypeCode) {
        BaseExample<ProcessFlow> example = new BaseExample<>();
        ProcessFlowGeneratedCriteria criteria = new ProcessFlowGeneratedCriteria();
        criteria.andProductTypeCodeEqualTo(productTypeCode);
        example.or(criteria);
        return processFlowIBaseService.findByCriteria(example);
    }

    public ProcessFlow findByProductTypeAndProcessCode(String productTypeCode, String processCode) {
        BaseExample<ProcessFlow> example = new BaseExample<>();
        ProcessFlowGeneratedCriteria criteria = new ProcessFlowGeneratedCriteria();
        criteria.andProductTypeCodeEqualTo(productTypeCode);
        criteria.andProcessCodeEqualTo(processCode);
        example.or(criteria);
        List<ProcessFlow> flows = processFlowIBaseService.findByCriteria(example);
        if (flows != null && flows.size() > 0) {
            return flows.get(0);
        }
        return null;
    }

}
