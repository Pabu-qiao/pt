package com.pt.recommend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pt.recommend.dao.ZhuSuDao;
import com.pt.recommend.entity.ZhuSu;
import com.pt.recommend.service.ZhuSuService;

@Service
public class ZhuSuServiceImpl implements ZhuSuService {

	@Autowired
	private ZhuSuDao zhuSuDao;
	
	@Override
	public List<ZhuSu> getByZhuSuId(List<Integer> ids) {
		// TODO Auto-generated method stub
		return zhuSuDao.findByIdIn(ids);
	}

}
