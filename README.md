# 技术练习项目


> 整体使用微服务架构，基于SpringCloud<br>
> 不需要深入研究用户的使用便捷性，尽量以学习解决方案为主<br>
> 如果同一个需求有多种解决方案，那么挑常见的都写一遍<br>


## 预期功能模块
- 安全认证模块
- 用户管理模块
- 商家用户管理
- 会员模块
- 商品模块
- 订单模块
- 秒杀模块
- 优惠券模块
- 日志审计模块

## 涉及技术以及应用
|  技术   | 功能  |
|  :----:  | :----:  |
|SpringCloud以及相关技术、SpringBoot |	系统架构 |
|Mysql、MybatisPlus |	数据管理 |
|Mysql主从复制，读写分离Gaea |	尝试 |
|seata |	分布式事务 |
|feign |/ribbon	服务调用负载均衡 |
|mq |	订单支付延时回调、超时订单处理 |
|smartdoc |	文档 |
|SpringCloudGateway + Swagger |	网关存放文档 |
|Elasticsearch |	商品搜索 |
|MongoDB |	热点商品存储 |
|ELK |	日志收集 |
|Fluentd |	另一种日志收集实现 |
|Hystrix | 以及dashboard	断路器以及断路器监控 |
|SpringCloudSleuth |	分布式请求链路跟踪 |
|Consul	|服务治理与配置中心|
|spring cloud gateway/zuul	|网关的多重实现|
|SpringBootAdmin	|微服务应用监控|
|SpringCloudAlibaba/nacos	|另一个注册中心实现方案|
|Sentinel	|熔断和限流|
|jenkins	|持续部署|
|MinIO	|自建对象存储服务|
|nimbus-jose-jwt	|JWT?|
|PowerJob	|可视化任务调度|
|Elastic APM	|微服务应用性能监控|
|Quartz	|定时任务|
|canal	|Mysql数据同步到ES|
|多线程锁	|单体应用内处理|
|nio、netty、JVM、Spring	|**_源码教程阅读_**|