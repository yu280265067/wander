package com.ycx.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.ycx.model.User;

public class Futuretest {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		System.out.println("----程序开始运行----");
		Date date1 = new Date();

		int taskSize = 5;
		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		// 创建多个有返回值的任务
		List<Future> list = new ArrayList<Future>();
		for (int i = 0; i < 100; i++) {
			Callable c = new MyCallable(i + " ");
			// 执行任务并获取Future对象
			//Future f = pool.submit(c);
			final User user = new User(1, "aa", "asdasdasd", "asdas", new Date(2016, 9, 23));
			user.setName("yuchengxiang");
			Future<Void> f = pool.submit(new Callable<Void>() {
						@Override
						public Void call() throws Exception {
							fun(user);
							return null;
						}
			});
			f.get();
			System.out.println(user.getName());
			// System.out.println(">>>" + f.get().toString());
			//list.add(f);
			//System.out.println(">>>" + f.get().toString());
		}
		// 关闭线程池
		pool.shutdown();

		// 获取所有并发任务的运行结果
		/*for (Future f : list) {
			// 从Future对象上获取任务的返回值，并输出到控制台
			System.out.println(">>>" + f.get().toString());
		}*/

		Date date2 = new Date();
		System.out.println("----程序结束运行----，程序运行时间【" + (date2.getTime() - date1.getTime()) + "毫秒】");
	}
	public static void fun(User user) throws Exception{
		user.setName("messi");
		int i = 3/0;
	}
}

class MyCallable implements Callable<Object> {
	private String taskNum;

	MyCallable(String taskNum) {
		this.taskNum = taskNum;
	}


	public Object call() throws Exception {
		System.out.println(">>>" + taskNum + "任务启动");
		Date dateTmp1 = new Date();
		Thread.sleep(1000);
		Date dateTmp2 = new Date();
		long time = dateTmp2.getTime() - dateTmp1.getTime();
		System.out.println(">>>" + taskNum + "任务终止");
		return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
	}
}
