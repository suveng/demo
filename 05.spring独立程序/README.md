# spring data jpa 的一个小demo

## 依赖

- springboot 2.1.9
- spring-data-jdbc
- spring-data-jpa
- mapstruct(暂时没用到这个...)
- hutool
- fastjson
- druid

## 介绍

单独使用jpa,不依赖web,只是一个一次性的程序

所有逻辑可以从 Application 中查看, 利用 getBean 获取 spring bean


## 用途

### 为什么要做这些小demo?

因为系统都是小demo拼成的

### 这个小demo可以用来做些什么?

有一些业务需要我去处理一些数据, 可能从不同的数据中获取, spring 生态挺好的,用着非常顺手

而且 spring 不单单可以用来做web,还可以用来做很多东西的

假设我现在要去写一个 flume 的source 或者 sink 自定义组件的时候,
我需要操作数据库,但是手动封装jdbc不实在,主要是我用习惯了spring

然后这个时候我就可以引入springboot, 但是不引入web模块就行, 使用其他模块的功能,
感觉都回来了,开始了愉快的curd


