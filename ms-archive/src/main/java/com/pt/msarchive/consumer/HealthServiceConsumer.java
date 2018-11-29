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
import com.pt.msarchive.service.HealthServiceService;

/**
 * @ClassName: HealthServiceConsumer
 * @Description: 用户服务记录消费者，用于保存用户所做的服务记录
 * @author 谯雕
 * @date 2018年11月29日
 *
 */
public class HealthServiceConsumer implements BaseConsumer{

	private static final Logger log = LoggerFactory.getLogger(HealthServiceConsumer.class);

	private DefaultMQPushConsumer consumer=new DefaultMQPushConsumer();
	private HealthServiceService healthService;

	private final static HealthServiceConsumer INSTANCE = new HealthServiceConsumer();

	private HealthServiceConsumer() {}

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
				if (service instanceof HealthServiceService) {
					INSTANCE.healthService=(HealthServiceService) service;
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
								healthService.saveRecord(model.getId(), model.getInfo());
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
