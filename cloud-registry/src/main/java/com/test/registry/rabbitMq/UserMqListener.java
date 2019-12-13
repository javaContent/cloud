package com.test.registry.rabbitMq;

import com.test.system.api.entity.SysUser;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserMqListener {

    //自动创建队列，Exchange 与 Queue绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("userQueue"),
            exchange = @Exchange(value = "userExChange",type = ExchangeTypes.TOPIC, durable = "true"),
            key = "user.#"
    ))
    public void process(String userName) throws InterruptedException {
        System.out.println("userReceiver: " + userName);
        Thread.sleep(1000);
    }

    //自动创建队列，Exchange 与 Queue绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("userQueue"),
            exchange = @Exchange(value = "userExChange",type = ExchangeTypes.TOPIC, durable = "true"),
            key = "user.#"
    ))
    public void process2(String userName) throws InterruptedException {
        System.out.println("userReceiver2: " + userName);
        Thread.sleep(2000);
    }


}
