package com.my.qs.kafkademo.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerKafka {

    private static final String TOPIC_NAME = "testTopic";

    @Autowired
    private KafkaProducer<String, String> kafkaProducer;

    public void send() {
        for (int i = 0; i < 100; i++) {
            ProducerRecord record = new ProducerRecord<>(TOPIC_NAME, "key" + i, "test" + i);
            kafkaProducer.send(record);
        }

    }
}
