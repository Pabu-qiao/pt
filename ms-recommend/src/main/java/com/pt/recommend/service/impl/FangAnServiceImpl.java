package com.pt.recommend.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pt.recommend.dao.FangAnDao;
import com.pt.recommend.entity.FangAn;
import com.pt.recommend.service.FangAnService;
import com.ptutil.enums.PtEnum;
import com.ptutil.ptbase.PtResult;

@Service
@Transactional
public class FangAnServiceImpl implements FangAnService {

	@Autowired
	private FangAnDao fangAnDao;
	
	@Override
	public PtResult<FangAn> getById(Integer id) {
		// TODO Auto-generated method stub
		Optional<FangAn> findById = fangAnDao.findById(id);
		if (!findById.isPresent()) {
			return PtResult.build(PtEnum.CODE_03);
		}
		List<FangAn> data=new ArrayList<FangAn>();
		data.add(findById.get());
		return PtResult.ok(data);
	}

}
