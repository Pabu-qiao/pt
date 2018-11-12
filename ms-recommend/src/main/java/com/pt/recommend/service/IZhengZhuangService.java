package com.pt.recommend.service;

import java.util.List;
import java.util.Map;

import com.pt.recommend.entity.ZhengZhuang;
import com.pt.recommend.model.Plan;

public interface IZhengZhuangService {
	
	/**
	 * @Title: getPlanBySymptoms
	 * @Description: 根据症状推荐方案
	 * @param symptoms
	 * @return
	 */
	List<Plan> getPlanByZhengZhuang(List<String> symptoms);
	
	/**
	 * @Title: getALLZhengZhuang
	 * @Description: 获得所有症状,并分类
	 * @return
	 */
	Map<String, List<ZhengZhuang>> getAllZhengZhuang();
}
