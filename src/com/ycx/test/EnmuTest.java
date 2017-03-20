package com.ycx.test;

import com.ycx.dubbo.DemoService;
import com.ycx.model.User;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public enum EnmuTest implements DemoService{
	 	pay("pay","支付中"),
	    paid("paid","支付结束");//可能成功或失败
	    private final String code;
	    private final String message;

	    EnmuTest(String code, String message) {
	        this.code = code;
	        this.message = message;
	    }
	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

	@Override
	public User getUser(String id) {
		User user = new User(2, "ycx", "15142300652", "ycx@163.com",new Date());
		return user;
	}

	@Override
	public Map<String, String> getmap(String id) {
		HashMap<String,String>  map = new HashMap<>();
		map.put("name", "ycx");
		return map;
	}
	    public static void main(String[] args) {
	    	EnmuTest enu = null ;
			System.out.println(enu.name());
		}
}
class Test {
	public static void main(String[] args) {
		EnmuTest[] enu = EnmuTest.values();
		for(EnmuTest x : enu)
		System.out.println(x);
	}
}
