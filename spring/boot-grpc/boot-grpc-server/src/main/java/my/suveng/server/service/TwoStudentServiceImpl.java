package my.suveng.server.service;

import io.grpc.stub.StreamObserver;
import my.suveng.grpc.api.MyRequest;
import my.suveng.grpc.api.MyResponse;
import my.suveng.grpc.two.api.MyRequestTwo;
import my.suveng.grpc.two.api.MyResponseTwo;
import my.suveng.grpc.two.api.StudentServiceTwoGrpc;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 *
 * @author suwenguang
 **/
@GrpcService
public class TwoStudentServiceImpl extends StudentServiceTwoGrpc.StudentServiceTwoImplBase {
    @Override
    public void getRealNameByUsername(MyRequestTwo request, StreamObserver<MyResponseTwo> responseObserver) {
        System.out.println("two");
        System.out.println("接受到参数: " + request + "");
        MyResponseTwo response = MyResponseTwo.newBuilder().setRealname("hello").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getRealNameByUsernameResStream(MyRequestTwo request, StreamObserver<MyResponseTwo> responseObserver) {
        System.out.println("two");
        MyResponseTwo response = MyResponseTwo.newBuilder().setRealname("hello").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
        super.getRealNameByUsernameResStream(request, responseObserver);
    }

    @Override
    public StreamObserver<MyRequestTwo> getRealNameByUsernameReqStream(StreamObserver<MyResponseTwo> responseObserver) {
        System.out.println("two");
        // 流式,使用的是异步回调,事件驱动回调
        return new StreamObserver<MyRequestTwo>() {
            // 查看父类说明
            @Override
            public void onNext(MyRequestTwo myRequest) {
                // 在这里获取参数
                System.out.println("onNext: " + myRequest.getUsername());
            }

            @Override
            public void onError(Throwable throwable) {
                // 当在onNext 或者 onCompleted 发生异常时, 会被回调
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                // 这里编写正常业务逻辑
                MyResponseTwo suveng = MyResponseTwo.newBuilder().setRealname("suveng").build();
                responseObserver.onNext(suveng);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<MyRequestTwo> getRealNameByUsernameStreamAll(StreamObserver<MyResponseTwo> responseObserver) {
        System.out.println("two");
        // 流式,使用的是异步回调,事件驱动回调
        return new StreamObserver<MyRequestTwo>() {
            // 查看父类说明
            @Override
            public void onNext(MyRequestTwo myRequest) {
                // 在这里获取参数
                System.out.println("onNext: " + myRequest.getUsername());
            }

            @Override
            public void onError(Throwable throwable) {
                // 当在onNext 或者 onCompleted 发生异常时, 会被回调
                throwable.printStackTrace();
                responseObserver.onCompleted();
            }

            @Override
            public void onCompleted() {
                // 这里编写正常业务逻辑
                MyResponseTwo suveng = MyResponseTwo.newBuilder().setRealname("suveng").build();
                responseObserver.onNext(suveng);
                responseObserver.onCompleted();
            }
        };
    }
}
