# demo
文档 [中文] [English]()

## 服务间的调用逻辑

cloud-grpc-sleuth-zipkin-user 用 grpc 调用 cloud-grpc-sleuth-zipkin-pay
cloud-grpc-sleuth-zipkin-user 用 grpc 调用 cloud-grpc-sleuth-zipkin-order
cloud-grpc-api 是存放 grpc 的 proto 文件

查看 cloud-grpc-sleuth-zipkin-user 中的 controller, 里面简单写了一些测试逻辑


## 整合了sleuth和zipkin做链路追踪

查看 cloud-grpc-sleuth-zipkin-user 的 application.yml 配置文件
其他模块类似, 查看配置即可, 这里没有使用服务发现组件, 写死了 ip

