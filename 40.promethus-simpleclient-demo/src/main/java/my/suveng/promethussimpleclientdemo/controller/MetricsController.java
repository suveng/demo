package my.suveng.promethussimpleclientdemo.controller;

import my.suveng.model.common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author suwenguang
 **/
@Controller
public class MetricsController {

	/**
	 * 接口
	 * @author suwenguang
	 */
	@RequestMapping("/get/cost")
	@ResponseBody
	public Result<Object> getCost() throws InterruptedException {
		Thread.sleep(2000);
		return Result.buildSuccess(null);
	}
}
