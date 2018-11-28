package com.lifesense.quality.facade;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.base.BaseExample;
import com.lifesense.quality.base.IBaseService;
import com.lifesense.quality.criteria.QaUserGeneratedCriteria;
import com.lifesense.quality.domain.QaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther zcd
 * @Date
 */
@Service
public class QaUserServiceFacadeImpl {

    @Autowired
    private IBaseService<QaUser> qaUserIBaseService;


    public QaUser findQaUserById(Long id) {
        return qaUserIBaseService.fetchById(id);
    }

    public QaUser findQaUserByCode(String code) {
        BaseExample<QaUser> example = new BaseExample<QaUser>();
        QaUserGeneratedCriteria criteria = new QaUserGeneratedCriteria();
        criteria.andCodeEqualTo(code);
        example.or(criteria);
        List<QaUser> qaUsers = qaUserIBaseService.findByCriteria(example);
        if (qaUsers!=null && !qaUsers.isEmpty()){
            return qaUsers.get(0);
        }
        return null;
    }

    public int saveOrUpdate(QaUser qaUser) {
        if (qaUser.getId() != null) {
            return qaUserIBaseService.edit(qaUser);
        } else {
            return qaUserIBaseService.insert(qaUser);
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
    public PageInfo<QaUser> getPageData(QaUser record, int pageNum, int limit) {
        return qaUserIBaseService.queryPage(record, pageNum, limit);
    }

    public QaUser findQaUserByName(String userName) {
        BaseExample<QaUser> example = new BaseExample<QaUser>();
        QaUserGeneratedCriteria criteria = new QaUserGeneratedCriteria();
        criteria.andNameEqualTo(userName);
        example.or(criteria);
        List<QaUser> qaUsers = qaUserIBaseService.findByCriteria(example);
        if (qaUsers!=null && !qaUsers.isEmpty()){
            return qaUsers.get(0);
        }
        return null;
    }
}
