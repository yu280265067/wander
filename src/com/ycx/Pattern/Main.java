package com.ycx.Pattern;

public class Main {
	//结论 静态代码块是类初始化的时候调用，而静态方法只有被调用才会调用，不会随着类初始化而调用
	// 类初始化经过三个步骤，装载，链接，初始化。loadclass只会装载，不链接，不初始化，所以不调用静态代码块。
	//  class.forname 初始化，所以调用静态代码块。
	// 调用静态方法的时候会自动初始化，会调用静态代码块
	public static void main(String[] args) throws ClassNotFoundException {
//		Class cl=ClassLoader.getSystemClassLoader().loadClass("com.ycx.Pattern.StaticTest");
//		Class.forName("com.ycx.Pattern.StaticTest");
//		StaticTest st=new StaticTest();
		StaticTest.func1();
	}
}
