package com.ycx.threadConnect;

import com.ycx.model.User;

public class Thread2 {
	public static void noy() {
		System.out.println("thread2 执行");
		User localt1 = Tread1.th;
		synchronized (localt1) {
			localt1.notify();
		}
		
	}
}
