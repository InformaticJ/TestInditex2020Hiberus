package com.inditex.test.infrastructure.inputadapter.rest.swagger;

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
public class ConfigSwagger {

    private static final String TITLE = "Test Inditex 2020 API";
    private static final String DESCRIPTION = "Test Inditex 2020 API";
    private static final String BASE_PACKAGE = "com.inditex.test.infrastructure.rest.inputadapter.controllers.Impl";
    private static final String VERSION = "v1";

    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .build()
                .forCodeGeneration(true)
                .apiInfo(new ApiInfoBuilder().title(TITLE).description(DESCRIPTION).version(VERSION).build());
    }
}
