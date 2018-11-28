package com.pt.recommend.service;

import java.util.List;

import com.pt.recommend.entity.FangAn;
import com.pt.recommend.entity.ZhuSu;
import com.pt.recommend.model.PtResult;

public interface ZhuSuService extends BaseService {

	/**
	 * @Title: getPlanByZhuSuId
	 * @Description: 根据主诉，获得方案
	 * @param ids
	 * @return
	 */
	PtResult<ZhuSu> getPlanByZhuSuId(List<Integer> ids);
	
	/**
	 * @Title: getPlanByZhuSus
	 * @Description: 根据主诉，获得方案
	 * @param name
	 * @return
	 */
	PtResult<ZhuSu> getPlanByZhuSus(List<String> names);

	/**
	 * @Title: getAllZhuSu
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 */
	PtResult<ZhuSu> getAllZhuSu();

	/**
	 * @Title: saveZhuSu
	 * @Description: 保存一条新的主诉
	 * @param zhuSu
	 * @param fangAn
	 * @return
	 */
	PtResult<ZhuSu> saveZhuSu(ZhuSu zhuSu, FangAn fangAn);
}
