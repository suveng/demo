package com.TT.demo.mq.rabbitmq.test.一对多使用;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by 苏文广 on 2018/11/19
 * 测试一对多发送
 */
@Component
public class NeoSender {
    @Autowired
    AmqpTemplate rabbitMQTemplate;
    public void send(String msg){
        String s =msg+ "测试一对多发送" + LocalDateTime.now();
        rabbitMQTemplate.convertAndSend("neo",s);
        System.err.println("neo send:"+s);
    }
}
