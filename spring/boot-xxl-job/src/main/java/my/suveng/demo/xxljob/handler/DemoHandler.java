package my.suveng.demo.xxljob.handler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

/**
 *
 * @author suwenguang
 **/
@Component
public class DemoHandler {

	@XxlJob("demo")
	public ReturnT<String> executeDemo(String param){
		ReturnT<String> success = ReturnT.SUCCESS;
		success.setContent("hhhh");
		success.setMsg("ddd");
		System.out.println("jjj");
		System.out.println(param);
		return success;
	}
}
