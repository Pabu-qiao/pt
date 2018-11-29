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
import com.pt.msarchive.dao.HealthRecordDao;
import com.pt.msarchive.entity.HealthRecord;
import com.pt.msarchive.service.HealthRecordService;
import com.ptutil.enums.PtEnum;
import com.ptutil.ptbase.PtResult;

@Service
@Transactional
public class HealthRecordServiceImpl implements HealthRecordService {

	private final DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	@Autowired
	private HealthRecordDao healthRecordDao;
	
	@Override
	public PtResult<HealthRecord> getByDate(String customerId, String beginDate, String endDate) {
		// TODO Auto-generated method stub
		List<HealthRecord> list = null;
		try {
			list = healthRecordDao.findByCustomerIdAndRecordDateGreaterThanEqualAndRecordDateLessThanEqual(customerId, LocalDate.parse(beginDate, formatter), LocalDate.parse(endDate,formatter));
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
	public PtResult<HealthRecord> getAll(String customerId) {
		// TODO Auto-generated method stub
		List<HealthRecord> all = healthRecordDao.findAll();
		if (all==null||all.size()<1) {
			return PtResult.build(PtEnum.CODE_03);
		}
		return PtResult.ok(all);
	}

	@Override
	public PtResult<HealthRecord> saveRecord(String customerId, JSONObject info) {
		// TODO Auto-generated method stub
		HealthRecord entity=new HealthRecord();
		entity.setCustomerId(customerId);
		entity.setData(JSON.toJSONString(info));
		HealthRecord save = healthRecordDao.save(entity);
		if (save==null) {
			return PtResult.build(PtEnum.CODE_04);
		}
		
		List<HealthRecord> data=new ArrayList<HealthRecord>();
		data.add(entity);
		return PtResult.ok(data);
	}

}
