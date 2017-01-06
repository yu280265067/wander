package com.ycx.dubbo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ycx.model.User;

public class DemoServiceImpl implements DemoService{

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

}
