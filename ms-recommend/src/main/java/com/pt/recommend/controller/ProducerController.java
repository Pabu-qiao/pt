package com.pt.recommend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pt.recommend.message.MessageModel;
import com.pt.recommend.message.MessageProducer;
import com.pt.recommend.message.MessageTag;
import com.pt.recommend.message.MessageTopic;

/**
 * @ClassName: ProducerController
 * @Description: 测试接收消息
 * @author 谯雕
 * @date 2018年11月12日
 *
 */
@RestController
public class ProducerController {

	private MessageProducer producer=MessageProducer.getInstance();
	
	@GetMapping("/add")
	public String add() {
		MessageModel model=new MessageModel(MessageTopic.putaiArchive);
		model.setTopic(MessageTopic.putaiArchive);
		model.setTag(MessageTag.putai_message_create);
		model.setId("123");
		producer.sendMessage(model);
		return "add";
	}
	
	@GetMapping("/update")
	public String update() {
		MessageModel model=new MessageModel(MessageTopic.putaiArchive);
		model.setTopic(MessageTopic.putaiArchive);
		model.setTag(MessageTag.putai_message_update);
		model.setId("123");
		producer.sendMessage(model);
		return "update";
	}
}
