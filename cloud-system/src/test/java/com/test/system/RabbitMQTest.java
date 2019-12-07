package com.test.system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.frame.rabbitMQ.sender.MsgSender;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {
	
	@Autowired
    private MsgSender msgSender;

    @Test
    public void send1() throws Exception {
        msgSender.send1();
    }

    @Test
    public void send2() throws Exception {
        msgSender.send2();
    }

}
