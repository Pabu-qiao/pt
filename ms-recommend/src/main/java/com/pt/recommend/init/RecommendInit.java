package com.pt.recommend.init;

import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.pt.recommend.config.Global;
import com.pt.recommend.consumer.RecommendConsumer;
import com.pt.recommend.service.ZhengZhuangService;
import com.pt.recommend.service.ZhuSuService;
import com.ptutil.message.MessageProducer;
import com.ptutil.message.MessageTag;
import com.ptutil.message.MessageTopic;

/**
 * @ClassName: RecommendInit
 * @Description: RecommendInit初始化
 * @author 谯雕
 * @date 2018年11月12日
 *
 */
@Component
public class RecommendInit implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger log = LoggerFactory.getLogger(RecommendInit.class);

	@Autowired
	private ZhengZhuangService zhengZhuangService;
	@Autowired
	private ZhuSuService zhuSuService;
	@Autowired
	private Global global;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		log.info("-----------------------初始化完成-----------------------");
		// 初始化消息发送者
		MessageProducer.getInstance().init("recommendProducer", global.getRocketUrl());

		// 初始化healthInfoConsumer
		RecommendConsumer.builder
			.setConsumerGroup("recommendConsumer")
			.setNamesrvAddr(global.getRocketUrl())
			.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET)
			.setSubscribe(MessageTopic.putaiArchive, MessageTag.ALL)
			.setConsumeThreadMax(100)
			.setConsumeThreadMin(10)
			.setConsumeMessageBatchMaxSize(100)
			.build(zhengZhuangService,zhuSuService)
			.start();
	}

}
