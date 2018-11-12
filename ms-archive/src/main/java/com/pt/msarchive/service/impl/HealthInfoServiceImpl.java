package com.pt.msarchive.service.impl;

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
import com.pt.msarchive.service.HealthInfoService;

@Service
@Transactional
public class HealthInfoServiceImpl implements HealthInfoService{

	@Autowired
	private HealthInfoDao healthInfoDao;
	
	@Override
	public List<HealthInfo> getAll() {
		// TODO Auto-generated method stub
		return healthInfoDao.findAll();
	}
	
	@Override
	public HealthInfo getById(String customerId) {
		// TODO Auto-generated method stub
		Optional<HealthInfo> findById = healthInfoDao.findById(customerId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}
	
	@Override
	public HealthInfo add(String customerId, JSONObject info) {
		// TODO Auto-generated method stub
		HealthInfo entity=new HealthInfo();
		entity.setCustomerId(customerId);
		Map<String, Object> map=new HashMap<String, Object>();
		for (String key : info.keySet()) {
			map.put(key, info.get(key));
		}
		entity.setInfo(JSON.toJSONString(map));
		return healthInfoDao.save(entity);
	}
	
	@Override
	public HealthInfo update(String customerId, JSONObject info) {
		// TODO Auto-generated method stub
		Optional<HealthInfo> findById=healthInfoDao.findById(customerId);
		if (findById.isPresent()) {
			HealthInfo entity= findById.get();
			Map<String, Object> map=JSON.parseObject(entity.getInfo());
			for (String key : info.keySet()) {
				map.put(key, info.get(key));
			}
			entity.setInfo(JSON.toJSONString(map));
			return entity;
		}
		return null;
	}

}
