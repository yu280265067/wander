package com.ycx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ycx.webservice_cli.WebServiceSer;


public class SpringServiceTest {
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("classpath:webservice-cxf_cli.xml");
		WebServiceSer ser = (WebServiceSer) context.getBean("helloClient");
		System.out.println(ser.hello("sdasdas"));
	}
		
}
