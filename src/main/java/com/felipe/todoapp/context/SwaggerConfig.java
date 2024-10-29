package com.felipe.todoapp.context;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Todo API")
                        .version("v1")
                        .description("La API REST de ToDo App.")
                        .termsOfService("Terms of service")
                        .contact(new Contact().name("Felipe Marroquin").url("www.example.com").email("myeaddress@company.com"))
                        .license(new License().name("License of API").url("API license URL")));
    }
}
