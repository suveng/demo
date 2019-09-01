package my.suveng.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * description:
 * @author suwenguang
 * @date 2019-09-01
 * @version 1.0.0
 **/
@Data
public class FemaleVo {
	/**
	 * 主键
	 */
	private String id;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 年龄
	 */
	private String age;

	/**
	 * 哪种类型的女人;FemaleTypeEnums
	 */
	private Integer type;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 修改时间
	 */
	private Date modifiedTime;

	/**
	 * 其他信息
	 */
	private Integer page;

	private Integer size;

	private Sort sort;

	private Date start;

	private  Date end;

	private Integer startAge;

	private  Integer endAge;
}
