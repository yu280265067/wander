package com.ycx.proxy;

import org.springframework.stereotype.Component;

@Component
public class Hello {

	public void sayHello() {
		System.out.println("say hello");
	}
	public String sayHello2() {
		System.out.println("say hello yuchengxiang");
		return "hello";
	}
	
}
