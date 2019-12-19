package my.suveng.campus.modules.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description:
 * @author suwenguang
 * @date 2019-08-23
 * @version 1.0.0
 **/
@Controller
public class ViewController {

	/**
	 * description: 主页
	 * author: suwenguang
	 * date: 2019-08-24
	 */
	@RequestMapping("/index.html")
	public String index(){
		return "index";
	}

	/**
	 * description: 主页
	 * author: suwenguang
	 * date: 2019-08-24
	 */
	@RequestMapping("/welcome.html")
	public String welcome(){
		return "welcome";
	}

	/**
	 * description: 网申列表页
	 * author: suwenguang
	 * date: 2019-08-24
	 */
	@RequestMapping("/apply_list.html")
	public String applyList(){
		return "apply/apply_list";
	}

	/**
	 * description: 助力活动页
	 * author: suwenguang
	 * date: 2019-08-24
	 */
	@RequestMapping("/assistance_activity.html")
	public String assistanceActivity(){
		return "activity/assistance/assistance_list";
	}
}
