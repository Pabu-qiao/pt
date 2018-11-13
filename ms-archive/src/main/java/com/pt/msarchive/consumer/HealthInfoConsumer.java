package com.pt.msarchive.consumer;

import java.util.List;

import org.apache.commons.lang.StringUtils;
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
import com.pt.common.message.MessageTag;
import com.pt.common.message.MessageTopic;
import com.pt.common.service.ArchiveBaseService;
import com.pt.msarchive.service.HealthInfoService;

/**
 * @ClassName: HealthInfoConsumer
 * @Description: 用户健康信息消费者，用于更新用户健康信息（各种病症信息）
 * @author 谯雕
 * @date 2018年11月5日
 *
 */
public class HealthInfoConsumer {

	private static final Logger log = LoggerFactory.getLogger(HealthInfoConsumer.class);

	private DefaultMQPushConsumer consumer;
	private HealthInfoService infoService;

	private final static HealthInfoConsumer INSTANCE = new HealthInfoConsumer();

	private HealthInfoConsumer() {}

	public static class Builder{
		private final static Builder BUILDER = new Builder();
		private Builder(){}
		public static Builder getInstance() {
			return BUILDER;
		}
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer();
		
		public Builder setConsumerGroup(String consumerGroup) {
			BUILDER.consumer.setConsumerGroup(consumerGroup);
			return BUILDER;
		}
		public Builder setNamesrvAddr(String namesrvAddr) {
			BUILDER.consumer.setNamesrvAddr(namesrvAddr);
			return BUILDER;
		}
		public Builder setConsumeFromWhere(ConsumeFromWhere fromWhere) {
			BUILDER.consumer.setConsumeFromWhere(fromWhere);
			return BUILDER;
		}
		public Builder setSubscribe(MessageTopic messageTopic,MessageTag messageTag) {
			String topic=messageTopic.toString();
			String tag=messageTag.toString();
			tag=StringUtils.equalsIgnoreCase("all", tag)?"*":tag;
			try {
				BUILDER.consumer.subscribe(topic, tag);
			} catch (MQClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return BUILDER;
		}
		public Builder setConsumeThreadMax(Integer consumeThreadMax) {
			BUILDER.consumer.setConsumeThreadMax(consumeThreadMax);
			return BUILDER;
		}
		public Builder setConsumeThreadMin(Integer consumeThreadMin) {
			BUILDER.consumer.setConsumeThreadMin(consumeThreadMin);
			return BUILDER;
		}
		public Builder setConsumeMessageBatchMaxSize(Integer consumeMessageBatchMaxSize) {
			BUILDER.consumer.setConsumeMessageBatchMaxSize(consumeMessageBatchMaxSize);
			return BUILDER;
		}
		public Builder setServices(ArchiveBaseService...services) {
			for (ArchiveBaseService service : services) {
				if (service instanceof HealthInfoService) {
					INSTANCE.infoService=(HealthInfoService) service;
					log.info("infoservice:{}",service);
				}
			}
			return BUILDER;
		}
		public HealthInfoConsumer build() {
			INSTANCE.consumer=consumer;
			return INSTANCE;
		}
	}

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
