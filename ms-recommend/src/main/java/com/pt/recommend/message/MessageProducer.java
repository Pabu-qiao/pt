package com.pt.recommend.message;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendCallback;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

public class MessageProducer {

	private Logger log = LoggerFactory.getLogger(MessageProducer.class); 
	
	private DefaultMQProducer producer;
	private static MessageProducer INSTANCE=new MessageProducer();
	
	public static final MessageProducer getInstance() {
		return INSTANCE;
	}

	public MessageProducer() {
		
	}

	public void init(String producerName, String rocketmq_url) {
		try {
			producer = new DefaultMQProducer(producerName);
			producer.setNamesrvAddr(rocketmq_url);
			producer.setRetryTimesWhenSendFailed(3);
			producer.start();
		} catch (MQClientException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(final MessageModel model) {
		if (producer != null) {
			Message msg = new Message(model.getTopic(), model.getTag(), JSON.toJSONString(model).getBytes());
			try {
				if (StringUtils.isNotEmpty(model.getId())) {
					producer.send(msg, new PutaiMessageQueueSelector(), model.getId(), new SendCallback() {
						@Override
						public void onSuccess(SendResult sendResult) {

						}

						@Override
						public void onException(Throwable e) {
							e.printStackTrace();
							log.error("消息发送失败，topic：" + model.getTopic() + ", 内容:" + JSON.toJSONString(model));
						}
					});
				} else {
					producer.send(msg, new SendCallback() {
						@Override
						public void onSuccess(SendResult sendResult) {

						}

						@Override
						public void onException(Throwable e) {
							e.printStackTrace();
							log.error("消息发送失败，topic：" + model.getTopic() + ", 内容:" + JSON.toJSONString(model));
						}
					});
				}
			} catch (MQClientException e) {
				e.printStackTrace();
			} catch (RemotingException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
