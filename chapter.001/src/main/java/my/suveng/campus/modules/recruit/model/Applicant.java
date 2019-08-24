package my.suveng.campus.modules.recruit.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * description:
 * @author suwenguang
 * @date 2019-08-24
 * @version 1.0.0
 **/
@Document(collection = "applicant")
@Data
@NoArgsConstructor
public class Applicant {
	@Id
	private String id;

	/**
	 *	基本信息
	 */
	private Integer applyType;

	private String applyJod;

	private Date internStartTime;

	private Date internEndTime;

	/**
	 * 期望薪资
	 */
	private String expectSalary;


	/**
	 * 个人特长
	 */
	private String skills;

	/**
	 *	个人信息
	 */
	private String name;

	/**
	 * 国籍
	 */
	private String nationality;

	/**
	 * 0:未知, 1:男, 2:女
	 */
	private Integer sex;

	/**
	 * 出生年月
	 */
	private Date birth;

	/**
	 * 籍贯
	 */
	private String nativePlace;

	/**
	 * 户口所在地
	 */
	private String registeredResidence;

	/**
	 * 民族
	 */
	private String nation;

	/**
	 * 学历
	 */
	private String educationLevel;

	/**
	 * qq
	 */
	private String qq;

	/**
	 * wechat
	 */
	private String wechat;

	/**
	 * email
	 */
	private String email;

	/**
	 * 身份证号码
	 */
	private String idCard;

	/**
	 * 现住址
	 */
	private String presentAddress;


	/**
	 * 手机号码
	 */
	@Indexed
	private String phone;

	/**
	 * 家庭情况
	 */
	private List<FamilyMemberInfo> familyMemberInfos;

	/**
	 * 教育经历
	 */
	private List<EducationalExperience> educationalExperiences;

	/**
	 * 实习经历
	 */
	private List<InternshipExperience> internshipExperiences;


	/**
	 * 社团经历
	 */
	private List<ClubExperience> clubExperiences;

	/**
	 * 其他信息
	 */
	private Date createTime;


}
