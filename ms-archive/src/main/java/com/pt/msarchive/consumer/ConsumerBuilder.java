package com.pt.msarchive.consumer;

import org.apache.commons.lang.StringUtils;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.pt.msarchive.message.MessageTag;
import com.pt.msarchive.message.MessageTopic;
import com.pt.msarchive.service.BaseService;

/**
 * @ClassName: ConsumerBuilder
 * @Description: 消费者建造工具
 * @author 谯雕
 * @date 2018年11月29日
 *
 */
public interface ConsumerBuilder {
	
	public DefaultMQPushConsumer createConsumer();

	default ConsumerBuilder setConsumerGroup(String consumerGroup) {
		createConsumer().setConsumerGroup(consumerGroup);
		return this;
	}

	default ConsumerBuilder setNamesrvAddr(String namesrvAddr) {
		createConsumer().setNamesrvAddr(namesrvAddr);
		return this;
	}

	default ConsumerBuilder setConsumeFromWhere(ConsumeFromWhere fromWhere) {
		createConsumer().setConsumeFromWhere(fromWhere);
		return this;
	}

	default ConsumerBuilder setSubscribe(MessageTopic messageTopic, MessageTag messageTag) {
		String topic = messageTopic.toString();
		String tag = messageTag.toString();
		tag = StringUtils.equalsIgnoreCase("all", tag) ? "*" : tag;
		try {
			createConsumer().subscribe(topic, tag);
		} catch (MQClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	default ConsumerBuilder setConsumeThreadMax(Integer consumeThreadMax) {
		createConsumer().setConsumeThreadMax(consumeThreadMax);
		return this;
	}

	default ConsumerBuilder setConsumeThreadMin(Integer consumeThreadMin) {
		createConsumer().setConsumeThreadMin(consumeThreadMin);
		return this;
	}

	default ConsumerBuilder setConsumeMessageBatchMaxSize(Integer consumeMessageBatchMaxSize) {
		createConsumer().setConsumeMessageBatchMaxSize(consumeMessageBatchMaxSize);
		return this;
	}

	
	/**
	 * @Title: build
	 * @Description: 将consumer与实例中的消费者绑定,传入service绑定到实例中。
	 */
	public<T extends BaseService> BaseConsumer build(T t);
}
