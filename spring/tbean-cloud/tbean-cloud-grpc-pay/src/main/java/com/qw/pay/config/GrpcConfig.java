package com.qw.pay.config;

import com.qw.grpc.api.order.OrderServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author suwenguang
 **/
@Configuration
public class GrpcConfig {

    @GrpcClient("order")
    private OrderServiceGrpc.OrderServiceBlockingStub orderServiceBlockingStub;

    @Bean
    public OrderServiceGrpc.OrderServiceBlockingStub orderServiceBlockingStub() {
        return orderServiceBlockingStub;
    }
}
