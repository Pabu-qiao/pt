package com.pt.msarchive.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pt.msarchive.dao.HealthServiceDao;
import com.pt.msarchive.entity.HealthService;
import com.pt.msarchive.service.HealthServiceService;
import com.ptutil.enums.PtEnum;
import com.ptutil.ptbase.PtResult;

@Service
@Transactional
public class HealthServiceServiceImpl implements HealthServiceService {
	
	private final DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Autowired
	private HealthServiceDao healthServiceDao;

	@Override
	public PtResult<HealthService> getByDate(String customerId, String beginDate, String endDate) {
		// TODO Auto-generated method stub
		List<HealthService> list=null;
		try {
			list=healthServiceDao.findByCustomerIdAndServiceDateGreaterThanEqualAndServiceDateLessThanEqual(customerId, LocalDate.parse(beginDate,formatter), LocalDate.parse(endDate,formatter));
		} catch (DateTimeParseException e) {
			// TODO: handle exception
			e.printStackTrace();
			return PtResult.build(PtEnum.CODE_05);
		}
		if (list==null||list.size()<1) {
			return PtResult.build(PtEnum.CODE_03);
		}
		return PtResult.ok(list);
	}
	
	@Override
	public PtResult<HealthService> saveRecord(String customerId, JSONObject info) {
		// TODO Auto-generated method stub
		HealthService entity=new HealthService();
		entity.setCustomerId(customerId);
		entity.setService(JSON.toJSONString(info));
		HealthService save = healthServiceDao.save(entity);
		
		if (save==null) {
			return PtResult.build(PtEnum.CODE_04);
		}
		
		List<HealthService> data=new ArrayList<HealthService>();
		data.add(entity);
		return PtResult.ok(data);
	}


}
