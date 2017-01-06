package com.ycx.dao;



import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;

import com.ycx.model.User;
@Resource(name="IUserDao")
public interface IUserDao {
	public List<User> getUserById(User user);
	public AcqTradeOrderExtDO findByIdsMap(String[] ids);
		
}
