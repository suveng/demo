package com.tt.demo.controller;

import com.tt.demo.dao.mysql.spring.KkkMapper;
import com.tt.demo.model.domain.mysql.spring.Kkk;
import com.tt.demo.model.domain.mysql.springboot.User;
import com.tt.demo.service.KkkService;
import com.tt.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * web 搭建的测试类
 */
@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {
    @Autowired
    UserService<User> userService;
    @Autowired
    KkkService<Kkk> kkkService;
    @Autowired
    KkkMapper kkkMapper;

    /**
     * 测试tk.mybatis
     */
    @RequestMapping("/tk.mybatis")
    public void testTkMybatis(){
        log.error("测试tk.mybatis");

        User entity = new User();
        entity.setId(154L);
        entity.setNickName("suvenga");
        entity.setEmail("adfaa");
        entity.setPassWord("sdafa");
        entity.setUserName("dafsda");
        entity.setRegTime("fasdfa");
        userService.save(entity);
    }

    @RequestMapping("/multidatasource")
    public void testMultidatasource(){
        Kkk kkk = new Kkk();
        kkk.setAsdfas("faf");
        kkk.setKkk("fdaf");
        kkkMapper.insert(kkk);
//        int save = kkkService.save(kkk);
        System.out.println("yes");

    }

}
