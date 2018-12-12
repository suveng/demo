package com.tt.demo.mq.rabbitmq.test.helloqueue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by 苏文广 on 2018/11/19
 */
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    public void send(String msg){
        String context="hello"+msg+LocalDateTime.now();
        System.out.println("sender :"+context);
        this.rabbitmqTemplate.convertAndSend("hello",context);
    }

}
