package com.test.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
//@ServletComponentScan
@EnableEurekaClient
@SpringBootApplication
public class SystemApplication {
	
	public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args );
    }

}
