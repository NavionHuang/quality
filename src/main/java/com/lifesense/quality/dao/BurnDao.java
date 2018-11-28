package com.lifesense.quality.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lifesense.quality.domain.Burn;

public interface BurnDao {
	int inser(Burn burn);

	int update(Burn burn);

	Burn queryBySN(String sn);

	List<Burn> query(@Param("burn") Burn burn, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

	int reBurn(Burn burn);
}
