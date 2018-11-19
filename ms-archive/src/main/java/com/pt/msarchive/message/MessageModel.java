package com.pt.msarchive.message;

import com.alibaba.fastjson.JSONObject;

public class MessageModel {

	private MessageTopic topic;
	private MessageTag tag;
	private String id;
	private JSONObject info;
	
	public MessageModel(MessageTopic topic) {
		super();
		this.topic = topic;
	}
	
	public MessageModel() {}

	public String getTopic() {
		return this.topic.toString();
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
		return this.tag.toString();
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