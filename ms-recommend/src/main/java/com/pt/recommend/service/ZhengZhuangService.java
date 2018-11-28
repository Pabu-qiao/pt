package com.pt.recommend.service;

import java.util.List;

import com.pt.recommend.entity.ZhengZhuang;
import com.pt.recommend.model.PtResult;

public interface ZhengZhuangService extends BaseService{
	
	/**
	 * @Title: getPlanBySymptoms
	 * @Description: 根据症状推荐方案
	 * @param symptoms
	 * @return
	 */
	PtResult<ZhengZhuang> getPlanByZhengZhuang(List<String> symptoms);
	
	/**
	 * @Title: getALLZhengZhuang
	 * @Description: 获得所有症状,并分类
	 * @return
	 */
	PtResult<ZhengZhuang> getAllZhengZhuang();
}
