package com.pt.recommend.service;

import java.util.List;

import com.pt.recommend.entity.ZhengZhuang;
import com.ptutil.ptbase.PtBaseService;
import com.ptutil.ptbase.PtResult;

public interface ZhengZhuangService extends PtBaseService{
	
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
