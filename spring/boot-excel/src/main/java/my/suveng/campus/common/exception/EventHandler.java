package my.suveng.campus.common.exception;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import my.suveng.campus.common.log.LogDetail;
import my.suveng.campus.common.log.LogDetailThreadLocal;
import my.suveng.campus.common.outermessage.Robot;
import my.suveng.campus.common.outermessage.RobotEnums;
import my.suveng.campus.common.outermessage.robotdingtalk.model.bo.message.DingTalkMessage;
import my.suveng.campus.common.result.CodeEnum;
import my.suveng.campus.common.result.Result;
import my.suveng.campus.common.result.ResultBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * description:
 * @author suwenguang
 * @date 2019-08-23
 * @version 1.0.0
 **/
@ControllerAdvice
@Slf4j
public class EventHandler {
	@Autowired
	private DingTalkMessage dingTalkMessage;

	private final ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(1000, true);

	private final ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 10, 60L, TimeUnit.SECONDS,
		workQueue, ThreadFactoryBuilder.create().setNamePrefix("exception-handler-").build(), new ThreadPoolExecutor.DiscardPolicy());

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result defaultErrorHandler(HttpServletRequest req, Exception e) {
		LogDetail logDetail = LogDetailThreadLocal.logDetailThreadLocal.get();
		log.error(logDetail.setStage("发生异常").setMsg(e.getMessage()).toString(), e);
		dingTalkMessage.setContent(logDetail.toString());
		executor.execute(() -> {
			Robot.build(RobotEnums.TEXT_ROBOT).init(dingTalkMessage.getLink()).sendMsgAt(dingTalkMessage.toBeautiful(),dingTalkMessage.getPhone());
		});
		return ResultBuilder.build(CodeEnum.EXCEPTION,new Object());
	}
}
