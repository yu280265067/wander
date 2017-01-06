
package com.ycx.dao;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mchange.v2.lock.SharedUseExclusiveUseLock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.Transaction;
//@Repository
public class RedisDao {
	   @Autowired  
	  private  JedisPool jedisPool;    
	   
	  Jedis jedis ;
	  public  Jedis getpool(){
		  if(jedis==null){
		 // Jedis ge = new Jedis("localhost"); 会拒绝连接？
			  
		  //Transaction tx =  ge.multi();
		  jedis = jedisPool.getResource();
		  System.out.println("jedis==="+jedis);
		  return jedis;
		  }
		  else{
			  System.out.println("jedis==="+jedis);
			  return jedis; 
		  }
		 
	  } 
	  public void set(String vcodeKey, String vcodeValue, int exp) {
	        try {
	            getpool().setex(vcodeKey, exp, vcodeValue);
	        } catch (Exception e) {
	        }
	    }
	  public void set(String key, String value)  {  
		  getpool().set(key, value);  
	  }    
	  public String get(String key)  {    
	  return getpool().get(key);  
	  }
	  public long getincr(String key)  {  
		  long incr = getpool().incr(key);
		  return incr;
	  }  
	  public long setExpire(String key,int seconds)  {    
		  return getpool().expire(key, seconds);  
		  }
	  public long zadd(String key,double score,String name){
		  return getpool().zadd(key, score,name);
	  } 
	  
	  public Set<String> zrevrange(String key,long start,long end){
		  return getpool().zrevrange(key, start, end);
	  }
	  
	  public Set<String> zrange(String key,long start,long end){
		  return getpool().zrange(key, start, end);
	  }
	  public double zscore(String key,String member){
		  
		  return getpool().zscore(key,member);
	  }
}

