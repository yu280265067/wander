package com.ycx.Pattern;

public class StaticTest {
	static {
		System.out.println("静态代码块");
	}
	{
		System.out.println("构造代码块");
	}
	public static void func1(){
		System.out.println("静态方法1");
	}
}
