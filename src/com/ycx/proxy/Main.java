package com.ycx.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {
	public static void main(String[] args) {
		Hello realhello=new Hello();
		InvocationHandler handler =new HelloHandler(realhello);
		//这地方一定要用接口来创建对象 这同时也是jdk实现动态代理的一个局限
		//cglib 实现的动态代理 intercepter 个人理解是 容器给生成了一个子类，在子类基础上进行方法的代理。
		//而jdk的是在当前类基础上代理，所以需要手动写接口类。
		HelloInterface hello = (HelloInterface) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realhello.getClass().getInterfaces(), handler);
		hello.sayHello();
	}
}
