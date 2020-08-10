package my.suveng.app.model.log;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.thread.ThreadFactoryBuilder;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import my.suveng.app.model.result.ServiceResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
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

		HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();


		//获取参数
		Map<String, String[]> parameterMap = request.getParameterMap();
		if (CollectionUtil.isNotEmpty(parameterMap)) {
			logger.info(logDetail.setTag(request.getRequestURI()).setStage("接收参数").setMsg("request=" + JSON.toJSONString(parameterMap)).toString());
		}

		long start = System.nanoTime();
		try {
			//执行
			Object res = pjp.proceed();
			//响应时间
			long end = System.nanoTime();
			double cost = (end - start) / 1000000;
			//返回打印
			logger.info(logDetail.setStage("返回").setMsg("response=%s,cost=%sms", JSON.toJSONString(res), cost).toString());
			return res;
		} catch (Throwable throwable) {
			logger.error(logDetail.setMsg("类=%s,方法=%s,异常信息=%s",
				pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName(), throwable.getMessage())
				.toString());
			throw new RuntimeException(logDetail.toString(), throwable);
		}
	}
}
