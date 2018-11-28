package com.lifesense.quality.facade;

import com.lifesense.quality.base.BaseExample;
import com.lifesense.quality.base.IBaseService;
import com.lifesense.quality.criteria.QaPreviewGeneratedCriteria;
import com.lifesense.quality.criteria.QaUserGeneratedCriteria;
import com.lifesense.quality.criteria.Role2previewGeneratedCriteria;
import com.lifesense.quality.criteria.User2roleGeneratedCriteria;
import com.lifesense.quality.domain.QaPreview;
import com.lifesense.quality.domain.QaUser;
import com.lifesense.quality.domain.Role2preview;
import com.lifesense.quality.domain.User2role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

/**
 * @Auther zcd
 * @Date 主要提供系统的业务处理
 * 用户模块
 * 角色模块
 * 权限模块
 */
@Service
public class SystemServiceFacadeImpl {

    private Logger logger = LoggerFactory.getLogger(SystemServiceFacadeImpl.class);

    @Autowired
    private IBaseService<QaUser> qaUserService;

    @Autowired
    private IBaseService<User2role> user2roleService;
    @Autowired
    private IBaseService<Role2preview> role2previewService;

    @Autowired
    private IBaseService<QaPreview> qaPreviewIBaseService;

    public QaUser findQaUserByAccount(String account) {
        if (StringUtils.isEmpty(account)) {
            logger.warn("find  QaUser  By  Account,account is empty");
        }
        logger.info("find  QaUser  By  Account,account is:{}", account);
        BaseExample<QaUser> example = new BaseExample<>();
        /*准则*/
        QaUserGeneratedCriteria criteria = new QaUserGeneratedCriteria();
        /*设置准则到example*/
        example.or(criteria);
        /*添加条件到准则里，account=?*/
        criteria.andAccountEqualTo(account);
        /*使用准则查询*/
        List<QaUser> qaUsers = qaUserService.findByCriteria(example);
        if (qaUsers != null && !qaUsers.isEmpty()) {
            return qaUsers.get(0);
        }
        return null;
    }

    public List<User2role> findUser2roleByUserId(Long userId) {
        if (userId == null) {
            logger.warn("find  User2role  By  UserId,UserId is empty");
        }
        logger.info("find  User2role  By  UserId,UserId is:{}", userId);
        BaseExample<User2role> example = new BaseExample<>();
        /*准则*/
        User2roleGeneratedCriteria criteria = new User2roleGeneratedCriteria();
        /*设置准则到example*/
        example.or(criteria);
        /*添加条件到准则里，account=?*/
        criteria.andUserIdEqualTo(userId);
        /*使用准则查询*/
        List<User2role> user2roles = user2roleService.findByCriteria(example);
        return user2roles;
    }

    public List<Role2preview> findRole2previewByRoleCode(List<String> roleCodes) {
        if (roleCodes == null || roleCodes.isEmpty()) {
            logger.warn("find  Role2preview  By  RoleCode,RoleCode is empty");
            return null;
        } else {
            logger.info("find  Role2preview  By  RoleCode,RoleCode is empty");
            BaseExample<Role2preview> example = new BaseExample<>();
            /*准则*/
            Role2previewGeneratedCriteria criteria = new Role2previewGeneratedCriteria();
            /*设置准则到example*/
            example.or(criteria);
            /*添加条件到准则里，account=?*/
            criteria.andRoleCodeIn(roleCodes);
            /*使用准则查询*/
            List<Role2preview> role2previews = role2previewService.findByCriteria(example);
            return role2previews;
        }
    }

    public List<QaPreview> findQaPreviewByCodes(List<String> ids) {
        if (ids == null || ids.isEmpty()) {
            logger.warn("find  preview  By  ids,ids is empty");
            return null;
        } else {
            logger.info("find  preview  By  ids,ids is empty");
            BaseExample<QaPreview> example = new BaseExample<>();
            /*准则*/
            QaPreviewGeneratedCriteria criteria = new QaPreviewGeneratedCriteria();
            /*设置准则到example*/
            example.or(criteria);
            /*添加条件到准则里，account=?*/
            criteria.andCodeIn(ids);
            /*使用准则查询*/
            List<QaPreview> previews = qaPreviewIBaseService.findByCriteria(example);
            return previews;
        }
    }

    public List<QaPreview> findAllQaPreviews() {
        BaseExample<QaPreview> example = new BaseExample<>();
        List<QaPreview> previews = qaPreviewIBaseService.findByCriteria(example);
        return previews;
    }


}
