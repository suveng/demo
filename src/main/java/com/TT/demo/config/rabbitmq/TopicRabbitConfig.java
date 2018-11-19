package com.TT.demo.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 苏文广 on 2018/11/19
 * rabbitMq的TopicExchange的配置
 */
@Configuration
public class TopicRabbitConfig {
    final static String message = "topic.message";
    final static String messages = "topic.messages";

    /**
     * 创建queue
     * @return queue
     */
    @Bean
    public Queue queueMessage() {
        return new Queue("Q1");
    }

    /**
     * 创建queue
     * @return queueu
     */
    @Bean
    public Queue queueMessages() {
        return new Queue("Q2");
    }

    /**
     * 创建TopicExchange
     * @return Exchange
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    /**
     * 绑定配置
     * @param queueMessage queque
     * @param exchange topicexchange
     * @return binding
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    /**
     * 绑定配置
     * @param queueMessages queue
     * @param exchange topic exchange
     * @return binding
     */
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
