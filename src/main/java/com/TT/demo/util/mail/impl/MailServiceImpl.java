package com.TT.demo.util.mail.impl;

import com.TT.demo.util.mail.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

/**
 * Created by 苏文广 on 2018/11/19
 * 邮件服务类，用于发送系统邮件
 */
@Component("MailService")
@Slf4j
public class MailServiceImpl  implements MailService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.from.addr}")
    private String from;

    /**
     * 发送简单邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    @Override
    public void sendSimpleMail(String to, String subject, String content){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            log.info("邮件已发送");
        }catch (Exception e){
                  log.error("邮件发送失败");
        }
    }

    /**
     * 发送html邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    @Override
    public void sendHtmlMail(String to,String subject,String content){
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            //true 表示要创建一个multipart message
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content,true);
            mailSender.send(mimeMessage);
            log.info("html邮件发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("html邮件发送失败");
        }
    }
}
