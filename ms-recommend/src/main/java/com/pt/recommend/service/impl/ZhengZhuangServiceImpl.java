package com.pt.recommend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pt.recommend.dao.ZhengZhuangDao;
import com.pt.recommend.entity.ZhengZhuang;
import com.pt.recommend.service.IZhengZhuangService;

@Service
@Transactional
public class ZhengZhuangServiceImpl implements IZhengZhuangService {

	@Autowired
	private ZhengZhuangDao dao;

	@Override
	public List<ZhengZhuang> getPlanByZhengZhuang(List<String> zhengzhuangs) {
		// TODO Auto-generated method stub
		return dao.findByZhengZhuangIn(zhengzhuangs);
	}

	@Override
	public List<ZhengZhuang> getAllZhengZhuang() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
}
