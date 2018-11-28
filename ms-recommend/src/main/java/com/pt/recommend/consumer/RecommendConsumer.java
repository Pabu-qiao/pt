package com.pt.recommend.consumer;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.pt.recommend.entity.FangAn;
import com.pt.recommend.entity.ZhuSu;
import com.pt.recommend.message.MessageModel;
import com.pt.recommend.message.MessageTag;
import com.pt.recommend.message.MessageTopic;
import com.pt.recommend.service.BaseService;
import com.pt.recommend.service.ZhengZhuangService;
import com.pt.recommend.service.ZhuSuService;
import com.pt.recommend.util.CamelUtils;

/**
 * @ClassName: RecommendConsumer
 * @Description: 推荐方案消费者，由单纯的单例模式改为建造者单例模式，在外部控制参数
 * @author 谯雕
 * @date 2018年11月12日
 *
 */
public class RecommendConsumer {

	private static final Logger log = LoggerFactory.getLogger(RecommendConsumer.class);

	private DefaultMQPushConsumer consumer;
	private ZhengZhuangService zhengZhuangService=null;
	private ZhuSuService zhuSuService=null;

	private final static RecommendConsumer INSTANCE = new RecommendConsumer();

	private RecommendConsumer() {}
	
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
			String topic=CamelUtils.camelCaseName(messageTopic.toString());
			String tag=CamelUtils.camelCaseName(messageTag.toString());
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
		public Builder setServices(BaseService...services) {
			for (BaseService service : services) {
				if (service instanceof ZhengZhuangService) {
					INSTANCE.zhengZhuangService=(ZhengZhuangService) service;
					log.info("症状service:{}",service);
				}
				if (service instanceof ZhuSuService) {
					INSTANCE.zhuSuService=(ZhuSuService) service;
					log.info("主诉service:{}",service);
				}
			}
			return BUILDER;
		}
		public RecommendConsumer build() {
			INSTANCE.consumer=consumer;
			return INSTANCE;
		}
	}

	/*public static RecommendConsumer getInstance(String consumerName, String rocketUrl, ZhengZhuangService zhengZhuangService) {
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
	}*/

	public void start() {
		try {
			this.consumer.registerMessageListener(new MessageListenerConcurrently() {
				public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
						ConsumeConcurrentlyContext context) {
					for (MessageExt msg : msgs) {
						try {
							MessageModel model = JSON.parseObject(new String(msg.getBody()), MessageModel.class);
							if(model==null) {
								log.warn("消息内容为空");
								return null;
							}
							//新增客户
							if (MessageTag.ZHUSU_CREATE.toString().equals(msg.getTags())) {
								log.info("新增用户");
								JSONObject info = model.getInfo();
								ZhuSu zhuSu = JSON.parseObject(info.getString("zhuSu"),ZhuSu.class);
								FangAn fangAn = JSON.parseObject(info.getString("fangAn"),FangAn.class);
								zhuSuService.saveZhuSu(zhuSu, fangAn);
							}
							//更新老客户
							if (MessageTag.PUTAI_MESSAGE_UPDATE.toString().equals(msg.getTags())) {
								zhengZhuangService.getAllZhengZhuang();
								log.info("更新用户");
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
