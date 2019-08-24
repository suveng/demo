package my.suveng.campus.modules.recruit.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * description: 教育经历
 * @author suwenguang
 * @date 2019-08-24
 * @version 1.0.0
 **/
@Data
@NoArgsConstructor
public class EducationalExperience {
	/**
	 * 起止时间
	 */
	private Date startTime;

	/**
	 * 结束时间
	 */
	private Date endTime;

	/**
	 * 学校
	 */
	private String school;

	/**
	 * 专业
	 */
	private String major;

	/**
	 * 学历
	 */
	private String educationLevel;

	/**
	 * 学习成绩排名
	 */
	private String rank;

	/**
	 * 挂科
	 */
	private String fail;


	/**
	 * 奖学金名称:等级
	 */
	private String scholarship;





}
