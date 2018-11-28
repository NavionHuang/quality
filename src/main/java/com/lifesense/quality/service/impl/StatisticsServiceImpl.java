package com.lifesense.quality.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lifesense.quality.dao.StatisticsDao;
import com.lifesense.quality.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 赵春定 on 2018/5/1.
 * email:975511216@qq.com
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsDao statisticsDao;

    @Override
    public PageInfo<Map<String, Object>> spsBySheet(int pageNum, int pageSize, String sheetPo, Date startTime, Date endTime) {
        Map<String, Object> param = new HashMap<String, Object>();
        if (!StringUtils.isEmpty(sheetPo)) {
            param.put("sheet_po", sheetPo);
        }
        if (startTime != null) {
            param.put("start_time", startTime);
        }
        if (endTime != null) {
            param.put("end_time", endTime);
        }
        PageHelper.startPage(pageNum, pageSize, true);
        List<Map<String, Object>> data = statisticsDao.spsBySheet(param);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(data);
        return pageInfo;
    }

    @Override
    public PageInfo<Map<String, Object>> spsByLine(int pageNum, int pageSize, String sheetPo,String productTypeCode, String line, Date startTime, Date endTime) {
        Map<String, Object> param = new HashMap<String, Object>();
        if (!StringUtils.isEmpty(sheetPo)) {
            param.put("sheet_po", sheetPo);
        }
        if (!StringUtils.isEmpty(productTypeCode)) {
            param.put("product_type_code", productTypeCode);
        }
        if (!StringUtils.isEmpty(line)) {
            param.put("product_line_code", line);
        }
        if (startTime != null) {
            param.put("start_time", startTime);
        }
        if (endTime != null) {
            param.put("end_time", endTime);
        }
        PageHelper.startPage(pageNum, pageSize, true);
        List<Map<String, Object>> data = statisticsDao.spsByLine(param);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(data);
        return pageInfo;
    }

    @Override
    public PageInfo<Map<String, Object>> spsRateByLine(int pageNum, int pageSize, String sheetPo, String productTypeCode,String line,Date startTime, Date endTime) {
        Map<String, Object> param = new HashMap<String, Object>();
        if (!StringUtils.isEmpty(sheetPo)) {
            param.put("sheet_po", sheetPo);
        }
        if (!StringUtils.isEmpty(productTypeCode)) {
            param.put("product_type_code", productTypeCode);
        }
        if (!StringUtils.isEmpty(line)) {
            param.put("product_line_code", line);
        }
        PageHelper.startPage(pageNum, pageSize, true);
        List<Map<String, Object>> data = statisticsDao.spsRateByLine(param);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(data);
        return pageInfo;
    }

    @Override
    public List<Map<String, Object>> spsByState(List<String> sheetPoes, List<String> linees, Date startTime, Date endTime,Integer sps) {
        Map<String, Object> param = new HashMap<String, Object>();
        if (sheetPoes!=null && !sheetPoes.isEmpty()) {
            param.put("sheet_poes", sheetPoes);
        }
        if (linees!=null && !linees.isEmpty()) {
            param.put("product_line_codees", linees);
        }
        if (startTime != null) {
            param.put("start_time", startTime);
        }
        if (endTime != null) {
            param.put("end_time", endTime);
        }
        if (sps != null) {
            param.put("sps", sps);
        }
        List<Map<String, Object>> data = statisticsDao.spsByState(param);
        return data;
    }

    @Override
    public PageInfo<Map<String, Object>> spsByProduct(int pageNum, int pageSize, String sheetPo, String cpsn, String blsn, String bbsn) {
        Map<String, Object> param = new HashMap<String, Object>();
        if (!StringUtils.isEmpty(sheetPo)) {
            param.put("sheet_po", sheetPo);
        }
        if (!StringUtils.isEmpty(cpsn)) {
            param.put("cpsn", cpsn);
        }
        if (!StringUtils.isEmpty(blsn)) {
            param.put("blsn", blsn);
        }
        if (!StringUtils.isEmpty(bbsn)) {
            param.put("bbsn", bbsn);
        }
        PageHelper.startPage(pageNum, pageSize, true);
        List<Map<String, Object>> data = statisticsDao.spsBySheet(param);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(data);
        return pageInfo;
    }



    @Override
    public PageInfo<Map<String, Object>> queryByProduct(int pageNum, int pageSize, String cpsn) {
        Map<String, Object> param = new HashMap<String, Object>();
        if (!StringUtils.isEmpty(cpsn)) {
            param.put("cpsn", cpsn);
        }
        PageHelper.startPage(pageNum, pageSize, true);
        List<Map<String, Object>> data = statisticsDao.queryByProduct(param);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(data);
        return pageInfo;
    }

    @Override
    public PageInfo<Map<String, Object>> queryCountTimeByState(int pageNum, int pageSize, String sheetPo,String productType, String line, String processCode, Date startTime, Date endTime) {
        Map<String, Object> param = new HashMap<String, Object>();
        if (!StringUtils.isEmpty(sheetPo)) {
            param.put("sheet_po", sheetPo);
        }
        if (!StringUtils.isEmpty(productType)) {
            param.put("product_type_code", productType);
        }
        if (!StringUtils.isEmpty(line)) {
            param.put("product_line_code", line);
        }
        if (!StringUtils.isEmpty(processCode)) {
            param.put("process_code", processCode);
        }
        if (startTime!=null) {
            param.put("start_time", startTime);
        }
        if (endTime!=null) {
            param.put("end_time", endTime);
        }

        PageHelper.startPage(pageNum, pageSize, true);
        List<Map<String, Object>> data = statisticsDao.queryCountTimeByState(param);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(data);
        return pageInfo;
    }

    @Override
    public PageInfo<Map<String, Object>> querySninfo(int pageNum, int pageSize, String sheetPo, String cpsn, String sn) {
        Map<String, Object> param = new HashMap<String, Object>();
        if (!StringUtils.isEmpty(sheetPo)) {
            param.put("sheet_po", sheetPo);
        }
        if (!StringUtils.isEmpty(cpsn)) {
            param.put("cpsn", cpsn);
        }
        if (!StringUtils.isEmpty(sn)) {
            param.put("sn", sn);
        }
        PageHelper.startPage(pageNum, pageSize, true);
        List<Map<String, Object>> data = statisticsDao.querySninfo(param);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(data);
        return pageInfo;
    }

    @Override
    public PageInfo<Map<String, Object>> queryRepair(int pageNum, int pageSize,String sheetPo, String line, String state) {
        Map<String, Object> param = new HashMap<String, Object>();
        if (!StringUtils.isEmpty(sheetPo)) {
            param.put("sheet_po", sheetPo);
        }
        if (!StringUtils.isEmpty(line)) {
            param.put("product_line_code", line);
        }
        if (!StringUtils.isEmpty(state)) {
            param.put("process_code", state);
        }
        PageHelper.startPage(pageNum, pageSize, true);
        List<Map<String, Object>> data = statisticsDao.queryRepair(param);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(data);
        return pageInfo;
    }
    
	@Override
	public PageInfo<Map<String, Object>> queryDataStatement(int pageNum, int pageSize, String sheetPo, String[] statuss,
			String[] productLineCodes, String[] processCodes, Date startTime, Date endTime) {
		Map<String, Object> param = new HashMap<String, Object>();
        PageHelper.startPage(pageNum, pageSize, true);
        if (!StringUtils.isEmpty(sheetPo)) {
        	param.put("sheetPo", sheetPo);
        }
        if (!StringUtils.isEmpty(statuss)) {
        	param.put("stasuss", statuss);
        }

        if (!StringUtils.isEmpty(productLineCodes)) {
        	param.put("productLineCodes", productLineCodes);
        }

        if (!StringUtils.isEmpty(processCodes)) {
        	param.put("processCodes", processCodes);
        }

        if (!StringUtils.isEmpty(startTime)) {
        	param.put("startTime", startTime);
        }

        if (!StringUtils.isEmpty(endTime)) {
        	param.put("endTime", endTime);
        }

        List<Map<String, Object>> data = statisticsDao.queryDataStatement(param);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(data);
        return pageInfo;
	}

	@Override
	public List<Map<String, Object>> dataStatementExport(String sheetPo, String[] statuss,
			String[] productLineCodes, String[] processCodes, Date startTime, Date endTime) {
		Map<String, Object> param = new HashMap<String, Object>();
		if (!StringUtils.isEmpty(sheetPo)) {
        	param.put("sheetPo", sheetPo);
        }
        if (!StringUtils.isEmpty(statuss)) {
        	param.put("stasuss", statuss);
        }

        if (!StringUtils.isEmpty(productLineCodes)) {
        	param.put("productLineCodes", productLineCodes);
        }

        if (!StringUtils.isEmpty(processCodes)) {
        	param.put("processCodes", processCodes);
        }

        if (!StringUtils.isEmpty(startTime)) {
        	param.put("startTime", startTime);
        }

        if (!StringUtils.isEmpty(endTime)) {
        	param.put("endTime", endTime);
        }
		return statisticsDao.queryDataStatement(param);
	}
}
