package my.suveng.spring.application.event.sub;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import my.suveng.spring.application.event.event.DemoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @author suwenguang
 **/
@Slf4j
@Component
public class DemoEventListener implements ApplicationListener<DemoEvent> {
	/**
	 * Handle an application event.
	 * @param event the event to respond to
	 */
	@Override
	@Async
	public void onApplicationEvent(DemoEvent event) {
		log.info("事件={}", JSON.toJSONString(event));
	}
}
