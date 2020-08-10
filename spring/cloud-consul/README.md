# consul 服务中心

使用的版本

-   server 1.5.0

## 1 简介

功能

-   服务注册中心-服务提供者
-   服务配置中心-应用启动前拉取配置

### 1.1 springcloud 的 demo 演示

-   GitHub
    -   [https://github.com/suveng/demo/tree/master/spring-cloud-consul-demo](https://github.com/suveng/demo/tree/master/spring-cloud-consul-demo)

### 1.2 consul 本地 docker 安装

```shell
docker run -d --rm --name consul -p 8400:8400 -p 8500:8500 -p 8600:53/udp -h node1 progrium/consul -server -bootstrap
```

## 2. springcloud 注册服务

2.1. 添加 maven 依赖
2.2. springboot 配置 application.yml 注册服务

### 2.1. 添加 maven 依赖

```xml
<!--consul服务注册功能-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-consul-all</artifactId>
</dependency>
```

```xml
<!--使用config, 解析yml-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```

### 2.2. springboot 配置 bootstrap.yml 注册服务

```yaml
spring:
    application:
        name: zuul-service
    cloud:
        consul:
            host: 192.168.9.233
            port: 8500
            discovery: # consul 注册中心
                prefer-ip-address: true #  ip 偏好; 这个必须配
                service-name: zuul-service #注册在consul上面的名字，在consul的调用中，是通过此名字调用的
                register-health-check: true #健康检查，保证服务处于启动状态，建议开启
                instance-id: ${spring.application.name}:${spring.cloud.client.ip-address} # 服务id
                health-check-url: http://${spring.cloud.client.ip-address}:${server.port}/actuator/health # 健康检查的URI
```

### 2.3 spring-cloud-starter-consul-discovery 的配置属性详解

> 版本: spring-cloud-consul-discovery-2.0.0.RELEASE
> 配置信息类: org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties
> 入口方法: 可以从 idea 的 bootstrap.yml 点击具体属性进入,注意属性类的继承性
> 推荐技巧: 打开 idea 的 structure 面板查看
> [Spring Cloud Consul 的官方文档](https://cloud.spring.io/spring-cloud-consul/reference/html/)

```shell
spring:
  cloud:
    consul:
      host: 192.168.9.233 # ip
      port: 8500 # 端口
      discovery: # consul 注册中心
        service-name: zuul-service #注册在consul上面的名字，在consul的调用中，是通过此名字调用的
        register-health-check: true #健康检查，保证服务处于启动状态，建议开启
        instance-id: ${spring.application.name}:${spring.cloud.client.ip-address} # 服务id
        health-check-url: http://${spring.cloud.client.ip-address}:${server.port}/actuator/health # 健康检查的URI
        tags: # 标签,这个属性是个list,所以用yml的list的格式注入
          - gateway
          - common
          - other
          - firstboot
        enabled: true # 服务发现是否启动
        management-tags: # 注册管理服务时使用的标记,默认是management
          - sss
        # health-check-path: /health/check # 要调用以进行运行状况检查的备用服务器路径,已经使用health-check-url覆盖了,所以这属性暂时找不到有什么用处
        health-check-interval: 10s # 字符串,执行运行状况检查的频率（例如10秒），默认为10秒。
        health-check-timeout: 10s # 健康检查超时（例如10秒）。
        health-check-critical-timeout: 30s # 注销关键服务的时间, 要求consul的版本在1.0.7或者更高
        prefer-ip-address: true #  ip 偏好; 这个必须配 在注册过程中使用ip地址而不是主机名
        prefer-agent-address: false # 来源,我们将如何确定使用的地址
        # ip-address: 192.168.9.233 # 访问服务时要使用的IP地址（还必须设置要使用的首选IP地址）
        # hostname: # Hostname to use when accessing server
        # port: 8500 # Port to register the service under (defaults to listening port)
        # management-port: # Port to register the management service under (defaults to management port)
        # catalog-services-watch-delay: 1000 # 查看consul的服务更新间隔,默认1s
        # catalog-services-watch-timeout: 2 # 查看consul服务更新间隔的超时时间, 默认两秒
        query-passing: true # 这推动健康检查 pass 传递到服务器。
        deregister: false # 在consul禁用自动注销登记服务。
        fail-fast: true # *服务登记期间抛出异常如果这是真的,否则,日志警告(默认值为true)。
        # health-check-tls-skip-verify: true # 跳过证书校验, 如果不是则进行证书校验
      config:   # consul 配置中心
        prefix: config
        enabled: true
        format: YAML
        data-key: settings.yml
```

## 3. 配置中心使用(在注册服务的前提上)

3.1. springboot 配置文件配置 consul 的配置中心路径和格式
3.2. 在 consul 的 key/value 的控制面板上添加和 springboot 配置的路径的配置文件,以 yaml 格式
3.3. 把配置保存在对应的项目中,目录路径/用\_线代替

### 3.1. springboot 配置文件配置 consul 的配置中心路径和格式

```yaml
spring:
    application:
        name: zuul-service
    cloud:
        consul:
            host: 192.168.9.233
            port: 8500
            discovery: # consul 注册中心
                prefer-ip-address: true #  ip 偏好; 这个必须配
                service-name: zuul-service #注册在consul上面的名字，在consul的调用中，是通过此名字调用的
                register-health-check: true #健康检查，保证服务处于启动状态，建议开启
                instance-id: ${spring.application.name}:${spring.cloud.client.ip-address} # 服务id
                health-check-url: http://${spring.cloud.client.ip-address}:${server.port}/actuator/health # 健康检查的URI
            config: # consul 配置中心
                prefix: config
                enabled: true
                format: YAML
                data-key: settings.yml
```

### 3.3. 把配置保存在对应的项目中,目录路径/用\_线代替

这是 settings.yml,在 consul 的路径是 `config/<service-name>,<profile>/settings.yml`

```yaml
zuul:
    routes:
        console:
            path: /console/**
            serviceId: console-service
            strip-prefix: false
        order:
            path: /order/**
            serviceId: order-service
            strip-prefix: false
    add-host-header: true
    add-proxy-headers: true
env:
    version: 1.0
    author: suveng
```

## 4. springcloud 注销服务

4.1. 去掉 maven 依赖
4.2. 删除配置,application.yml 和 bootstarp.yml 的
4.3. 清除 consul 线上的失效服务

清除线上的失效服务

1. 请求 consul 的接口删除

```shell
# 删除无效服务
http://<server_ip>:<port>/v1/agent/service/deregister/<service_id>  put请求

# 删除无效节点
http://<server_ip>:<port>/v1/agent/force-leave/<node_id>
```

2. 在注册的时候配置

[Spring Cloud Consul 应用下线后，健康检查自动删除无效服务](https://blog.csdn.net/Little_fxc/article/details/95331613)
[consul 删除不想要的服务](https://blog.csdn.net/qq_23367963/article/details/79199166)

## 资料

[Spring Boot 集成 Consul 配置中心, 配置有坑, 看评论](https://juejin.im/post/5ce1f236e51d45109b01b0ef)
