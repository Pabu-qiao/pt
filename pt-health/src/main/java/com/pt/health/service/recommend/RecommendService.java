package com.pt.health.service.recommend;

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
}
