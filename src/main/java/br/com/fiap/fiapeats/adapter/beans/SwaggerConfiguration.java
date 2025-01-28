package br.com.fiap.fiapeats.adapter.beans;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("FiapEats MS Pedido")
                                .description("Documentação técnica para serviço de Pedidos")
                                .version("1.0.0"));
    }

    @Bean
    public GroupedOpenApi internal() {
        return GroupedOpenApi.builder()
                .pathsToMatch("/order/**")
                .group("internal")
                .build();
    }
}
