package com.ycx.test;

import com.ycx.dao.IUserService;
import com.ycx.dao.UserserviceImp;
import com.ycx.model.User;
//import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class SpringMybatis{
	private IUserService userService;
//	@Test
	public void addUser(){
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(new String[] { "/main/resources/applicationContext.xml",
						"/main/resources/applicationContext-cxf.xml",
						"/main/resources/mybatis-config.xml"
						});  
		userService = context.getBean("userserviceImp", UserserviceImp.class);
		User user = new User();
		user.setIds(new int[]{1,2});
		System.out.println(userService.getuserById(user).size());
	}
}
