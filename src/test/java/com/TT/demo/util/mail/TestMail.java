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

    /**
     * 测试发送简单邮件
     */
    @Test
    public void testSendMail() {
        mailService.sendSimpleMail("suveng@163.com", "test simple mail", "hello");
    }

    /**
     * 测试发送HTML邮件
     */
    @Test
    public void testHtmlMail() {
        String content = "<html>\n" + "<body>\n" + "    <h3>hello world ! 这是一封Html邮件!</h3>\n" + "</body>\n" + "</html>";
        mailService.sendHtmlMail("suveng@163.com", "html邮件", content);
    }

    /**
     * 测试发送带附件的邮件
     */
    @Test
    public void testAttachmentMail(){
        mailService.sendAttachmentMail("suveng@163.com", "带附件邮件", "带附件",
                "F:\\Mproject\\demo\\src\\main\\java\\com\\TT\\demo\\DemoApplication.java");
    }
}
