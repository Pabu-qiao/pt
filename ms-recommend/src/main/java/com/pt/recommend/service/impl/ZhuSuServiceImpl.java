package com.pt.recommend.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	public Set<FangAn> getPlanByZhuSuId(List<Integer> ids) {
		// TODO Auto-generated method stub
		List<ZhuSu> list = zhuSuDao.findByIdIn(ids);
		Set<FangAn> fangAns=new HashSet<FangAn>();
		for (ZhuSu zhuSu : list) {
			fangAns.add(zhuSu.getFangAn());
		}
		return fangAns;
	}

	@Override
	public List<ZhuSu> getAllZhuSu() {
		// TODO Auto-generated method stub
		List<ZhuSu> findAll = zhuSuDao.findAll();
		List<ZhuSu> list=new ArrayList<ZhuSu>();
		for (ZhuSu zhuSu : findAll) {
			ZhuSu clone = zhuSu.clone();
			clone.setFangAn(null);
			list.add(clone);
		}
		return list;
	}

}
