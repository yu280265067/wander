
package com.ycx.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.ycx.dao.RedisDao;
import com.ycx.model.User;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

public class RedisTest implements Runnable {
	// @Test

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				new String[] { "classpath:/resources/applicationContext.xml", });
		RedisDao redisdao = context.getBean("redisDao", RedisDao.class);
		// long resultE = redisdao.setExpire("ycx2", 10);
		
		 redisdao.set("ycx3", "1321",10);
		// redisdao.set("ycx3", "108");
		 //System.out.println("resultE=="+resultE);
//		 long result = redisdao.getincr("ycx3");
//			System.out.println(result);
		 
		RedisTest rt = new RedisTest();
		Thread th = new Thread(rt);
		th.start();

	}

	@Override
	public void run() {
		while (true) {
			ApplicationContext context = new FileSystemXmlApplicationContext(
					new String[] { "classpath:/resources/applicationContext.xml", });
			RedisDao redisdao = context.getBean("redisDao", RedisDao.class);
			// long resultE = redisdao.setExpire("ycx", 100);
			String result = redisdao.get("ycx3");
			System.out.println(result);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void test3() {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				new String[] { "classpath:/resources/applicationContext.xml", });
		RedisDao redisdao = context.getBean("redisDao", RedisDao.class);
		redisdao.set("name", "1233321");
		System.out.println(redisdao.get("name"));
	}

	// @Test
	public void test2() {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				new String[] { "classpath:/resources/applicationContext.xml", });
		RedisDao redisdao = context.getBean("redisDao", RedisDao.class);
		redisdao.set("name", "1233321");
		System.out.println(redisdao.get("name"));
		redisdao.zadd("yuwen", 133, "yuchengxiang");
		redisdao.zadd("yuwen", 131, "zhangsan");
		redisdao.zadd("yuwen", 132, "lisi");
		redisdao.zadd("yuwen", 132, "lisi1");
		redisdao.zadd("yuwen", 132, "lisi2");
		redisdao.zadd("yuwen", 132, "lisi3");
		redisdao.zadd("yuwen", 132, "lisi4");
		Set<String> yuwen = redisdao.zrange("yuwen", 0, 150);
		String ss = redisdao.get("12");
		System.out.println("ss=  ==  " + ss);
		RedisTest runTest = new RedisTest();
		Thread t = new Thread(runTest);
		t.start();
		Set<Tuple> range;
		// range = redisdao.getpool().getResource().zrangeWithScores("yuwen", 0,
		// -1);
		// System.out.println();
		// for(Tuple x:range){
		// System.out.println(x.getElement().toString());
		// System.out.println(x.getScore());
		// }
		// redisdao.getpool().getResource().zremrangeByRank("yuwen", 0, -5);
		range = redisdao.getpool().zrangeWithScores("yuwen", 0, -1);
		System.out.println("---- ----");
		for (Tuple x : range) {
			System.out.println(x.getElement().toString());
			System.out.println(x.getScore());
		}
	}

	public void run2() {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				new String[] { "classpath:/resources/applicationContext.xml", });
		RedisDao redisdao = context.getBean("redisDao", RedisDao.class);
		System.out.println("redis线程");
		for (int i = 10; i < 25; i++) {
			System.out.println("i==" + i);
			redisdao.zadd("yuwen", 120, "zhangsan" + i);
			System.out.println("yuwen===" + redisdao.getpool().zscore("yuwen", "zhangsan" + i));
			System.out.println("run");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main1(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				new String[] { "classpath:/resources/applicationContext.xml", });
		RedisDao redisdao = context.getBean("redisDao", RedisDao.class);
		redisdao.zadd("yuwen", 133, "yuchengxiang");
		redisdao.zadd("yuwen", 131, "zhangsan");
		redisdao.zadd("yuwen", 132, "lisi");
		redisdao.zadd("yuwen", 132, "lisi1");
		redisdao.zadd("yuwen", 132, "lisi2");
		redisdao.zadd("yuwen", 132, "lisi3");
		redisdao.zadd("yuwen", 132, "lisi4");

		RedisTest runTest = new RedisTest();
		Thread t = new Thread(runTest);
		t.start();
		Set<Tuple> range;
		// range = redisdao.getpool().getResource().zrangeWithScores("yuwen", 0,
		// -1);
		// System.out.println();
		// for(Tuple x:range){
		// System.out.println(x.getElement().toString());
		// System.out.println(x.getScore());
		// }
		// redisdao.getpool().getResource().zremrangeByRank("yuwen", 0, -5);
		range = redisdao.getpool().zrangeWithScores("yuwen", 0, -1);
		System.out.println("---- ----");
		for (Tuple x : range) {
			System.out.println(x.getElement().toString());
			System.out.println(x.getScore());
		}
	}

	public static void mainn(String[] args) {

		// System.out.println(RedisTest.maint());
	}

	@SuppressWarnings("finally")
	public static void maint() {

		int i = 0;
		try {
			i = i / 0;
		} catch (Exception e) {
			System.out.println("catch");
			// return "catch return";
		} finally {
			System.out.println("finally");
			// return "finally return " ;
		}
		System.out.println("nn");
	}

}

