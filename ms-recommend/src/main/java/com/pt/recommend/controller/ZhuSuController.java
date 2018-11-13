package com.pt.recommend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pt.common.util.ResponseUtil;
import com.pt.recommend.service.ZhuSuService;

@RestController
public class ZhuSuController {

	@Autowired
	private ZhuSuService zhuSuService;
	
	@GetMapping("/plans")
	public ResponseEntity<String> getPlanByZhuSus(@RequestParam String id){
		id=id.replace("[", "").replace("]", "").replace("\"", "");
		String[] split = id.split(",");
		List<Integer> ids=new ArrayList<Integer>();
		for (String str : split) {
			ids.add(new Integer(str));
		}
		return ResponseUtil.toJson(zhuSuService.getPlanByZhuSuId(ids));
	}
	
	@GetMapping("/zhuSus")
	public ResponseEntity<String> getAllZhuSu(){
		return ResponseUtil.toJson(zhuSuService.getAllZhuSu());
	}
}
