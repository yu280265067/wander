package com.ycx.redis_inaction;

import redis.clients.jedis.Jedis;

public class Subscriber {
	public void psub(final Jedis redisClient, final Mylistener listener) {  
		  new Thread(new Runnable() {  
		   public void run() {  
		  
		    System.out.println("订阅：news.share");  
		    // 订阅得到信息在lister的onMessage(...)方法中进行处理  
		  
		    // 订阅多个频道  
		    // redisClient.subscribe(listener, "news.share", "news.log");  
		  
		    //redisClient.subscribe(listener, new String[]{"news.share","news.log"});  
		    System.out.println("---订阅---");
		      redisClient.psubscribe(listener, new String[] { "news.share" });// 使用模式匹配的方式设置频道  
		   }  
		  }).start();  
		  
		 }  
}
