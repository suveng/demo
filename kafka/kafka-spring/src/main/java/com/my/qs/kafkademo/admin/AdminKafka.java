package com.my.qs.kafkademo.admin;

import org.apache.kafka.clients.admin.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class AdminKafka {

	private final static String TOPIC_NAME = "testTopic";

	@Autowired
	private AdminClient adminClient;

	/**
	 * 创建topic
	 */
	public void createTopic(){
		NewTopic topic = new NewTopic("testTopic", 1, Short.parseShort("1"));
		CreateTopicsResult topicsResult = adminClient.createTopics(Arrays.asList(topic));
	}

	/**
	 * 查看topics列表
	 */
	public void listTopics() throws ExecutionException, InterruptedException {
		ListTopicsOptions options = new ListTopicsOptions();
		options.listInternal(true);
		ListTopicsResult topicsListResult = adminClient.listTopics();
		Collection<TopicListing> topicListings = topicsListResult.listings().get();
		for (TopicListing topicListing : topicListings) {
			System.out.println(topicListing.name());
		}
	}

	/**
	 * 查看topic信息
	 */
	public void describeTopic() throws ExecutionException, InterruptedException {

		DescribeTopicsResult describeTopicsResult = adminClient.describeTopics(Arrays.asList(TOPIC_NAME));
		Map<String, TopicDescription> descriptionMap = describeTopicsResult.all().get();
		for (TopicDescription topicDescription : descriptionMap.values()) {
			System.out.println("topic name: " + topicDescription.name() + "," + "topic partitions" + topicDescription.partitions());
		}

	}

	/**
	 * 创建partition
	 */
	public void alterPartition(){
		Map<String, NewPartitions> newPartitions =  new HashMap<>();
		NewPartitions newPartition = NewPartitions.increaseTo(2);
		newPartitions.put(TOPIC_NAME, newPartition);
		CreatePartitionsResult createPartitionsResult = adminClient.createPartitions(newPartitions);

	}


}
