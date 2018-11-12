package com.pt.recommend.service;

import java.util.List;

import com.pt.recommend.entity.ZhengZhuang;

public interface ZhengZhuangService {
	
	/**
	 * @Title: getPlanBySymptoms
	 * @Description: 根据症状推荐方案
	 * @param symptoms
	 * @return
	 */
	List<ZhengZhuang> getPlanByZhengZhuang(List<String> symptoms);
	
	/**
	 * @Title: getALLZhengZhuang
	 * @Description: 获得所有症状,并分类
	 * @return
	 */
	List<ZhengZhuang> getAllZhengZhuang();
}
