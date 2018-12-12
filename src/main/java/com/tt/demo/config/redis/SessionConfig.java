package com.tt.demo.config.redis;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 使用redis做共享session的配置类
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfig {

}
