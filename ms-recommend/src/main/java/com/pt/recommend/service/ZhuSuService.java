package com.pt.recommend.service;

import java.util.List;
import java.util.Set;

import com.pt.common.service.RecommendBaseService;
import com.pt.recommend.entity.FangAn;
import com.pt.recommend.entity.ZhuSu;


public interface ZhuSuService extends RecommendBaseService{

	/**
	 * @Title: getPlanByZhuSuId
	 * @Description: 根据主诉，获得方案
	 * @param ids
	 * @return
	 */
	Set<FangAn> getPlanByZhuSuId(List<Integer> ids);
	
	/**
	 * @Title: getAllZhuSu
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 */
	List<ZhuSu> getAllZhuSu();
}
