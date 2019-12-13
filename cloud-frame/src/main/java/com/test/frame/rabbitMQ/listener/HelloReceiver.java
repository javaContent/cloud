package com.test.frame.rabbitMQ.listener;

import com.test.system.api.entity.SysUser;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
//@RabbitListener(queues = "q_hello")
public class HelloReceiver {

//    //1. 手动创建，需在RabbitMQ中手动创建myQueue1 队列，否则报错
//    @RabbitListener(queues = "q_hello")
//    @RabbitHandler
//    public void process(SysUser sysUser) {
//        System.out.println("Receiver  : " + sysUser.getUserName());
//    }
//
//    //2. 自动创建队列
//    @RabbitListener(queuesToDeclare = @Queue("myQueue2"))
//    public void process2(String message){
//        System.out.println("Receiver2  : " + message);
//    }
//
//    //3. 自动创建队列，Exchange 与 Queue绑定
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue("invoiceVerifyQueue"),
//            exchange = @Exchange(value = "testExChange",type = ExchangeTypes.TOPIC, durable = "true"),
//            key = "invoiceVerify.#"
//    ))
//    public void process3(String message){
//        System.out.println("MqReceiver3: " + message);
//    }
//
//    //4. 自动创建队列，Exchange 与 Queue绑定
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue("userQueue"),
//            exchange = @Exchange(value = "testExChange",type = ExchangeTypes.TOPIC, durable = "true"),
//            key = "user.#"
//    ))
//    public void process4(String message){
//        System.out.println("MqReceiver4: " + message);
//    }
}
