package com.ycx.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ycx.model.User;
@Repository
public class DatatableDao {
	public static List<Map<String,String>> userList = new ArrayList<Map<String,String>>();
	public static List<User> userCollection = new ArrayList<User>();
		static {
			for(int i=0;i<10;i++){
				Map<String,String> tempMap = new HashMap<String, String>();
				tempMap.put("id",i+1+"");
				tempMap.put("name",i+1+"111");
				tempMap.put("telephone","1211");
				tempMap.put("email","ycx@163.com");
				userList.add(tempMap);
		}
			for(int i=0;i<10;i++){
				userCollection.add(new User(i, "MEIXI", "1102203330", "123@163.COM", new Date(1988, 10, 12))) ; 
				
			}
	}
		
		
}
