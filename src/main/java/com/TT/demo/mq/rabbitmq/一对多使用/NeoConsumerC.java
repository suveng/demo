package com.TT.demo.mq.rabbitmq.一对多使用;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by 苏文广 on 2018/11/19
 */
@Component
@RabbitListener(queues = "neo")
public class NeoConsumerC {
    @RabbitHandler
    public void process(String msg){
        System.err.println("neo receiverCCC:"+msg);
    }
}
