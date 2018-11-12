package com.pt.recommend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pt.common.util.ResponseUtil;
import com.pt.recommend.service.IZhengZhuangService;

@RestController
@CrossOrigin
public class RecommendController {

	@Autowired
	private IZhengZhuangService iZhengZhuangService;
	
	
	@GetMapping("/recommends")
	public ResponseEntity<String> getRecommend(@RequestParam String params) {
		params=params.replace("[", "").replace("]", "").replace("\"", "");
		String[] split = params.split(",");
		List<String> zhengzhuangs = Arrays.asList(split);
		return ResponseUtil.toJson(iZhengZhuangService.getPlanByZhengZhuang(zhengzhuangs));
	}
	
	@GetMapping("/zhengZhuangs")
	public ResponseEntity<String> getAllZhengZhuang(){
		return ResponseUtil.toJson(iZhengZhuangService.getAllZhengZhuang());
	}
}
