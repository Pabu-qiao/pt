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
import com.alibaba.rocketmq.common.message.MessageExt;
import com.pt.msarchive.message.MessageModel;
import com.pt.msarchive.message.MessageTopic;
import com.pt.msarchive.service.BaseService;
import com.pt.msarchive.service.HealthRecordService;

/**
 * @ClassName: HealthRecordConsumer
 * @Description: 用户健康记录消费者，用于保存用户健康记录
 * @author 谯雕
 * @date 2018年11月29日
 *
 */
public class HealthRecordConsumer implements BaseConsumer {

	private static final Logger log = LoggerFactory.getLogger(HealthRecordConsumer.class);

	private DefaultMQPushConsumer consumer=new DefaultMQPushConsumer();
	private HealthRecordService recordService;

	private final static HealthRecordConsumer INSTANCE = new HealthRecordConsumer();

	private HealthRecordConsumer() {}

	public static final ConsumerBuilder builder=new ConsumerBuilder() {
		@Override
		public DefaultMQPushConsumer bindConsumer() {
			// TODO Auto-generated method stub
			return INSTANCE.consumer;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public <T extends BaseService> BaseConsumer build(T...services) {
			// TODO Auto-generated method stub
			for (T service : services) {
				if (service instanceof HealthRecordService) {
					INSTANCE.recordService=(HealthRecordService) service;
				}
			}
			return INSTANCE;
		}
	};

	@Override
	public void start() {
		try {
			this.consumer.registerMessageListener(new MessageListenerConcurrently() {
				public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
						ConsumeConcurrentlyContext context) {
					for (MessageExt msg : msgs) {
						try {
							if (MessageTopic.putaiArchive.toString().equals(msg.getTopic())) {
								MessageModel model = JSON.parseObject(new String(msg.getBody()), MessageModel.class);
								if(model==null) {
									log.warn("消息内容为空");
									return null;
								}
								recordService.saveRecord(model.getId(), model.getInfo());
								log.info("保存一条健康记录");
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
