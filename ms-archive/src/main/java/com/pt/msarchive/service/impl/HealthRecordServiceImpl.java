package com.pt.msarchive.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pt.msarchive.dao.HealthRecordDao;
import com.pt.msarchive.entity.HealthRecord;
import com.pt.msarchive.service.HealthRecordService;

@Service
public class HealthRecordServiceImpl implements HealthRecordService {

	private final SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private HealthRecordDao healthRecordDao;
	
	@Override
	public List<HealthRecord> getByDate(String customerId, String beginDate, String endDate) {
		// TODO Auto-generated method stub
		List<HealthRecord> list = null;
		try {
			list = healthRecordDao.findByCustomerIdAndRecordDateGreaterThanEqualAndRecordDateLessThanEqual(customerId, sf.parse(beginDate), sf.parse(endDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<HealthRecord> getAll(String customerId) {
		// TODO Auto-generated method stub
		return healthRecordDao.findAll();
	}

	@Override
	@Transactional
	public HealthRecord saveRecord(String customerId, JSONObject info) {
		// TODO Auto-generated method stub
		HealthRecord entity=new HealthRecord();
		entity.setCustomerId(customerId);
		entity.setData(JSON.toJSONString(info));
		return healthRecordDao.save(entity);
	}

}
