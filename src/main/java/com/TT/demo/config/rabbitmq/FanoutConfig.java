package com.TT.demo.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 苏文广 on 2018/11/19
 * Rabbitmq的FanoutExchange的配置
 */
@Configuration
public class FanoutConfig {
    /**
     * 创建queue
     * @return queue
     */
    @Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }
    /**
     * 创建queue
     * @return queue
     */
    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }
    /**
     * 创建queue
     * @return queue
     */
    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }
    /**
     * 创建Exchange
     * @return Exchange
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 绑定Queue到Exchange
     * @param AMessage a
     * @param fanoutExchange exchange
     * @return binding
     */
    @Bean
    Binding bindingExchangeA(Queue AMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }
    /**
     * 绑定Queue到Exchange
     * @param BMessage b
     * @param fanoutExchange exchange
     * @return binding
     */
    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }
    /**
     * 绑定Queue到Exchange
     * @param CMessage c
     * @param fanoutExchange exchange
     * @return binding
     */
    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }

}
