package xyz.ledyx.manipulate_headers.configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@SecurityScheme(
        type = SecuritySchemeType.APIKEY, name = "api_key",
        in = SecuritySchemeIn.HEADER)
@Configuration
public class OpenApiConfig {



    /*@Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components());
    }*/

    /*@Bean
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder()
                .addOpenApiCustomizer(openApi -> {
                    openApi.security(
                            List.of(new SecurityRequirement().addList("foo"))
                    );
                })
                .build();
    }*/
}
