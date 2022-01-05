package cn.qhy.goodsfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author qhy
 * @date 2022/1/4 17:48
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class GoodsFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsFeignApplication.class, args);
    }

}
