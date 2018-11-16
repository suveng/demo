package com.TT.demo.controller;

import com.TT.demo.domain.User;
import com.TT.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {
    @Autowired
    UserService userService;
    @RequestMapping("/tk.mybatis")
    public void testTkMybatis(){
        log.error("测试tk.mybatis");

        User entity = new User();
        entity.setId(1L);
        entity.setNickName("suveng");
        entity.setEmail("adfa");
        entity.setPassWord("sdaf");
        entity.setUserName("dafsd");
        userService.save(entity);
    }

}