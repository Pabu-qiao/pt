package com.pt.recommend.consumer;

import org.apache.commons.lang.StringUtils;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.pt.recommend.message.MessageTag;
import com.pt.recommend.message.MessageTopic;
import com.pt.recommend.service.BaseService;

public interface ConsumerBuilder {

	/**
	 * @Title: createConsumer
	 * @Description: 绑定各自的consumer
	 * @return
	 */
	DefaultMQPushConsumer bindConsumer();
	
	default ConsumerBuilder setConsumerGroup(String consumerGroup) {
		bindConsumer().setConsumerGroup(consumerGroup);
		return this;
	}

	default ConsumerBuilder setNamesrvAddr(String namesrvAddr) {
		bindConsumer().setNamesrvAddr(namesrvAddr);
		return this;
	}

	default ConsumerBuilder setConsumeFromWhere(ConsumeFromWhere fromWhere) {
		bindConsumer().setConsumeFromWhere(fromWhere);
		return this;
	}

	default ConsumerBuilder setSubscribe(MessageTopic messageTopic, MessageTag messageTag) {
		String topic = messageTopic.toString();
		String tag = messageTag.toString();
		tag = StringUtils.equalsIgnoreCase("all", tag) ? "*" : tag;
		try {
			bindConsumer().subscribe(topic, tag);
		} catch (MQClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	default ConsumerBuilder setConsumeThreadMax(Integer consumeThreadMax) {
		bindConsumer().setConsumeThreadMax(consumeThreadMax);
		return this;
	}

	default ConsumerBuilder setConsumeThreadMin(Integer consumeThreadMin) {
		bindConsumer().setConsumeThreadMin(consumeThreadMin);
		return this;
	}

	default ConsumerBuilder setConsumeMessageBatchMaxSize(Integer consumeMessageBatchMaxSize) {
		bindConsumer().setConsumeMessageBatchMaxSize(consumeMessageBatchMaxSize);
		return this;
	}

	
	/**
	 * @Title: build
	 * @Description: 传入service绑定到实例中。
	 */
	@SuppressWarnings("unchecked")
	public<T extends BaseService> BaseConsumer build(T...services);
}
