package my.suveng.spring.kafka.demo.sendMessage.template;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author suwenguang
 **/
@Service
@Slf4j
public class KafkaTemplateSend {

    /**
     * 注入spring配置的kafkaTemplate
     */
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 注入spring配置的topic
     */
    @Autowired
    NewTopic testSpring;

    /**
     * 异步发送kafka消息
     * 
     * @author suwenguang
     */
    public void sendToKafkaAsync(final String data) {
        final ProducerRecord<String, String> record = createRecord(data);

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(record);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                handleSuccess(data);
            }

            @Override
            public void onFailure(Throwable ex) {
                handleFailure(data, record, ex);
            }

        });
    }

    /**
     * 同步发送kafka消息
     * 
     * @author suwenguang
     */
    public void sendToKafkaSync(final String data) {
        final ProducerRecord<String, String> record = createRecord(data);

        try {
            kafkaTemplate.send(record).get(10, TimeUnit.SECONDS);
            handleSuccess(data);
        } catch (ExecutionException e) {
            handleFailure(data, record, e.getCause());
        } catch (TimeoutException | InterruptedException e) {
            handleFailure(data, record, e);
        }
    }

    private void handleFailure(String data, ProducerRecord<String, String> record, Throwable cause) {
        log.info("发送数据: {},失败,record={},cause={}", data, JSON.toJSONString(record), cause.getMessage());
    }

    private void handleSuccess(String data) {
        log.info("发送数据: {},成功", data);
    }

    private ProducerRecord<String, String> createRecord(String data) {
        ProducerRecord<String, String> stringStringProducerRecord = new ProducerRecord<>(testSpring.name(),
                IdUtil.fastSimpleUUID(), data);
        return stringStringProducerRecord;
    }
}
