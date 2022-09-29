package com.api.businessReportingAgency.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi(){
        return new Docket((DocumentationType.SWAGGER_2) )
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.api.businessReportingAgency"))
                .paths(regex("/report.*"))
                .paths(regex("/employee.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "businessReportingAgency",
                "API REST DE GERENCIAMENTO DE RELATÓRIOS",
                "1.0",
                "Terms of Service",
                new Contact("karen","https://github.com/KarenAlmeida21/businessReportingAgency","karenalmeida61@hotmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", Collections.emptyList()

        );
        return apiInfo;



    }



}
