package com.ycx.thread;

public class ThreadTest implements Runnable {
	public static void main(String[] args) {
		
		ThreadTest tt = new ThreadTest();
		Thread thread = new Thread(tt);
		//ThreadTest tt2 = new ThreadTest();
		//Thread thread2 = new Thread(tt2);
		thread.start();
		for (int i = 0; i < 100; i++) {
			System.out.println("我是主线程");
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			System.out.println("我是thread线程");
		}
	}

}
