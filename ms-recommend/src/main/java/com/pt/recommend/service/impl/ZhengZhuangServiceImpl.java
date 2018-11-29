package com.pt.recommend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pt.recommend.dao.ZhengZhuangDao;
import com.pt.recommend.entity.ZhengZhuang;
import com.pt.recommend.service.ZhengZhuangService;
import com.ptutil.ptbase.PtResult;

@Service
@Transactional
public class ZhengZhuangServiceImpl implements ZhengZhuangService {

	@Autowired
	private ZhengZhuangDao dao;

	@Override
	public PtResult<ZhengZhuang> getPlanByZhengZhuang(List<String> zhengzhuangs) {
		// TODO Auto-generated method stub
		return PtResult.ok(dao.findByZhengZhuangIn(zhengzhuangs));
	}

	@Override
	public PtResult<ZhengZhuang> getAllZhengZhuang() {
		// TODO Auto-generated method stub
		return PtResult.ok(dao.findAll());
	}
}
