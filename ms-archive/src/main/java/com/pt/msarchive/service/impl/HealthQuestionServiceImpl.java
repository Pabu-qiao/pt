package com.pt.msarchive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pt.msarchive.dao.HealthQuestionDao;
import com.pt.msarchive.entity.HealthQuestion;
import com.pt.msarchive.service.HealthQuestionService;
import com.ptutil.enums.PtEnum;
import com.ptutil.enums.QUESTION_ORIGIN;
import com.ptutil.ptbase.PtResult;

/**
 * @ClassName: HealthQuestionServiceImpl
 * @Description: 获取所有问题的服务实现类
 * @author 谯雕
 * @date 2018年11月2日
 *
 */
@Service
@Transactional
public class HealthQuestionServiceImpl implements HealthQuestionService {

	@Autowired
	private HealthQuestionDao questionDao;
	
	@Override
	public PtResult<HealthQuestion> getAll() {
		// TODO Auto-generated method stub
		List<HealthQuestion> all = questionDao.findAll();
		if (all==null||all.size()<1) {
			return PtResult.build(PtEnum.CODE_03);
		}
		return PtResult.ok(all);
	}

	@Override
	public PtResult<HealthQuestion> getByOrigin(QUESTION_ORIGIN origin) {
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
		
		if (list==null||list.size()<1) {
			return PtResult.build(PtEnum.CODE_03);
		}
		return PtResult.ok(list);
	}

}
