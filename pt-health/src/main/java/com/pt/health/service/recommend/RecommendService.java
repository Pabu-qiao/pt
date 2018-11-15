package com.pt.health.service.recommend;

import com.alibaba.fastjson.JSONObject;

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
	
	/**
	 * @Title: getAllZhuSu
	 * @Description: 查询所有主诉
	 */
	String getAllZhuSu();
	
	/**
	 * @Title: saveZhuSu
	 * @Description: 保存一条新的主诉
	 * @param jsonObject
	 * @return
	 */
	String saveZhuSu(JSONObject jsonObject);
}
