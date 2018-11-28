package com.pt.msarchive.service;

import com.alibaba.fastjson.JSONObject;
import com.pt.msarchive.entity.HealthInfo;
import com.pt.msarchive.model.PtResult;

/**
 * @ClassName: HealthInfoService
 * @Description: 用户健康信息服务
 * @author 谯雕
 * @date 2018年10月23日
 *
 */
public interface HealthInfoService extends BaseService{

	/**
	 * @Title: getAll
	 * @Description: 获得所有用户的健康信息
	 * @return
	 */
	PtResult<HealthInfo> getAll();
	
	/**
	 * @Title: getById
	 * @Description: 根据客户id获取用户的健康信息
	 * @param customerId
	 * @return
	 */
	PtResult<HealthInfo> getById(String customerId);
	
	/**
	 * @Title: add
	 * @Description: 新增用户健康信息
	 * @param customerId
	 * @param info
	 * @return
	 */
	PtResult<HealthInfo> add(String customerId,JSONObject info);
	
	/**
	 * @Title: update
	 * @Description: 根据id，更新客户健康信息
	 * @param customerId
	 * @param info
	 */
	PtResult<HealthInfo> update(String customerId,JSONObject info);
	
}
