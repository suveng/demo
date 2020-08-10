# springboot grpc 整合

在32.grpc-demo-maven中, 已经写好了grpc官网提供的demo,可以初步体会到grpc的高效率
但是对于Java, 我还是习惯用spring的生态, 所以有了这个整合grpc
在网上翻阅到艿艿的一篇文章,于是前来再写一个属于我自己的demo
艿艿的文章:http://www.iocoder.cn/Spring-Boot/gRPC
gRPC 社区暂时没有提供 Spring Boot Starter 库，以简化我们对 gRPC 的配置。不过艿艿经过一轮搜寻对比，发现咱国产了 gRPC Spring Boot Starter 项目，能够很好的满足我们的诉求。
https://github.com/yidongnan/grpc-spring-boot-starter/blob/master/README-zh-CN.md
```xml
<!-- 国产的grpc starter -->
<!-- https://yidongnan.github.io/grpc-spring-boot-starter/ -->
<dependency>
    <groupId>net.devh</groupId>
    <artifactId>grpc-server-spring-boot-starter</artifactId>
    <version>2.9.0.RELEASE</version>
</dependency>

<dependency>
    <groupId>net.devh</groupId>
    <artifactId>grpc-client-spring-boot-starter</artifactId>
    <version>2.9.0.RELEASE</version>
</dependency>

```


## 基本模块

35.grpc-springboot-demo
- 35.server
- 35.client
- interface


35.server --- grpc server的实现, 这里是从32的实现复制过来的,然后不自己实现server,而是使用starter自带的注解启动grpc server
35.client --- grpc client的实现, 这个可以由proto文件各自生成client,不限,但是我们这里使用starter提供的grpcclient注解实现一个client



gRPC 框架的 Spring Boot 启动器模块

- 使用@ GrpcService自动创建并运行一个 gRPC 服务，内嵌在 spring-boot 应用中
- 使用@ GrpcClient自动创建和管理你的channel和stub
- 支持 Spring Cloud（向 Consul 或 Eureka 或 Nacos 注册服务并获取gRPC服务信息）
- 支持 Spring Sleuth 进行链路跟踪(需要单独引入 brave-instrumentation-grpc)
- 支持对 server、client 分别设置全局拦截器或单个的拦截器
- 支持 Spring-Security
- 支持 metric (micrometer / actuator)
- 可以使用 (non-shaded) grpc-netty


## 关于grpc的client的配置

这个client starter 提供了client的一些通用参数配置, 可以根据自己业务来调整
https://github.com/yidongnan/grpc-spring-boot-starter/blob/master/README-zh-CN.md

