package com.TT.demo.util.mail;

/**
 * Created by 苏文广 on 2018/11/19
 * 邮件服务类，用于发送系统邮件
 */
public interface MailService {
    void sendSimpleMail(String to, String subject, String content);

    void sendHtmlMail(String to, String subject, String content);
}
