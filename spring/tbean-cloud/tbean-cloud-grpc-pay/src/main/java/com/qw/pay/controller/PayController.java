package com.qw.pay.controller;

import com.qw.grpc.api.order.OrderRequest;
import com.qw.grpc.api.order.OrderResponse;
import com.qw.grpc.api.order.OrderServiceGrpc;
import net.devh.boot.grpc.client.security.CallCredentialsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author suwenguang
 **/
@RestController
public class PayController {

    @Autowired
    private OrderServiceGrpc.OrderServiceBlockingStub orderServiceBlockingStub;

    @RequestMapping
    public Object getPay() {
        OrderResponse hello = orderServiceBlockingStub.withCallCredentials(CallCredentialsHelper.bearerAuth("jwt")).getRealNameByUsername(OrderRequest.newBuilder().setPay("hello").build());
        System.out.println("返回: " + hello + "");
        return hello + "";
    }

}
