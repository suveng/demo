package com.qw.order.api;

import com.qw.grpc.api.order.OrderRequest;
import com.qw.grpc.api.order.OrderResponse;
import com.qw.grpc.api.order.OrderServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 *
 * @author suwenguang
 **/
@GrpcService
public class OrderServiceImpl extends OrderServiceGrpc.OrderServiceImplBase {

    /**
     * <pre>
     *     1. 普通请求返回
     * </pre>
     * @param request
     * @param responseObserver
     */
    @Override
    public void getRealNameByUsername(OrderRequest request, StreamObserver<OrderResponse> responseObserver) {
        System.out.println("order 接受到参数: " + request + "");
        OrderResponse response = OrderResponse.newBuilder().setOrderId(String.valueOf(System.currentTimeMillis())).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * <pre>
     *      2. 流式请求,普通返回
     * </pre>
     * @param request
     * @param responseObserver
     */
    @Override
    public void getRealNameByUsernameResStream(OrderRequest request, StreamObserver<OrderResponse> responseObserver) {
        System.out.println("order 接受到参数: " + request + "");
        OrderResponse response = OrderResponse.newBuilder().setOrderId(String.valueOf(System.currentTimeMillis())).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * <pre>
     *      3. 普通请求,流式返回
     * </pre>
     * @param responseObserver
     */
    @Override
    public StreamObserver<OrderRequest> getRealNameByUsernameReqStream(StreamObserver<OrderResponse> responseObserver) {
        // 流式,使用的是异步回调,事件驱动回调
        return new StreamObserver<OrderRequest>() {
            // 查看父类说明
            @Override
            public void onNext(OrderRequest myRequest) {
                // 在这里获取参数
                System.out.println("order onNext: " + myRequest.getPay());
            }

            @Override
            public void onError(Throwable throwable) {
                // 当在onNext 或者 onCompleted 发生异常时, 会被回调
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                // 这里编写正常业务逻辑
                OrderResponse suveng = OrderResponse.newBuilder().setOrderId(String.valueOf(System.currentTimeMillis())).build();
                responseObserver.onNext(suveng);
                responseObserver.onCompleted();
            }
        };
    }

    /**
     * <pre>
     *      3. 流式请求, 流式返回
     * </pre>
     * @param responseObserver
     */
    @Override
    public StreamObserver<OrderRequest> getRealNameByUsernameStreamAll(StreamObserver<OrderResponse> responseObserver) {
        // 流式,使用的是异步回调,事件驱动回调
        return new StreamObserver<OrderRequest>() {
            // 查看父类说明
            @Override
            public void onNext(OrderRequest myRequest) {
                // 在这里获取参数
                System.out.println("pay onNext: " + myRequest.getPay());
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
                OrderResponse suveng = OrderResponse.newBuilder().setOrderId(String.valueOf(System.currentTimeMillis())).build();
                responseObserver.onNext(suveng);
                responseObserver.onCompleted();
            }
        };
    }
}
