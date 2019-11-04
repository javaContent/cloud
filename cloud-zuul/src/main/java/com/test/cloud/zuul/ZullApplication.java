package com.test.cloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.test.cloud.zuul","com.test.system.api"})
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZullApplication {

	public static void main(String[] args) {
        SpringApplication.run(ZullApplication.class, args );
    }
	
}
