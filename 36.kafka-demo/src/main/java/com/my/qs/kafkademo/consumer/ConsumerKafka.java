package com.my.qs.kafkademo.consumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.*;

@Service
public class ConsumerKafka {

	private static final String TOPIC_NAME = "testTopic";

	@Autowired
	private KafkaConsumer<String, String> kafkaConsumer;


	/**
	 * 订阅分区
	 */
	public void assign(){
		TopicPartition p0 = new TopicPartition(TOPIC_NAME, 0);
		TopicPartition p1 = new TopicPartition(TOPIC_NAME, 1);
		kafkaConsumer.assign(Arrays.asList(p0, p1));
	}

	/**
	 * 手动提交
	 */
	public void poll() {
		kafkaConsumer.subscribe(Arrays.asList(TOPIC_NAME));
		while (true) {
			ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(1000));

			if (!records.isEmpty()){
				for (ConsumerRecord<String, String> record : records) {
					System.out.println("offset is:" + record.offset() + ",partition:" + record.partition() + ",key is:" + record.key() + ",value is:" + record.value());
				}

				kafkaConsumer.commitSync();
			}
		}
	}

	/**
	 * 手动分区提交
	 */
	public void pollByPartition(){
		kafkaConsumer.subscribe(Arrays.asList(TOPIC_NAME));
		while (true) {
			ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(1000));


			if (!records.isEmpty()){
				for (TopicPartition partition : records.partitions()) {
					List<ConsumerRecord<String, String>> recordList = records.records(partition);
					for (ConsumerRecord<String, String> record : recordList) {
						System.out.println("offset is:" + record.offset() + ",partition:" + record.partition() + ",key is:" + record.key() + ",value is:" + record.value());
					}
					// 根据分区提交offset
					Map<TopicPartition, OffsetAndMetadata> offsets = new HashMap<>();
					long offset = recordList.get(recordList.size() - 1).offset();
					TopicPartition topicPartition = new TopicPartition(TOPIC_NAME, partition.partition());
					OffsetAndMetadata offsetAndMetadata = new OffsetAndMetadata(offset + 1 );
					offsets.put(topicPartition, offsetAndMetadata);
					kafkaConsumer.commitSync(offsets);

				}
			}
		}
	}


	/**
	 * 多consumer模式， 一个consumer group中不同的consumer出来不同的partition
	 * 资源消耗更大
	 */
	public void multiConsumer() throws InterruptedException {

		List<Thread> threadList = new ArrayList<>();
		List<PartitionInfo> partitionInfos = kafkaConsumer.partitionsFor(TOPIC_NAME);
		for (int i = 0; i < partitionInfos.size(); i++) {
			Consumer consumer = new Consumer();
			Thread thread = new Thread(consumer);
			thread.start();
			threadList.add(thread);
		}
		// 等待子线程中最后一个线程结束
		threadList.get(threadList.size() - 1).join();

	}

	private static class Consumer implements Runnable{

		private KafkaConsumer<String, String> kafkaConsumer;
		private static final String TOPIC_NAME = "testTopic";

		public Consumer(){
			Properties properties = new Properties();
			properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "106.12.194.126:9092");
			properties.put(ConsumerConfig.GROUP_ID_CONFIG, "testGroup");
			properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
			properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
			properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
			kafkaConsumer = new KafkaConsumer<>(properties);
			kafkaConsumer.subscribe(Arrays.asList(TOPIC_NAME));
		}

		@Override
		public void run() {
			System.out.println("thread" + Thread.currentThread().getId() + " start!");
			while (true){
				ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofMillis(1000));
				if (!consumerRecords.isEmpty()){
					for (ConsumerRecord<String, String> record : consumerRecords) {
						System.out.println("Thread " + Thread.currentThread().getId() + "offset:" + record.offset() +
							",partition:" + record.partition() + ",key：" + record.key() + ",value：" + record.value());
					}
					kafkaConsumer.commitSync();
				}
			}
		}
	}

	/**
	 * 一个consumer提取后，分发worker处理
	 * offset难以控制，不知道哪一条失败
	 */
	public void multiWorker(){
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
			5, 8,
			60 , TimeUnit.SECONDS,
			new ArrayBlockingQueue<Runnable>(4),
			Executors.defaultThreadFactory(), new failHandler()
		);
		kafkaConsumer.subscribe(Arrays.asList(TOPIC_NAME));
		while (true){
			ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(500));
			for (ConsumerRecord<String, String> record : records) {
				threadPoolExecutor.execute(new ConsumerWorker(record));
			}

			kafkaConsumer.commitSync();
		}


	}

	private static class ConsumerWorker implements Runnable{

		private ConsumerRecord<String, String> record;

		public ConsumerWorker(ConsumerRecord<String, String> consumerRecord){
			this.record = consumerRecord;
		}

		public ConsumerRecord<String, String> getRecord() {
			return record;
		}

		@Override
		public void run() {
			System.out.println("thread " + Thread.currentThread() + ",partition: " + record.partition() +
				",key: " + record.key() + ",value: " + record.value());

		}
	}


	/**
	 * 自定义拒绝策略
	 */
	private static class failHandler implements RejectedExecutionHandler{

		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			ConsumerWorker worker = (ConsumerWorker) r;
			ConsumerRecord<String, String> record = worker.getRecord();
			System.out.println("partition:" + record.partition() + ",offset:" + record.offset() + " has been rejected");
		}
	}
}
