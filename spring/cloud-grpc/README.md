# demo
文档 [中文] [English](spring/cloud-grpc/README-en.md)

## 服务间的调用逻辑

cloud-grpc-user 用 grpc 调用 cloud-grpc-pay
cloud-grpc-user 用 grpc 调用 cloud-grpc-order
cloud-grpc-api 是存放 grpc 的 proto 文件

查看 cloud-grpc-user 中的 controller, 里面简单写了一些测试逻辑
