package com.ycx.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class HelloHandler implements InvocationHandler{
	Object object;
	public HelloHandler(Object object) {
		this.object=object;
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(new Date().getTime());
		//第二个参数为原方法的参数
		method.invoke(object, args);
		return null;
	}
	



}
