package com.test.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RegistryApplication {
	
	public static void main(String[] args) {
        SpringApplication.run(RegistryApplication.class, args );
    }

}
