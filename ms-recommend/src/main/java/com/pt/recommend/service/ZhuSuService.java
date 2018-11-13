package com.pt.recommend.service;

import java.util.List;

import com.pt.common.service.RecommendBaseService;
import com.pt.recommend.entity.ZhuSu;


public interface ZhuSuService extends RecommendBaseService{

	List<ZhuSu> getByZhuSuId(List<Integer> ids);
}
