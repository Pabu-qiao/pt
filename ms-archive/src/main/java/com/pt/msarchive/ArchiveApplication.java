package com.pt.msarchive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ArchiveApplication {
	public static void main(String[] args) {
		SpringApplication.run(ArchiveApplication.class, args);
	}
}
