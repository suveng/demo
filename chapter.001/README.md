# 校园招聘系统

 [在线接口文档地址](http://192.168.9.232:4999/web/#/8?page_id=140)

## 项目简介

- 网申模块
- 助力活动模块

## 技术选型

- JDK1.8
- springboot
- MyBatis
- Redis
- MySQL
- Druid
- fastJSON
- LogBack

## 构建

- mvn clean install -Dmaven.test.skip=true
- mvn clean package -Dmaven.test.skip=true

## 部署

- 本地部署

- 测试部署

## 测试策略

- junit4

自动化测试如何分类，哪些必须写测试，哪些没有必要写测试

## 领域模型(业务对象封装)


## 技术架构



## 部署架构

![](http://192.168.9.232:4999/server/../Public/Uploads/2019-07-23/5d36e5fab92cc.png)

# 外部依赖

- 佣金模块

- 实名模块

    - [FaceID服务](https://faceid.com/pages/documents/)
    
    - [聚合数据服务](https://www.juhe.cn/docs)


## 环境信息 

- 各个环境的访问方式，数据库连接等

## 编码实践

- 统一的编码实践，比如异常处理原则、分页封装等
- 统一过滤: 项目所有请求都是经过AuthenticationFilter的过滤器,参数经过过滤器会封装到一个 `reqData` 的属性
- 统一返回: 统一用Result作为返回体,工厂类ResultBuilder
- 统一日志msg格式: LogDetail是封装的日志抽象,原理是 `String.format()`
- 统一版本接口:  

## FAQ


