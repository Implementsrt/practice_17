package com.qhy.goods.config;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Properties;

/**
 * @author qhy
 * @date 2021/12/30 9:40
 */
@Configuration
public class MybatisPlusConfig {

    @Resource
    private PageHelperConfig pageHelperConfig;

    @Bean
    public PageInterceptor pageInterceptor() {

        Properties properties = new Properties();
        // 不知道为什么会有一个DefaultListenableFactory的属性，等我有空先
        Map<String, Object> propertiesMap = BeanUtil.beanToMap(pageHelperConfig);
        // 移除非String类型的配置
        propertiesMap.entrySet().removeIf(next -> !String.class.equals(next.getValue().getClass()));
        properties.putAll(propertiesMap);

        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }

    // @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

}
