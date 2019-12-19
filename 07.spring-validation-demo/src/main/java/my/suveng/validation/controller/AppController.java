package my.suveng.validation.controller;

import my.suveng.validation.model.HelloVo;
import my.suveng.validation.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 *
 * @author suwenguang
 * @version 1.0.0
 **/
@Controller
public class AppController {

	@Autowired
	private Validator validator;

	@Autowired
	private AppService appService;

	/**
	 * 手动校验
	 * @author suwenguang
	 * @date 2019/10/31
	 */
	@RequestMapping("/test")
	@ResponseBody
	public String hello(HelloVo vo){

		Set<ConstraintViolation<HelloVo>> validate = validator.validate(vo);
		if (validate.size()>0){
			for (ConstraintViolation<HelloVo> e :
				validate) {
				return e.getPropertyPath()+e.getMessage();
			}
		}


		appService.logic();

		return "";
	}

	/**
	 * 自定义注解校验
	 * @author suwenguang
	 * @date 2019/10/31
	 */
	@RequestMapping("/mobile")
	@ResponseBody
	public String mobile(){
		String str = " ddddd";

		appService.mobile(str);
		return "";
	}
}
