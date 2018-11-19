package com.TT.demo.mq.rabbitmq.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 苏文广 on 2018/11/19
 *
 * 测试rabbitmq 的fanoutExchange的消息发送
 */
@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String s = "测试信息，fanout";
        System.err.println("sender:"+s);
        this.rabbitTemplate.convertAndSend("fanoutExchange","","s");
    }
}
