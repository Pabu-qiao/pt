package com.pt.msarchive.service;

import com.alibaba.fastjson.JSONObject;
import com.pt.msarchive.entity.HealthRecord;
import com.ptutil.ptbase.PtBaseService;
import com.ptutil.ptbase.PtResult;

public interface HealthRecordService extends PtBaseService{

	PtResult<HealthRecord> getAll(String customerId );
	
	
	/**
	 * @Title: getByDate
	 * @Description: 根据id和起止时间，查询用户在指定时间段内的健康记录
	 * @param customerId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	PtResult<HealthRecord> getByDate(String customerId,String beginDate,String endDate);
	
	/**
	 * @Title: saveRecord
	 * @Description: 新增一条记录
	 * @param customerId
	 * @param dataJson
	 * @return
	 */
	PtResult<HealthRecord> saveRecord(String customerId,JSONObject info);
	
}
