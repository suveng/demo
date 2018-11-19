package com.TT.demo.mq;

import com.TT.demo.mq.rabbitmq.fanout.FanoutSender;
import com.TT.demo.mq.rabbitmq.helloqueue.HelloSender;
import com.TT.demo.mq.rabbitmq.一对多使用.NeoSender;
import com.TT.demo.mq.rabbitmq.发送对象.ObjectSend;
import com.TT.demo.mq.rabbitmq.测试topic.TopicSend;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 苏文广 on 2018/11/19
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloQueueTest {
    @Autowired
    private HelloSender helloSender;

    @Autowired
    private NeoSender neoSender;
    @Autowired
    private ObjectSend objectSend;
    @Autowired
    private TopicSend topicSend;

    @Autowired
    private FanoutSender fanoutSender;
    @Test
    public void testHelloQueue() {
        helloSender.send("你好啊");
        log.error("sender 完成");
    }

    /**
     * 测试一对多: 结论，消费者轮询消费
     */
    @Test
    public void testYiduiduo() {
        for (int i = 0; i < 100; i++) {
            neoSender.send(i + "    ");
        }
    }

    /**
     * 测试发送对象
     */
    @Test
    public void testObject() {
        objectSend.send("hello");
    }

    /**
     * 测试TopicExchange
     */
    @Test
    public void testTopicExchange() {
        topicSend.send1();
        topicSend.send2();
    }

    /**
     * 测试fanoutExchange
     */
    @Test
    public  void testFabout(){
        fanoutSender.send();
    }

}
