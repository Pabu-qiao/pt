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
import com.pt.msarchive.message.MessageTag;
import com.pt.msarchive.message.MessageTopic;
import com.pt.msarchive.service.BaseService;
import com.pt.msarchive.service.HealthInfoService;

/**
 * @ClassName: HealthInfoConsumer
 * @Description: 用户健康信息消费者，用于更新用户健康信息（各种病症信息）
 * @author 谯雕
 * @date 2018年11月29日
 *
 */
public class HealthInfoConsumer implements BaseConsumer{

	private static final Logger log = LoggerFactory.getLogger(HealthInfoConsumer.class);

	private DefaultMQPushConsumer consumer=new DefaultMQPushConsumer();
	private HealthInfoService infoService;

	private final static HealthInfoConsumer INSTANCE = new HealthInfoConsumer();

	private HealthInfoConsumer() {}

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
				if (service instanceof HealthInfoService) {
					INSTANCE.infoService=(HealthInfoService) service;
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
								//新增客户
								if (MessageTag.putai_message_create.toString().equals(msg.getTags())) {
									infoService.add(model.getId(), model.getInfo());
									log.info("新增用户");
								}
								//更新老客户
								if (MessageTag.putai_message_update.toString().equals(msg.getTags())) {
									infoService.update(model.getId(), model.getInfo());
									log.info("更新用户");
								}
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
