package com.pt.recommend.service;

import com.pt.recommend.entity.FangAn;
import com.ptutil.ptbase.PtResult;

public interface FangAnService {
	PtResult<FangAn> getById(Integer id);
}
