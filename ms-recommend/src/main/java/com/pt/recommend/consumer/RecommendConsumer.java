package com.pt.recommend.consumer;

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
import com.pt.common.message.MessageTag;
import com.pt.common.message.MessageTopic;
import com.pt.recommend.service.ZhengZhuangService;

/**
 * @ClassName: RecommendConsumer
 * @Description: 推荐方案消费者
 * @author 谯雕
 * @date 2018年11月12日
 *
 */
public class RecommendConsumer {

	private static final Logger log = LoggerFactory.getLogger(RecommendConsumer.class);

	private DefaultMQPushConsumer consumer;
	private ZhengZhuangService zhengZhuangService;

	private final static RecommendConsumer INSTANCE = new RecommendConsumer();

	private RecommendConsumer() {

	}

	public static RecommendConsumer getInstance(String consumerName, String rocketUrl, ZhengZhuangService zhengZhuangService) {
		// 创建一个组名为archives_healthinfo的消费者
		DefaultMQPushConsumer temp = new DefaultMQPushConsumer(consumerName);
		// 指定NameServer地址，多个地址以 ; 隔开
		temp.setNamesrvAddr(rocketUrl);
		temp.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
		try {
			// 可订阅多个tag,源码中用||区分不同tag,*代表所有tag，但是一个消息只能有一个tag
			temp.subscribe(MessageTopic.HEALTHINFO, "*");
			// 可以订阅多个topic
			// temp.subscribe("", "*");
		} catch (MQClientException e) {
			e.printStackTrace();
		}

		temp.setConsumeThreadMax(100);
		temp.setConsumeThreadMin(10);
		temp.setConsumeMessageBatchMaxSize(100);

		INSTANCE.consumer = temp;
		INSTANCE.zhengZhuangService = zhengZhuangService;
		return INSTANCE;
	}

	public void start() {
		try {
			this.consumer.registerMessageListener(new MessageListenerConcurrently() {
				public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
						ConsumeConcurrentlyContext context) {
					for (MessageExt msg : msgs) {
						try {
							if (MessageTopic.HEALTHINFO.equals(msg.getTopic())) {
								MessageModel model = JSON.parseObject(new String(msg.getBody()), MessageModel.class);
								if(model==null) {
									log.warn("消息内容为空");
									return null;
								}
								//新增客户
								if (MessageTag.PUTAI_MESSAGE_CREATE.equals(msg.getTags())) {
									log.info("新增用户");
								}
								//更新老客户
								if (MessageTag.PUTAI_MESSAGE_UPDATE.equals(msg.getTags())) {
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
