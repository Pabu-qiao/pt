package com.pt.recommend.message;

import com.alibaba.fastjson.JSONObject;
import com.pt.recommend.util.CamelUtils;

public class MessageModel {

	private MessageTopic topic;
	private MessageTag tag;
	private String id;
	private JSONObject info;
	
	public MessageModel(MessageTopic topic) {
		super();
		this.topic = topic;
	}
	
	public MessageModel() {
		
	}

	public String getTopic() {
		return CamelUtils.camelCaseName(this.topic.toString());
	}

	public void setTopic(MessageTopic topic) {
		this.topic = topic;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTag() {
		return CamelUtils.camelCaseName(this.tag.toString());
	}

	public void setTag(MessageTag tag) {
		this.tag = tag;
	}

	public JSONObject getInfo() {
		return this.info;
	}

	public void setInfo(JSONObject jsonObject) {
		
		this.info = jsonObject;
	}
	
}