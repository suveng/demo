package my.suveng.spring.application.event;

import lombok.extern.slf4j.Slf4j;
import my.suveng.spring.application.event.event.DemoEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * @author suwenguang
 **/
@SpringBootApplication
@Slf4j
public class SpringApplcationEvent {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringApplcationEvent.class, args);
        log.info("启动完毕...");
        log.info("发送事件");
        context.publishEvent(new DemoEvent(context, "1", 1));
        log.info("发送完毕");
    }
}
