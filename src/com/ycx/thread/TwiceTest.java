package com.ycx.thread;

import java.util.concurrent.locks.Lock;

public class TwiceTest {
	static int num = 1;
	static int num2 = 1;
	public static void main(String[] args) throws InterruptedException {
		final Lock lock = new TwiceLock();
		class Worker extends Thread{
			@Override
			public void run() {
				// TODO Auto-generated method stub
		//	while(true){
				//lock 接口是阻塞的 没有获得lock的线程会一直阻塞，具体原理参见lock数据结构
				// 自旋的轮训
				System.out.println("before lock  "+num++);
				lock.lock();
				System.out.println("after lock   "+num2++);
					try {
						sleep(1);
					System.out.println(Thread.currentThread().getName());
					sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally {
						try {
							sleep(100000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						lock.unlock();
					}
				}
	//		}
		}
		for(int i=0;i<10;i++){
			Worker w = new Worker();
		//	w.setDaemon(true);
			w.start();
		}
		for(int i=0 ;i<10;i++){
			Thread.sleep(1);
			System.out.println(Thread.currentThread().getName());
		}
	}
}
