package com.pt.recommend.service;

import java.util.List;

import com.pt.recommend.entity.ZhuSu;


public interface ZhuSuService {

	List<ZhuSu> getByZhuSuId(List<Integer> ids);
}
