package my.suveng.spring.application.event.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 异步配置
 * 
 * @author suwenguang
 **/
@Configuration
@EnableAsync
public class AsyncConfig {
    // 可以自定义异步线程池
}
