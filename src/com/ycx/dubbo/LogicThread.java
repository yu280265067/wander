package com.ycx.dubbo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;


import com.ycx.model.User;

public class LogicThread implements Runnable{
	private static AtomicInteger ai = new AtomicInteger(1);
/*
 *  测试结果 dubbo 支持map 不支持pojo。支持map 理论上也应该支持json。
 * 
*/
	
	@Override
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("dubbo test  ");
		com.alibaba.dubbo.demo.DemoService demoService = (com.alibaba.dubbo.demo.DemoService) SpringBeanHelper.getBean("demoService");
		System.out.println("dubbo test  ");
		String hello = demoService.sayHello("world");
		System.out.println(hello);
		HashMap<String,String> map = new HashMap<>();
		//map=(HashMap<String, String>) demoService.getmap("1");
		//User user = demoService.getUser("2");
		System.out.println("-----------run----------");
		System.out.println(map.get("name"));
		//System.out.println(user.getName());
		System.out.println(sdf.format(new Date()) + " = " + ai.getAndIncrement() + " : " + hello);
	}
}
