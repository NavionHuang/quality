package com.lifesense.quality.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by 赵春定 on 2017/10/20.
 */
public interface StatisticsDao {

    List<Map<String, Object>> spsBySheet(@Param("map") Map<String, Object> paramMap);

    List<Map<String, Object>> spsByLine(@Param("map") Map<String, Object> paramMap);

    List<Map<String, Object>> spsByState(@Param("map") Map<String, Object> paramMap);

    List<Map<String, Object>> spsRateByLine(@Param("map") Map<String, Object> paramMap);

    /**
     *统计站点产出产品刷次数
     * @param paramMap sheet_po，product_type_code，product_line_code，process_code
     * @return
     */
    List<Map<String, Object>> queryCountTimeByState(@Param("map") Map<String, Object> paramMap);

    /**
     *
     * @param paramMap sheet_po，cpsn，product_line_code，product_type_code
     * @return
     */
    List<Map<String, Object>> queryByProduct(@Param("map") Map<String, Object> paramMap);

    /**
     * 产品信息数量
     * @param paramMap sheet_po，cpsn，sn
     * @return
     */
    List<Map<String, Object>> querySninfo(@Param("map") Map<String, Object> paramMap);
    /**
     * 产品维修信息
     * @param paramMap sheet_po，process_code，product_line_code
     * @return
     */
    List<Map<String, Object>> queryRepair(@Param("map") Map<String, Object> paramMap);
    /**
     * 数据报表
     * @param paramMap
     * @return
     */
    List<Map<String, Object>> queryDataStatement(@Param("map") Map<String, Object> paramMap);
}
