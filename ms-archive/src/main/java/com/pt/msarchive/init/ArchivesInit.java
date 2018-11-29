package com.pt.msarchive.init;

import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.pt.msarchive.config.Global;
import com.pt.msarchive.consumer.HealthInfoConsumer;
import com.pt.msarchive.consumer.HealthRecordConsumer;
import com.pt.msarchive.consumer.HealthServiceConsumer;
import com.pt.msarchive.service.HealthInfoService;
import com.pt.msarchive.service.HealthRecordService;
import com.pt.msarchive.service.HealthServiceService;
import com.ptutil.message.MessageProducer;
import com.ptutil.message.MessageTag;
import com.ptutil.message.MessageTopic;


/**
 * @ClassName: ArchivesInit
 * @Description: TArchivesInit初始化
 * @author 谯雕
 * @date 2018年10月25日
 *
 */
@Component
public class ArchivesInit implements ApplicationListener<ContextRefreshedEvent>{
	
	private static final Logger log = LoggerFactory.getLogger(ArchivesInit.class);

	@Autowired
	private HealthInfoService healtInfoService;
	@Autowired
	private HealthRecordService recordService;
	@Autowired
	private HealthServiceService serviceService;
	@Autowired
	private Global global;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		log.info("-----------------------初始化完成-----------------------");
		//初始化消息发送者
		MessageProducer.getInstance().init("producerName",global.getRocketUrl());
		
		//初始化healthInfoConsumer
		HealthInfoConsumer.builder
			.setConsumerGroup("infoConsumer")
			.setNamesrvAddr(global.getRocketUrl())
			.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET)
			.setSubscribe(MessageTopic.putaiArchive, MessageTag.ALL)
			.setConsumeThreadMax(100)
			.setConsumeThreadMin(10)
			.setConsumeMessageBatchMaxSize(100)
			.build(healtInfoService)
			.start();
		HealthRecordConsumer.builder
			.setConsumerGroup("recordConsumer")
			.setNamesrvAddr(global.getRocketUrl())
			.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET)
			.setSubscribe(MessageTopic.putaiArchive, MessageTag.ALL)
			.setConsumeThreadMax(100)
			.setConsumeThreadMin(10)
			.setConsumeMessageBatchMaxSize(100)
			.build(recordService)
			.start();
		HealthServiceConsumer.builder
			.setConsumerGroup("healthConsumer")
			.setNamesrvAddr(global.getRocketUrl())
			.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET)
			.setSubscribe(MessageTopic.putaiArchive, MessageTag.ALL)
			.setConsumeThreadMax(100)
			.setConsumeThreadMin(10)
			.setConsumeMessageBatchMaxSize(100)
			.build(serviceService)
			.start();
	}

}
