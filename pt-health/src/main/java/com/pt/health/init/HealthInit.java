package com.pt.health.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.netflix.discovery.EurekaClient;
import com.pt.common.util.EurekaUtil;


@Component
public class HealthInit implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private EurekaClient client;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		EurekaUtil.getInstance().init(client);
	}
}
