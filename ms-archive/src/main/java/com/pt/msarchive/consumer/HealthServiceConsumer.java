package com.pt.msarchive.consumer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.pt.common.message.MessageModel;
import com.pt.common.message.MessageTopic;
import com.pt.msarchive.service.HealthServiceService;

/**
 * @ClassName: HealthServiceConsumer
 * @Description: 用户服务记录消费者，用于保存用户所做的服务记录
 * @author 谯雕
 * @date 2018年11月5日
 *
 */
public class HealthServiceConsumer {

	private static final Logger log = LoggerFactory.getLogger(HealthServiceConsumer.class);

	private DefaultMQPushConsumer consumer;
	private HealthServiceService service;

	private final static HealthServiceConsumer INSTANCE = new HealthServiceConsumer();

	private HealthServiceConsumer() {

	}

	public static HealthServiceConsumer getInstance(String consumerName,String rocketUrl, HealthServiceService service) {
		// 创建一个组名为archives_healthinfo的消费者
		DefaultMQPushConsumer temp = new DefaultMQPushConsumer(consumerName);
		// 指定NameServer地址，多个地址以 ; 隔开
		temp.setNamesrvAddr(rocketUrl);
		temp.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
		try {
			// 可订阅多个tag,源码中用||区分不同tag,*代表所有tag，但是一个消息只能有一个tag
			temp.subscribe(MessageTopic.HEALTHSERVICE, "*");
			// 可以订阅多个topic
			// temp.subscribe("", "*");
		} catch (MQClientException e) {
			e.printStackTrace();
		}

		temp.setConsumeThreadMax(100);
		temp.setConsumeThreadMin(10);
		temp.setConsumeMessageBatchMaxSize(100);

		INSTANCE.consumer = temp;
		INSTANCE.service = service;
		return INSTANCE;
	}

	public void start() {
		try {
			this.consumer.registerMessageListener(new MessageListenerConcurrently() {
				public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
						ConsumeConcurrentlyContext context) {
					for (MessageExt msg : msgs) {
						try {
							if (MessageTopic.HEALTHSERVICE.equals(msg.getTopic())) {
								MessageModel model = JSON.parseObject(new String(msg.getBody()), MessageModel.class);
								if(model==null) {
									log.warn("消息内容为空");
									return null;
								}
								service.saveRecord(model.getId(), model.getInfo());
								log.info("保存一条服务记录");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
					return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
				}
			});

			consumer.start();

		} catch (MQClientException e1) {
			e1.printStackTrace();
		}
	}
}
