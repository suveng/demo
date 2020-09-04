# 12-0 中间件-kafka

## 什么是kafka? 



### 架构是什么? 



### 特性是什么? 



### 应用场景是什么? 



### 优缺点是什么? 



## 为什么会出现kafka? 



## 怎么使用kafka



### 安装

#### macos



<u>安装命令</u>

```bash
brew install kafka
```

> 安装完成后, 弹出提示
>
> To have launchd start kafka now and restart at login:
>   brew services start kafka
> Or, if you don't want/need a background service you can just run:
>   zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties & kafka-server-start /usr/local/etc/kafka/server.properties



<u>安装位置</u>

`/usr/local/Cellar/kafka`

`/usr/local/Cellar/zookeeper`



<u>启动命令</u>

  `zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties & kafka-server-start /usr/local/etc/kafka/server.properties`



仔细查看了文件指向, 源文件还是存放在`/usr/local/Cellar` 中



### shell脚本使用kafka

#### 脚本发送消息

进入bin目录

`kafka-console-producer`

```bash
# 查看帮助
kafka-console-producer --help
# 我当前版本2.6
# required 参数
# --bootstrap-server kafka集群地址
# --topic topic名称
./kafka-console-producer --bootstrap-server kafka集群地址 --topic topic名称

# 继续输入消息, 按回车发送消息
```



#### 脚本消费消息

`kafka-console-consumer`