package com.ycx.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



public class ThreadPool extends ThreadPoolExecutor{
	static ThreadPool threadpool = new ThreadPool(4, 100, 300, TimeUnit.DAYS, new ArrayBlockingQueue<Runnable>(5));
	public ThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}
	public void  fun1() {
		System.out.println("func"+Thread.currentThread().toString());
		threadpool.execute(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("refore thread invoke "+Thread.currentThread().toString());
				ThreadPool.this.fun1();
				System.out.println("after thread invoke "+Thread.currentThread().toString());
				
			}
		});
	}
	public static void main(String[] args) {
		ThreadPool threadpool = new ThreadPool(5, 100, 300, TimeUnit.DAYS, new ArrayBlockingQueue<Runnable>(5));
		threadpool.fun1();
		
	}
}
