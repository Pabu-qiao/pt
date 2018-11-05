package com.pt.msarchive.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.pt.common.message.MessageProducer;
import com.pt.msarchive.config.Global;
import com.pt.msarchive.consumer.HealthInfoConsumer;
import com.pt.msarchive.consumer.HealthRecordConsumer;
import com.pt.msarchive.consumer.HealthServiceConsumer;
import com.pt.msarchive.service.HealthInfoService;
import com.pt.msarchive.service.HealthRecordService;
import com.pt.msarchive.service.HealthServiceService;


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
		MessageProducer.getInstance().init(global.getRocketUrl());
		
		//初始化healthInfoConsumer
		HealthInfoConsumer.getInstance(global.getRocketUrl(), healtInfoService).start();
		HealthRecordConsumer.getInstance(global.getRocketUrl(), recordService).start();
		HealthServiceConsumer.getInstance(global.getRocketUrl(), serviceService).start();
	}

}
