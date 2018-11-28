package com.lifesense.quality.facade;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.base.BaseExample;
import com.lifesense.quality.base.IBaseService;
import com.lifesense.quality.criteria.ProcessGeneratedCriteria;
import com.lifesense.quality.domain.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther zcd
 * @Date 站点服务类
 */
@Service
public class ProcessServiceFacadeImpl {

    @Autowired
    private IBaseService<Process> processIBaseService;

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public Process findProcessById(Long id) {
        return processIBaseService.fetchById(id);
    }

    /**
     * 根据code查找
     * @param code
     * @return
     */
    public Process findProcessByCode(String code) {
        BaseExample<Process> example = new BaseExample<>();
        ProcessGeneratedCriteria criteria = new ProcessGeneratedCriteria();
        criteria.andCodeEqualTo(code);
        criteria.andValidEqualTo(0);
        example.or(criteria);
        List<Process> processes = processIBaseService.findByCriteria(example);
        if (processes!=null && !processes.isEmpty()){
            return processes.get(0);
        }
        return null;
    }

    /**
     * 保存更新，有id就更新
     * @param process
     * @return
     */
    public int saveOrUpdate(Process process) {
        if (process.getId()!=null){
            return processIBaseService.edit(process);
        }else{
            return processIBaseService.insert(process);
        }
    }

    /**
     * 查找所有有效的站点
     * @return
     */
    public List<Process> findValidProcess(Integer type) {
        BaseExample<Process> example = new BaseExample<>();
        ProcessGeneratedCriteria criteria = new ProcessGeneratedCriteria();
        criteria.andTypeEqualTo(type);
        criteria.andValidEqualTo(0);
        example.or(criteria);
        return processIBaseService.findByCriteria(example);
    }


    /**
     *  分页查询
     * @param record
     * @param pageNum
     * @param limit
     * @return
     */
    public PageInfo<Process> getPageData(Process record, int pageNum, int limit) {
        return processIBaseService.queryPage(record, pageNum, limit);

    }


    public List<Process> findAll() {
        BaseExample<Process> example = new BaseExample<>();
        ProcessGeneratedCriteria criteria = new ProcessGeneratedCriteria();
        criteria.andValidEqualTo(0);
        example.or(criteria);
        example.setOrderByClause("asc_order asc");
        return processIBaseService.findByCriteria(example);
    }

    public Process findProcessByName(String name) {
        BaseExample<Process> example = new BaseExample<>();
        ProcessGeneratedCriteria criteria = new ProcessGeneratedCriteria();
        criteria.andNameEqualTo(name);
        criteria.andValidEqualTo(0);
        example.or(criteria);
        List<Process> processes = processIBaseService.findByCriteria(example);
        if (processes!=null && !processes.isEmpty()){
            return processes.get(0);
        }
        return null;
    }

    public List<Process> findAllSps() {
        BaseExample<Process> example = new BaseExample<>();
        ProcessGeneratedCriteria criteria = new ProcessGeneratedCriteria();
        criteria.andValidEqualTo(0);
        criteria.andSpsEqualTo(0);
        example.or(criteria);
        example.setOrderByClause("asc_order desc");
        return processIBaseService.findByCriteria(example);
    }
}
