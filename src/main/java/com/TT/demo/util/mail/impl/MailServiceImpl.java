package com.TT.demo.util.mail.impl;

import com.TT.demo.util.mail.MailService;
import com.TT.demo.util.vo.Mail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by 苏文广 on 2018/11/19
 * 邮件服务类，用于发送系统邮件
 */
@Component("MailService")
@Slf4j
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.from.addr}")
    private String from;
    @Autowired
    AmqpTemplate rabbitMQTemplate;

    /**
     * 发送简单邮件
     *
     * @param to      收件人
     * @param subject 主题
     * @param content 内容
     */
    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            log.info("邮件已发送");
        } catch (Exception e) {
            log.error("邮件发送失败");
        }
    }

    /**
     * 发送html邮件
     *
     * @param to      收件人
     * @param subject 主题
     * @param content 内容
     */
    @Override
    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            //true 表示要创建一个multipart message
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content, true);
            mailSender.send(mimeMessage);
            log.info("html邮件发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("html邮件发送失败");
        }
    }


    /**
     * 发送带附件邮件
     *
     * @param to       收件人
     * @param subject  主题
     * @param content  内容
     * @param filepath 文件路径
     */
    @Override
    public void sendAttachmentMail(String to, String subject, String content, String filepath) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setText(content);
            String fileName = filepath.substring(filepath.lastIndexOf(File.separator));
            FileSystemResource fileSystemResource = new FileSystemResource(new File(filepath));
            mimeMessageHelper.addAttachment(fileName, fileSystemResource);

            mailSender.send(mimeMessage);
            log.info("发送带附件的邮件成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("发送带附件的邮件失败");
        }
    }

    /**
     * 发送带静态资源邮件
     *
     * @param to           收件人
     * @param subject      主题
     * @param content      内容
     * @param resourcePath 文件路径
     * @param resouceId    资源ID
     */
    @Override
    public void sendInlineResourceMail(String to, String subject, String content, String resourcePath,
                                       String resouceId) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setText(content, true);
            FileSystemResource fileSystemResource = new FileSystemResource(new File(resourcePath));
            mimeMessageHelper.addInline(resouceId, fileSystemResource);

            mailSender.send(mimeMessage);
            log.info("发送邮件成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("发送邮件失败");
        }
    }

    /**
     * 异步发送邮件
     */
    @Override
    public void sendAsyncSendMail(Mail mail) {
        //把com.TT.demo.util.vo.Mail对象发送到rabbitmq
        rabbitMQTemplate.convertAndSend("mailObject", mail);
    }

}
