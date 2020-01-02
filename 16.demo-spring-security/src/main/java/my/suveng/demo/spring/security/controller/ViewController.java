package my.suveng.demo.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author suwenguang
 **/
@Controller
public class ViewController {
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
}
