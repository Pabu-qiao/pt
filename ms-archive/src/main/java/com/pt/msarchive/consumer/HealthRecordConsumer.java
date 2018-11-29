package com.pt.msarchive.consumer;

import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.pt.msarchive.service.HealthRecordService;
import com.ptutil.consumer.ConsumerBuilder;
import com.ptutil.message.MessageModel;
import com.ptutil.ptbase.PtBaseConsumer;
import com.ptutil.ptbase.PtBaseService;

/**
 * @ClassName: HealthRecordConsumer
 * @Description: 用户健康记录消费者，用于保存用户健康记录
 * @author 谯雕
 * @date 2018年11月29日
 *
 */
public class HealthRecordConsumer implements PtBaseConsumer {

	private static final Logger log = LoggerFactory.getLogger(HealthRecordConsumer.class);

	private DefaultMQPushConsumer consumer = new DefaultMQPushConsumer();
	private HealthRecordService recordService;

	private final static HealthRecordConsumer INSTANCE = new HealthRecordConsumer();

	private HealthRecordConsumer() {
	}

	public static final ConsumerBuilder builder = new ConsumerBuilder() {
		@Override
		public DefaultMQPushConsumer bindConsumer() {
			// TODO Auto-generated method stub
			return INSTANCE.consumer;
		}

		@SuppressWarnings("unchecked")
		@Override
		public <T extends PtBaseService> PtBaseConsumer build(T... services) {
			// TODO Auto-generated method stub
			for (T service : services) {
				if (service instanceof HealthRecordService) {
					INSTANCE.recordService = (HealthRecordService) service;
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
							MessageModel model = JSON.parseObject(new String(msg.getBody()), MessageModel.class);
							if (model == null) {
								log.warn("消息内容为空");
								return null;
							}
							recordService.saveRecord(model.getId(), model.getInfo());
							log.info("保存一条健康记录");
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
