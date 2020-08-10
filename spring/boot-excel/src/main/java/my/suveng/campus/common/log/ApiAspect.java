package my.suveng.campus.common.log;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import my.suveng.campus.common.outermessage.Robot;
import my.suveng.campus.common.outermessage.RobotEnums;
import my.suveng.campus.common.outermessage.robotdingtalk.model.bo.message.DingTalkMessage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * description:
 * @author suwenguang
 * @date 2019-08-14
 * @version 1.0.0
 **/
@Aspect
@Component
public class ApiAspect {

	@Autowired
	private DingTalkMessage dingTalkMessage;

	private static final Logger logger = LoggerFactory.getLogger(ApiAspect.class);
	private static final int LIMIT = 4000;



	private final ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(1000, true);

	private final ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 10, 60L, TimeUnit.SECONDS,
		workQueue, ThreadFactoryBuilder.create().setNamePrefix("outer-message-").build(), new ThreadPoolExecutor.DiscardPolicy());


	@Pointcut(value = "execution(* *..*.*.*(..)) ")
	public void anyMethod() {
	}

	@Around(value = "anyMethod() && @annotation(requestMapping)", argNames = "pjp,requestMapping")
	public Object aroundMethod(ProceedingJoinPoint pjp, RequestMapping requestMapping) {
		LogDetail logDetail = LogDetailThreadLocal.logDetailThreadLocal.get();
		//设置requestid
		logDetail.setRequsetId(UUID.randomUUID().toString().replaceAll("-", "").toLowerCase());

		//获取参数
		HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
		Object reqData = request.getAttribute("reqData");
		Object appid = request.getAttribute("appid");

		if (ObjectUtil.isNotEmpty(reqData)) {
			StringBuilder stringBuilder = new StringBuilder("appid=");
			stringBuilder.append(appid);
			stringBuilder.append(",").append("reqData=").append(JSON.toJSONString(reqData));
			logger.info(logDetail.setTag(this.getClass().getSimpleName()).setStage("接收参数").setMsg(stringBuilder.toString()).toString());
		}

		long start = System.nanoTime();
		try {
			//执行
			Object res = pjp.proceed();
			//响应时间
			long end = System.nanoTime();
			double cost = (end - start) / 1000000;
			if (cost > LIMIT) {
				logger.info(logDetail.setMsg("接口响应时间超过4s").setStage("拦截器").toString());
				String content = logDetail.toString();
				executor.execute(() -> Robot.build(RobotEnums.TEXT_ROBOT).init(dingTalkMessage.getLink()).sendMsg(content));
			}
			//返回打印
			logger.info(logDetail.setStage("返回").setMsg("response=%s,cost=%sms", JSON.toJSONString(res), cost).toString());
			return res;
		} catch (Throwable throwable) {
			logger.error(logDetail.setMsg("类=%s,方法=%s,执行异常", pjp.getSignature().getDeclaringTypeName(),pjp.getSignature().getName()).toString());
			throw new RuntimeException(logDetail.toString(), throwable);
		}
	}
}
