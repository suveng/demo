package com.TT.demo.mq.rabbitmq.mailMQ;

import com.TT.demo.util.vo.Mail;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 苏文广 on 2018/11/20
 */
@Component
public class MailSend {
    @Autowired
    AmqpTemplate rabbitMQTemplate;

    public void sendMailObjectAsync(Mail mail){
        rabbitMQTemplate.convertAndSend("mailObject",mail);
    }
}
