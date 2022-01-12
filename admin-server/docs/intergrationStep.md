## 配置spring-boot-admin步骤

1. 新建module [admin-server]
2. 引入依赖
``` xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>de.codecentric</groupId>
            <artifactId>spring-boot-admin-starter-server</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
```
3. 启动类添加注解
```
@EnableAdminServer
@EnableEurekaClient
```
4. 配置文件
```
server:
  port: 9301

spring:
  application:
    name: admin-server

eureka:
  client:
    registry-fetch-interval-seconds: 5
    service-url:
      defaultZone: ${EUREKA_SERVICE_URL:http://localhost:8001}/eureka/
  instance:
    lease-renewal-interval-in-seconds: 10
    health-check-url-path: /actuator/health
management:
  endpoints:
    web:
      exposure:
        include: '*'
  endpoint:
    health:
      show-details: ALWAYS
```


5. 需要监控的服务
    1. 引入依赖
   ```
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-actuator</artifactId>
   </dependency>
   ```
    2. 配置文件
   ```
   eureka:
     instance:
       health-check-url-path: /actuator/health
   management:
     endpoint:
       health:
         show-details: ALWAYS
     endpoints:
       web:
         exposure:
           include: "*"
   ```