package com.pt.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pt.health.service.archive.ArchiveService;
import com.pt.health.util.ResponseUtil;

@RestController
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
}
