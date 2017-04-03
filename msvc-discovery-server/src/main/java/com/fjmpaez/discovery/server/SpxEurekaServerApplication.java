package com.fjmpaez.discovery.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpxEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpxEurekaServerApplication.class, args);
	}

}
