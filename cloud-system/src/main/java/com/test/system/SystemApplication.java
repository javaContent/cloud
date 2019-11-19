package com.test.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages = {"com.test.system","com.test.system.api","com.test.frame"})
@EnableSwagger2
//@ServletComponentScan
@EnableEurekaClient
@SpringBootApplication
public class SystemApplication {
	
	public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args );
    }

}
