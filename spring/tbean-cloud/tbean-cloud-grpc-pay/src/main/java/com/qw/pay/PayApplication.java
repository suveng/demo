package com.qw.pay;

import brave.Tracing;
import brave.grpc.GrpcTracing;
import io.grpc.ClientInterceptor;
import io.grpc.ServerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import zipkin2.Span;
import zipkin2.reporter.Reporter;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
@MapperScan("com.qw")
public class PayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public GrpcTracing grpcTracing(Tracing tracing) {
        return GrpcTracing.create(tracing);
    }

    // grpc server端开启中间拦截
    @Bean
    ServerInterceptor grpcServerSleuthInterceptor(GrpcTracing grpcTracing) {
        return grpcTracing.newServerInterceptor();
    }

    // grpc client端开启拦截
    @Bean
    ClientInterceptor grpcClientSleuthInterceptor(GrpcTracing grpcTracing) {
        return grpcTracing.newClientInterceptor();
    }

    // Use this for debugging (or if there is no Zipkin server running on port 9411)
    @Bean
    @ConditionalOnProperty(value = "sample.zipkin.enabled", havingValue = "false")
    public Reporter<Span> spanReporter() {
        return new Reporter<Span>() {
            @Override
            public void report(Span span) {
                log.info(span + "");
            }
        };
    }
}
