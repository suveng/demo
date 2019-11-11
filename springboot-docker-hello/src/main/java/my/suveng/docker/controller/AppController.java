package my.suveng.docker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author suwenguang
 * @version 1.0.0
 **/
@RestController
public class AppController {

	@RequestMapping("/info")
	public Object info(HttpServletRequest httpServletRequest){
		HashMap<String, Object> result = new HashMap<>();
		result.put("ip",httpServletRequest.getLocalAddr());
		result.put("port",httpServletRequest.getLocalPort());
		result.put("time",new Date());
		return result;
	}
}
