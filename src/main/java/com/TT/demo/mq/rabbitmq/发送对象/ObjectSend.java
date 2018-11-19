package com.TT.demo.mq.rabbitmq.发送对象;

import com.TT.demo.domain.springboot.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 苏文广 on 2018/11/19
 */
@Component
public class ObjectSend {
    @Autowired
    AmqpTemplate rabbitmqTemplate;
    public void send(String msg){
        User user =new User();
        user.setEmail("sdfa");
        user.setId(123L);
        user.setNickName("dfs");
        user.setPassWord("sdaf");
        user.setUserName("sdfsa");
//        String s = user.toString();
        System.out.println("object sender:测试发送对象"+msg);
        rabbitmqTemplate.convertAndSend("object",user);
    }
}
