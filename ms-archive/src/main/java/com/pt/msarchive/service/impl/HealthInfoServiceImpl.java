package com.pt.msarchive.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pt.msarchive.dao.HealthInfoDao;
import com.pt.msarchive.entity.HealthInfo;
import com.pt.msarchive.model.PtResult;
import com.pt.msarchive.service.HealthInfoService;
import com.pt.msarchive.util.PtEnum;

@Service
@Transactional
public class HealthInfoServiceImpl implements HealthInfoService{

	@Autowired
	private HealthInfoDao healthInfoDao;
	
	@Override
	public PtResult<HealthInfo> getAll() {
		// TODO Auto-generated method stub
		List<HealthInfo> all = healthInfoDao.findAll();
		if (all==null||all.size()<1) {
			return PtResult.build(PtEnum.CODE_03);
		}
		return PtResult.ok(all);
	}
	
	@Override
	public PtResult<HealthInfo> getById(String customerId) {
		// TODO Auto-generated method stub
		Optional<HealthInfo> findById = healthInfoDao.findById(customerId);
		if (!findById.isPresent()) {
			return PtResult.build(PtEnum.CODE_03);
		}
		List<HealthInfo> data=new ArrayList<HealthInfo>();
		data.add(findById.get());
		return PtResult.ok(data);
	}
	
	@Override
	public PtResult<HealthInfo> add(String customerId, JSONObject info) {
		// TODO Auto-generated method stub
		HealthInfo entity=new HealthInfo();
		entity.setCustomerId(customerId);
		Map<String, Object> map=new HashMap<String, Object>();
		for (String key : info.keySet()) {
			map.put(key, info.get(key));
		}
		entity.setInfo(JSON.toJSONString(map));
		HealthInfo save = healthInfoDao.save(entity);
		if (save==null) {
			return PtResult.build(PtEnum.CODE_04);
		}
		List<HealthInfo> data=new ArrayList<HealthInfo>();
		data.add(save);
		return PtResult.ok(data);
	}
	
	@Override
	public PtResult<HealthInfo> update(String customerId, JSONObject info) {
		// TODO Auto-generated method stub
		Optional<HealthInfo> findById=healthInfoDao.findById(customerId);
		if (!findById.isPresent()) {
			return PtResult.build(PtEnum.CODE_03);
		}
		
		HealthInfo entity = findById.get();
		Map<String, Object> map=JSON.parseObject(entity.getInfo());
		for (String key : info.keySet()) {
			map.put(key, info.get(key));
		}
		entity.setInfo(JSON.toJSONString(map));
		
		List<HealthInfo> data=new ArrayList<HealthInfo>();
		data.add(entity);
		return PtResult.ok(data);
	}

}
