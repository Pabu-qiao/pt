package com.pt.recommend.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootConfiguration
@PropertySource(value = { "file:config/global.properties" })
@ConfigurationProperties()
public class Global {

	private String rocketUrl;
	
	public String getRocketUrl() {
		return rocketUrl;
	}
	public void setRocketUrl(String rocketUrl) {
		this.rocketUrl = rocketUrl;
	}
}
