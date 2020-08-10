package com.my.qs.kafkademo.config;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;

public class PartitionImpl implements Partitioner {

	private final static String TOPIC_NAME = "testTopic";

	@Override
	public int partition(String s, Object o, byte[] bytes, Object o1, byte[] bytes1, Cluster cluster) {
		List<PartitionInfo> partitionInfos = cluster.partitionsForTopic(TOPIC_NAME);
		String s1 = o.toString().substring(3);

		return Integer.parseInt(s1) % partitionInfos.size();
	}

	@Override
	public void close() {

	}

	@Override
	public void configure(Map<String, ?> map) {

	}
}
