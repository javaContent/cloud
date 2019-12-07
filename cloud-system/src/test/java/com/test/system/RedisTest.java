package com.test.system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.frame.helper.RedisClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
	
	@Autowired
	RedisClient redisClient;
	
	
	@Test
    public void test() throws Exception {
		redisClient.setValue("test1", "001");
		System.out.print(redisClient.getValue("test1"));
    }
	
	

}
