package my.suveng.spring.kafka.demo.controller;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import my.suveng.spring.kafka.demo.sendMessage.template.KafkaTemplateSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author suwenguang
 **/
@RestController
@Slf4j
public class WebController {

    @Autowired
    private KafkaTemplateSend kafkaTemplateSend;

    @RequestMapping("/send/async")
    public Object sendAsync() {
        log.info("异步发送kafka消息");
        kafkaTemplateSend.sendToKafkaAsync(DateUtil.now());
        return "succes";
    }

    @RequestMapping("/send/sync")
    public Object sendsync() {
        log.info("同步发送kafka消息");
        kafkaTemplateSend.sendToKafkaSync(DateUtil.now());
        return "succes";
    }
}
