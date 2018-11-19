package com.TT.demo.mq.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by 苏文广 on 2018/11/19
 */
@Component
@RabbitListener
public class FanoutReceiverA {
    @RabbitHandler
    public void process(String msg){
        System.err.println("receviceA:"+msg);
    }
}
