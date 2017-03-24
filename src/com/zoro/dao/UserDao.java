package com.zoro.dao;

import java.util.List;

import com.zoro.domain.User;

public interface UserDao {
	//由id查询用户
	public User findUserById(int id);
	
	//模糊查询
	public List<User> findUserByName(String name);
	
	//插入用户
	public void insertUser(User user);
}
