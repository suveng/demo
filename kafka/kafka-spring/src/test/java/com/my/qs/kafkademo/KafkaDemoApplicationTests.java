package com.my.qs.kafkademo;

import com.my.qs.kafkademo.admin.AdminKafka;
import com.my.qs.kafkademo.consumer.ConsumerKafka;
import com.my.qs.kafkademo.producer.ProducerKafka;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;

@SpringBootTest
class KafkaDemoApplicationTests {

    @Autowired
    private AdminKafka adminKafka;
    @Autowired
    private ProducerKafka producerKafka;
    @Autowired
    private ConsumerKafka consumerKafka;

    @Test
    void contextLoads() {
    }

    @Test
    void test() throws ExecutionException, InterruptedException {
        // adminKafka.createTopic();
        // adminKafka.listTopics();
        // adminKafka.describeTopic();
        // adminKafka.alterPartition();
        // adminKafka.describeTopic();
        // producerKafka.send();
        // consumerKafka.poll();
        // consumerKafka.pollByPartition();
        // consumerKafka.multiConsumer();
        consumerKafka.multiWorker();
    }

}
