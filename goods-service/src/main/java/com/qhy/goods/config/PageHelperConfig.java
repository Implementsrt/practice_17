package com.qhy.goods.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author qhy
 * @date 2021/12/30 16:31
 */
@Data
@Configuration
@PropertySource(value = "classpath:pagehelper.yml", factory = YamlPropertyLoaderFactory.class)
@ConfigurationProperties(prefix = "pagehelper")
public class PageHelperConfig {

    private String helperDialect;

    private String pageSizeZero;

    private String reasonable;

    private String supportMethodsArguments;

    private String offsetAsPageNum;

}
