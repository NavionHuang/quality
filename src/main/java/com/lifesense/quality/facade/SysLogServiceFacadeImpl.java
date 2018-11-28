package com.lifesense.quality.facade;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.base.IBaseService;
import com.lifesense.quality.domain.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther zcd
 * @Date
 */
@Service
public class SysLogServiceFacadeImpl {

    @Autowired
    private IBaseService<SysLog> sysLogIBaseService;

    /**
     * 分页查询
     *
     * @param record
     * @param pageNum
     * @param limit
     * @return
     */
    public PageInfo<SysLog> getPageData(SysLog record, int pageNum, int limit) {
        return sysLogIBaseService.queryPage(record, pageNum, limit);

    }

    public void save(SysLog sysLog) {
        sysLogIBaseService.insert(sysLog);
    }
}
