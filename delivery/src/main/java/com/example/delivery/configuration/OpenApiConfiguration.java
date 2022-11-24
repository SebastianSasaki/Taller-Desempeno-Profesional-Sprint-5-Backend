package com.example.delivery.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean(name = "deliveryAPI")
    public OpenAPI deliveryApi(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Delivery Application API")
                        .description("Delivery API implemented with Spring Boot RESTful service and documented using spingdoc_openapi and OpenAPI 3.0"));
    }
}