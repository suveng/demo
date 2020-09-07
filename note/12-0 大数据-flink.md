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

查看flink版本

```bash
flink --version
```



查看flink对应的scala版本

1. 查看flink版本
2. 去官方网站, 查看对应版本的文档
3. 找到从源码构建, 里面包含了scala的版本



### 配置DataSource extract

[DataSource介绍](https://mp.weixin.qq.com/s?__biz=MzIxMTE0ODU5NQ==&mid=2650237500&idx=1&sn=ee850cfc108f7922a896c8e4da6c8065&scene=19#wechat_redirect)

#### 数据源分类

1. 内置的
2. 扩展的



#### 内置数据源

- 集合
- 文件
- socket



#### 如何自定义DataSource?

[自定义DataSource----zhiseng](https://mp.weixin.qq.com/s?__biz=MzIxMTE0ODU5NQ==&mid=2650237509&idx=1&sn=224ee608bee4c752dbc2b5b625328139&scene=19#wechat_redirect)

1. 查找datasource的抽象接口
   - SourceFuction 
   - RichSourceFuction
2. 实现SourceFuction 接口
   - run() : 不断的产生数据
   - cancel(): 中断前的回调
   - open() 生命周期, 启动打开数据源的方法
   - close() 生命周期, 关闭数据源的方法

RichSourceFuction 抽象类 实现 SourceFuction接口

RichSourceFuction的子类

- MessageAcknowledgingSourceBase 抽象类  消息队列场景, 基于消息ID
- MultipleIdsMessageAcknowledgingSourceBase 抽象类 支持两种 ID 应答模型：session id 和 unique message id
- ContinuousFileMonitoringFunction 监视文件

### 配置DataSink Load



#### DataSink分类

1. 内置的sink
2. 自定义sink



#### 内置的sink

- kafka
- es
- socket
- rabbitmq
- JDBC
- cassandra 
- file
- print



#### 如何自定义sink? 

1. 实现sink的接口 SinkFuction
2. 在上下文增加sink



RichSinkFuction实现了SinkFuction 

重写/实现方法

- open() 打开datasink
- close() 关闭datasink
- invoke() 执行sink

### 数据转换 transform

transform形式

1. map
2. flatmap
3. filter
4. keyBy
5. reduce
6. fold
7. aggregations
8. window
9. windowAll
10. union
11. window join 
12. split
13. project

#### map

输入是数据流, 输出也是相同的数据流

#### flatmap

输入数据流, 输出0或多个的相同的数据流

#### filter

输入数据流, 输出0或多个相同的数据流

#### keyBy

输入数据流, 输出分区数据流, 结构改变

#### reduce

输入数据流, 返回单个的结果

类似map/reduce过程

分片->计算->统计

#### fold

Fold 通过将最后一个文件夹流与当前记录组合来推出 KeyedStream

#### aggregations

DataStream API 支持各种聚合，例如 min，max，sum 等。 这些函数可以应用于 KeyedStream 以获得 Aggregations 聚合。

#### window

输入分区数据流, 按规则分组

Flink 定义数据片段以便（可能）处理无限数据流。 这些切片称为窗口。 此切片有助于通过应用转换处理数据块。 要对流进行窗口化，我们需要分配一个可以进行分发的键和一个描述要对窗口化流执行哪些转换的函数

要将流切片到窗口，我们可以使用 Flink 自带的窗口分配器。 我们有选项，如 tumbling windows, sliding windows, global 和 session windows。 

Flink 还允许您通过扩展 WindowAssginer 类来编写自定义窗口分配器。 

#### windowAll

输入数据流, 按规则分组

#### union

Union 函数将两个或多个数据流结合在一起。 这样就可以并行地组合数据流。 如果我们将一个流与自身组合，那么它会输出每个记录两次。

#### window join

我们可以通过一些 key 将同一个 window 的两个数据流 join 起来

#### split

此功能根据条件将流拆分为两个或多个流。 当您获得混合流并且您可能希望单独处理每个数据流时，可以使用此方法

#### select

此功能允许您从拆分流中选择特定流

#### project

Project 函数允许您从事件流中选择属性子集，并仅将所选元素发送到下一个处理流。

### 几种时间Time

- Processing Time
- Event Time
- Ingestion Time

#### Processing Time

**Processing Time 是指事件被处理时机器的系统时间。**

当流程序在 Processing Time 上运行时，所有基于时间的操作(如时间窗口)将使用当时机器的系统时间。每小时 Processing Time 窗口将包括在系统时钟指示整个小时之间到达特定操作的所有事件。

例如，如果应用程序在上午 9:15 开始运行，则第一个每小时 Processing Time 窗口将包括在上午 9:15 到上午 10:00 之间处理的事件，下一个窗口将包括在上午 10:00 到 11:00 之间处理的事件。

Processing Time 是最简单的 "Time" 概念，不需要流和机器之间的协调，它提供了最好的性能和最低的延迟。但是，在分布式和异步的环境下，Processing Time 不能提供确定性，因为它容易受到事件到达系统的速度（例如从消息队列）、事件在系统内操作流动的速度以及中断的影响。

#### Event Time 

**Event Time 是事件发生的时间**，一般就是数据本身携带的时间。这个时间通常是在事件到达 Flink 之前就确定的，并且可以从每个事件中获取到事件时间戳。在 Event Time 中，时间取决于数据，而跟其他没什么关系。Event Time 程序必须指定如何生成 Event Time 水印，这是表示 Event Time 进度的机制。

完美的说，无论事件什么时候到达或者其怎么排序，最后处理 Event Time 将产生完全一致和确定的结果。但是，除非事件按照已知顺序（按照事件的时间）到达，否则处理 Event Time 时将会因为要等待一些无序事件而产生一些延迟。由于只能等待一段有限的时间，因此就难以保证处理 Event Time 将产生完全一致和确定的结果。

假设所有数据都已到达， Event Time 操作将按照预期运行，即使在处理无序事件、延迟事件、重新处理历史数据时也会产生正确且一致的结果。 例如，每小时事件时间窗口将包含带有落入该小时的事件时间戳的所有记录，无论它们到达的顺序如何。

请注意，有时当 Event Time 程序实时处理实时数据时，它们将使用一些 Processing Time 操作，以确保它们及时进行。

#### Ingestion Time

Ingestion Time 是事件进入 Flink 的时间。 在源操作处，每个事件将源的当前时间作为时间戳，并且基于时间的操作（如时间窗口）会利用这个时间戳。

Ingestion Time 在概念上位于 Event Time 和 Processing Time 之间。 与 Processing Time 相比，它稍微贵一些，但结果更可预测。因为 Ingestion Time 使用稳定的时间戳（在源处分配一次），所以对事件的不同窗口操作将引用相同的时间戳，而在 Processing Time 中，每个窗口操作符可以将事件分配给不同的窗口（基于机器系统时间和到达延迟）。

​	

![img](https://gitee.com/suveng/upic/raw/master/uPic/640-20200907172741320.jpg)




## flink的最佳实践

