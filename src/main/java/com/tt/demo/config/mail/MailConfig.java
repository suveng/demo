package com.tt.demo.config.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Properties;

/**
 * Created by 苏文广 on 2018/11/19
 * 配置邮箱服务
 */
@Configuration
public class MailConfig  {
    @Autowired
    JedisPool jedisPool;
    // 邮件发送器
    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com");
        mailSender.setUsername("suveng@qq.com");
        Jedis jedis = jedisPool.getResource();
        String mail = jedis.get("mail");
        mailSender.setPassword(mail);
        mailSender.setDefaultEncoding("utf-8");
        Properties prop = new Properties();
        // 设定properties
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.timeout", "25000");
        // 设置调试模式可以在控制台查看发送过程
        // prop.put("mail.debug", "true");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        mailSender.setJavaMailProperties(prop);
        return mailSender;
    }
}
