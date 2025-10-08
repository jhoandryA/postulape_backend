package com.sise.postulape_backend.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API-Sistema de Reclutamiento")
                .description("Documentación de los endpoints del sistema de reclutamiento (CRUD)")
                .version("1.0.0"));
    }
}