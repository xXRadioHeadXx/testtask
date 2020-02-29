package com.testtask.rest_service.swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.Collections;

@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.testtask.rest_service.controller"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiInfo());
    }



    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("My Spring Boot REST API",
                "Some custom description of API.",
                "API TOS",
                "Terms of service",
                new Contact("Anton Gavrilin",
                        "https://penza.hh.ru/resume/35fb0923ff00f5737b0039ed1f4c39496e7670",
                        "a.u.gavrilin@gmail.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0.html",
                Collections.emptyList());
        return apiInfo;
    }
}