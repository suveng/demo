package my.suveng.spring.application.event.pub;

import lombok.extern.slf4j.Slf4j;
import my.suveng.spring.application.event.event.DemoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author suwenguang
 **/
@Component
@Slf4j
public class EventPulish {
	@Autowired
	private ApplicationContext applicationContext;

	/**
	 * 获取root context
	 * @author suwenguang
	 * @date 2019/10/21
	 */
	private void rootContext() {
		for (; ; ) {
			if (applicationContext.getParent() != null) {
				applicationContext = applicationContext.getParent();
				continue;
			}
			break;
		}
	}

	/**
	 * 发送钉钉消息事件
	 * @author suwenguang
	 * @date 2019/10/21
	 */
	public void publishDingTalkMessageEvent(String id, Integer count) {
		rootContext();
		log.info("id={},count={}", id, count);
		DemoEvent event = new DemoEvent(applicationContext, id, count);
		applicationContext.publishEvent(event);
		log.info("推送事件...");
	}

}
