package cn.qhy.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OperationCustomizer;
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
                version = "1.0.0",
                description = "练习商城文档说明",
                termsOfService = "http://localhost:9001/",
                contact = @Contact(name = "qhy", url = "https://gitee.com/Implementsrt", email = "implementsrt@outlook.com")
        ),
        // 请求服务器地址配置，可以按不同的环境配置
        servers = {
                @Server(
                        url = "http://localhost:9001",
                        description = "本地地址"
                )
        }
)
@Configuration
@ServletComponentScan("cn.qhy.common.*")
public class SpringDocConfig {

    @Bean
    public GroupedOpenApi goodsApi() {
        return GroupedOpenApi.builder()
                // 这个好像不能用中文
                .group("spring-doc-goods")
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
