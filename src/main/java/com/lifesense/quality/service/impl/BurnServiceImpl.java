package com.lifesense.quality.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lifesense.quality.dao.BurnDao;
import com.lifesense.quality.domain.Burn;
import com.lifesense.quality.service.BurnService;

@Service
public class BurnServiceImpl implements BurnService {
	@Autowired
	private BurnDao burnDao;

	@Override
	public int inser(Burn burn) {
		return burnDao.inser(burn);
	}

	@Override
	public int update(Burn burn) {
		return burnDao.update(burn);
	}

	@Override
	public Burn queryBySN(String sn) {
		return burnDao.queryBySN(sn);
	}

	@Override
	public PageInfo<Burn> query(Burn burn,Date startTime, Date endTime, int pageNum, int pageSize) {
		 PageHelper.startPage(pageNum, pageSize,true);
	        List<Burn> data = burnDao.query(burn,startTime, endTime);
	        PageInfo<Burn> pageInfo = new PageInfo<Burn>(data);
	        return pageInfo;
	}

	@Override
	public List<Burn> query(Burn burn, Date startTime, Date endTime) {
		return burnDao.query(burn,startTime, endTime);
	}

	@Override
	public int reBurn(Burn burn) {
		return burnDao.reBurn(burn);
	}
}
