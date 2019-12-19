package my.suveng.campus.common.outermessage.robotdingtalk.service;


import my.suveng.campus.common.outermessage.robotdingtalk.model.bo.DingTalkResult;
import my.suveng.campus.common.result.ServiceResult;

import java.util.List;

/**
 * description:
 * @author suwenguang
 * @date 2019-08-11
 * @version 1.0.0
 **/
public interface IRobotService {


	/**
	 * 说明: 发送消息,默认文本类型
	 * @author suwenguang
	 * @date 2019-08-11
	 * @return com.free.base.dingtalkrobot.model.ServiceResult<com.free.base.dingtalkrobot.model.DingTalkResult> <- 返回类型
	 */
	ServiceResult<DingTalkResult> sendMsg(String content);

	/**
	 * 说明: 发送消息,默认文本类型,at特定人手机号码 string:("1XXXXX","2XXXXX")
	 * @author suwenguang
	 * @date 2019-08-11
	 * @return com.free.base.dingtalkrobot.model.ServiceResult<com.free.base.dingtalkrobot.model.DingTalkResult> <- 返回类型
	 */
	ServiceResult<DingTalkResult> sendMsgAt(String content, String atMobiles);


	/**
	 * 说明: 发送消息,默认文本类型,at特定人手机号码,string
	 * @author suwenguang
	 * @date 2019-08-11
	 * @return com.free.base.dingtalkrobot.model.ServiceResult<com.free.base.dingtalkrobot.model.DingTalkResult> <- 返回类型
	 */
	ServiceResult<DingTalkResult> sendMsgAt(String content, List<String> atMobiles);


	/**
	 * 说明: 发送消息,默认文本类型,at所有人
	 * @author suwenguang
	 * @date 2019-08-11
	 * @return com.free.base.dingtalkrobot.model.ServiceResult<com.free.base.dingtalkrobot.model.DingTalkResult> <- 返回类型
	 */
	ServiceResult<DingTalkResult> sendMsgAtAll(String content);


	/**
	 * 说明: 发送不同类型的内容,默认不at人
	 * @author suwenguang
	 * @date 2019-08-11
	 * @return com.free.base.dingtalkrobot.model.ServiceResult<com.free.base.dingtalkrobot.model.DingTalkResult> <- 返回类型
	 */
	ServiceResult<DingTalkResult> sendMsgType(String msgtype, String content);


	/**
	 * 说明: 所有内容自定义,详细内容查看钉钉 https://ding-doc.dingtalk.com/doc#/serverapi2/qf2nxq
	 *
	 * @author suwenguang
	 * @date 2019-08-11
	 * @return com.free.base.dingtalkrobot.model.ServiceResult<com.free.base.dingtalkrobot.model.DingTalkResult> <- 返回类型
	 */
	ServiceResult<DingTalkResult> sendMsgType(String msgtype, String content, List<String> atMobiles, Boolean isAtALl);
}
