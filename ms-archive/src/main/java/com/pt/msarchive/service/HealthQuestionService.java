package com.pt.msarchive.service;

import com.pt.msarchive.entity.HealthQuestion;
import com.pt.msarchive.enums.QUESTION_ORIGIN;
import com.pt.msarchive.model.PtResult;

/**
 * @ClassName: HealthQuestionService
 * @Description: 获取所有问题的服务接口
 * @author 谯雕
 * @date 2018年11月2日
 *
 */
public interface HealthQuestionService extends BaseService{

	PtResult<HealthQuestion> getAll();
	PtResult<HealthQuestion> getByOrigin(QUESTION_ORIGIN origin);
}
