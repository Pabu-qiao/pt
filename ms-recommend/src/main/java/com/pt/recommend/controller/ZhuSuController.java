package com.pt.recommend.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pt.common.util.ResponseUtil;
import com.pt.recommend.entity.FangAn;
import com.pt.recommend.entity.ZhuSu;
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
		
		List<ZhuSu> list = zhuSuService.getPlanByZhuSuId(ids);
		Set<FangAn> fangAns=new HashSet<FangAn>();
		for (ZhuSu zhuSu : list) {
			fangAns.add(zhuSu.getFangAn());
		}
		
		return ResponseUtil.toJson(fangAns);
	}
	
	@GetMapping("/zhuSus")
	public ResponseEntity<String> getAllZhuSu(){
		List<ZhuSu> list = zhuSuService.getAllZhuSu();
		for (ZhuSu zhuSu : list) {
			zhuSu.setFangAn(null);
		}
		return ResponseUtil.toJson(list);
	}
}
