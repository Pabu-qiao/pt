package com.pt.health;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HealthApplication {
	public static void main(String[] args) {
		SpringApplication.run(HealthApplication.class, args);
	}
}
