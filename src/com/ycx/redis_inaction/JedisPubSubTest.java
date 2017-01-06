package com.ycx.redis_inaction;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPubSubTest {
	public static JedisPool pool;  
	 static {  
	  JedisPoolConfig jedispool_config = new JedisPoolConfig();
	  jedispool_config.setMaxIdle(0);  
	  jedispool_config.setMaxWaitMillis(1000);  
	  jedispool_config.setTestOnBorrow(true);  
	  
	  pool = new JedisPool(jedispool_config, "127.0.0.1", 6379);  
	 }  
	  
	 public static void main(String[] args) throws InterruptedException {  
	  Jedis redisClient1 = pool.getResource();  
	  Jedis redisClient2 = pool.getResource();  
	  Mylistener listener = new Mylistener();  
	  
	  Publisher pub = new Publisher();  
	  pub.publish(redisClient2); //发布一个频道  
	  
	   
	  
	  Subscriber sub = new Subscriber();  
	  sub.psub(redisClient1, listener); // 订阅一个频道  
	  
	    
	 }  
}
