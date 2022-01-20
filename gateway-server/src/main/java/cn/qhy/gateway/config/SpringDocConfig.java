package cn.qhy.gateway.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qhy
 * @date 2022/1/19 17:57
 */
@Configuration
public class SpringDocConfig {
    @Bean
    @Lazy(false)
    public List<GroupedOpenApi> apis(SwaggerUiConfigParameters swaggerUiConfigParameters, RouteDefinitionLocator locator) {
        List<GroupedOpenApi> groups = new ArrayList<>();
        List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();

        definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*-service"))
                .forEach(routeDefinition -> {
                    String name = routeDefinition.getId().replaceAll("-service", "");
                    swaggerUiConfigParameters.addGroup(name);
                    GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build();
                });
        return groups;
    }

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info(new Info().title("练习商城文档")
                .description("练习商城文档说明")
                .version("v1.0.0")
                .contact(new Contact()
                        .name("qhy")
                        .url("https://gitee.com/Implementsrt")
                        .email("Implementsrt@outlook.com")));
    }
}
