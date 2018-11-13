package com.pt.recommend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pt.recommend.dao.ZhuSuDao;
import com.pt.recommend.entity.FangAn;
import com.pt.recommend.entity.ZhuSu;
import com.pt.recommend.service.ZhuSuService;

@Service
@Transactional
public class ZhuSuServiceImpl implements ZhuSuService {

	@Autowired
	private ZhuSuDao zhuSuDao;
	
	@Override
	public List<ZhuSu> getPlanByZhuSuId(List<Integer> ids) {
		// TODO Auto-generated method stub
		return zhuSuDao.findByIdIn(ids);
	}

	@Override
	public List<ZhuSu> getAllZhuSu() {
		// TODO Auto-generated method stub
		return zhuSuDao.findAll();
	}

	@Override
	public ZhuSu saveZhuSu(ZhuSu zhuSu, FangAn fangAn) {
		// TODO Auto-generated method stub
		zhuSu.setFangAn(fangAn);
		return zhuSuDao.save(zhuSu);
	}

}
