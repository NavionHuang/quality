package com.lifesense.quality.facade;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.base.BaseExample;
import com.lifesense.quality.base.IBaseService;
import com.lifesense.quality.criteria.RepairRecordGeneratedCriteria;
import com.lifesense.quality.domain.RepairRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther zcd
 * @Date
 */
@Service
public class RepairRecordServiceFacadeImpl {

    @Autowired
    private IBaseService<RepairRecord> repairRecordIBaseService;

    public int saveOrUpdate(RepairRecord repairRecord) {
        if (repairRecord.getId() != null) {
            return repairRecordIBaseService.edit(repairRecord);
        } else {
            return repairRecordIBaseService.insert(repairRecord);
        }
    }

    public RepairRecord getRepairRecordById(Long id) {
        return repairRecordIBaseService.fetchById(id);
    }

    public RepairRecord findRepairRecordByProductId(Long productId,int status){
        BaseExample<RepairRecord> example = new BaseExample<>();
        RepairRecordGeneratedCriteria criteria = new RepairRecordGeneratedCriteria();
        criteria.andProductIdEqualTo(productId);
        criteria.andRepairEqualTo(status);
        example.or(criteria);
        List<RepairRecord> repairRecords = repairRecordIBaseService.findByCriteria(example);
        if (repairRecords!=null && !repairRecords.isEmpty()){
            return repairRecords.get(0);
        }
        return null;
    }

    public int batchUpdate(String[] ids, String badType, String badReson, Long userId) {
        RepairRecord repairRecord = new RepairRecord();
        repairRecord.setBadType(badType);
        repairRecord.setBadReson(badReson);
        repairRecord.setUserId(userId);
        repairRecord.setModifyTime(new Date());
        BaseExample<RepairRecord> example = new BaseExample<>();
        RepairRecordGeneratedCriteria criteria = new RepairRecordGeneratedCriteria();
        List<Long> ids_l = Arrays.stream(ids).map(id -> Long.valueOf(id)).collect(Collectors.toList());
        criteria.andIdIn(ids_l);
        example.or(criteria);
        return repairRecordIBaseService.updateNotNullByCondition(repairRecord, example);
    }

    /**
     * 分页查询
     *
     * @param record
     * @param pageNum
     * @param limit
     * @return
     */
    public PageInfo<RepairRecord> getPageData(RepairRecord record, int pageNum, int limit) {
        return repairRecordIBaseService.queryPage(record, pageNum, limit);
    }


}
