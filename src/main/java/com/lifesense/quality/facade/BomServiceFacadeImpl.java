package com.lifesense.quality.facade;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.base.BaseExample;
import com.lifesense.quality.base.IBaseService;
import com.lifesense.quality.criteria.BomGeneratedCriteria;
import com.lifesense.quality.domain.BadCode;
import com.lifesense.quality.domain.Bom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther zcd
 * @Date
 */
@Service
public class BomServiceFacadeImpl {

	@Autowired
	private IBaseService<Bom> bomIBaseService;

	public List<Bom> findBomByProductTypeCode(String productTypeCode, String code) {
		BaseExample<Bom> example = new BaseExample<>();
		BomGeneratedCriteria criteria = new BomGeneratedCriteria();
		criteria.andProductTypeCodeEqualTo(productTypeCode);
		criteria.andCodeEqualTo(code);
		example.or(criteria);
		return bomIBaseService.findByCriteria(example);
	}

	/*public void save(Bom bom) {
		bomIBaseService.insert(bom);
	}*/

	/**
	 * 根据产品类型,物料类型,物料代码查询
	 * 
	 * @param productTypeCode
	 * @param name
	 * @param code
	 * @return
	 */
	public Bom findBomByExample(String productTypeCode, String name, String code) {
		BaseExample<Bom> example = new BaseExample<>();
		BomGeneratedCriteria criteria = new BomGeneratedCriteria();
		criteria.andProductTypeCodeEqualTo(productTypeCode);
		criteria.andCodeEqualTo(code);
		criteria.andNameEqualTo(name);
		example.or(criteria);
		List<Bom> boms = bomIBaseService.findByCriteria(example);
		return boms != null && !boms.isEmpty() ? boms.get(0) : null;
	}

	/**
	 * 根据id 查询
	 *
	 * @param id
	 * @return
	 */
	public Bom findBadcodById(Long id) {
		return bomIBaseService.fetchById(id);
	}

	public int saveOrUpdate(Bom entity) {
		if (entity.getId() == null) {
			return bomIBaseService.insert(entity);
		} else {
			return bomIBaseService.edit(entity);
		}
	}

	/**
	 * 分页查询
	 * 
	 * @param bom
	 * @param pageNum
	 * @param limit
	 * @return
	 */
	public PageInfo<Bom> getPageData(Bom bom, int pageNum, int limit) {
		return bomIBaseService.queryPage(bom, pageNum, limit);
	}
}
