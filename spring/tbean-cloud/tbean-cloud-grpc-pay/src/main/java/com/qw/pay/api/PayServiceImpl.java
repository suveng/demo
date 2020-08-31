package com.qw.pay.api;


import com.qw.grpc.api.pay.PayRequest;
import com.qw.grpc.api.pay.PayResponse;
import com.qw.grpc.api.pay.PayServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.CallbackHelper;

/**
 *
 * @author suwenguang
 **/
@GrpcService
public class PayServiceImpl extends PayServiceGrpc.PayServiceImplBase {

    @Override
    public void getRealNameByUsername(PayRequest request, StreamObserver<PayResponse> responseObserver) {
        System.out.println("pay 接受到参数: " + request + "");
        PayResponse response = PayResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getRealNameByUsernameResStream(PayRequest request, StreamObserver<PayResponse> responseObserver) {
        System.out.println("pay 接受到参数: " + request + "");
        PayResponse response = PayResponse.newBuilder().setSuccess(false).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<PayRequest> getRealNameByUsernameReqStream(StreamObserver<PayResponse> responseObserver) {
        // 流式,使用的是异步回调,事件驱动回调
        return new StreamObserver<PayRequest>() {
            // 查看父类说明
            @Override
            public void onNext(PayRequest myRequest) {
                // 在这里获取参数
                System.out.println("pay onNext: " + myRequest.getMoney());
            }

            @Override
            public void onError(Throwable throwable) {
                // 当在onNext 或者 onCompleted 发生异常时, 会被回调
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                // 这里编写正常业务逻辑
                PayResponse suveng = PayResponse.newBuilder().setSuccess(true).build();
                responseObserver.onNext(suveng);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<PayRequest> getRealNameByUsernameStreamAll(StreamObserver<PayResponse> responseObserver) {
        // 流式,使用的是异步回调,事件驱动回调
        return new StreamObserver<PayRequest>() {
            // 查看父类说明
            @Override
            public void onNext(PayRequest myRequest) {
                // 在这里获取参数
                System.out.println("pay onNext: " + myRequest.getMoney());
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
                PayResponse suveng = PayResponse.newBuilder().setSuccess(true).build();
                responseObserver.onNext(suveng);
                responseObserver.onCompleted();
            }
        };
    }
}
