package com.lifesense.quality.facade;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.base.BaseExample;
import com.lifesense.quality.base.IBaseService;
import com.lifesense.quality.criteria.BadCodeGeneratedCriteria;
import com.lifesense.quality.domain.BadCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther zcd
 * @Date 错误代码
 */
@Service
public class BadcodeServiceFacadeImpl {

    @Autowired
    private IBaseService<BadCode> badCodeIBaseService;

    /**
     * 根据id 查询
     *
     * @param id
     * @return
     */
    public BadCode findBadcodById(Long id) {
        return badCodeIBaseService.fetchById(id);
    }

    /**
     * 查找错误代码，多个返回一个
     *
     * @param processCode 工站代码
     * @param code        错误代码
     * @return
     */
    public BadCode findBadcodeByCode(String processCode, String code) {
        BaseExample<BadCode> example = new BaseExample<>();
        BadCodeGeneratedCriteria criteria = new BadCodeGeneratedCriteria();
        example.or(criteria);
        criteria.andProcessCodeEqualTo(processCode);
        criteria.andCodeEqualTo(code);
        List<BadCode> badCodes = badCodeIBaseService.findByCriteria(example);
        return badCodes != null && !badCodes.isEmpty() ? badCodes.get(0) : null;
    }

    /**
     * @param entity
     * @return
     */
    public int saveOrUpdate(BadCode entity) {
        if (entity.getId() == null) {
            return badCodeIBaseService.insert(entity);
        } else {
            return badCodeIBaseService.edit(entity);
        }
    }

    /**
     * 分页查询
     *
     * @param record
     * @param pageNum
     * @param limit
     * @return
     */
    public PageInfo<BadCode> getPageData(BadCode record, int pageNum, int limit) {
        return badCodeIBaseService.queryPage(record, pageNum, limit);
    }


}
