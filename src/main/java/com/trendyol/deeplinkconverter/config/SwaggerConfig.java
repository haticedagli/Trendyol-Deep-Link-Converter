package com.trendyol.deeplinkconverter.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().addServersItem(new Server().url("http://localhost:8080"))
                .components(new Components()
                        .addSecuritySchemes("Authorization", new SecurityScheme()
                                .type(SecurityScheme.Type.OAUTH2)
                                .description("")
                                .flows(new OAuthFlows()
                                        .password(new OAuthFlow()
                                                .tokenUrl("/oauth/token")
                                        )
                                )
                                .in(SecurityScheme.In.HEADER).name("Authorization")
                        ))
                .info(new Info().title("Deeplink Converter Service")
                        .description("Deeplink Converter Service Restfull API").version("v0.0.1"))
                .addSecurityItem(new SecurityRequirement().addList("Authorization", Collections.singletonList("all")));
    }
}
