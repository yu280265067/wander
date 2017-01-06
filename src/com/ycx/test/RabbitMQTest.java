/*package com.ycx.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.ycx.rabbitMQ.MessageProducer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "src/main/resources/applicationContext.xml", "applicationContext-mq-rabbit.xml" })
public class RabbitMQTest {

	@Autowired
	private MessageProducer messageProducer;

	@Autowired

	@Test
	public void testSend() {
		for (int i = 0; i < 2; i++) {
			messageProducer.sendMessage("你好，生产者！这是消息：" + (i + 1));
		}
	}

}
*/