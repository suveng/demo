# 12-0 大数据-flink

## 什么是flink?

> Apache Flink 是一个框架和分布式处理引擎，用于在无边界和有边界数据流上进行有状态的计算。Flink 能在所有常见集群环境中运行，并能以内存速度和任意规模进行计算。
> ---- 官网
>
> [Apache Flink: Apache Flink 是什么？](https://flink.apache.org/zh/flink-architecture.html)

Flink 是一种流式计算框架, 三驾马车中的计算框架

Flink 处理的是数据, 数据被定义为有界流和无界流

------

<u>什么是有界流</u>? 
有头有尾
有定义流的开始, 有定义流的结束

------

<u>什么是无界流</u>? 
有头无尾
有定义流的开始, 没有定义流的结束

------

### 架构是什么? 

组成: 
- CEP event processing
- FlinkML marchine learning
- Gelly graph processing
- Table relational
- DataStream API
- DataSet API

------



![l1McoK](https://gitee.com/suveng/upic/raw/master/uPic/l1McoK.jpg)

### 特性是什么? 

- checkpoint
- savepoint

### 应用场景是什么? 

- 事件驱动型应用
- 数据分析型应用
- 数据管道应用

#### 事件驱动型应用
事件驱动型应用是**一类具有状态的应用**，它从**一个或多个事件流提取数据**，并根据到来的事件触发计算、状态更新或其他外部动作。

事件驱动型应用是在计算存储分离的传统应用基础上进化而来。在传统架构中，应用需要读写远程事务型数据库。

相反，事件驱动型应用是基于状态化流处理来完成。在该设计中，数据和计算不会分离，应用只需访问本地（内存或磁盘）即可获取数据。系统容错性的实现依赖于定期向远程持久化存储写入 checkpoint。下图描述了传统应用和事件驱动型应用架构的区别。



![WtC6OX](https://gitee.com/suveng/upic/raw/master/uPic/WtC6OX.jpg)



<u>事件驱动型应用优势</u>

- 无需查询远程数据库, 本地访问使他拥有更高的吞吐和更低的延迟
- 远程持久化的checkpoint定期, 增量完成
- 减少依赖升级带来的麻烦



<u>事件驱动型实例</u>: 

- 反欺诈
- 异常检测
- 基于规则告警
- 业务流程监控
- 社交网络 web应用



<u>Flink 如何支持事件驱动型应用？</u>

事件驱动型应用会受制于底层流处理系统对时间和状态的把控能力，Flink 诸多优秀特质都是围绕这些方面来设计的。

1. 它提供了一系列丰富的状态操作原语
   允许以精确一次的一致性语义合并海量规模（TB 级别）的状态数据。
2. Flink 还支持事件时间和自由度极高的定制化窗口逻辑，而且它内置的 ProcessFunction 支持细粒度时间控制，方便实现一些高级业务逻辑
3. Flink 还拥有一个复杂事件处理（CEP）类库，可以用来检测数据流中的模式。
4. Flink 中针对事件驱动应用的明星特性当属 savepoint。
   Savepoint 是一个一致性的状态映像，它可以用来初始化任意状态兼容的应用。在完成一次 savepoint 后，即可放心对应用升级或扩容，还可以启动多个版本的应用来完成 A/B 测试



#### 数据分析应用

数据分析任务需要从原始数据中提取有价值的信息和指标
- 批量分析
- 流式分析

Apache Flink 同时支持流式及批量分析应用
![bP5uP4](https://gitee.com/suveng/upic/raw/master/uPic/bP5uP4.jpg)

流式分析应用的优势? 
- 从事件中获取指标的延迟更低, 因为和批量分析相比,流式分析省掉了周期性的数据导入和查询过程
- 无需考虑数据边界
- 简化应用抽象, 因为流水线的步骤Flink从数据到计算结果的过程都涵盖了,还提供故障恢复机制

Flink 如何支持数据分析类应用？
Flink 为持续流式分析和批量分析都提供了良好的支持。具体而言，它内置了一个符合 ANSI 标准的 SQL 接口，将批、流查询的语义统一起来。无论是在记录事件的静态数据集上还是实时事件流上，相同 SQL 查询都会得到一致的结果。同时 Flink 还支持丰富的用户自定义函数，允许在 SQL 中执行定制化代码。如果还需进一步定制逻辑，可以利用 Flink DataStream API 和 DataSet API 进行更低层次的控制。此外，Flink 的 Gelly 库为基于批量数据集的大规模高性能图分析提供了算法和构建模块支持


#### 数据管道应用 

数据管道就是数据迁移和转化的过程

提取-转换-加载 (ETL) extract transform load

周期性ETL和流式数据管道的区别

![Vp5oVx](https://gitee.com/suveng/upic/raw/master/uPic/Vp5oVx.jpg)

流式数据管道优势:
- 持续的数据流 延迟更低
- 持续消费和发送数据

flink如何支持数据管道
- Flink的SQL接口,用户自定义函数, DataStream API
- 为多种数据存储系统提供内置连接器, kafka, es, jdbc 
- 提供文件系统的连续型数据源

数据管道应用实例: 
- 电子商务实时查询索引构建
- 电子商务的持续ETL

### 优缺点是什么? 

优点 
- 处理无界和有界数据
- 部署到任何地方
- 运行任意规模的应用
- 利用内存性能


部署到任何地方
Flink 集成了所有常见的集群资源管理器，例如 Hadoop YARN、 Apache Mesos 和 Kubernetes，但同时也可以作为独立集群运行。


运行任意规模的应用
应用程序被并行化为可能数千个任务，这些任务分布在集群中并发执行。所以应用程序能够充分利用无尽的 CPU、内存、磁盘和网络 IO

利用内存性能
有状态的 Flink 程序针对本地状态访问进行了优化。任务的状态始终保留在内存中，如果状态大小超过可用内存，则会保存在能高效访问的磁盘数据结构中。任务通过访问本地（通常在内存中）状态来进行所有的计算，从而产生非常低的处理延迟。Flink 通过定期和异步地对本地状态进行持久化存储来保证故障场景下精确一次的状态一致性。
![dsbSsX](https://gitee.com/suveng/upic/raw/master/uPic/dsbSsX.jpg)


## 为什么需要flink? 

1. 提供准确的结果, 甚至在出现无序或者延迟加载的数据的情况下
2. 状态容错, savepoint特性
3. 大规模运行

## flink的使用



### 安装

#### mac os

```bash
brew install flink	
```



<u>安装的位置</u>: 

`/usr/local/Cellar/apache-flink`



<u>验证安装成功</u>: 

`flink --version`

### 查看配置

[flink配置文件](https://mp.weixin.qq.com/s?__biz=MzIxMTE0ODU5NQ==&mid=2650237495&idx=1&sn=9e4ae9bde1e56a6620041975a13f6c9c&scene=19#wechat_redirect)

### 配置DataSource

[DataSource介绍](https://mp.weixin.qq.com/s?__biz=MzIxMTE0ODU5NQ==&mid=2650237500&idx=1&sn=ee850cfc108f7922a896c8e4da6c8065&scene=19#wechat_redirect)

数据源

1. 内置的
2. 扩展的



内置

- 集合
- 文件
- socket



<u>如何自定义DataSource?</u>

[自定义DataSource----zhiseng](https://mp.weixin.qq.com/s?__biz=MzIxMTE0ODU5NQ==&mid=2650237509&idx=1&sn=224ee608bee4c752dbc2b5b625328139&scene=19#wechat_redirect)



查看flink版本

```bash
flink --version
```



查看flink对应的scala版本

1. 查看flink版本
2. 去官方网站, 查看对应版本的文档
3. 找到从源码构建, 里面包含了scala的版本





### 配置DataSink

1. 内置的sink
2. 自定义sink



内置的sink

- kafka
- es
- socket
- rabbitmq
- JDBC
- cassandra 
- file
- print



如何自定义sink? 

1. 实现sink的接口
2. 在上下文增加sink




## flink的最佳实践

