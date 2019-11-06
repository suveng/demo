package my.suveng.fastjson.model.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 *
 * @author suwenguang
 * @version 1.0.0
 **/
@Data
public class Human {

	/**
	 * 身体
	 */
	private String body;

	/**
	 * 精神
	 */
	private  String spirit;

	/**
	 * 出生日期
	 */
	@JSONField(format = "yyyy-MM")
	private Date birthday;

	/**
	 * 年龄
	 */
	private Long age;

	/**
	 * 家庭
	 */
	private List<Human> famaily;
}
