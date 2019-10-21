# Spring 操作 Redis Repositoy
<!-- toc -->

- [操作方式](#操作方式)
- [`Redis Repository` 使用](#Redis-Repository-使用)
  * [代码仓库](#代码仓库)
  * [demo 功能介绍](#demo-功能介绍)
- [资料](#资料)

<!-- tocstop -->
## 操作方式

spring 操作 redis 有好几种方式,以下是最常用的两种,并且都是同步的方式

-   `RedisTemplate`
-   `Redis Repository`

以上是 spring 对 redis 客户端的封装的结果,redis 客户端按照不同的 spring 版本分为不同的依赖,常用的有`jedis`, `lettuce`

spring 从 5.0 版本开始也支持了 响应式的方式去访问 redis server,但是未必用的上,主要是封装`lettuce`这个 redis 客户端才得以支持,`jedis`是不支持 reactive 方式访问 redis server 的

## `Redis Repository` 使用

### 代码仓库

地址: [GitHub](https://github.com/suveng/demo/tree/master/spring.redis)

### demo 功能介绍

-   使用 `spring-boot-starter-data-redis:2.1.2`
-   使用 `Redis Repository` 特性, 简便操作 redis 数据库
-   对象存储,key-value
-   设置过时时间

操作流程

1. 一个 redis server , version >=2.8
2. 一个 springboot, 带有 web,lombok,redis 等组件,springboot version>2.0
3. 持久化对象 domain
4. dao 层, repository

源码阅读

-   查看`RedisConfig`
    -   `@Configuration`表示配置类
    -   `@EnableRedisRepositories`表示启用 Redis Repository 功能
    -   `RedisConnectionFactory`是 redis 的连接池,配置`RedisTemplate`需要
    -   `RedisTemplate`作为 Redis Repository 的依赖
-   查看 domain 里面的`person`类

    -   `@RedisHash(people)` 标识 key 的前缀;`@Id`标识该字段作为`people`的唯一标识,也是作为 key 的后半部分.
    -   `@TimeToLive` 表示过期时间,一旦过期,该 key 对应的 redis 的对象将会移除

-   查看`AppController`
    -   查看主逻辑即可,只是一个 web 接口的入口.
    -   里面包含操作 redis repository 的 curd 使用,以及设置过期时间

## 资料

[官网 spring data redis 2.2.x 版](https://docs.spring.io/spring-data/redis/docs/2.2.x/reference/html/#reference)
