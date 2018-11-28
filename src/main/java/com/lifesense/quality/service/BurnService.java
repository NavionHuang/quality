package com.lifesense.quality.service;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.domain.Burn;

public interface BurnService {
	int inser(Burn burn);

	int update(Burn burn);

	Burn queryBySN(String sn);

	PageInfo<Burn> query(Burn burn, Date startTime, Date endTime, int pageNum, int pageSize);

	List<Burn> query(Burn burn, Date startTime, Date endTime);
	
	int reBurn(Burn burn);
}
