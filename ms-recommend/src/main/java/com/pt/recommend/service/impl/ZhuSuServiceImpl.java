package com.pt.recommend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pt.recommend.dao.ZhuSuDao;
import com.pt.recommend.entity.FangAn;
import com.pt.recommend.entity.ZhuSu;
import com.pt.recommend.model.PtResult;
import com.pt.recommend.service.ZhuSuService;
import com.pt.recommend.util.PtEnum;

@Service
@Transactional
public class ZhuSuServiceImpl implements ZhuSuService {

	@Autowired
	private ZhuSuDao zhuSuDao;
	
	@Override
	public PtResult<ZhuSu> getPlanByZhuSuId(List<Integer> ids) {
		// TODO Auto-generated method stub
		List<ZhuSu> data = zhuSuDao.findByIdIn(ids);
		if (data==null||data.size()<1) {
			return PtResult.build(PtEnum.CODE_03);
		}
		return PtResult.ok(data);
	}
	
	@Override
	public PtResult<ZhuSu> getPlanByZhuSus(List<String> names) {
		// TODO Auto-generated method stub
		List<ZhuSu> data = zhuSuDao.findBynameIn(names);
		if (data==null||data.size()<1) {
			return PtResult.build(PtEnum.CODE_03);
		}
		return PtResult.ok(data);
	}

	@Override
	public PtResult<ZhuSu> getAllZhuSu() {
		// TODO Auto-generated method stub
		List<ZhuSu> data = zhuSuDao.findAll();
		if (data==null||data.size()<1) {
			return PtResult.build(PtEnum.CODE_03);
		}
		return PtResult.ok(data);
	}

	@Override
	public PtResult<ZhuSu> saveZhuSu(ZhuSu zhuSu, FangAn fangAn) {
		// TODO Auto-generated method stub
		zhuSu.setFangAn(fangAn);
		ZhuSu save = zhuSuDao.save(zhuSu);
		if (save==null) {
			return PtResult.build(PtEnum.CODE_03);
		}
		List<ZhuSu> data=new ArrayList<ZhuSu>();
		data.add(save);
		return PtResult.ok(data);
	}


}
