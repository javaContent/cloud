package com.test.registry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.test.registry.controller"))
				.paths(PathSelectors.any())
				.build();
//                .paths(PathSelectors.regex("/.*"))// 对根下所有路径进行监控
//                //不显示错误的接口地址
//                .paths(Predicates.not(PathSelectors.regex("/error.*")))//错误路径不监控
//                .build();
    }
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger接口API")//swagger的title
                .description("Swagger接口")//自己定义
                .termsOfServiceUrl("")//自己定义
                .version("1.0")
                .build();
	}

}
