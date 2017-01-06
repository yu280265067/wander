package com.ycx.redis_inaction;

import redis.clients.jedis.JedisPubSub;

public class Mylistener extends JedisPubSub {  
	
	
	 @Override
	public int getSubscribedChannels() {
		// TODO Auto-generated method stub
		 System.out.println("getSubscribedChannels");
		return super.getSubscribedChannels();
	}

	@Override
	public void subscribe(String... channels) {
		// TODO Auto-generated method stub
		System.out.println("subscribe");
		super.subscribe(channels);
	}

	// 取得订阅的消息后的处理  
	 public void onMessage(String channel, String message) {  
	  System.out.println(channel + "=onMessage＝" + message);  
	 }  
	  
	 // 初始化订阅时候的处理  
	 public void onSubscribe(String channel, int subscribedChannels) {  
	   System.out.println(channel + "＝onSubscribe=" + subscribedChannels+"&&&&&&&");  
	 }  
	  
	 // 取消订阅时候的处理  
	 public void onUnsubscribe(String channel, int subscribedChannels) {  
	   System.out.println(channel + "＝onUnsubscribe=" + subscribedChannels+"#########");  
	 }  
	  
	 // 初始化按表达式的方式订阅时候的处理  
	 public void onPSubscribe(String pattern, int subscribedChannels) {  
	   System.out.println(pattern + "＝onPSubscribe＝" + subscribedChannels+"!!!!!!!");  
	 }  
	  
	 // 取消按表达式的方式订阅时候的处理  
	 public void onPUnsubscribe(String pattern, int subscribedChannels) {  
	   System.out.println(pattern + "=onPUnsubscribe＝" + subscribedChannels+"@@@@@@@@@");  
	 }  
	  
	 // 取得按表达式的方式订阅的消息后的处理  
	 public void onPMessage(String pattern, String channel, String message) {  
	  System.out.println(pattern + "=onPMessage＝" + channel + "=" + message);  
	 }  
	}  
	  