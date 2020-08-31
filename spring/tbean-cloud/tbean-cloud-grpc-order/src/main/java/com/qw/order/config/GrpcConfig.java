package com.qw.order.config;

import com.qw.grpc.api.pay.PayServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author suwenguang
 **/
@Configuration
public class GrpcConfig {

    @GrpcClient("pay")
    private PayServiceGrpc.PayServiceBlockingStub payServiceStub;

    @Bean
    public PayServiceGrpc.PayServiceBlockingStub payServiceBlockingStub(){
        return payServiceStub;
    }

}
