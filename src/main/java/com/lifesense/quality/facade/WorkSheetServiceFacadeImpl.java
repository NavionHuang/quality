package com.lifesense.quality.facade;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.base.BaseExample;
import com.lifesense.quality.base.IBaseService;
import com.lifesense.quality.criteria.WorkSheetGeneratedCriteria;
import com.lifesense.quality.domain.WorkSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther zcd
 * @Date
 */
@Service
public class WorkSheetServiceFacadeImpl {

    @Autowired
    private IBaseService<WorkSheet> workSheetIBaseService;


    public WorkSheet findWorkSheetById(Long id) {
        return workSheetIBaseService.fetchById(id);
    }

    public int saveOrUpdate(WorkSheet entity) {
        if (entity.getId() != null) {
            return workSheetIBaseService.edit(entity);
        } else {
            return workSheetIBaseService.insert(entity);
        }
    }

    public WorkSheet findWorkSheetBySheetPo(String sheetPo) {
        BaseExample<WorkSheet> example = new BaseExample<>();
        WorkSheetGeneratedCriteria criteria = new WorkSheetGeneratedCriteria();
        criteria.andSheetPoEqualTo(sheetPo);
        example.or(criteria);
        List<WorkSheet> workSheets = workSheetIBaseService.findByCriteria(example);
        if (workSheets!=null && !workSheets.isEmpty()){
            return workSheets.get(0);
        }
        return null;
    }

    /**
     * 分页查询
     *
     * @param record
     * @param pageNum
     * @param limit
     * @return
     */
    public PageInfo<WorkSheet> getPageData(WorkSheet record, int pageNum, int limit) {
        return workSheetIBaseService.queryPage(record, pageNum, limit);
    }

}
