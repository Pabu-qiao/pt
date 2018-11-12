package com.pt.health.service.recommend.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pt.common.msApi.MsApplication;
import com.pt.common.msApi.restApi.RecommendApi;
import com.pt.common.util.EurekaUtil;
import com.pt.common.util.RestUtil;
import com.pt.health.service.recommend.RecommendService;

@Service
public class RecommendServiceImpl implements RecommendService {

	@Override
	public String getAllZhengZhuangs() {
		// TODO Auto-generated method stub
		String url = EurekaUtil.getInstance().getServiceUrl(MsApplication.MSRECOMMEND, RecommendApi.ZHENGZHUANGS);
		return RestUtil.getResult(url);
	}

	@Override
	public String getRecommendPlan(String zhengZhuangs) {
		// TODO Auto-generated method stub
		String url = EurekaUtil.getInstance().getServiceUrl(MsApplication.MSRECOMMEND, RecommendApi.RECOMMENDS);
		Map<String, String> map=new HashMap<String, String>();
		map.put("zhengZhuangs", zhengZhuangs);
		return RestUtil.getResult(url, map);
	}

}