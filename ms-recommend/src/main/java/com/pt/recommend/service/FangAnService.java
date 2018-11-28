package com.pt.recommend.service;

import com.pt.recommend.entity.FangAn;
import com.pt.recommend.model.PtResult;

public interface FangAnService {
	PtResult<FangAn> getById(Integer id);
}
