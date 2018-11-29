package com.pt.msarchive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pt.msarchive.entity.HealthRecord;
import com.pt.msarchive.service.HealthRecordService;
import com.ptutil.ResponseUtil;
import com.ptutil.enums.PtEnum;
import com.ptutil.ptbase.PtResult;

@RestController
public class HealthRecordController {

	@Autowired
	private HealthRecordService recordService;
	
	@GetMapping("/records/{customerId}")
	public ResponseEntity<String> record(@PathVariable String customerId,@RequestParam String beginDate,@RequestParam String endDate){
		PtResult<HealthRecord> pt = recordService.getByDate(customerId, beginDate, endDate);
		if (pt.getStatus()!=PtEnum.CODE_01.getCode()&&pt.getStatus()!=PtEnum.CODE_02.getCode()) {
			return ResponseUtil.toJson(pt);
		}
		return ResponseUtil.toJson(PtResult.ok(pt.getData()));
	}
}
