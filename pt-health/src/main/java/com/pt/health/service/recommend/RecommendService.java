package com.pt.health.service.recommend;

import java.util.List;

public interface RecommendService {

	/**
	 * @Title: getAllZhengZhuangs
	 * @Description: 获得所有症状
	 * @return
	 */
	String getAllZhengZhuangs();
	
	/**
	 * @Title: getRecommendPlan
	 * @Description: 根据症状获得推荐方案
	 * @param zhengZhuangs
	 * @return
	 */
	String getRecommendPlan(String zhengZhuangs);
	
	/**
	 * @Title: getPlansByZhuSu
	 * @Description: 根据主诉，获得推荐方案（定义好的方案）
	 * @param ids
	 * @return
	 */
	String getPlansByZhuSu(String ids);
}
