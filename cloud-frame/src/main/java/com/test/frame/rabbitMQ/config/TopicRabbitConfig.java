//package com.test.frame.rabbitMQ.config;
//
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.context.annotation.Bean;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//
//@Configurable
//public class TopicRabbitConfig {
//	
//	final static String message = "q_topic_message";
//    final static String messages = "q_topic_messages";
//
//    @Bean
//    public Queue queueMessage() {
//        return new Queue(TopicRabbitConfig.message);
//    }
//
//    @Bean
//    public Queue queueMessages() {
//        return new Queue(TopicRabbitConfig.messages);
//    }
//
//    /**
//     * 声明一个Topic类型的交换机
//     * 交换机名称mybootexchange
//     * @return
//     */
//    @Bean
//    TopicExchange exchange() {
//        return new TopicExchange("mybootexchange");
//    }
//
//    /**
//     * 绑定Q到交换机,并且指定routingKey
//     * @param queueMessage
//     * @param exchange
//     * @return
//     */
//    @Bean
//    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
//        return BindingBuilder.bind(queueMessage).to(exchange).with("q.topic.message");
//    }
//
//    @Bean
//    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
//        return BindingBuilder.bind(queueMessages).to(exchange).with("q.topic.#");
//    }
//
//}
