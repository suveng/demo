package com.TT.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Slf4j
@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String index() {
        log.error("测试出错===========");
        log.warn("测试警告========");
        log.info("测试信息=======");
        return "Hello World,";
    }
    @RequestMapping("/uid")
    public String uid(HttpSession session){
        UUID uid=(UUID) session.getAttribute("uid");
        if (null==uid){
            uid=UUID.randomUUID();
            log.warn("uid 成功，sessionid为"+session.getId());
        }
        log.warn("uid 失败，sessionid为"+session.getId()+"开始设置uid");
        session.setAttribute("uid",uid);
        return session.getId();
    }
}
