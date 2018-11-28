package com.lifesense.quality.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Spring on 2018/5/1.
 */
public abstract class AbstractBaseService<T extends BaseDomain> implements IBaseService<T> {

    @Autowired
    private BaseDao<T> baseDao;

    @Override
    public int add(T paramT) {
        return baseDao.insertSelective(paramT);
    }

    @Override
    public int insert(T paramT) {
        return baseDao.insert(paramT);
    }

    @Override
    public int edit(T paramT) {
        return baseDao.updateByPrimaryKeySelective(paramT);
    }

    @Override
    public int update(T paramT) {
        return baseDao.updateByPrimaryKey(paramT);
    }

    @Override
    public T fetchById(Long key) {
        return baseDao.selectByPrimaryKey(key);
    }

    @Override
    public int deleteById(Long key) {
        return baseDao.deleteByPrimaryKey(key);
    }

    @Override
    public int updateByCondition(T paramT, BaseExample<T> example) {
        return baseDao.updateByExample(paramT, example);
    }

    @Override
    public int updateNotNullByCondition(T paramT, BaseExample<T> example) {
        return baseDao.updateByExampleSelective(paramT, example);
    }

    @Override
    public List<T> findByCriteria(BaseExample<T> example) {
        return baseDao.selectByExample(example);
    }

    @Override
    public int deleteByCondition(BaseExample<T> example) {
        return baseDao.deleteByExample(example);
    }

    @Override
    public int count(BaseExample<T> example) {
        return baseDao.countByExample(example);
    }

    @Override
    public PageInfo<T> queryPage(T param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize,true);
        List<T> data = baseDao.select(param);
        PageInfo<T> pageInfo = new PageInfo<T>(data);
        return pageInfo;
    }

    @Override
    public int count(T param) {
        return baseDao.count(param);
    }
}
