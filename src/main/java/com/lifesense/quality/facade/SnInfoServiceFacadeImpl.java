package com.lifesense.quality.facade;

import com.lifesense.quality.base.BaseExample;
import com.lifesense.quality.base.IBaseService;
import com.lifesense.quality.criteria.SnInfoGeneratedCriteria;
import com.lifesense.quality.domain.SnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther zcd
 * @Date
 */
@Service
public class SnInfoServiceFacadeImpl {

	@Autowired
	private IBaseService<SnInfo> snInfoIBaseService;

	public void saveOrUpdate(SnInfo snInfo) {
		snInfoIBaseService.insert(snInfo);
	}

	public List<SnInfo> findByIds(List<Long> ids, String sn) {
		BaseExample<SnInfo> example = new BaseExample<>();
		SnInfoGeneratedCriteria criteria = new SnInfoGeneratedCriteria();
		if (ids != null && !ids.isEmpty()) {
			criteria.andProductIdIn(ids);
		}
		if (!StringUtils.isEmpty(sn)) {
			criteria.andSnEqualTo(sn);
		}
		example.or(criteria);
		return snInfoIBaseService.findByCriteria(example);

	}

	public SnInfo findBysn(String sn) {
		BaseExample<SnInfo> example = new BaseExample<>();
		SnInfoGeneratedCriteria criteria = new SnInfoGeneratedCriteria();
		criteria.andSnEqualTo(sn);
		example.or(criteria);
		List<SnInfo> snes = snInfoIBaseService.findByCriteria(example);
		if (snes != null && !snes.isEmpty()) {
			return snes.get(0);
		}
		return null;
	}

	// 按条件删除
	public int del(String codeType, Long productId) {
		BaseExample<SnInfo> example = new BaseExample<>();
		SnInfoGeneratedCriteria criteria = new SnInfoGeneratedCriteria();
		criteria.andCategoryEqualTo(codeType);
		List<Long> productIds = new ArrayList<>();
		productIds.add(productId);
		criteria.andProductIdIn(productIds);
		example.or(criteria);
		int result = snInfoIBaseService.deleteByCondition(example);
		return result;
	}
}
