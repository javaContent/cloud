package com.test.system.rabbitMq.listener;

import com.test.system.api.entity.SysUser;
import com.test.system.service.UserServiceI;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMqListener {

    @Autowired
    private UserServiceI userService;

    //自动创建队列，Exchange 与 Queue绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("userQueue"),
            exchange = @Exchange(value = "userExChange",type = ExchangeTypes.TOPIC, durable = "true"),
            key = "user.register"
    ))
    public void process(SysUser user) {
        user.setUserName(user.getUserName()+"1");
//        userService.register(user);
//        System.out.println("注册成功");
    }


}
