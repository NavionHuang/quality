package com.lifesense.quality.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.lifesense.quality.base.BaseDao;
import com.lifesense.quality.domain.Product;

/**
 * Created by 赵春定 on 2017/8/10.
 */
public interface IProductDao extends BaseDao<Product>{
	public int updateCPSN(@Param("id")Long id,@Param("modifyTime")Date modifyTime);
}
