package com.pt.msarchive.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.pt.msarchive.entity.HealthService;

/**
 * @ClassName: HealthServiceService
 * @Description: 用户服务记录的服务接口
 * @author 谯雕
 * @date 2018年10月24日
 *
 */
public interface HealthServiceService extends ArchiveBaseService{

	/**
	 * @Title: getByDate
	 * @Description: 根据id和起止时间，查询用户在指定时间段内的服务记录
	 * @param customerId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	List<HealthService> getByDate(String customerId,String beginDate,String endDate);

	/**
	 * @Title: saveRecord
	 * @Description: 保存用户服务记录
	 * @param customerId
	 * @param info
	 * @return
	 */
	HealthService saveRecord(String customerId, JSONObject info);
	
	

}
