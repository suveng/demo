# 基于sharding jdbc 的 读写分离demo

## 前提

你需要几个不同实例的数据库,建议使用docker搭建测试环境

不同的数据库实例, 一主 多从, 主库和从库不需要具备主从同步特性

因为这里的demo主要是测试sharding jdbc 的功能特性
- 读写分离
- 分库分表

其他特性暂时不测试, 比如分布式事务

## 搭建不同实例数据库



