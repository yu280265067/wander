package com.ycx.dubbo;

import java.util.Map;

import com.ycx.model.User;

public interface DemoService {
		public String sayHello(String name);
		public User getUser(String id);
		public Map<String,String> getmap(String id);
	}
