package com.lifesense.quality.service;

import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by 赵春定 on 2017/10/20.
 */
public interface StatisticsService {

    /**
     * 单位时间内的统计工单的，生产数量，维修数量
     * 返回，工单号，评审号，产品编号，工单数量，生产数量，维修数量
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    PageInfo<Map<String, Object>> spsBySheet(int pageNum, int pageSize, String sheetPo, Date startTime, Date endTime);

    /**
     * 单位时间内的已工单为条件，统计线别的，生产数量，维修数量
     * 返回，工单号，评审号，产品编号,工单数量，线别，生产数量，维修数量
     *
     * @param sheetPo   工单
     * @param line      线别
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    PageInfo<Map<String, Object>> spsByLine(int pageNum, int pageSize, String sheetPo,String productType, String line, Date startTime, Date endTime);

    PageInfo<Map<String, Object>> spsRateByLine(int pageNum, int pageSize, String sheetPo,String productType, String line, Date startTime, Date endTime);

    /**
     * 单位时间内的已工单为条件，统计站点的，生产数量，维修数量，正在生产数量
     * 返回，工单号，评审号，产品编号,工单数量,站点名称，生产数量，维修数量,正在生产数量
     *
     * @param sheetPoes   工单
     * @param linees      站点
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    List<Map<String, Object>> spsByState(List<String> sheetPoes, List<String> linees, Date startTime, Date endTime,Integer sps);

    /**
     * ，统计站点的，生产数量，维修数量
     * 返回，产品id,评审号，型号名称，产品sn,玻璃sn,板板sn,当期线别名称,当期工站名称，维修数量
     *
     * @return
     */
    PageInfo<Map<String, Object>> spsByProduct(int pageNum, int pageSize, String sheetPo, String cpsn, String blsn, String bbsn);

    PageInfo<Map<String, Object>> queryByProduct(int pageNum, int pageSize, String cpsn);

    PageInfo<Map<String, Object>> queryCountTimeByState(int pageNum, int pageSize, String sheetPo,String productType, String line, String processCode,Date startTime, Date endTime);

    PageInfo<Map<String, Object>> querySninfo(int pageNum, int pageSize, String sheetPo, String cpsn, String sn);

    PageInfo<Map<String, Object>> queryRepair( int pageNum, int pageSize,String sheetPo, String line, String state);
    /**
     * 数据报表
     * @param pageNum
     * @param pageSize
     * @param sheetPo
     * @param stasuss
     * @param productLineCodes
     * @param processCodes
     * @param startTime
     * @param endTime
     * @return
     */
    PageInfo<Map<String, Object>> queryDataStatement(int pageNum, int pageSize, String sheetPo,String[] statuss, String[] productLineCodes, String[] processCodes,Date startTime, Date endTime);
    /**
     * 报表下载
     * @param pageNum
     * @param pageSize
     * @param sheetPo
     * @param stasuss
     * @param productLineCodes
     * @param processCodes
     * @param startTime
     * @param endTime
     * @return
     */
    List<Map<String, Object>> dataStatementExport(String sheetPo,String[] statuss, String[] productLineCodes, String[] processCodes,Date startTime, Date endTime);

}
