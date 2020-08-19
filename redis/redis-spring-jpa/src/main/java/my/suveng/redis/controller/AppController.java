package my.suveng.redis.controller;

import my.suveng.redis.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * '
 * 
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
@RestController
public class AppController {
    @Autowired
    private AppService appService;

    @RequestMapping("/redis")
    public String redis() {
        appService.basicCrudOperations();
        return "1";
    }
}
