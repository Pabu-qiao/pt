package com.pt.msarchive.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pt.msarchive.dao.HealthServiceDao;
import com.pt.msarchive.entity.HealthService;
import com.pt.msarchive.service.HealthServiceService;

@Service
public class HealthServiceServiceImpl implements HealthServiceService {
	
	private final SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private HealthServiceDao healthServiceDao;

	@Override
	public List<HealthService> getByDate(String customerId, String beginDate, String endDate) {
		// TODO Auto-generated method stub
		List<HealthService> list=null;
		try {
			list=healthServiceDao.findByCustomerIdAndServiceDateGreaterThanEqualAndServiceDateLessThanEqual(customerId, sf.parse(beginDate), sf.parse(endDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public HealthService saveRecord(String customerId, JSONObject info) {
		// TODO Auto-generated method stub
		HealthService entity=new HealthService();
		entity.setCustomerId(customerId);
		entity.setService(JSON.toJSONString(info));
		return healthServiceDao.save(entity);
	}


}
