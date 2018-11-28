package com.lifesense.quality.facade;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.base.BaseExample;
import com.lifesense.quality.base.IBaseService;
import com.lifesense.quality.criteria.ProcessRecordGeneratedCriteria;
import com.lifesense.quality.domain.ProcessRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther zcd
 * @Date
 */
@Service
public class ProcessRecordServiceFacadeImpl {

    @Autowired
    private IBaseService<ProcessRecord> processRecordIBaseService;

    /**
     * 分页查询
     *
     * @param record
     * @param pageNum
     * @param limit
     * @return
     */
    public PageInfo<ProcessRecord> getPageData(ProcessRecord record, int pageNum, int limit) {
        return processRecordIBaseService.queryPage(record, pageNum, limit);
    }

    /**
     * 保存或者更新
     *
     * @param record
     * @return
     */
    public int saveOrUpdate(ProcessRecord record) {
        if (record.getId() != null) {
            return processRecordIBaseService.edit(record);
        } else {
            return processRecordIBaseService.insert(record);
        }
    }

    public List<ProcessRecord> findProcessRecord(Long productId, String processCode) {
        BaseExample<ProcessRecord> example = new BaseExample<>();
        ProcessRecordGeneratedCriteria criteria = new ProcessRecordGeneratedCriteria();
        criteria.andProductIdEqualTo(productId);
        criteria.andProcessCodeEqualTo(processCode);
        example.or(criteria);
        return processRecordIBaseService.findByCriteria(example);
    }

    public List<ProcessRecord> findProcessRecord(Long productId) {
        BaseExample<ProcessRecord> example = new BaseExample<>();
        ProcessRecordGeneratedCriteria criteria = new ProcessRecordGeneratedCriteria();
        criteria.andProductIdEqualTo(productId);
        example.or(criteria);
        example.setOrderByClause("id ASC");
        return processRecordIBaseService.findByCriteria(example);
    }

    public ProcessRecord findUnHandleProcessRecord(Long productId) {
        BaseExample<ProcessRecord> example = new BaseExample<>();
        ProcessRecordGeneratedCriteria criteria = new ProcessRecordGeneratedCriteria();
        criteria.andProductIdEqualTo(productId);
        criteria.andStatusEqualTo("1");
        example.or(criteria);
        List<ProcessRecord> records = processRecordIBaseService.findByCriteria(example);
        return records != null && records.size() > 0 ? records.get(0) : null;
    }
    /**
     * 结果NG的流程
     * @param productId
     * @return
     */
    public ProcessRecord newFindUnHandleProcessRecord(Long productId) {
    	BaseExample<ProcessRecord> example = new BaseExample<>();
    	ProcessRecordGeneratedCriteria criteria = new ProcessRecordGeneratedCriteria();
    	criteria.andProductIdEqualTo(productId);
    	criteria.andStatusEqualTo("-1");
    	example.or(criteria);
    	List<ProcessRecord> records = processRecordIBaseService.findByCriteria(example);
    	return records != null && records.size() > 0 ? records.get(0) : null;
    }

    public ProcessRecord findProcessRecordById(Long processRecordId) {
        return processRecordIBaseService.fetchById(processRecordId);
    }

    public void deleteById(Long id) {
        processRecordIBaseService.deleteById(id);
    }
    /**
     * 按产品ID,工站,状态查询
     * @param productId
     * @param processCode
     * @param status
     * @return
     */
    public ProcessRecord findProcessRecord(Long productId,String processCode,Integer status) {
    	BaseExample<ProcessRecord> example = new BaseExample<>();
    	ProcessRecordGeneratedCriteria criteria = new ProcessRecordGeneratedCriteria();
    	criteria.andProductIdEqualTo(productId);
    	criteria.andProcessCodeEqualTo(processCode);
    	criteria.andStatusEqualTo(status.toString());
    	example.or(criteria);
    	List<ProcessRecord> records = processRecordIBaseService.findByCriteria(example);
    	return records != null && records.size() > 0 ? records.get(0) : null;
    }
}
