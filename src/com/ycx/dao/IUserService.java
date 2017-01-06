package com.ycx.dao;

import java.util.List;

import com.ycx.model.User;

public interface IUserService {
	public List<User> getuserById(User user);
	public AcqTradeOrderExtDO findByIdsMap(String[] ids);
}
