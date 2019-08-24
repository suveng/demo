package my.suveng.campus.modules.recruit.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 * @author suwenguang
 * @date 2019-08-24
 * @version 1.0.0
 **/
@Data
@NoArgsConstructor
public class FamilyMemberInfo {
	/**
	 * 成员姓名
	 */
	private String name;

	/**
	 * 与本人关系
	 */
	private String relationship;

	/**
	 * 工作单位
	 */
	private String workplace;

	/**
	 * 职务
	 */
	private String position;

	/**
	 * 联系电话
	 */
	private String phone;

	/**
	 * 联系地址
	 */
	private String address;

}
