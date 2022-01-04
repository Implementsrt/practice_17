package cn.qhy.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author qhy
 * @date 2021/10/13 10:36
 */
@SpringBootApplication(scanBasePackages = "cn.qhy.*")
@MapperScan("cn.qhy.**.mapper")
@ServletComponentScan("cn.qhy.*")
public class GoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }

}
