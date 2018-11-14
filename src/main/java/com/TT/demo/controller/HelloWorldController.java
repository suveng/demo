package com.TT.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String index() {
        log.error("测试出错===========");
        log.warn("测试警告========");
        log.info("测试信息=======");
        return "Hello World,suveng";
    }
}
