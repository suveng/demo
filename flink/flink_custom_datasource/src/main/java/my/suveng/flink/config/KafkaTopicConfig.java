package my.suveng.flink.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 *
 * @author suwenguang
 **/
@Configuration
public class KafkaTopicConfig {

	/**
	 * 普通
	 *
	 * @author suwenguang
	 */
	@Bean
	public NewTopic flinkKafkaSource() {
		return TopicBuilder.name("flink_kafka_source").partitions(1).replicas(1).compact().build();
	}

	@Bean
	public NewTopic two() {
		return TopicBuilder.name("two").partitions(1).replicas(1).compact().build();
	}

}
