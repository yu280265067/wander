package com.ycx.threadConnect;

import com.ycx.model.User;

public class Tread1 implements Runnable{
	public static User th =new User();
	@Override
	public void run() {
		synchronized (th) {
			//while(1!=th.getId()){
				try {
					System.out.println("获取锁 等待");
					th.wait();
					System.out.println("wait后执行");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		//	}
			System.out.println("代码执行");
		}
		// TODO Auto-generated method stub
		System.out.println();
	}
	
	
}
