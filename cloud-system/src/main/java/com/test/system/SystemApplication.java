package com.test.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


//@ServletComponentScan(basePackages = "com.test.system.filter.UrlFilter")
@ServletComponentScan
@EnableEurekaClient
@SpringBootApplication
public class SystemApplication {
	
	public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args );
    }

}
