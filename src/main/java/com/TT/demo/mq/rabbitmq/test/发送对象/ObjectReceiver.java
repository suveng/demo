package com.TT.demo.mq.rabbitmq.test.发送对象;

import com.TT.demo.domain.mysql.springboot.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by 苏文广 on 2018/11/19
 */
@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {
    @RabbitHandler
    public void process(User msg){
        System.out.println("Receiver:");
        msg.getEmail();
//        User user = JSONObject.parseObject(msg, User.class);
//        System.out.println(user.getEmail());
    }
}
