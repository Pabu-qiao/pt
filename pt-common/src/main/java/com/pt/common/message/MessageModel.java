package com.pt.common.message;

import com.alibaba.fastjson.JSONObject;

public class MessageModel {

	private String topic;
	private String tag;
	private String id;
	private JSONObject info;
	
	public MessageModel(String topic) {
		super();
		this.topic = topic;
	}
	
	public MessageModel() {
		
	}

	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public JSONObject getInfo() {
		return this.info;
	}

	public void setInfo(JSONObject jsonObject) {
		
		this.info = jsonObject;
	}
	
}