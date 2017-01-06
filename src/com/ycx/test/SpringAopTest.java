package com.ycx.test;

import com.ycx.aop.BankAccount;
import com.ycx.aop.PushServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ycx.aop.LogImp;
import com.ycx.proxy.Hello;
import org.springframework.stereotype.Component;

public class SpringAopTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new FileSystemXmlApplicationContext(
				new String[] { "classpath:/resources/applicationContext.xml", });		
		//此处必须用接口来创建bean 不知原因
		//当Hello实现其他接口的时候 下面的两个Hello都必须用接口来创建，如果没实现接口则可以如下创建，都是可以的。
		//因为spring内部有两种动态代理的实现机制，当检测到得代理的类实现了接口则使用jdk的动态代理实现，如检测到没实现
		//接口则使用cglib的机制来实现
//		Hello hello=context.getBean(Hello.class);
//		hello.sayHello2();
		
		PushServiceImpl ipm = context.getBean(PushServiceImpl.class);
		BankAccount bankAccount = new BankAccount();
		bankAccount.setMemberId("10002000");
		bankAccount.setBankcardId(new Long(622202340));
		ipm.sayHelloAopTest(bankAccount);
		//ipm.sayHelloAopTest();
	}
	public void test(){
		
	}
	
	public static void main1(String[] args) {
		for(int i=0 ;i<10000;i++){
			if((i&8)==8){
				System.out.print(i+"  ");
			}
		}
		
		System.out.println(String.format("%s/%d", "dsadasd", 100));
	}
}
