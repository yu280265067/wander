package com.ycx.redis_inaction;

import redis.clients.jedis.Jedis;

public class Publisher {
	public void publish(final Jedis redisClient) {  
	    
		  new Thread(new Runnable() {  
		   public void run() {  
		    try {  
		     Thread.currentThread().sleep(2000);  
		    } catch (InterruptedException e) {  
		     e.printStackTrace();  
		    }  
		    System.out.println("发布：news.share");  
		    redisClient.publish("news.share", "ok");  
		    redisClient.publish("news.share", "hello word");  
		   }  
		  }).start();  
		  
		 }  
}
