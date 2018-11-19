package com.pt.health.service.recommend.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pt.health.msApi.MsApplication;
import com.pt.health.msApi.restApi.RecommendApi;
import com.pt.health.service.recommend.RecommendService;
import com.pt.health.util.EurekaUtil;
import com.pt.health.util.RestUtil;

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

	@Override
	public String getPlansByZhuSu(String ids) {
		// TODO Auto-generated method stub
		String url = EurekaUtil.getInstance().getServiceUrl(MsApplication.MSRECOMMEND, RecommendApi.PLANS);
		Map<String, String> map=new HashMap<String, String>();
		map.put("ids", ids);
		return RestUtil.getResult(url,map);
	}

	@Override
	public String getAllZhuSu() {
		// TODO Auto-generated method stub
		String url = EurekaUtil.getInstance().getServiceUrl(MsApplication.MSRECOMMEND, RecommendApi.ZHUSUS);
		return RestUtil.getResult(url);
	}

	@Override
	public String saveZhuSu(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		String url = EurekaUtil.getInstance().getServiceUrl(MsApplication.MSRECOMMEND, RecommendApi.ZHUSUS);
		return RestUtil.sendAsyncPost(url, null, jsonObject);
	}

}
