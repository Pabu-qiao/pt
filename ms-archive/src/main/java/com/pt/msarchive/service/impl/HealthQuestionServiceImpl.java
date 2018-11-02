package com.pt.msarchive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.pt.msarchive.dao.HealthQuestionDao;
import com.pt.msarchive.entity.HealthQuestion;
import com.pt.msarchive.enums.QUESTION_ORIGIN;
import com.pt.msarchive.service.HealthQuestionService;

/**
 * @ClassName: HealthQuestionServiceImpl
 * @Description: 获取所有问题的服务实现类
 * @author 谯雕
 * @date 2018年11月2日
 *
 */
@Service
public class HealthQuestionServiceImpl implements HealthQuestionService {

	@Autowired
	private HealthQuestionDao questionDao;
	
	@Override
	public List<HealthQuestion> getAll() {
		// TODO Auto-generated method stub
		return questionDao.findAll();
	}

	@Override
	public List<HealthQuestion> getByOrigin(QUESTION_ORIGIN origin) {
		// TODO Auto-generated method stub
		List<HealthQuestion> list = questionDao.findAll(new Example<HealthQuestion>() {

			@Override
			public HealthQuestion getProbe() {
				// TODO Auto-generated method stub
				HealthQuestion probe=new HealthQuestion();
				probe.setOrigin(origin);
				return probe;
			}

			@Override
			public ExampleMatcher getMatcher() {
				// TODO Auto-generated method stub
				ExampleMatcher matcher=ExampleMatcher.matching();
				matcher.withMatcher("origin", ExampleMatcher.GenericPropertyMatchers.exact());
				return matcher;
			}
		});
		
		return list;
	}

}
