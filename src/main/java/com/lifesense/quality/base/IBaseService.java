package com.lifesense.quality.base;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by Spring on 2018/5/1.
 */
public interface IBaseService<T extends BaseDomain> {


    /**
     * 插入有值字段
     *
     * @param paramT
     * @return
     */
    abstract int add(T paramT);

    /**
     * 插入全部字段
     *
     * @param paramT
     * @return
     */
    abstract int insert(T paramT);

    /**
     * 更新有值字段
     *
     * @param paramT
     * @return
     */
    abstract int edit(T paramT);

    /**
     * 更新全部字段
     *
     * @param paramT
     * @return
     */
    abstract int update(T paramT);

    /**
     * 根据条件更新所有的字段
     *
     * @param paramT
     * @param example
     * @return
     */
    abstract int updateByCondition(T paramT, BaseExample<T> example);


    /**
     * 根据ID查询
     *
     * @param key
     * @return
     */
    abstract T fetchById(Long key);

    /**
     * 根据ID条件删除
     *
     * @param key
     * @return
     */
    abstract int deleteById(Long key);

    /**
     * 根据条件更新所有的非空字段
     *
     * @param paramT
     * @param example
     * @return
     */
    abstract int updateNotNullByCondition(T paramT, BaseExample<T> example);

    /**
     * 根据条件查询所有记录
     *
     * @param example
     * @return
     */
    abstract List<T> findByCriteria(BaseExample<T> example);

    /**
     * 根据条件查询分页
     *
     * @param param
     * @param start
     * @param end
     * @return
     */
    abstract PageInfo<T> queryPage(T param, int start, int end);

    /**
     * 统计数量
     *
     * @param param
     * @return
     */
    abstract int count(T param);


    /**
     * 根据条件删除
     *
     * @param example
     * @return
     */
    abstract int deleteByCondition(BaseExample<T> example);

    /**
     * 统计数量
     *
     * @param example
     * @return
     */
    abstract int count(BaseExample<T> example);



}
