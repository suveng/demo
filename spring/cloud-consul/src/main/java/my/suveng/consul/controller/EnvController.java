package my.suveng.consul.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
@RestController
public class EnvController {

    @Value("${env.version}")
    private String version;

    @Value("${env.author}")
    private String author;

    @RequestMapping("/get")
    public String get() {
        return version + ":" + author;
    }
}
