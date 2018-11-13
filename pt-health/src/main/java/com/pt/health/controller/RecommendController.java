package com.pt.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pt.common.util.ResponseUtil;
import com.pt.health.service.recommend.RecommendService;

@RestController
@CrossOrigin
public class RecommendController {

	@Autowired
	private RecommendService recommendService;
	
	@GetMapping("/zhengZhuangs")
	public ResponseEntity<String> getAllZhengZhuangs(){
		return ResponseUtil.toJson(recommendService.getAllZhengZhuangs());
	}
	
	@GetMapping("/recommenPlans")
	public ResponseEntity<String> recommendPlan(@RequestParam String zhengZhuangs){
		String temp = recommendService.getRecommendPlan(zhengZhuangs);
		return ResponseUtil.toJson(temp);
	}
	
	@GetMapping("/plans")
	public ResponseEntity<String> getPlansByZhuSu(@RequestParam String ids){
		String temp = recommendService.getPlansByZhuSu(ids);
		return ResponseUtil.toJson(temp);
	}
	
	@GetMapping("/zhuSus")
	public ResponseEntity<String> getAllZhuSu(){
		String temp = recommendService.getAllZhuSu();
		return ResponseUtil.toJson(temp);
	}
	
	@PostMapping("/zhuSus")
	public ResponseEntity<String> saveZhuSu(@RequestBody JSONObject jsonObject){
		String temp = recommendService.saveZhuSu(jsonObject);
		return ResponseUtil.toJson(temp);
	}
}
