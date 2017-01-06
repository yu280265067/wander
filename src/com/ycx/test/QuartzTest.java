package com.ycx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class QuartzTest {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				new String[] { "classpath:/resources/applicationContext.xml", });
	}
	
}
