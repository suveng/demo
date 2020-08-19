package my.suveng.spring.kafka.demo.configTopic;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.Arrays;

/**
 *
 * @author suwenguang
 **/
@Configuration
public class DemoConfig {

    /**
     * 配置topic, 因为是使用了springboot KafkaAdmin已经被自动配置
     * 
     * @author suwenguang
     */
    // @Bean
    // public KafkaAdmin admin() {
    // Map<String, Object> configs = new HashMap<>();
    // configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, ...);
    // return new KafkaAdmin(configs);
    // }

    /**
     * 普通
     * 
     * @author suwenguang
     */
    @Bean
    public NewTopic testSpring() {
        return TopicBuilder.name("test-spring").partitions(1).replicas(1).compact().build();
    }

    /**
     * 自定义配置
     * 
     * @author suwenguang
     */
    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name("thing2").partitions(10).replicas(1)
                .config(TopicConfig.COMPRESSION_TYPE_CONFIG, "zstd").compact().build();
    }

    @Bean
    public NewTopic topic3() {
        return TopicBuilder.name("thing3").assignReplicas(0, Arrays.asList(0, 1)).assignReplicas(1, Arrays.asList(1, 2))
                .assignReplicas(2, Arrays.asList(2, 0)).config(TopicConfig.COMPRESSION_TYPE_CONFIG, "zstd").build();
    }
}
