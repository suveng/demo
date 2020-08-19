package my.suveng.grpcdemomaven.impl;

import io.grpc.stub.StreamObserver;
import my.suveng.grpcdemomaven.grpc.MyRequest;
import my.suveng.grpcdemomaven.grpc.MyResponse;
import my.suveng.grpcdemomaven.grpc.StudentServiceGrpc;

/**
 *
 * @author suwenguang
 **/
public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {
    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("接受到参数: " + request + "");
        MyResponse response = MyResponse.newBuilder().setRealname("hello").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getRealNameByUsernameResStream(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("接受到参数: " + request + "");
        MyResponse response = MyResponse.newBuilder().setRealname("hello").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<MyRequest> getRealNameByUsernameStreamAll(StreamObserver<MyResponse> responseObserver) {
        // 流式,使用的是异步回调,事件驱动回调
        return new StreamObserver<MyRequest>() {
            // 查看父类说明
            @Override
            public void onNext(MyRequest myRequest) {
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
                MyResponse suveng = MyResponse.newBuilder().setRealname("suveng").build();
                responseObserver.onNext(suveng);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<MyRequest> getRealNameByUsernameReqStream(StreamObserver<MyResponse> responseObserver) {
        // 流式,使用的是异步回调,事件驱动回调
        return new StreamObserver<MyRequest>() {
            // 查看父类说明
            @Override
            public void onNext(MyRequest myRequest) {
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
                MyResponse suveng = MyResponse.newBuilder().setRealname("suveng").build();
                responseObserver.onNext(suveng);
                responseObserver.onCompleted();
            }
        };
    }

}
