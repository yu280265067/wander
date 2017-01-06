package com.ycx.Pattern;


public class SingletonTest {
	public static void main(String[] args) {
		SingleTon single1=SingleTon.getInstance();
		SingleTon single2=SingleTon.getInstance();
		System.out.println(single1+"---"+single2);
	}
}
