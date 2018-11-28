package com.lifesense.quality.facade;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.base.BaseExample;
import com.lifesense.quality.base.IBaseService;
import com.lifesense.quality.criteria.ProductTypeGeneratedCriteria;
import com.lifesense.quality.domain.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther zcd
 * @Date
 */
@Service
public class ProductTypeServiceFacadeImpl {

    @Autowired
    private IBaseService<ProductType> productTypeIBaseService;

    /**
     * 根据id查找
     *
     * @param productTypeId
     * @return
     */
    public ProductType findProductTypeById(Long productTypeId) {
        return productTypeIBaseService.fetchById(productTypeId);
    }

    /**
     * 根据code 查找，没有数据返回null
     *
     * @param code
     * @return
     */
    public ProductType findProductTypeByCode(String code) {
        BaseExample<ProductType> example = new BaseExample<ProductType>();
        ProductTypeGeneratedCriteria criteria = new ProductTypeGeneratedCriteria();
        criteria.andCodeEqualTo(code);
        example.or(criteria);
        List<ProductType> productTypes = productTypeIBaseService.findByCriteria(example);
        if (productTypes != null && !productTypes.isEmpty()) {
            return productTypes.get(0);
        }
        return null;
    }

    /**
     * 根据id判断插入或者更新
     *
     * @param productType
     * @return
     */
    public int saveOrUpdate(ProductType productType) {
        if (productType.getId() != null) {
            return productTypeIBaseService.edit(productType);
        } else {
            return productTypeIBaseService.insert(productType);
        }
    }

    /**
     * 查找所有效性的类型
     *
     * @return
     */
    public List<ProductType> findValidProductType() {
        BaseExample<ProductType> example = new BaseExample<>();
        ProductTypeGeneratedCriteria criteria = new ProductTypeGeneratedCriteria();
        criteria.andValidEqualTo(0);
        example.or(criteria);
        return productTypeIBaseService.findByCriteria(example);
    }

    /**
     * 分页查询
     *
     * @param record
     * @param pageNum
     * @param limit
     * @return
     */
    public PageInfo<ProductType> getPageData(ProductType record, int pageNum, int limit) {
        return productTypeIBaseService.queryPage(record, pageNum, limit);
    }


}
