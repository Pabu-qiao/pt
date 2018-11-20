package com.pt.health.service.archive;

import com.alibaba.fastjson.JSONObject;

public interface ArchiveService {

	/**
	 * @Title: getAllQuestion
	 * @Description: 查询所有问题
	 * @return
	 */
	String getAllQuestion();
	
	/**
	 * @Title: getQuestionByOrigin
	 * @Description: 根据问题来源查询问题
	 * @param origin
	 * @return
	 */
	String getQuestionByOrigin(String origin);
	
	/**
	 * @Title: updateHealthInfo
	 * @Description: 更新客户健康信息
	 * @param jsonData
	 */
	void updateHealthInfo(JSONObject jsonData);
}
