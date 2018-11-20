package com.pt.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pt.health.service.archive.ArchiveService;
import com.pt.health.util.ResponseUtil;

@RestController
@CrossOrigin
@RequestMapping("/archive")
public class ArchiveController {

	@Autowired
	private ArchiveService archiveService;
	
	@GetMapping("/questions")
	public ResponseEntity<String> getAllQuestion(){
		String temp = archiveService.getAllQuestion();
		return ResponseUtil.toJson(temp);
	}
	
	@GetMapping("/questions/{origin}")
	public ResponseEntity<String> getQuestionByOrigin(@PathVariable String origin){
		String temp = archiveService.getQuestionByOrigin(origin);
		return ResponseUtil.toJson(temp);
	}
	
	@PutMapping("/updateInfo")
	public void updateInfo(@RequestBody JSONObject jsonData) {
		archiveService.updateHealthInfo(jsonData);
	}
}
