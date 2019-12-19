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
@Document(collection = "female")
@Data
public class Female {
	/**
	 * 主键
	 */
	@Id
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
	 * 舔狗
	 */
	private List<Male> dogs;

	/**
	 * 男朋友们
	 */
	@Indexed
	private List<Male> boyFriends;

	/**
	 * 男神们
	 */
	@Indexed
	private List<Male> dreamers;

	/**
	 * 创建时间
	 */
	@Indexed
	private Date createTime;

	/**
	 * 修改时间
	 */
	private Date modifiedTime;


}
