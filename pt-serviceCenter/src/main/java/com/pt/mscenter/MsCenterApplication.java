package com.pt.mscenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer		//开启Eureka注册中心
public class MsCenterApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsCenterApplication.class, args);
	}
}
