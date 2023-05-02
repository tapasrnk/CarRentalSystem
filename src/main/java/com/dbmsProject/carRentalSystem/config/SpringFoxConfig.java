package com.dbmsProject.carRentalSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SpringFoxConfig {
    @Bean
    public Docket swaggerConfiguration() {
        String groupName = "Swagger";
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/**"))
                .apis(RequestHandlerSelectors.basePackage("com.dbmsProject"))
                .build()
//                .groupName(groupName)
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Car Rental System API",
                "API for Car Rental System",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Car Rental System", "https://carrentalsystem.onrender.com/", "carrentalsystem475@gmail.com"),
                "API License",
                "https://",
                Collections.emptyList());
    }
}
