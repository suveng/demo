package com.tt.demo.config.mongo;

/**
 * Created by 苏文广 on 2018/11/21
 */
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;

//prefix需要与配置文件中用户user数据源的配置前缀对应
@Configuration
@ConfigurationProperties(prefix = "spring.data.mongodb.test1")
public class Test1MongoConfig extends AbstractMongoConfig {


    @Primary
    @Bean(name = "test1MongoTemplate")
    @Override
    public  MongoTemplate getMongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }


}