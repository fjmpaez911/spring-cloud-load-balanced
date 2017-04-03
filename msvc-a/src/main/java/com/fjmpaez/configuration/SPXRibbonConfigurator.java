package com.fjmpaez.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

@Configuration
public class SPXRibbonConfigurator {

    @Bean
    public IPing ribbonPing() {
        PingUrl pingUrl = new PingUrl();
        pingUrl.setPingAppendString("/info");
        return pingUrl;
    }

    @Bean
    public IRule ribbonRule() {
        return new AvailabilityFilteringRule();
    }

}