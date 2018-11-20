package com.TT.demo.util.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 苏文广 on 2018/11/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMail {
    @Autowired
    MailService mailService;

    @Test
    public void testSendMail() {
        mailService.sendSimpleMail("suveng@163.com", "test simple mail", "hello");
    }

    @Test
    public void testHtmlMail() {
        String content = "<html>\n" + "<body>\n" + "    <h3>hello world ! 这是一封Html邮件!</h3>\n" + "</body>\n" + "</html>";
        mailService.sendHtmlMail("suveng@163.com", "html邮件", content);
    }
}
