package com.test.frame.rabbitMQ.sender;

import com.test.system.api.entity.SysUser;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//24小时制
        String context = "hello " + date;
        System.out.println("Sender : " + context);
        SysUser sysUser = new SysUser();
        sysUser.setUserName("yangshuaifei");
        //简单对列的情况下routingKey即为Q名
        this.rabbitTemplate.convertAndSend("q_hello", sysUser);
        System.out.println("ok : ");
    }


    public void exchangeSend() {
        String message = "exchangeSend:";
        for (int i = 0; i < 100; i++) {
            System.out.println(message + i);
            this.rabbitTemplate.convertAndSend("userExChange", "user.test", message + "user:" + i);

        }
    }

}
