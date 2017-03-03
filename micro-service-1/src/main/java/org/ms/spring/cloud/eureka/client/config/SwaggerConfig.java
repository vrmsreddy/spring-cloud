package org.ms.spring.cloud.eureka.client.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author MS
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig { 
    /**
     * @return
     */
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
        .groupName("ms-admin")
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("org.ms.spring.cloud.eureka.client.controller"))
        .paths(regex("/.*"))
        .build();                                           
    }
    private ApiInfo apiInfo() {
    	return new ApiInfo(
          "REST APIs for the MS-Admin",
          "This WebUI describe the REST APIs that can be used to manipulate the 'MS-admin' service",
          "v2.0",
          "Terms of service",
          "ms@gmail.com",
          "License of API",
          "API license URL");
    }
}
