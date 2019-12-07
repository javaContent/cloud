package com.test.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages = {"com.test.registry","com.test.system.api","com.test.frame"})
@EnableSwagger2
@EnableEurekaClient
@SpringBootApplication
public class RegistryApplication {
	
	public static void main(String[] args) {
        SpringApplication.run(RegistryApplication.class, args );
    }

}
