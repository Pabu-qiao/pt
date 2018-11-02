package com.pt.msarchive.service;

import java.util.List;

import com.pt.msarchive.entity.HealthQuestion;
import com.pt.msarchive.enums.QUESTION_ORIGIN;

/**
 * @ClassName: HealthQuestionService
 * @Description: 获取所有问题的服务接口
 * @author 谯雕
 * @date 2018年11月2日
 *
 */
public interface HealthQuestionService {

	List<HealthQuestion> getAll();
	List<HealthQuestion> getByOrigin(QUESTION_ORIGIN origin);
}
