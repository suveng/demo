# springcloud gateway

12/19/2019
[官网文档](https://cloud.spring.io/spring-cloud-static/spring-cloud-gateway/2.2.0.RELEASE/reference/html/)
版本 

- java 1.8

- springcloud gateway 2.2.0.RELEASE

- springcloud Hoxton.RELEASE


## 引入springcloud

引入maven依赖

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
```

> 如果引入了springcloud gateway,但是并不像启用他,可以通过设置`spring.cloud.gateway.enabled=false` 来禁用
> gateway是基于netty和webflux,不是基于servlet的,所以不需要引入web模块.

## 专有词汇

- Route(路由): 这是网关的基本构建块.它由一个 ID,一个目标 URI,一组断言和一组过滤器定义.如果断言为真,则路由匹配。
- Predicate(断言):这是一个 Java 8 的 Predicate.输入类型是一个 ServerWebExchange.我们可以使用它来匹配来自 HTTP 请求的任何内容,例如 headers 或参数
- Fliter(过滤器):

## 工作原理

1. 客户端发起Request到Gateway
2. 如果Gateway判定这个请求匹配到Route,它会发送到Gateway Web Handler
3. 这个Handler运行一条专用于该Request的Filter Chain
4. 究其原因,Filter由虚线划分,能够在发送Request之后或者代理Request之前,Filter可以执行逻辑

![](https://gitee.com/suveng/upic/raw/master/EAPMxU.jpg)

通过不同的Predicate来决定Request是否匹配,配合配置中心,可以做到路由热插拔

建议:
1. application-xxx.yml使用环境特有的参数,改变spring.active.profile并不会重新读取对应的application-xxx.yml文件.
2. springcloud gateway 的 predicate 是可以通过consul的配置来动态加载的.改变之后,路由也会相应发生变化.
