package my.suveng.istioclouduserdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author suwenguang
 **/
@RestController
public class SecurityController {

	@RequestMapping("/api/v1")
	public String v1() throws InterruptedException {
		Thread.sleep(1000);
		return "v1";
	}

	@RequestMapping("/v2")
	public String v2() {
		return "v2";
	}
}
