package com.TT.demo.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by 苏文广 on 2018/11/19
 * 将JedisPool交给spring管理
 */
@Configuration
public class JedisPoolFactory {
    //自动注入redis配置属性文件
    @Autowired
    private RedisProperties properties;

    @Bean
    public JedisPool getJedisPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(properties.getJedis().getPool().getMaxIdle());
        config.setMaxTotal(properties.getJedis().getPool().getMaxActive());
        config.setMaxWaitMillis(properties.getJedis().getPool().getMaxWait().toMillis());
        JedisPool pool = new JedisPool(config,properties.getHost(),properties.getPort(),100);
        return pool;
    }
}
