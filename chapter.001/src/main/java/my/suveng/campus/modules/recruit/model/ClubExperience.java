package my.suveng.campus.modules.recruit.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * description:
 * @author suwenguang
 * @date 2019-08-24
 * @version 1.0.0
 **/
@Data
@NoArgsConstructor
public class ClubExperience {
	/**
	 * 开始时间
	 */
	private Date startTime;

	/**
	 * 结束时间
	 */
	private Date endTime;

	/**
	 * 社团名称
	 */
	private String clubName;

	/**
	 * 担任最高职位
	 */
	private String position;

	/**
	 * 业绩
	 */
	private String achievement;

}
