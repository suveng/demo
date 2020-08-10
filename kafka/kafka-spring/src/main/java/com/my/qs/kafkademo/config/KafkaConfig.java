package com.my.qs.kafkademo.config;

import com.my.qs.kafkademo.consumer.ConsumerKafka;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaConfig {

	@Bean
	public AdminClient adminClient(){
		Properties properties = new Properties();
		properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "106.12.194.126:9092");
		AdminClient adminClient = AdminClient.create(properties);
		return adminClient;
	}

	@Bean
	public KafkaProducer<String ,String>  kafkaProducer(){
		Properties properties = new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "106.12.194.126:9092");
		// 自定义分区
		properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, "com.my.qs.kafkademo.config.PartitionImpl");
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		KafkaProducer<String ,String> kafkaProducer = new KafkaProducer<>(properties);
		return kafkaProducer;
	}

	@Bean
	public KafkaConsumer<String, String> kafkaConsumer(){
		Properties properties = new Properties();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "106.12.194.126:9092");
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, "testGroup");
		// 自动提交offset 默认为true
		properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		// 一次最大poll的数量
//		properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 20);
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
		KafkaConsumer kafkaConsumer = new KafkaConsumer(properties);
		return kafkaConsumer;
	}
}
