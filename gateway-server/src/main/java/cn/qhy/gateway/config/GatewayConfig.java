package cn.qhy.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @author qhy
 * @date 2022/1/4 17:15
 */
@Configuration
public class GatewayConfig {

    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getHostName());
    }

    @Bean
    @Primary
    public RateLimiter<RedisRateLimiter.Config> myRateLimiter(){
        /*
        * defaultReplenishRate: 每秒钟可以请求的次数
        * defaultRequestedTokens: 每次请求消耗的令牌数量
        * defaultBurstCapacity: 每秒钟令牌桶内的最大数量
        * 所以用户实际可以访问的次数为：#3 整除 #2    那 #1 有什么用？
        */
        return new RedisRateLimiter(10, 20, 1);
    }

}
