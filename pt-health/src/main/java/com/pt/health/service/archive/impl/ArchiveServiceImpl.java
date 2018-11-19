package com.pt.health.service.archive.impl;

import org.springframework.stereotype.Service;

import com.pt.health.msApi.MsApplication;
import com.pt.health.msApi.restApi.ArchiveApi;
import com.pt.health.service.archive.ArchiveService;
import com.pt.health.util.EurekaUtil;
import com.pt.health.util.RestUtil;

@Service
public class ArchiveServiceImpl implements ArchiveService {

	@Override
	public String getAllQuestion() {
		// TODO Auto-generated method stub
		String url = EurekaUtil.getInstance().getServiceUrl(MsApplication.MSARCHIVE, ArchiveApi.QUESTIONS);
		return RestUtil.getResult(url);
	}

	@Override
	public String getQuestionByOrigin(String origin) {
		// TODO Auto-generated method stub
		String url = EurekaUtil.getInstance().getServiceUrl(MsApplication.MSARCHIVE, ArchiveApi.QUESTIONSBYORIGIN);
		return RestUtil.getResult(url, origin);
	}

}
