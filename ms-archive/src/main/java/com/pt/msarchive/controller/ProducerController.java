package com.pt.msarchive.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pt.common.message.MessageModel;
import com.pt.common.message.MessageProducer;
import com.pt.common.message.MessageTag;
import com.pt.common.message.MessageTopic;

/**
 * @ClassName: ProducerController
 * @Description: 以下开始是本地测试代码，测试发送消息
 * @author 谯雕
 * @date 2018年11月5日
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/test")
public class ProducerController {

	private MessageProducer producer=MessageProducer.getInstance();
	
	@PostMapping("/addInfo")
	public void addInfo(@RequestBody JSONObject jsonData) {
		MessageModel model=new MessageModel(MessageTopic.HEALTHINFO);
		model.setTopic(MessageTopic.HEALTHINFO);
		model.setTag(MessageTag.PUTAI_MESSAGE_CREATE);
		model.setId(jsonData.getString("customerId"));
		model.setInfo(JSON.parseObject(jsonData.getString("data")));
		producer.sendMessage(model);
		
	}
	
	@PutMapping("/updateInfo")
	public void updateInfo(@RequestBody JSONObject jsonData) {
		MessageModel model=new MessageModel(MessageTopic.HEALTHINFO);
		model.setId(jsonData.getString("customerId"));
		model.setTag(MessageTag.PUTAI_MESSAGE_UPDATE);
		model.setInfo(JSON.parseObject(jsonData.getString("data")));
		producer.sendMessage(model);
	}
	
	@PostMapping("/addService")
	public void addService(@RequestBody JSONObject jsonData) {
		MessageModel model=new MessageModel(MessageTopic.HEALTHSERVICE);
		model.setId(jsonData.getString("customerId"));
		model.setTag(MessageTag.PUTAI_MESSAGE_CREATE);
		model.setInfo(JSON.parseObject(jsonData.getString("data")));
		producer.sendMessage(model);
	}
}
