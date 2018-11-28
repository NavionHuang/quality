package com.lifesense.quality.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Spring on 2018/5/1.
 */

public interface BaseDao<T extends BaseDomain> {

    T selectByPrimaryKey(Object id);

    int deleteByExample(BaseExample<T> example);

    int deleteByPrimaryKey(Long id);

    int insert(T record);

    int insertSelective(T record);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    int countByExample(BaseExample<T> example);

    int count(@Param("record") T record);

    List<T> selectByExample(BaseExample<T> example);

    List<T> select(@Param("record") T record);

    int updateByExampleSelective(@Param("record") T record, @Param("example") BaseExample<T> example);

    int updateByExample(@Param("record") T record, @Param("example") BaseExample<T> example);

}
