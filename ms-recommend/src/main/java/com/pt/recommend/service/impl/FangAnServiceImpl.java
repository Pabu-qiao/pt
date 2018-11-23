package com.pt.recommend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pt.recommend.dao.FangAnDao;
import com.pt.recommend.entity.FangAn;
import com.pt.recommend.service.FangAnService;

@Service
@Transactional
public class FangAnServiceImpl implements FangAnService {

	@Autowired
	private FangAnDao fangAnDao;
	
	@Override
	public FangAn getById(Integer id) {
		// TODO Auto-generated method stub
		return fangAnDao.findById(id).orElse(null);
	}

}
