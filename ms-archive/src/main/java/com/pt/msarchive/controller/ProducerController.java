package com.pt.msarchive.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ptutil.message.MessageModel;
import com.ptutil.message.MessageProducer;
import com.ptutil.message.MessageTag;
import com.ptutil.message.MessageTopic;

/**
 * @ClassName: ProducerController
 * @Description: 以下开始是本地测试代码，测试发送消息
 * @author 谯雕
 * @date 2018年11月5日
 *
 */
@RestController
@RequestMapping("/test")
@CrossOrigin
public class ProducerController {

	private MessageProducer messageProducer=MessageProducer.getInstance();
	
	@PostMapping("/addInfo")
	public void addInfo(@RequestBody JSONObject jsonData) {
		MessageModel model=new MessageModel(MessageTopic.putaiArchive);
		model.setTopic(MessageTopic.putaiArchive);
		model.setTag(MessageTag.PUTAI_MESSAGE_CREATE);
		model.setId(jsonData.getString("customerId"));
		model.setInfo(JSON.parseObject(jsonData.getString("data")));
		messageProducer.sendMessage(model);
		
	}
	
	@PutMapping("/updateInfo")
	public void updateInfo(@RequestBody JSONObject jsonData) {
		MessageModel model=new MessageModel(MessageTopic.putaiArchive);
		model.setId(jsonData.getString("customerId"));
		model.setTag(MessageTag.PUTAI_MESSAGE_UPDATE);
		model.setInfo(JSON.parseObject(jsonData.getString("data")));
		messageProducer.sendMessage(model);
	}
	
	@PostMapping("/addService")
	public void addService(@RequestBody JSONObject jsonData) {
		MessageModel model=new MessageModel(MessageTopic.putaiArchive);
		model.setId(jsonData.getString("customerId"));
		model.setTag(MessageTag.PUTAI_MESSAGE_CREATE);
		model.setInfo(JSON.parseObject(jsonData.getString("data")));
		messageProducer.sendMessage(model);
	}
}
