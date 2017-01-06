package com.ycx.dubbo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.demo.DemoService;

public class DubboClientDemo {
	// 初始延迟1秒
	private static long INIT_DELAY = 1;

	// 30秒周期
	private static long PERIOD = 5;

	// 初始化1个定时线程池
	private static ScheduledExecutorService service = Executors
			.newScheduledThreadPool(1);


	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "/resources/dubbo_applicationContext-dubbo-consumer.xml" });

		//SpringBeanHelper.setApplicationContext(context);
		com.alibaba.dubbo.demo.DemoService demoService = (com.alibaba.dubbo.demo.DemoService) context.getBean("demoService");
		//com.alibaba.dubbo.demo.DemoService demoService = (com.alibaba.dubbo.demo.DemoService) SpringBeanHelper.getBean("demoService");
		System.out.println("dubbo test  ");
		String hello = demoService.sayHello("陈鑫");
		System.out.println(hello);
//		service.scheduleAtFixedRate(new LogicThread(), INIT_DELAY,
//				PERIOD, TimeUnit.SECONDS);

		context.start();

	}
}
