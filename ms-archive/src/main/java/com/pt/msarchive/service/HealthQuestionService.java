package com.pt.msarchive.service;

import com.pt.msarchive.entity.HealthQuestion;
import com.ptutil.enums.QUESTION_ORIGIN;
import com.ptutil.ptbase.PtBaseService;
import com.ptutil.ptbase.PtResult;

/**
 * @ClassName: HealthQuestionService
 * @Description: 获取所有问题的服务接口
 * @author 谯雕
 * @date 2018年11月2日
 *
 */
public interface HealthQuestionService extends PtBaseService{

	PtResult<HealthQuestion> getAll();
	PtResult<HealthQuestion> getByOrigin(QUESTION_ORIGIN origin);
}
