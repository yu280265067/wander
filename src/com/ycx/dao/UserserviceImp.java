package com.ycx.dao;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ycx.model.User;

@Service
public class UserserviceImp implements IUserService{
	
	@Resource(name="IUserDao")  
	private IUserDao userDao;
	
	@Override
	public List<User> getuserById(User user) {
		return this.userDao.getUserById(user);
	}

	@Override
	public AcqTradeOrderExtDO findByIdsMap(String[] ids) {
		return this.userDao.findByIdsMap(ids);
	}
}
