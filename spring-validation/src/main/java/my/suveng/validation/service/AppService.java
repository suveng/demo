package my.suveng.validation.service;

import my.suveng.validation.dao.Dao;
import my.suveng.validation.model.HelloBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 *
 * @author suwenguang
 * @version 1.0.0
 **/
@Service
public class AppService {
	@Autowired
	private Validator validator;

	@Autowired
	private Dao dao;
	/**
	 * 业务逻辑
	 * @author suwenguang
	 * @date 2019/10/31
	 */
	public void logic() {

		HelloBo hellobo = dao.getOne();

		if (!ObjectUtils.isEmpty(hellobo) && check(hellobo)){
			System.out.println("通过校验");
			return;
		}

		System.out.println("校验失败");
	}

	private boolean check(HelloBo hellobo) {
		Set<ConstraintViolation<HelloBo>> validate = validator.validate(hellobo);
		return validate.size() < 1;
	}
}
