package com.dogapi.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2 // enable Swagger 2
public class SwaggerConfig {
    // integrate Swagger into existing Spring Boot project:
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2) // says that documentation type is Swagger
                .select() // returns an instance of API selector builder controls endpoints exposed by Swagger
                .apis(RequestHandlerSelectors.any()) // allows documentation available for entire API
                .paths(PathSelectors.any()) // for both Request Handlers and Past Selectors
                .build()
                .useDefaultResponseMessages(false); // turn off default response messages
    }

    // apiInfo methods allow developers to customize some default values:
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Dog API",
                "This API returns a list of Plora's dogs.",
                "1.0",
                "http://localhost:3001/dogs",
                new Contact("Plora Tran", "www.udacity.com", "ploratran@gmail.com"),
                "License of API", "http://www.udacity.com/license", Collections.emptyList());
    }
}
