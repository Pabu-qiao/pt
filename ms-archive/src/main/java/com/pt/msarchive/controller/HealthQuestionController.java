package com.pt.msarchive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pt.msarchive.entity.HealthQuestion;
import com.pt.msarchive.enums.QUESTION_ORIGIN;
import com.pt.msarchive.service.HealthQuestionService;
import com.pt.msarchive.util.ResponseUtil;

@Controller
public class HealthQuestionController {

	@Autowired
	private HealthQuestionService questinService;

	/**
	 * @Title: getAll
	 * @Description: 查询所有问题
	 * @return
	 */
	@GetMapping("/questions")
	public ResponseEntity<String> getAll() {
		List<HealthQuestion> temp = questinService.getAll();
		return ResponseUtil.toJson(temp);
	}

	/**
	 * @Title: getQuetionsByOrigin
	 * @Description: 根据来源查询问题，默认查询system问题
	 * @param origin
	 * @return
	 */
	@GetMapping("/questions/{origin}")
	@ResponseBody
	public ResponseEntity<String> getQuetionsByOrigin(@PathVariable String origin) {
		// TODO Auto-generated method stub
		List<HealthQuestion> list=null;
		if (origin.equalsIgnoreCase(QUESTION_ORIGIN.CUSTOMER.toString())) {
			list= questinService.getByOrigin(QUESTION_ORIGIN.CUSTOMER);
		} else if (origin.equalsIgnoreCase(QUESTION_ORIGIN.SYSTEM.toString())) {
			list= questinService.getByOrigin(QUESTION_ORIGIN.SYSTEM);
		}
		return ResponseUtil.toJson(list);
	}
}
