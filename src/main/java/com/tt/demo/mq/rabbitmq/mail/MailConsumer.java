package com.tt.demo.mq.rabbitmq.mail;

import com.tt.demo.util.mail.MailService;
import com.tt.demo.domain.vo.Mail;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 苏文广 on 2018/11/20
 */
@Component
@RabbitListener(queues = "mailObject")
public class MailConsumer {
    @Autowired
    MailService mailService;
    @RabbitHandler
    public void process(Mail mail){
        System.err.println("chuli");
        mailService.sendHtmlMail(mail.getTo(), mail.getSubject(), mail.getContent());
    }
}
