package my.suveng.demo.springboot.junit.controller;

import org.springframework.stereotype.Controller;

/**
 *
 * @author suwenguang
 **/
@Controller
public class TestController {

	public String hello(){
		return "hello";
	}
}
