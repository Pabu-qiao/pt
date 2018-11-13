package com.pt.recommend.service.impl;

import java.util.Optional;

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
		Optional<FangAn> findById = fangAnDao.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

}
