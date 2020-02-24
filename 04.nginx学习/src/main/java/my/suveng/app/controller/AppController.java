package my.suveng.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * app
 * @author suwenguang
 * @version 1.0.0
 **/
@RestController
public class AppController {
	@RequestMapping("/hello")
	public Object hello(HttpServletRequest request) {
		HashMap<String, String> stringStringHashMap = new HashMap<>();
		stringStringHashMap.put("ip",request.getLocalAddr());
		stringStringHashMap.put("port", String.valueOf(request.getLocalPort()));
		return null;
	}
}
