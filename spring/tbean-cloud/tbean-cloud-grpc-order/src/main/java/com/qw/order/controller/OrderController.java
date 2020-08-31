package com.qw.order.controller;

import com.qw.grpc.api.pay.PayRequest;
import com.qw.grpc.api.pay.PayResponse;
import com.qw.grpc.api.pay.PayServiceGrpc;
import net.devh.boot.grpc.client.security.CallCredentialsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author suwenguang
 **/
@RestController
public class OrderController {

    @Autowired
    private PayServiceGrpc.PayServiceBlockingStub payServiceBlockingStub;

    @RequestMapping("/order/get")
    public Object orderGet() {
        PayResponse hello = payServiceBlockingStub.withCallCredentials(CallCredentialsHelper.bearerAuth("jwt")).getRealNameByUsername(PayRequest.newBuilder().setMoney("hello").build());
        System.out.println("返回: " + hello + "");
        return hello + "";
    }
}
