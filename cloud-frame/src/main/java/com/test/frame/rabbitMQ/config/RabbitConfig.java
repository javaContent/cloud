package com.test.frame.rabbitMQ.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import org.springframework.amqp.core.Queue;

@Configurable
public class RabbitConfig {
	
	@Bean
    public Queue queue() {
        return new Queue("q_hello");
    }

}
