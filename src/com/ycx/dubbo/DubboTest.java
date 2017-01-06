package com.ycx.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboTest {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "/resources/dubbo_applicationContext-dubbo2.xml" });
		context.start();
		System.in.read();
	}
}
