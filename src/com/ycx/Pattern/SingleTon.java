package com.ycx.Pattern;

public class SingleTon {
	
	private SingleTon(){}
	public static SingleTon getInstance(){
		return SingletonHandler.instance;
	}
	private static class SingletonHandler{
		private static final SingleTon instance = new SingleTon();
	}
}
