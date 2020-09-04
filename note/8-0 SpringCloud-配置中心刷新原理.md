# 8-0 SpringCloud-配置中心动态刷新



## 什么是动态刷新?

### 特性是什么? 

### 应用场景是什么? 

### 优缺点是什么? 

### 实现原理是什么? 

相关类

- @RefreshScope
- @Scope



<u>原理分析入口</u>

暂时没有找到对应的入口, 那就从SpringBoot启动流程开始看

看那些地方用到了RefreshScope













## 为什么会出现动态刷新? 

## 如何使用动态刷新? 

- 使用的bean必须是spring bean
- @RefreshScope(proxyMode = ScopedProxyMode.TARGET_CLASS)













## 资料

https://juejin.im/post/6845166890461954062