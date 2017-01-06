package com.ycx.threadConnect;

public class Switch {
	public static void main(String[] args) {
		Tread1 t1 = new Tread1();
		Thread thread = new Thread(t1);
		thread.start();
		try {
			thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread2.noy();
	}
}
