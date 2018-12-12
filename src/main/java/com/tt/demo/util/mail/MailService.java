package com.tt.demo.util.mail;


import com.tt.demo.model.vo.Mail;

/**
 * Created by 苏文广 on 2018/11/19
 * 邮件服务类，用于发送系统邮件
 * @author Administrator
 */
public interface MailService {
    /**
     * 发送简单邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送HTML邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送带附件的邮件
     * @param to to
     * @param subject 主题
     * @param content 内容
     * @param filepath 文件路径
     */
    void sendAttachmentMail(String to, String subject, String content, String filepath);

    /**
     * 带静态资源的邮件
     * @param to to
     * @param subject 主题
     * @param content 内容
     * @param resourcePath 静态资源文件
     * @param resourceId 静态资源id
     */
    void sendInlineResourceMail(String to, String subject, String content, String resourcePath,
                                String resourceId);

    /**
     * 异步发送邮件
     * @param mail 邮件对象
     */
    void sendAsyncSendMail(Mail mail);
}
