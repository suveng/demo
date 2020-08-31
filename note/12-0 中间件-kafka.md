# 12-0 中间件-kafka

## 什么是kafka? 



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

