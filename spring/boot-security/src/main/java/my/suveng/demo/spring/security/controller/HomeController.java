package my.suveng.demo.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author suwenguang
 **/
@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/")
    public String index() {
        return "home";
    }

}
