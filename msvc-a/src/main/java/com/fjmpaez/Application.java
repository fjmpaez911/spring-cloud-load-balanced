package com.fjmpaez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

import com.fjmpaez.configuration.SPXRibbonConfigurator;

@SpringBootApplication
@EnableEurekaClient
@RibbonClients(defaultConfiguration = SPXRibbonConfigurator.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
