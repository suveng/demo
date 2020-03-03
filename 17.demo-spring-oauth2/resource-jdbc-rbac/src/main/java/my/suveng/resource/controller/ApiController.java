package my.suveng.resource.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author suwenguang
 **/
@RestController
public class ApiController {
	@RequestMapping("/h")
	public String h(){
		return "h";
	}
}
