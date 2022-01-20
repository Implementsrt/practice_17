package cn.qhy.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

/**
 * SpringDoc配置
 *
 * @author qhy
 */
@OpenAPIDefinition(
        // openapi定义描述
        info = @Info(
                title = "练习商城文档",
                version = "v1.0.0",
                description = "练习商城文档说明",
                termsOfService = "http://localhost/goods/",
                contact = @Contact(name = "qhy", url = "https://github.com/Implementsrt", email = "Implementsrt@outlook.com")
        ),
        // 请求服务器地址配置，可以按不同的环境配置
        servers = {
                @Server(
                        url = "localhost/goods/",
                        description = "本地地址"
                )
        }
)
@Configuration
@ServletComponentScan("cn.qhy.common.*")
public class SpringDocConfig {

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public GroupedOpenApi goodsApi() {
        return GroupedOpenApi.builder()
                // 这个好像不能用中文
                .group(applicationName)
                .packagesToScan("cn.qhy.goods.web")
                .addOperationCustomizer(operationCustomizer())
                .build();
    }


    private OperationCustomizer operationCustomizer() {
        return (operation, handlerMethod) -> operation.addParametersItem(
                new Parameter()
                        .in("header")
                        .required(false)
                        .schema(new StringSchema())
                        .name(HttpHeaders.AUTHORIZATION)
                        .description("登录凭证")
        ).description(null == operation.getDescription() ? null : "<p style=\"color:red\">" + operation.getDescription() + "</p>");
    }


}
