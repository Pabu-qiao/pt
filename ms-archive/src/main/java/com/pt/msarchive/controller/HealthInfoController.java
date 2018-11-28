package com.pt.msarchive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pt.msarchive.entity.HealthInfo;
import com.pt.msarchive.model.PtResult;
import com.pt.msarchive.service.HealthInfoService;
import com.pt.msarchive.util.PtEnum;
import com.pt.msarchive.util.ResponseUtil;

@RestController
public class HealthInfoController {

	@Autowired
	private HealthInfoService infoService;
	
	@GetMapping("/healthInfo/{customerId}")
	public ResponseEntity<String> getHealthInfoById(@PathVariable String customerId){
		PtResult<HealthInfo> pt = infoService.getById(customerId);
		
		if (pt.getStatus()!=PtEnum.CODE_01.getCode()&&pt.getStatus()!=PtEnum.CODE_02.getCode()) {
			return ResponseUtil.toJson(pt);
		}
		return ResponseUtil.toJson(PtResult.ok(pt.getData()));
	}
}
