package my.suveng.jpa;

import com.alibaba.fastjson.JSON;
import my.suveng.jpa.dao.UserRepository;
import my.suveng.jpa.model.database.User;
import my.suveng.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * 启动器
 * 
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
@SpringBootApplication
public class AppApplication {
    @Autowired
    UserService userService;

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(AppApplication.class, args);
        System.out.println("hello,world");

        UserService userService = (UserService) run.getBean("userService");

        userService.insert();

        List<User> users = userService.select();
        System.out.println(JSON.toJSONString(users));
    }

}
