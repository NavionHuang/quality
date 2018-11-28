package com.lifesense.quality.facade;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.base.BaseExample;
import com.lifesense.quality.base.IBaseService;
import com.lifesense.quality.criteria.ProductLineGeneratedCriteria;
import com.lifesense.quality.domain.ProductLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther zcd
 * @Date
 */
@Service
public class ProductLineServiceFacadeImpl {

    @Autowired
    private IBaseService<ProductLine> productLineIBaseService;

    /**
     * 保存或者更新，存在id则更新，否则插入
     *
     * @param productLine
     * @return
     */
    public int saveOrUpdate(ProductLine productLine) {
        if (productLine.getId()!=null){
          return   productLineIBaseService.edit(productLine);
        }else{
           return  productLineIBaseService.insert(productLine);
        }
    }

    /**
     * 根据code 查找，无返回null
     *
     * @param code
     * @return
     */
    public ProductLine findProductLineByCode(String code) {
        BaseExample<ProductLine> example = new BaseExample<>();
        ProductLineGeneratedCriteria criteria = new ProductLineGeneratedCriteria();
        criteria.andCodeEqualTo(code);
        criteria.andValidEqualTo(0);
        example.or(criteria);
        List<ProductLine> productLines = productLineIBaseService.findByCriteria(example);
        if (productLines!=null && !productLines.isEmpty()){
            return productLines.get(0);
        }
        return null;
    }

    /**
     * 分页查询
     *
     * @param record
     * @param pageNum
     * @param limit
     * @return
     */
    public PageInfo<ProductLine> getPageData(ProductLine record, int pageNum, int limit) {
        return productLineIBaseService.queryPage(record, pageNum, limit);

    }


    public List<ProductLine> findAll() {
        BaseExample<ProductLine> example = new BaseExample<>();
        ProductLineGeneratedCriteria criteria = new ProductLineGeneratedCriteria();
        criteria.andValidEqualTo(0);
        example.or(criteria);
        return productLineIBaseService.findByCriteria(example);
    }

    public ProductLine findById(Long id) {
      return    productLineIBaseService.fetchById(id);
    }
}
