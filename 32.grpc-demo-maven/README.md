# 重点
grpc demo

> 注意, 这里集成了maven的grpc的protoc 插件, 已经绑定了complie 这个生命周期,
> 所以必须先complie然后再运行程序,这个才是正确的顺序
> 但是我怕别人直接跑demo会报错,为了防止这种报错, 我将编译好的grpc生成的文件放到对应的文件夹,
> 详情,后续想要继续编译调试, 需要打开pom文件的插件配置, 然后把 src/main/java/my/suveng/grpcdemomaven/grpc的所有文件删除,这些文件都是通过插件生成的,
> 生成的代码默认是存放到target/generated-sources/protobuf/ 里面


1. 如何生成grpc默认的代码
2. 如何编写服务端和客户端
3. jvm hook 钩子

