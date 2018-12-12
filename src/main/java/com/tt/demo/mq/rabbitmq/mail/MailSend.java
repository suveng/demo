package com.tt.demo.mq.rabbitmq.mail;

import com.tt.demo.model.vo.Mail;
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
